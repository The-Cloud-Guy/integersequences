package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TribonacciServiceTest {

    private TribonacciService tribonacciService;

    @BeforeEach
    void setUp() {
        tribonacciService = new TribonacciService();
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = tribonacciService.calculate(10);
        assertEquals(BigInteger.valueOf(81), result);
    }

    @Test
    void testCalculate_Position15() {
        BigInteger result = tribonacciService.calculate(15);
        assertEquals(BigInteger.valueOf(1705), result);
    }

    @Test
    void testCalculateRange_0To10() {
        List<BigInteger> result = tribonacciService.calculateRange(0, 10);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(0),
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(4),
                BigInteger.valueOf(7),
                BigInteger.valueOf(13),
                BigInteger.valueOf(24),
                BigInteger.valueOf(44),
                BigInteger.valueOf(81)
        );
        assertEquals(expected, result);
    }
}
