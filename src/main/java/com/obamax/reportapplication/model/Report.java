package com.obamax.reportapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private Long totalOrder;
    private Double totalAmount;

    public Report(LocalDate date, Long totalOrder, Double totalAmount) {
        this.date = date;
        this.totalOrder = totalOrder;
        this.totalAmount = totalAmount;
    }
}
