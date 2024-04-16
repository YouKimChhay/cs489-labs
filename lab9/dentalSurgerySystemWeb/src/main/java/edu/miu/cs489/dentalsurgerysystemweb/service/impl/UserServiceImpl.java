package edu.miu.cs489.dentalsurgerysystemweb.service.impl;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.UserRequest;
import edu.miu.cs489.dentalsurgerysystemweb.model.Role;
import edu.miu.cs489.dentalsurgerysystemweb.model.User;
import edu.miu.cs489.dentalsurgerysystemweb.repository.RoleRepository;
import edu.miu.cs489.dentalsurgerysystemweb.repository.UserRepository;
import edu.miu.cs489.dentalsurgerysystemweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createNewUser(UserRequest userRequest) {
        List<Role> roles = userRequest.getRoles().stream()
                .map(roleName -> roleRepository.getRoleByName(roleName).orElse(Role.builder().name(roleName).build()))
                .toList();
        User user = User.builder()
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(roles)
                .build();
        return userRepository.save(user);
    }
}
