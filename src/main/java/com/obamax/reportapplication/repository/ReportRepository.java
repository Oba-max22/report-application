package com.obamax.reportapplication.repository;

import com.obamax.reportapplication.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    Optional<Report> findReportByDate(LocalDate orderDate);
    List<Report> findByDateBetween(LocalDate start, LocalDate end);
}
