package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("padovanService")
public class PadovanService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 2) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2].add(dp[i - 3]);
        }

        return dp[n];
    }

    @Override
    public List<BigInteger> calculateRange(int start, int end) {
        if (start < 0 || end < start) throw new IllegalArgumentException("Invalid range");

        List<BigInteger> result = new ArrayList<>();
        BigInteger[] dp = new BigInteger[end + 1];
        dp[0] = BigInteger.ONE;
        if (end >= 1) dp[1] = BigInteger.ONE;
        if (end >= 2) dp[2] = BigInteger.ONE;

        for (int i = 3; i <= end; i++) {
            dp[i] = dp[i - 2].add(dp[i - 3]);
        }

        for (int i = start; i <= end; i++) {
            result.add(dp[i]);
        }

        return result;
    }

    @Override
    public String getFormula() {
        return "P(n) = P(n-2) + P(n-3), with P(0) = 1, P(1) = 1, P(2) = 1";
    }
}