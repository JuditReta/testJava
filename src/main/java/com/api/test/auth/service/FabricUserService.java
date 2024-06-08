package com.api.test.auth.service;

import com.api.test.auth.dto.UserDTO;
import com.api.test.auth.model.User;
import com.api.test.catalogo.dto.ItemDTO;
import com.api.test.catalogo.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricUserService {
    public User createUser(UserDTO userDTO){
        return  new User(userDTO);
    }

    public UserDTO createUserDTO(User user){
        return new UserDTO(user);
    }

    public List<UserDTO> createUsersDTO(List<User> listUsers){
        List<UserDTO> userDTOS = new ArrayList<>();
        listUsers.stream().forEach(
                user -> {
                    userDTOS.add(createUserDTO(user));
                }
        );
        return userDTOS;
    }
}
