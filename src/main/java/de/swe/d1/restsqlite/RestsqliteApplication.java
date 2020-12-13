package de.swe.d1.restsqlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class RestsqliteApplication {

    public static void main(String[] args) {
        SpringApplication app = new   SpringApplication(RestsqliteApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port","1338"));
        app.run(args);
       // SpringApplication.run(RestsqliteApplication.class, args);
        System.out.println("Lets Go Server");
    }

}
