package io.tokenanalyst.udfs;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

import java.lang.Math;

@UdfDescription(name = "pow", description = "calculates pow of a value")
public class Pow {
    @Udf(description = "pow of a base DOUBLE with given exponent DOUBLE")
    public double pow(final double base, final double exponent) {
      return Math.pow(base, exponent);
    }

    @Udf(description = "pow of a base DOUBLE with given exponent INT")
    public double pow(final double base, final int exponent) {
      return Math.pow(base, exponent);
    }

    @Udf(description = "pow of a base INT with given exponent INT")
    public double pow(final int base, final int exponent) {
      return Math.pow(base, exponent);
    }
} 
