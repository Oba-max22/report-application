package com.obamax.reportapplication.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.obamax.reportapplication.model.Order;
import com.obamax.reportapplication.model.Report;
import com.obamax.reportapplication.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.obamax.reportapplication.repository.OrderRepository;

import java.time.LocalDate;

@Component
public class KafkaListeners {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ReportRepository reportRepository;

    @KafkaListener(
            topics = "order",
            groupId = "order-group-id"
    )
    public void listen(String orderJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.readValue(orderJson, Order.class);

        // save the order to the database
        orderRepository.save(order);

        // update the order report for the order's date
        LocalDate orderDate = order.getCreatedAt().toLocalDateTime().toLocalDate();
        Report report = reportRepository.findReportByDate(orderDate)
                .orElseGet(() -> new Report(orderDate, 0L, 0D));
        report.setTotalOrder(report.getTotalOrder() + 1L);
        report.setTotalAmount(report.getTotalAmount() + order.getTotalAmount());
        reportRepository.save(report);
    }

}
