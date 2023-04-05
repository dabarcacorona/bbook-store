package com.jadm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JadmBbokTiendaApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(JadmBbokTiendaApplication.class, args);
    }
}
