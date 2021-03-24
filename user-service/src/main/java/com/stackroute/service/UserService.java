package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;

import java.util.List;

public interface UserService {

    /**
     * AbstractMethod to save a user
     */
    User saveUser(User user) throws UserAlreadyExistsException;

    /**
     * AbstractMethod to save a user
     */
    List<User> getAllUsers() throws Exception;
}
