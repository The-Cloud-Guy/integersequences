package com.intergersequences.service;

import java.math.BigInteger;
import java.util.List;

public interface SequenceService {
    BigInteger calculate(int n);
    List<BigInteger> calculateRange(int start, int end);
    String getFormula();
}
