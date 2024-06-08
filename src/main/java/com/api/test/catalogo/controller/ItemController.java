package com.api.test.catalogo.controller;

import com.api.test.catalogo.dto.ItemDTO;
import com.api.test.catalogo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDTO> save(@RequestBody ItemDTO itemDTO){
        return new ResponseEntity<>(itemService.save(itemDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemDTO>> findAll(){
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ItemDTO> findByName(@PathVariable String name){
        try{
            return new ResponseEntity<>(itemService.findByName(name),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        try{
            itemService.deleteById(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
