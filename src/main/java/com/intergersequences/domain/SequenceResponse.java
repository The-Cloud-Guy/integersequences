package com.intergersequences.domain;

import java.math.BigInteger;
import java.util.List;

public class SequenceResponse {
    private SequenceType type;
    private Integer position;
    private BigInteger value;
    private List<BigInteger> values;
    private String formula;

    public SequenceResponse() {}

    public SequenceResponse(SequenceType type, Integer position, BigInteger value, String formula) {
        this.type = type;
        this.position = position;
        this.value = value;
        this.formula = formula;
    }

    public SequenceResponse(SequenceType type, List<BigInteger> values, String formula) {
        this.type = type;
        this.values = values;
        this.formula = formula;
    }

  
    public SequenceType getType() {
        return type;
    }

    public void setType(SequenceType type) {
        this.type = type;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BigInteger getValue() {
        return value;
    }

    public void setValue(BigInteger value) {
        this.value = value;
    }

    public List<BigInteger> getValues() {
        return values;
    }

    public void setValues(List<BigInteger> values) {
        this.values = values;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}