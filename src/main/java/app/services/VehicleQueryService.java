package app.services;

import app.dto.VehicleQueryDTO;

import java.util.List;
import java.util.UUID;

public interface VehicleQueryService {
    public VehicleQueryDTO getVehicle(UUID id);
    public List<VehicleQueryDTO> listAllVehicles();
}
