package de.swe.d1.restsqlite;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;



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
    @Bean
    public TomcatServletWebServerFactory containerFactory() {
        return new TomcatServletWebServerFactory() {
            protected void customizeConnector(Connector connector) {
                int maxSize = 50000000;
                super.customizeConnector(connector);
                connector.setMaxPostSize(maxSize);
                connector.setMaxSavePostSize(maxSize);
                if (connector.getProtocolHandler() instanceof AbstractHttp11Protocol) {

                    ((AbstractHttp11Protocol <?>) connector.getProtocolHandler()).setMaxSwallowSize(maxSize);
                    logger.info("Set MaxSwallowSize "+ maxSize);
                }
            }
        };

    }

}
