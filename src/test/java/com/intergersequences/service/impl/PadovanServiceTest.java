package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PadovanServiceTest {

    private PadovanService padovanService;

    @BeforeEach
    void setUp() {
        padovanService = new PadovanService();
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = padovanService.calculate(10);
        assertEquals(BigInteger.valueOf(12), result);
    }

    @Test
    void testCalculate_Position15() {
        BigInteger result = padovanService.calculate(15);
        assertEquals(BigInteger.valueOf(49), result);
    }

    @Test
    void testCalculateRange_0To12() {
        List<BigInteger> result = padovanService.calculateRange(0, 12);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(4),
                BigInteger.valueOf(5),
                BigInteger.valueOf(7),
                BigInteger.valueOf(9),
                BigInteger.valueOf(12),
                BigInteger.valueOf(16),
                BigInteger.valueOf(21)
        );
        assertEquals(expected, result);
    }
}
