package com.pks.parking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private Double duration;
    @NotNull(message = "Starting time can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startingTime;
    @NotNull(message = "Ending type can not be null can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endingTime;
    private Boolean paymentStatus;

    // adding primary user in the system
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    private PrimaryUser primaryUser;

    // adding Secondary user in the system
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private SecondaryUser secondaryUser;





}
