package mpepke.system.reservation.controller;


import lombok.RequiredArgsConstructor;
import mpepke.system.reservation.controller.request.AddUserRequest;
import mpepke.system.reservation.model.UserApp;
import mpepke.system.reservation.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Clock;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserAppController {

    final UserService userService;
    final Clock clock;


    @PostMapping()
    ResponseEntity<UserApp> addUser(@RequestBody AddUserRequest addUserRequest) throws Exception {
        UserApp savedUser = userService.addUser(addUserRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
}
