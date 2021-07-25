package com.pks.parking.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "bkashPhoneNumberSU"}) })
public class SecondaryUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@JsonProperty("id")
    private Long suId;
    @Column(name = "bkashPhoneNumberSU", length = 13, unique = true)
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
