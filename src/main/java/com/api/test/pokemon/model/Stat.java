package com.api.test.pokemon.model;

import lombok.Data;

@Data
public class Stat {
    private long baseStat;
    private long effort;
    private Species stat;
}
