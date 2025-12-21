package com.example.capstone3.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String name;
    private String number;
    private String cvc;
    private String month;
    private String year;
    private double amount;
    private String currency;
    private String description;
    private String callbackUrl;

}

