package hu.dia.tacocloud.service.impl;

import hu.dia.tacocloud.model.data.User;
import hu.dia.tacocloud.repository.UserRepository;
import hu.dia.tacocloud.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User " + username + " not found!");
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
