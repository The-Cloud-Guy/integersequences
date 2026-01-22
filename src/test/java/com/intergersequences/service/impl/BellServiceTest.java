package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BellServiceTest {

    private BellService bellService;

    @BeforeEach
    void setUp() {
        bellService = new BellService();
    }

    @Test
    void testCalculate_Position4() {
        BigInteger result = bellService.calculate(4);
        assertEquals(BigInteger.valueOf(15), result);
    }

    @Test
    void testCalculate_Position6() {
        BigInteger result = bellService.calculate(6);
        assertEquals(BigInteger.valueOf(203), result);
    }

    @Test
    void testCalculateRange_0To7() {
        List<BigInteger> result = bellService.calculateRange(0, 7);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(2),
                BigInteger.valueOf(5),
                BigInteger.valueOf(15),
                BigInteger.valueOf(52),
                BigInteger.valueOf(203),
                BigInteger.valueOf(877)
        );
        assertEquals(expected, result);
    }
}