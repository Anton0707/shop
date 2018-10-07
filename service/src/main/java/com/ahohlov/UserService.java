package com.ahohlov;


import com.ahohlov.dao.model.User;
import com.ahohlov.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO update(UserDTO userDTO);

    UserDTO save(UserDTO userDTO);

    User demoSave(User user);

    User findUserByEmail(String email);

    List<User> findAll();

    void deleteById(Long id);

    User findUserById(Long id);
}

