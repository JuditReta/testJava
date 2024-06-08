package com.api.test.cifrado.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import java.util.Base64;

@Service
public class EncryptionService {
    private Cipher encryptionCipher;
    private static final String algorithm = "AES/CBC/PKCS5PADDING";
    private SecretKey key;
    private int KEY_SIZE = 128;

    public  void init() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key =  generator.generateKey();
    }

    public Object encrypts(String message)throws Exception{
        try {
            byte[] msgInBytes = message.getBytes();
            encryptionCipher = Cipher.getInstance(algorithm);
            encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = encryptionCipher.doFinal(msgInBytes);

            return new ResponseEntity<>(encode(encryptedBytes), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.toString(), HttpStatus.NOT_FOUND);
        }
    }

    private  String encode(byte[] data){
        return Base64.getEncoder().encodeToString(data);
    }
}
