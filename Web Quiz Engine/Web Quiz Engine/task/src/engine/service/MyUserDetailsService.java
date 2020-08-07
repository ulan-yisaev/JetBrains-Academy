package engine.service;

import engine.entity.MyUserDetails;
import engine.entity.User;
import engine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        user.orElseThrow(() -> new UsernameNotFoundException(email));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), )
        return user.map(MyUserDetails::new).get();
    }
}

/*
UserDetailsService is an interface provided by Spring Security module. We have to override one method provided by the interface
аннотация @Component указывает, что этот класс можно внедрить в другой файл (например, файл SecurityConfiguration)

 */