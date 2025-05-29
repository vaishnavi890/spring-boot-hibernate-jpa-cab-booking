package com.vaishnavi.jpa.cab.booking.domain;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "Cab")
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cabId;

    private String cabNumber;
    private String cabModel;
    private String cabType;
    private String licensePlate;
    private int driverId;

    public Cab(String cabNumber, String cabModel, String cabType, String licensePlate, int driverId) {
        this.cabNumber = cabNumber;
        this.cabModel = cabModel;
        this.cabType = cabType;
        this.licensePlate = licensePlate;
        this.driverId = driverId;
    }
}


