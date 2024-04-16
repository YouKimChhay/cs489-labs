package edu.miu.cs489.dentalsurgerysystemweb.service;

import edu.miu.cs489.dentalsurgerysystemweb.dto.request.UserRequest;
import edu.miu.cs489.dentalsurgerysystemweb.model.User;

public interface UserService {
    User createNewUser(UserRequest userRequest);
}
