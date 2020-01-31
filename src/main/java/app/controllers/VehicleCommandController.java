package app.controllers;

import app.dto.VehicleCreateDTO;
import app.dto.VehicleQueryDTO;
import app.dto.VehicleUpdateDTO;
import app.services.VehicleCommandService;
import app.services.VehicleCommandServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleCommandController {

    private VehicleCommandService vehicleCommandService;

    public VehicleCommandController(VehicleCommandService vehicleCommandService) {
        this.vehicleCommandService = vehicleCommandService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UUID> createVehicle(@RequestBody VehicleCreateDTO createDTO){
        return new ResponseEntity<>(vehicleCommandService.createVehicle(createDTO),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VehicleQueryDTO> updateVehicle(@PathVariable(value = "id") UUID id,
                                                         @RequestBody VehicleUpdateDTO vehicleUpdateDTO){
        return new ResponseEntity<>(vehicleCommandService.updateVehicle(id,vehicleUpdateDTO),HttpStatus.OK);
    }
}
