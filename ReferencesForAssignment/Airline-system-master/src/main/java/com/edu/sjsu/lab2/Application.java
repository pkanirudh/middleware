package com.edu.sjsu.lab2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
public class Application extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}


/***
 *
 * server.port: 8443
 server.ssl.key-store: keystore.p12
 server.ssl.key-store-password: changeit
 server.ssl.keyStoreType: PKCS12
 server.ssl.keyAlias: tomcat
 */
