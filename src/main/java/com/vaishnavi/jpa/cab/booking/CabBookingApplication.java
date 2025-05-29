package com.vaishnavi.jpa.cab.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class CabBookingApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(CabBookingApplication.class, args);
    }

}
