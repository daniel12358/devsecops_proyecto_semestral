package com.umb.devsecops.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
    }

    @Test
    void testCalculateDiscount_ValidInputs() {
        assertEquals(80.0, service.calculateDiscount(100.0, 20.0), 0.001);
        assertEquals(0.0, service.calculateDiscount(100.0, 100.0), 0.001);
        assertEquals(100.0, service.calculateDiscount(100.0, 0.0), 0.001);
    }

    @Test
    void testCalculateDiscount_InvalidPrice() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateDiscount(-10.0, 20.0));
    }

    @Test
    void testCalculateDiscount_InvalidDiscountRate() {
        assertThrows(IllegalArgumentException.class, () -> service.calculateDiscount(100.0, -5.0));
        assertThrows(IllegalArgumentException.class, () -> service.calculateDiscount(100.0, 105.0));
    }

    @Test
    void testIsEligibleForBonus() {
        assertTrue(service.isEligibleForBonus(3, true));
        assertTrue(service.isEligibleForBonus(5, true));
        assertFalse(service.isEligibleForBonus(2, true));
        assertFalse(service.isEligibleForBonus(5, false));
    }
}
