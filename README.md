# ksql-math-udf
UDF which implements basic math functions for ksql

Inspiration for this library was this github [issue](https://github.com/confluentinc/ksql/issues/2163#issuecomment-440637503)

## Usage
### Getting the jar

1. Either download from releases

```
wget https://github.com/tokenanalyst/ksql-math-udf/releases/download/basic-math/ta-math-udfs.jar
```

2. Bulding from source

```
$ # get source code
$ git clone https://github.com/tokenanalyst/ksql-math-udf.git
$ # install sbt (https://www.scala-sbt.org/1.0/docs/Setup.html)
$ sudo apt-get install agt
$ # build the binary
$ sbt assembly
```

### Using the JAR in ksql

1. Create a directory for UDF jar's and put the jar file there

```
$ mkdir \var\lib\ksql-ext\
$ mv ta-math-udfs.jar \var\lib\ksql-ext\
```

2. Update the location in `ksqlserver.properties`
```
$ echo ksql.extension.dir=/var/lib/ksql-ext >> /etc/ksql/ksql-server.properties
```

3. Restart KSQL server
```
$ systemctl restart confluent-ksql
```

4. Start ksql and show functions to see if the new functions have been added
```
$ ksql
ksql> show functions;

 Function Name           | Type      
-------------------------------------
 SQUARE                  | SCALAR    
 SQRT                    | SCALAR  
```

5. The functions are now ready to use
```
ksql> SELECT key, sqrt(value) as sqrt_value from STREAM_NAME;
ksql> SELECT key, sqrt(sum(square(value))/count()) as stdev_value from STREAM_NAME group by key;
```