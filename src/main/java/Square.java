package io.tokenanalyst.udfs;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;


@UdfDescription(name = "square", description = "calculates square of a value")
public class Square {
    
    @Udf(description = "square of an Integer")
    public long square(final int val) {
      return val * val;
    }
  
    @Udf(description = "square of a BIGINT")
    public long square(final long val) {
      return val * val;
    }
  
    @Udf(description = "square of a DOUBLE")
    public double square(final double val) {
      return val * val;
    }
}
