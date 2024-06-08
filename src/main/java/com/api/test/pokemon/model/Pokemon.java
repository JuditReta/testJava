package com.api.test.pokemon.model;

import lombok.Data;

import java.util.List;

@Data
public class Pokemon {
    private long id;
    private boolean is_default;
    private String location_area_encounters;
    private List<Move> moves;
    private String name;
    private List<PastType> past_types;
    private Species species;
    private Sprites sprites;
    private List<Stat> stats;
    private List<Type> types;
    private long weight;

    private long base_experience;
    private long height;
    private long order;
    private Cries cries;
}
