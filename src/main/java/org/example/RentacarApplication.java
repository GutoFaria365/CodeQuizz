package org.example;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class RentacarApplication implements QuarkusApplication {

    public static void main(String[] args) {
        Quarkus.run(RentacarApplication.class, args);
    }

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Hello, world!");
        return 0;
    }
}
