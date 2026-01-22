package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MotzkinServiceTest {

    private MotzkinService motzkinService;

    @BeforeEach
    void setUp() {
        motzkinService = new MotzkinService();
    }

    @Test
    void testCalculate_Position5() {
        BigInteger result = motzkinService.calculate(5);
        assertEquals(BigInteger.valueOf(21), result);
    }

    @Test
    void testCalculate_Position8() {
        BigInteger result = motzkinService.calculate(8);
        assertEquals(BigInteger.valueOf(323), result);
    }

    @Test
    void testCalculateRange_0To7() {
        List<BigInteger> result = motzkinService.calculateRange(0, 7);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(4),
                BigInteger.valueOf(9),
                BigInteger.valueOf(21),
                BigInteger.valueOf(51),
                BigInteger.valueOf(127)
        );
        assertEquals(expected, result);
    }
}
