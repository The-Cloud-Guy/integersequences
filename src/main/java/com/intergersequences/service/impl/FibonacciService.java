package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("fibonacciService")
public class FibonacciService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        return dp[n];
    }

    @Override
    public List<BigInteger> calculateRange(int start, int end) {
        if (start < 0 || end < start) throw new IllegalArgumentException("Invalid range");

        List<BigInteger> result = new ArrayList<>();
        BigInteger[] dp = new BigInteger[end + 1];
        dp[0] = BigInteger.ZERO;
        if (end >= 1) dp[1] = BigInteger.ONE;

        for (int i = 2; i <= end; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]);
        }

        for (int i = start; i <= end; i++) {
            result.add(dp[i]);
        }

        return result;
    }

    @Override
    public String getFormula() {
        return "F(n) = F(n-1) + F(n-2), with F(0) = 0, F(1) = 1";
    }
}
