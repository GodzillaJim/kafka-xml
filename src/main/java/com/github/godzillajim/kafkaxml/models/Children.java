package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Children {
    @JsonProperty("Son")
    private Son son;
    @JsonProperty("Daughter")
    private Daughter daughter;
}
