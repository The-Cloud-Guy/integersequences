package com.intergersequences.controller;

import com.intergersequences.domain.SequenceResponse;
import com.intergersequences.domain.SequenceType;
import com.intergersequences.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/sequences")
public class SequenceController {
    private final Map<SequenceType, SequenceService> serviceMap;

    @Autowired
    public SequenceController(
            @Qualifier("fibonacciService") SequenceService fibonacciService,
            @Qualifier("lucasService") SequenceService lucasService,
            @Qualifier("tribonacciService") SequenceService tribonacciService,
            @Qualifier("catalanService") SequenceService catalanService,
            @Qualifier("pellService") SequenceService pellService,
            @Qualifier("bellService") SequenceService bellService,
            @Qualifier("padovanService") SequenceService padovanService,
            @Qualifier("jacobsthalService") SequenceService jacobsthalService,
            @Qualifier("motzkinService") SequenceService motzkinService,
            @Qualifier("tetranacciService") SequenceService tetranacciService
    ) {
        this.serviceMap = Map.of(
                SequenceType.FIBONACCI, fibonacciService,
                SequenceType.LUCAS, lucasService,
                SequenceType.TRIBONACCI, tribonacciService,
                SequenceType.CATALAN, catalanService,
                SequenceType.PELL, pellService,
                SequenceType.BELL, bellService,
                SequenceType.PADOVAN, padovanService,
                SequenceType.JACOBSTHAL, jacobsthalService,
                SequenceType.MOTZKIN, motzkinService,
                SequenceType.TETRANACCI, tetranacciService
        );
    }

    @GetMapping("/{type}/{n}")
    public ResponseEntity<SequenceResponse> getSequenceValue(
            @PathVariable String type,
            @PathVariable int n) {
        try {
            SequenceType sequenceType = SequenceType.valueOf(type.toUpperCase());
            SequenceService service = serviceMap.get(sequenceType);

            if (service == null) {
                return ResponseEntity.badRequest().build();
            }

            BigInteger value = service.calculate(n);
            SequenceResponse response = new SequenceResponse(
                    sequenceType,
                    n,
                    value,
                    service.getFormula()
            );

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{type}/range/{start}/{end}")
    public ResponseEntity<SequenceResponse> getSequenceRange(
            @PathVariable String type,
            @PathVariable int start,
            @PathVariable int end) {
        try {
            SequenceType sequenceType = SequenceType.valueOf(type.toUpperCase());
            SequenceService service = serviceMap.get(sequenceType);

            if (service == null) {
                return ResponseEntity.badRequest().build();
            }

            List<BigInteger> values = service.calculateRange(start, end);
            SequenceResponse response = new SequenceResponse(
                    sequenceType,
                    values,
                    service.getFormula()
            );

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
