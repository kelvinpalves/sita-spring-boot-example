package br.com.forgeit.urbanobservatory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SitaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SitaExampleApplication.class, args);
    }

}
