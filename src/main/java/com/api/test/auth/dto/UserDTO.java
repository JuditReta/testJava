package com.api.test.auth.dto;

import com.api.test.auth.model.Rol;
import com.api.test.auth.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Rol rol;
    private Date creationDate;
    private String image;
    private String details;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.rol = user.getRol();
        this.creationDate = user.getCreationDate();
        this.image = user.getImage();
        this.details = user.getDetails();
    }
}
