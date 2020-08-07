package engine.controller;

import engine.dto.UserDto;
import engine.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping("/api/register")
    private UserDto registerUser(@Valid @RequestBody UserDto userDto){
        return userService.register(userDto);
    }
}
