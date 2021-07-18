package com.pks.parking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SecondaryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bkashPhoneNumberSU;
    private String name;
    @NotBlank(message = "New password is mandatory")
    private String password;
    @NotNull(message = "Can not be empty")
    private String acNumber;
    @NotNull(message = "Can not be empty")
    private String bankName;
    @Min(value = 0)
    private double currentBalance;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;
    @Min(value = 0)
    private int numberOfBikes;
    @Min(value = 0)
    private double hourlyRentForBike;
    @Min(value = 0)
    private int numberOfCars;
    @Min(value = 0)
    private double hourlyRentForCar;




}
