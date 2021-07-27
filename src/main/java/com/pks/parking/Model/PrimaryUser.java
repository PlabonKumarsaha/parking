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
    //@JsonProperty("id")
    private Long puId;
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