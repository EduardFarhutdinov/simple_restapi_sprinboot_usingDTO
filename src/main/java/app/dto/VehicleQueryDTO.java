package app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class VehicleQueryDTO {

    private UUID id;

    private String vehicleIdentityNumber;

    private String make;

    private String model;

}
