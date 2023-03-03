package com.obamax.reportapplication.controller;

import com.obamax.reportapplication.model.Report;
import com.obamax.reportapplication.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/reports")
@RestController
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/{startDate}/{endDate}")
    public ResponseEntity<List<Report>> getReport(@PathVariable String startDate,
                                                  @PathVariable String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        List<Report> report = reportService.getReportsWithinDateRange(start, end);

        return ResponseEntity.ok(report);
    }
}
