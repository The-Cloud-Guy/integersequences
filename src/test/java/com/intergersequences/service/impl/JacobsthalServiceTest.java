package com.intergersequences.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacobsthalServiceTest {

    private JacobsthalService jacobsthalService;

    @BeforeEach
    void setUp() {
        jacobsthalService = new JacobsthalService();
    }

    @Test
    void testCalculate_Position6() {
        BigInteger result = jacobsthalService.calculate(6);
        assertEquals(BigInteger.valueOf(21), result);
    }

    @Test
    void testCalculate_Position10() {
        BigInteger result = jacobsthalService.calculate(10);
        assertEquals(BigInteger.valueOf(341), result);
    }

    @Test
    void testCalculateRange_0To9() {
        List<BigInteger> result = jacobsthalService.calculateRange(0, 9);
        List<BigInteger> expected = List.of(
                BigInteger.valueOf(0),
                BigInteger.valueOf(1),
                BigInteger.valueOf(1),
                BigInteger.valueOf(3),
                BigInteger.valueOf(5),
                BigInteger.valueOf(11),
                BigInteger.valueOf(21),
                BigInteger.valueOf(43),
                BigInteger.valueOf(85),
                BigInteger.valueOf(171)
        );
        assertEquals(expected, result);
    }
}
