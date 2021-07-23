package com.pks.parking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    @NotNull(message = "Must choose a type")
    private String vehicleType;
    private double duration;
    @NotNull(message = "Starting time can not be null")
    private String startingTime;
    @NotNull(message = "Ending type can not be null can not be null")
    private String endingTime;
    private boolean paymentStatus;

    // adding primary user in the system
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "primary_user_id",referencedColumnName = "Pu_Id")
    private PrimaryUser primaryUser;

    // adding Secondary user in the system
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "secondary_user_id",referencedColumnName = "Su_Id")
    private SecondaryUser secondaryUser;



}
