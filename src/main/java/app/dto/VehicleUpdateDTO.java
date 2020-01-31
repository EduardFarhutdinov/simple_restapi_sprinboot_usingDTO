package app.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VehicleUpdateDTO {
    private String make;

    private String model;

}
