package com.pks.parking.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDetailsContainer {

    private Long bookingId;
    private String vehicleType;
    private Double duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startingTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endingTime;
    private Boolean paymentStatus;

}
