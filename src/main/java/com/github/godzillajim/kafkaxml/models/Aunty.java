package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Aunty extends Wife{
    @JsonProperty("Husband")
    private Husband husband;
    @JsonProperty("Children")
    private Children children;
}
