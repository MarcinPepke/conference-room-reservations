package mpepke.system.reservation.controller;

import lombok.AllArgsConstructor;
import mpepke.system.reservation.controller.request.AuthenticationRequest;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.model.dto.AuthenticationDto;
import mpepke.system.reservation.repository.UserAppRepository;
import mpepke.system.reservation.service.TokenService;
import mpepke.system.reservation.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {


    private final UserAppRepository userAppRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> createAuthentication(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String username = userService.loadByUsername(authenticationRequest.getUsername()).orElseThrow(Exception::new).getUsername();
        String token = tokenService.generateAccessToken(authenticationRequest.getUsername());
        String refreshToken = tokenService.generateRefreshToken(authenticationRequest.getUsername());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        return ResponseEntity.ok(new AuthenticationDto(token, refreshToken, username, "ROLE_USER"));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<UserApp> all = userAppRepository.findAll();
        return ResponseEntity.ok().body(all);

    }
}