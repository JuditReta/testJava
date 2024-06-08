package com.api.test.catalogo.service;

import com.api.test.catalogo.dto.ItemDTO;
import com.api.test.catalogo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private FabricItemService fabricItemService;

    @Autowired
    private ItemRepository itemRepository;

    public ItemDTO save(ItemDTO itemDTO){
        return fabricItemService.createItemDTO(itemRepository.save(fabricItemService.createItem(itemDTO)));
    }

    public List<ItemDTO> findAll(){
        return fabricItemService.createItemsDTO(itemRepository.findAll());
    }
    public ItemDTO findByName(String name){
        return fabricItemService.createItemDTO(itemRepository.findByNameContains(name).get(0));
    }

    public void deleteById(Integer id){
        itemRepository.deleteById(id);
    }
}
