package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PellServiceTest {

    private PellService pellService;

    @BeforeEach
    void setUp() {
        pellService = new PellService();
    }

    @Test
    void testCalculate_Position7() {
        BigInteger result = pellService.calculate(7);
        assertEquals(BigInteger.valueOf(169), result);
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = pellService.calculate(10);
        assertEquals(BigInteger.valueOf(2378), result);
    }

    @Test
    void testCalculateRange_0To8() {
        List<BigInteger> result = pellService.calculateRange(0, 8);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(5),
                BigInteger.valueOf(12),
                BigInteger.valueOf(29),
                BigInteger.valueOf(70),
                BigInteger.valueOf(169),
                BigInteger.valueOf(408)
        );
        assertEquals(expected, result);
    }
}