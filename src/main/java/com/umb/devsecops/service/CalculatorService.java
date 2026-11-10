package com.umb.devsecops.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculateDiscount(double price, double discountRate) {
        if (price < 0 || discountRate < 0 || discountRate > 100) {
            throw new IllegalArgumentException("Valores de entrada no válidos");
        }
        return price - (price * (discountRate / 100.0));
    }

    public boolean isEligibleForBonus(int yearsOfService, boolean isActive) {
        return isActive && yearsOfService >= 3;
    }
}
