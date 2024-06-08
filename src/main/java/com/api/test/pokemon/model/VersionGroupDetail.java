package com.api.test.pokemon.model;

import lombok.Data;

@Data
public class VersionGroupDetail {
    private long level_learned_at;
    private Species move_learn_method;
    private Species version_group;
}
