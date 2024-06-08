package com.api.test.pokemon.model;

import lombok.Data;

import java.util.List;

@Data
public class PastType {
    private Species generation;
    private List<Type> types;
}
