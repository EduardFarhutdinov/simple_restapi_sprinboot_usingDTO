package app.services;

import app.dto.VehicleCreateDTO;
import app.dto.VehicleQueryDTO;
import app.dto.VehicleUpdateDTO;
import app.entities.Status;
import app.entities.Vehicle;
import app.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class VehicleCommandServiceImpl implements VehicleCommandService {

    private VehicleRepository vehicleRepository;

    public VehicleCommandServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public UUID createVehicle(VehicleCreateDTO vehicleCreateDTO) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(UUID.randomUUID());
        vehicle.setVehicleIdentityNumber(vehicleCreateDTO.getVehicleIdentityNumber());
        vehicle.setMake(vehicleCreateDTO.getMake());
        vehicle.setModel(vehicleCreateDTO.getModel());
        vehicle.setStatus(String.valueOf(Status.FOR_SALE));


        return  vehicleRepository.save(vehicle).getId();
    }

    @Override
    public VehicleQueryDTO updateVehicle(UUID id, VehicleUpdateDTO vehicleUpdateDTO) {

        if (vehicleRepository.findById(id).isPresent()){
            Vehicle existingVehicle = vehicleRepository.findById(id).get();

            existingVehicle.setMake(vehicleUpdateDTO.getMake());
            existingVehicle.setModel(vehicleUpdateDTO.getModel());

            Vehicle updateVehicle = vehicleRepository.save(existingVehicle);

            return new VehicleQueryDTO(updateVehicle.getId(),updateVehicle.getVehicleIdentityNumber(),updateVehicle.getMake(),updateVehicle.getMake());
        }
        return null;
    }
}
