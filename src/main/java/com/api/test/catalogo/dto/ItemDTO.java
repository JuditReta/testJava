package com.api.test.catalogo.dto;

import com.api.test.catalogo.model.Item;
import lombok.*;

@Data
@NoArgsConstructor
public class ItemDTO {
    private Integer id;
    private String name;
    private String description;
    private String code;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.code = item.getCode();
    }
}
