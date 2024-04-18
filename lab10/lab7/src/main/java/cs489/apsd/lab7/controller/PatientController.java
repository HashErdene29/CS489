package cs489.apsd.lab7.controller;

import cs489.apsd.lab7.dto.patient.PatientRequest;
import cs489.apsd.lab7.dto.patient.PatientResponse;
import cs489.apsd.lab7.exception.PatientNotFoundException;
import cs489.apsd.lab7.model.Patient;
import cs489.apsd.lab7.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adsweb/api/v1/patient")
public class PatientController {
    private PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<PatientResponse>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable("id") int id) throws PatientNotFoundException {
        var patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<PatientResponse> save(@Valid @RequestBody PatientRequest patient) {
        return new ResponseEntity<>(patientService.addPatient(patient), HttpStatus.CREATED);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Patient> update(@PathVariable("id") int id, @Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{searchString}")
    public ResponseEntity<List<PatientResponse>> getPatientsBySearchString(@PathVariable("searchString") String searchString) {
        return ResponseEntity.ok(patientService.searchPatient(searchString));
    }
}
