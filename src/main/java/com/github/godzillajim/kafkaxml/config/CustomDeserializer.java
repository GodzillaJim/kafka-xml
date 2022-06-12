package com.github.godzillajim.kafkaxml.config;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.godzillajim.kafkaxml.models.ExtendedFamily;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomDeserializer implements Deserializer<ExtendedFamily>{
    Logger log = LoggerFactory.getLogger(CustomDeserializer.class);
    XmlMapper mapper = new XmlMapper();

    @Override
    public ExtendedFamily deserialize(String arg0, byte[] arg1) {
        ExtendedFamily family = null;
        try{
            if(arg1 != null){
                family = mapper.readValue(arg1, ExtendedFamily.class);
            }
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
        return family;
    }
}
