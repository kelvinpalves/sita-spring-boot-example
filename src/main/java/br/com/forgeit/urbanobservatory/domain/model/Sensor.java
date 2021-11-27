package br.com.forgeit.urbanobservatory.domain.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@ToString
public class Sensor {
    private String metricName;
    private String unitName;
    private LocalDateTime lastUpdate;
    private String value;

    public Sensor(String metricName, String unitName, String time, String value) {
        this.metricName = metricName;
        this.unitName = unitName;
        this.lastUpdate = stringToLocalDateTime(time);
        this.value = value;
    }

    private LocalDateTime stringToLocalDateTime(String time) {
        return LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
    }
}
