package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TetranacciServiceTest {

    private TetranacciService tetranacciService;

    @BeforeEach
    void setUp() {
        tetranacciService = new TetranacciService();
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = tetranacciService.calculate(10);
        assertEquals(BigInteger.valueOf(56), result);
    }

    @Test
    void testCalculate_Position12() {
        BigInteger result = tetranacciService.calculate(12);
        assertEquals(BigInteger.valueOf(208), result);
    }

    @Test
    void testCalculateRange_0To11() {
        List<BigInteger> result = tetranacciService.calculateRange(0, 11);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(0),
                BigInteger.valueOf(0),
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(4),
                BigInteger.valueOf(8),
                BigInteger.valueOf(15),
                BigInteger.valueOf(29),
                BigInteger.valueOf(56),
                BigInteger.valueOf(108)
        );
        assertEquals(expected, result);
    }
}
