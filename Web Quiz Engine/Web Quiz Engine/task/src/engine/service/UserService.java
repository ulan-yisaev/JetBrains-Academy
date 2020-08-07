package engine.service;

import engine.dto.UserDto;
import engine.entity.User;
import engine.mapper.UserMapper;
import engine.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        return userMapper.toUserDto(user);
    }

    public UserDto register(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email is already taken by another user");
        User user = userMapper.toUser(userDto);
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        user.setActive(true);
        user.setRoles("ADMIN");
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }
}
