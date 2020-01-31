package app.services;

import app.dto.VehicleQueryDTO;
import app.entities.Vehicle;
import app.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleQueryServiceImpl implements VehicleQueryService {

    private VehicleRepository vehicleRepository;

    public VehicleQueryServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleQueryDTO getVehicle(UUID id) {
        if (vehicleRepository.findById(id).isPresent()){
            Vehicle vehicle = vehicleRepository.findById(id).get();
            return new VehicleQueryDTO(vehicle.getId(),vehicle.getVehicleIdentityNumber(),vehicle.getMake(),vehicle.getModel());
        }
        return null;
    }

    @Override
    public List<VehicleQueryDTO> listAllVehicles() {
        List<VehicleQueryDTO> vehicleList = new ArrayList<>();

        vehicleRepository.findAll().stream().forEach(vehicle -> vehicleList.add(new VehicleQueryDTO(vehicle.getId(),vehicle.getVehicleIdentityNumber(),
                vehicle.getMake(),vehicle.getModel())));

        return vehicleList;
    }
}
