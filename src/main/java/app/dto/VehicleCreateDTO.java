package app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VehicleCreateDTO {

    private String vehicleIdentityNumber;

    private String make;

    private String model;
}
