package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("tetranacciService")
public class TetranacciService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n <= 2) return BigInteger.ZERO;
        if (n == 3) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ZERO;
        dp[2] = BigInteger.ZERO;
        dp[3] = BigInteger.ONE;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]).add(dp[i - 3]).add(dp[i - 4]);
        }

        return dp[n];
    }

    @Override
    public List<BigInteger> calculateRange(int start, int end) {
        if (start < 0 || end < start) throw new IllegalArgumentException("Invalid range");

        List<BigInteger> result = new ArrayList<>();
        BigInteger[] dp = new BigInteger[end + 1];
        dp[0] = BigInteger.ZERO;
        if (end >= 1) dp[1] = BigInteger.ZERO;
        if (end >= 2) dp[2] = BigInteger.ZERO;
        if (end >= 3) dp[3] = BigInteger.ONE;

        for (int i = 4; i <= end; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2]).add(dp[i - 3]).add(dp[i - 4]);
        }

        for (int i = start; i <= end; i++) {
            result.add(dp[i]);
        }

        return result;
    }

    @Override
    public String getFormula() {
        return "T(n) = T(n-1) + T(n-2) + T(n-3) + T(n-4), with T(0)=0, T(1)=0, T(2)=0, T(3)=1";
    }
}