package com.example.crud_api.service;

import com.example.crud_api.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<UUID, User> userStorage = new HashMap<>();

    // CREATE - Add a new user
    public User addUser(User user) {
        UUID userId = UUID.randomUUID(); // Generate the ID here
        user.setId(userId);
        userStorage.put(userId, user);
        return user;
    }

    // READ - Get all users
    public List<User> getAllUsers() {
        return new ArrayList<>(userStorage.values());
    }

    // READ - Get user by ID
    public Optional<User> getUserById(UUID id) {
        return Optional.ofNullable(userStorage.get(id));
    }

    // UPDATE - Update user by ID
    public Optional<User> updateUser(UUID id, User updatedUser) {
        if (userStorage.containsKey(id)) {
            updatedUser.setId(id); // Preserve original ID
            userStorage.put(id, updatedUser);
            return Optional.of(updatedUser);
        }
        return Optional.empty();
    }

    // DELETE - Remove user by ID
    public boolean deleteUser(UUID id) {
        return userStorage.remove(id) != null;
    }
}
