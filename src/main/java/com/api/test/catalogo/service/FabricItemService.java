package com.api.test.catalogo.service;

import com.api.test.catalogo.dto.ItemDTO;
import com.api.test.catalogo.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FabricItemService {
    public Item createItem(ItemDTO itemDTO){
        return  new Item(itemDTO);
    }

    public ItemDTO createItemDTO(Item item){
        return new ItemDTO(item);
    }

    public List<ItemDTO> createItemsDTO(List<Item> listItems){
        List<ItemDTO> itemDTOS = new ArrayList<>();
        listItems.stream().forEach(
                item -> {
                    itemDTOS.add(createItemDTO(item));
                }
        );
        return itemDTOS;
    }
}
