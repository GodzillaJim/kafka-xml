package com.github.godzillajim.kafkaxml.config;

import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.godzillajim.kafkaxml.models.ExtendedFamily;

public class CustomSerializer implements Serializer<ExtendedFamily>{
    Logger log = LoggerFactory.getLogger(CustomSerializer.class);
    XmlMapper mapper = new XmlMapper();
    @Override
    public byte[] serialize(String arg0, ExtendedFamily data) {
        byte [] familyArray = null;
        try{
            if(data != null){
                familyArray = mapper.writeValueAsBytes(data);
            }
        }catch(Exception e){
            log.error(e.getMessage(), e);
        }
        return familyArray;
    }

   
    
}
