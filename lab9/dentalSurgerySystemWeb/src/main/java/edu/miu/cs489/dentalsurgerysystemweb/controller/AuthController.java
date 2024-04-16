package edu.miu.cs489.dentalsurgerysystemweb.controller;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.AuthRequest;
import edu.miu.cs489.dentalsurgerysystemweb.dto.request.UserRequest;
import edu.miu.cs489.dentalsurgerysystemweb.dto.response.AuthResponse;
import edu.miu.cs489.dentalsurgerysystemweb.model.User;
import edu.miu.cs489.dentalsurgerysystemweb.service.UserService;
import edu.miu.cs489.dentalsurgerysystemweb.service.util.JwtManagementUtilityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ads/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtManagementUtilityServiceImpl jwtManagementUtilityService;

    @PostMapping("/signup")
    public AuthResponse createNewUser(@RequestBody UserRequest userRequest) {
        User user = userService.createNewUser(userRequest);
        return AuthResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(jwtManagementUtilityService.generateToken(user))
                .build();
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        User user = (User) authentication.getPrincipal();
        String token = jwtManagementUtilityService.generateToken(user);
        return AuthResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .token(token)
                .build();
    }
}
