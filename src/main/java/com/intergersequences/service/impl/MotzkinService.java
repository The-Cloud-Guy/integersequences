package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("motzkinService")
public class MotzkinService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0 || n == 1) return BigInteger.ONE;

        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            dp[i] = BigInteger.ZERO;
            dp[i] = dp[i].add(dp[i - 1]);
            for (int k = 0; k < i - 1; k++) {
                dp[i] = dp[i].add(dp[k].multiply(dp[i - 2 - k]));
            }
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

        for (int i = 2; i <= end; i++) {
            dp[i] = BigInteger.ZERO;
            dp[i] = dp[i].add(dp[i - 1]);
            for (int k = 0; k < i - 1; k++) {
                dp[i] = dp[i].add(dp[k].multiply(dp[i - 2 - k]));
            }
        }

        for (int i = start; i <= end; i++) {
            result.add(dp[i]);
        }

        return result;
    }

    @Override
    public String getFormula() {
        return "M(n) = M(n-1) + Sum[M(k)*M(n-2-k)] for k=0 to n-2";
    }
}
