package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalanServiceTest {

    private CatalanService catalanService;

    @BeforeEach
    void setUp() {
        catalanService = new CatalanService();
    }

    @Test
    void testCalculate_Position5() {
        BigInteger result = catalanService.calculate(5);
        assertEquals(BigInteger.valueOf(42), result);
    }

    @Test
    void testCalculate_Position8() {
        BigInteger result = catalanService.calculate(8);
        assertEquals(BigInteger.valueOf(1430), result);
    }

    @Test
    void testCalculateRange_0To6() {
        List<BigInteger> result = catalanService.calculateRange(0, 6);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(5),
                BigInteger.valueOf(14),
                BigInteger.valueOf(42),
                BigInteger.valueOf(132)
        );
        assertEquals(expected, result);
    }
}
