package edu.miu.cs489.dentalsurgerysystemweb.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponse {
    private Long id;
    private String username;
    private String token;
}
