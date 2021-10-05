package br.com.forgeit.urbanobservatory.usecase.collectdata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "rooms")
@Configuration
@Component
@Data
public class Rooms {

    private List<Room> configurations;

    @Data
    public static class Room {
        private String name;
        private String entityID;
    }

}
