# A simple Spring Boot Kotlin application generating QR Codes.

Features
--------

A simple [Spring Boot](http://projects.spring.io/spring-boot/) standalone application generating QR Codes based on
[ZXing ("Zebra Crossing")](https://github.com/zxing/zxing/) barcode scanning library.

Build & run
-----------

**Prerequisites:**

* Java 15
* Apache Maven (https://maven.apache.org/)

Application properties can be configured in

```bash
qrcode-generator-kotlin/src/main/resources
```

Use

```bash
mvn package
```
to build the application and

```bash
java -jar target/qrcode-generator-kotlin-1.0.0-SNAPSHOT.jar
```

or

```bash
mvn spring-boot:run
```

to run it on your development machine.

Point your browser to

```bash
http://localhost:8080
```


