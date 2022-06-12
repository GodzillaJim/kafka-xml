package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NuclearFamily {
    @JsonProperty("Parents")
    private Parents parents;
    @JsonProperty("Children")
    private Children children;
}
