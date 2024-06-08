package com.api.test.auth.service;

import com.api.test.auth.dto.UserDTO;
import com.api.test.auth.model.User;
import com.api.test.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private FabricUserService fabricUserService;

    @Autowired
    private UserRepository userRepository;

    public UserDTO save(UserDTO userDTO){
        return fabricUserService.createUserDTO(userRepository.save(fabricUserService.createUser(userDTO)));
    }

    public List<UserDTO> findAll(){
        return fabricUserService.createUsersDTO(userRepository.findAll());
    }
    public UserDTO findById(Integer id){
        return fabricUserService.createUserDTO(userRepository.findById(id).get());
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    public UserDTO update(UserDTO userDTO){
        User existingUser = userRepository.findById(userDTO.getId()).get();
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setImage(userDTO.getImage());
        existingUser.setDetails(userDTO.getDetails());
        User updatedUser = userRepository.save(existingUser);
        return fabricUserService.createUserDTO(existingUser);
    }
}
