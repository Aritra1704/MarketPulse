package com.example.marketpulse.modules.data;

import javax.inject.Inject;

public class Variable extends BaseDO  {
    private Values $1;
    private Values $2;
    private Values $3;
    private Values $4;

    @Inject
    public Variable(){}

    public Values get$1() {
        return $1;
    }

    public void set$1(Values $1) {
        this.$1 = $1;
    }

    public Values get$2() {
        return $2;
    }

    public void set$2(Values $2) {
        this.$2 = $2;
    }

    public Values get$3() {
        return $3;
    }

    public void set$3(Values $3) {
        this.$3 = $3;
    }

    public Values get$4() {
        return $4;
    }

    public void set$4(Values $4) {
        this.$4 = $4;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "$1=" + $1 +
                ", $2=" + $2 +
                ", $3=" + $3 +
                ", $4=" + $4 +
                '}';
    }
}
