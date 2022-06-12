package com.github.godzillajim.kafkaxml.models;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
public class GrandMother extends Wife{
    public GrandMother(String firstName, String lastFemaleName) {
        this.setFirstName(firstName);
        this.setLastName(lastFemaleName);
    }
}
