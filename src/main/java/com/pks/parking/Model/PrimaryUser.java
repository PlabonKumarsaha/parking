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
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrimaryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String bkashPhoneNumberPU;
    @NotBlank(message = "User must enter a name")
    private String name;
    @NotBlank(message = "New password is mandatory")
    private String password;
    @Min(value = 0)
    private double currentBalance;
    @NotNull
    private double latitude;
    @NotNull
    private double longitude;


}
