package com.proyecto.proyecto.config;



import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties
public class AplicationsProperties {

    private String host="localhost";
    private Integer port=6379;
    private Integer timeOfLife=60000;

//    @Value(value = "${jwt.secret}")
//    private String jwtSecret;
//    @Value(value = "${jwt.expiration}")
//    private int expiration;

}
