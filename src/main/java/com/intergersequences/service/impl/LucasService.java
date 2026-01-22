package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("lucasService")
public class LucasService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return BigInteger.valueOf(2);
        if (n == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.valueOf(2);
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
        dp[0] = BigInteger.valueOf(2);
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
        return "L(n) = L(n-1) + L(n-2), with L(0) = 2, L(1) = 1";
    }
}