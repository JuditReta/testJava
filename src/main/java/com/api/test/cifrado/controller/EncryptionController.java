package com.api.test.cifrado.controller;

import com.api.test.catalogo.dto.ItemDTO;
import com.api.test.cifrado.service.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cifrado")
public class EncryptionController {
    @Autowired
    private EncryptionService encryptionService;

    @GetMapping("/encriptar/{word}")
    public ResponseEntity<?> getEncryption(@PathVariable String word){
        try {
            return new ResponseEntity<>(encryptionService.encrypts(word), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }

    }
}
