package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uncle extends Husband{
    @JsonProperty("Wife")
    private Wife wife;
    @JsonProperty("Children")
    private Children children;
}
