package com.hotel.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PaymentDTO {
    private String id;
    private LocalDate paymentDate;
    private Float amount;
    private String paymentMethod;
}
