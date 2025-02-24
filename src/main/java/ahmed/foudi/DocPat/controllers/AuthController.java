package ahmed.foudi.DocPat.controllers;

import ahmed.foudi.DocPat.dto.request.DoctorRequest;
import ahmed.foudi.DocPat.dto.request.LoginRequest;
import ahmed.foudi.DocPat.dto.request.PatientRequest;
import ahmed.foudi.DocPat.dto.response.AuthResponse;
import ahmed.foudi.DocPat.services.interfaces.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
    @GetMapping("/HAHA")
    public String hello(){
        return "Hello World";
    }

    @PostMapping("/register/doctor")
    public ResponseEntity<AuthResponse> registerDoctor(@Valid @RequestBody DoctorRequest request) {
        return ResponseEntity.ok(authService.registerDoctor(request));
    }

    @PostMapping("/register/patient")
    public ResponseEntity<AuthResponse> registerPatient(@Valid @RequestBody PatientRequest request) {
        return ResponseEntity.ok(authService.registerPatient(request));
    }
}
