package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LucasServiceTest {

    private LucasService lucasService;

    @BeforeEach
    void setUp() {
        lucasService = new LucasService();
    }

    @Test
    void testCalculate_Position8() {
        BigInteger result = lucasService.calculate(8);
        assertEquals(BigInteger.valueOf(47), result);
    }

    @Test
    void testCalculate_Position12() {
        BigInteger result = lucasService.calculate(12);
        assertEquals(BigInteger.valueOf(322), result);
    }

    @Test
    void testCalculateRange_0To7() {
        List<BigInteger> result = lucasService.calculateRange(0, 7);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(2),
                BigInteger.valueOf(1),
                BigInteger.valueOf(3),
                BigInteger.valueOf(4),
                BigInteger.valueOf(7),
                BigInteger.valueOf(11),
                BigInteger.valueOf(18),
                BigInteger.valueOf(29)
        );
        assertEquals(expected, result);
    }
}
