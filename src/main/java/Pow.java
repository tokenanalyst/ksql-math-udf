package io.tokenanalyst.udfs;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

import java.lang.Math;

@UdfDescription(name = "pow", description = "calculates pow of a value")
public class Pow {
    @Udf(description = "pow of a base with given exponent")
    public double pow(final double base, final double exponent) {
      return Math.pow(base, exponent);
    }
} 
