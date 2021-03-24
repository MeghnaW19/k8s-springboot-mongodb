package com.stackroute.service;

import com.stackroute.domain.User;
import com.stackroute.exception.UserAlreadyExistsException;
import com.stackroute.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Service indicates annotated class is a service which
 * holds business logic in the Service layer
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    /*
     * to get property value
     */
    @Value("${app.exceptionMessage}")
    private String exceptionMessage;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Implementation of saveUser method
     */
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        /*
         * Implementation of saveBlog method
         * Throw UserAlreadyExistsException if user id already exists in db
         */
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException(exceptionMessage);
        } else
            return userRepository.save(user);
    }

    /**
     * Implementation of getAllUsers method
     */
    @Override
    public List<User> getAllUsers() throws Exception {
        /*
        Throws Exception if Database connection issue happens
        */
        return (List<User>) userRepository.findAll();
    }
}
