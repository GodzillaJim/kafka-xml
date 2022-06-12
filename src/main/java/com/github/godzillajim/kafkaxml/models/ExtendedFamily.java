package com.github.godzillajim.kafkaxml.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedFamily {
    @JsonProperty("GrandParents")
    GrandParents grandParents;
    @JsonProperty("NuclearFamily")
    private NuclearFamily nuclearFamily;
    @JsonProperty("Aunty")
    private Aunty aunty;
    @JsonProperty("Uncle")
    private Uncle uncle;

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        Logger log = LoggerFactory.getLogger(ExtendedFamily.class);
        try{
            return mapper.writeValueAsString(this);
        }catch (Exception e){
            log.info("Json Stringify Error: ",e);
            return "ExtendedFamily{" +
                    "mapper=" + mapper +
                    ", grandParents=" + grandParents +
                    ", nuclearFamily=" + nuclearFamily +
                    ", aunty=" + aunty +
                    ", uncle=" + uncle +
                    '}';
        }
    }
}
