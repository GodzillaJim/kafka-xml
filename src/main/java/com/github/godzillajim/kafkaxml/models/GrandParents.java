package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GrandParents {
    @JsonProperty("GrandFather")
    private GrandFather grandFather;
    @JsonProperty("GrandMother")
    private GrandMother grandMother;
}
