package com.vaishnavi.jpa.cab.booking.service.impl;

import com.vaishnavi.jpa.cab.booking.domain.User;
import com.vaishnavi.jpa.cab.booking.model.UserModel;
import com.vaishnavi.jpa.cab.booking.repository.UserRepository;
import com.vaishnavi.jpa.cab.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel saveUser(UserModel user) {
        User userEntity = populateUserEntity(user);
        return populateUserModel(userRepository.save(userEntity));
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return true;
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<UserModel> users = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        userList.forEach(user -> users.add(populateUserModel(user)));
        return users;
    }

    @Override
    public UserModel getUserById(int userId) {
        return null;
    }

    @Override
    public UserModel getUserById(Long userId) {
        return populateUserModel(userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
    }

    private UserModel populateUserModel(final User user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setName(user.getName());
        model.setEmail(user.getEmail());
        model.setPhone(user.getPhone());
        return model;
    }

    private User populateUserEntity(UserModel model) {
        User user = new User();
        user.setName(model.getName());
        user.setEmail(model.getEmail());
        user.setPhone(model.getPhone());
        return user;
    }
}



