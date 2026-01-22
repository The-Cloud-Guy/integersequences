package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciServiceTest {

    private FibonacciService fibonacciService;

    @BeforeEach
    void setUp() {
        fibonacciService = new FibonacciService();
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = fibonacciService.calculate(10);
        assertEquals(BigInteger.valueOf(55), result);
    }

    @Test
    void testCalculate_Position20() {
        BigInteger result = fibonacciService.calculate(20);
        assertEquals(BigInteger.valueOf(6765), result);
    }

    @Test
    void testCalculateRange_0To10() {
        List<BigInteger> result = fibonacciService.calculateRange(0, 10);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(8),
                BigInteger.valueOf(13),
                BigInteger.valueOf(21),
                BigInteger.valueOf(34),
                BigInteger.valueOf(55)
        );
        assertEquals(expected, result);
    }
}
