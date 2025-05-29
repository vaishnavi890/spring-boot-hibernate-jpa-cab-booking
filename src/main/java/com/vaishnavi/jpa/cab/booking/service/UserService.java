package com.vaishnavi.jpa.cab.booking.service;

import com.vaishnavi.jpa.cab.booking.model.UserModel;
import java.util.List;

public interface UserService {
    UserModel saveUser(UserModel user);
    boolean deleteUser(int userId);

    boolean deleteUser(Long userId);

    List<UserModel> getAllUsers();
    UserModel getUserById(int userId);

    UserModel getUserById(Long userId);
}


