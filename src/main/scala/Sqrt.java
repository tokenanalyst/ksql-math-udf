package io.tokenanalyst.udfs;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

import java.lang.*;

@UdfDescription(name = "sqrt", description = "calculates square root of a value")
public class Sqrt {
    
    @Udf(description = "square root an Integer")
    public double sqrt(final int val) {
      return Math.sqrt(val);
    }
  
    @Udf(description = "square root a BIGINT")
    public double sqrt(final long val) {
      return Math.sqrt(val);
    }
  
    @Udf(description = "square root a DOUBLE")
    public double sqrt(final double val) {
      return Math.sqrt(val);
    }
}