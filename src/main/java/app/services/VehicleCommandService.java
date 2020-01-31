package app.services;

import app.dto.VehicleCreateDTO;
import app.dto.VehicleQueryDTO;
import app.dto.VehicleUpdateDTO;

import java.util.UUID;

public interface VehicleCommandService {
    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO);
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO);
}
