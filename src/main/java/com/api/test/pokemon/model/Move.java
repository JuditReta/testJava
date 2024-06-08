package com.api.test.pokemon.model;

import lombok.Data;

import java.util.List;

@Data
public class Move {
    private Species move;
    private List<VersionGroupDetail> version_group_details;
}
