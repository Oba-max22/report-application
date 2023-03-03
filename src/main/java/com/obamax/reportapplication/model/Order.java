package com.obamax.reportapplication.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Integer quantity;
    private String customerName;
    private String customerPhoneNumber;
    private Double totalAmount;
    @CreationTimestamp
    private Timestamp createdAt;

}
