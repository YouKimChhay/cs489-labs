package edu.miu.cs489.dentalsurgerysystemweb.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String username;
    private String password;
    private List<String> roles;
}
