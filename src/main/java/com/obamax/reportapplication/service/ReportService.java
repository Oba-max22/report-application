package com.obamax.reportapplication.service;

import com.obamax.reportapplication.model.Report;
import com.obamax.reportapplication.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public List<Report> getReportsWithinDateRange(LocalDate start, LocalDate end) {
        return reportRepository.findByDateBetween(start, end);
    }
}
