package com.pks.parking.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "bkashPhoneNumberPU"}) })
public class PrimaryUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Pu_Id;
    @Column(name = "bkashPhoneNumberPU", length = 11, unique = true)
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
