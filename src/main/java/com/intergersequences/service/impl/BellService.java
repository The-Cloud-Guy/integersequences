package com.intergersequences.service.impl;

import com.intergersequences.service.SequenceService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service("bellService")
public class BellService implements SequenceService {

    @Override
    public BigInteger calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be non-negative");
        if (n == 0) return BigInteger.ONE;

        BigInteger[][] bell = new BigInteger[n + 1][n + 1];
        bell[0][0] = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i - 1][j - 1].add(bell[i][j - 1]);
            }
        }

        return bell[n][0];
    }

    @Override
    public List<BigInteger> calculateRange(int start, int end) {
        if (start < 0 || end < start) throw new IllegalArgumentException("Invalid range");

        List<BigInteger> result = new ArrayList<>();
        BigInteger[][] bell = new BigInteger[end + 1][end + 1];
        bell[0][0] = BigInteger.ONE;

        for (int i = 1; i <= end; i++) {
            bell[i][0] = bell[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i - 1][j - 1].add(bell[i][j - 1]);
            }
        }

        for (int i = start; i <= end; i++) {
            result.add(bell[i][0]);
        }

        return result;
    }

    @Override
    public String getFormula() {
        return "B(n) = Sum of Stirling numbers S(n,k) for k=0 to n";
    }

}