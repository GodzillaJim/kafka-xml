package com.github.godzillajim.kafkaxml.services;

import com.github.godzillajim.kafkaxml.models.*;
import com.tzb.faker4j.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    Logger log = LoggerFactory.getLogger(FamilyService.class);
    @Autowired
    KafkaTemplate<String, ExtendedFamily> kafkaTemplate;

    private static final String TOPIC = "Family_Tree";
    private static final String GROUP_ID = "SwissAlps";

    @KafkaListener(topics = TOPIC, groupId = GROUP_ID, containerFactory =
            "KafkaListenerContainerFactory")
    public void consumeData(ExtendedFamily family){
        log.info("Messge Published: {}", family);
    }

    public ExtendedFamily publishMessage(){
        ExtendedFamily family = this.geFamily();
        kafkaTemplate.send(TOPIC, family);
        kafkaTemplate.flush();
        kafkaTemplate.destroy();
        return family;
    }

    public ExtendedFamily geFamily(){
        ExtendedFamily family = new ExtendedFamily();
        Son son = new Son();
        son.setFirstName(Faker.personal.firstName());
        son.setLastName(Faker.personal.lastMaleName(6));

        Daughter daughter = new Daughter();
        daughter.setFirstName(Faker.personal.firstName());
        daughter.setLastName(Faker.personal.lastFemaleName(8));

        Children children = new Children(son, daughter);

        Father father = new Father();
        father.setFirstName(Faker.personal.firstName());
        father.setLastName(Faker.personal.lastMaleName(8));

        Mother mother = new Mother();
        mother.setFirstName(Faker.personal.firstName());
        mother.setLastName(Faker.personal.lastFemaleName(12));

        NuclearFamily nuclearFamily = new NuclearFamily();
        nuclearFamily.setChildren(children);

        Parents parents = new Parents();
        parents.setFather(father);
        parents.setMother(mother);
        nuclearFamily.setParents(parents);

        family.setNuclearFamily(nuclearFamily);

        GrandFather grandFather = new GrandFather();
        grandFather.setFirstName(Faker.personal.firstName());
        grandFather.setLastName(Faker.personal.lastMaleName(15));

        GrandMother grandMother = new GrandMother(Faker.personal.firstName(),
                Faker.personal.lastFemaleName(4));
        GrandParents grandParents = new GrandParents(grandFather, grandMother);
        family.setGrandParents(grandParents);

        Husband husband = new Husband();
        husband.setFirstName(father.getFirstName());
        husband.setLastName(father.getLastName());

        Wife wife = new Wife();
        wife.setFirstName(mother.getFirstName());
        wife.setLastName(mother.getLastName());

        Aunty aunty = new Aunty(husband, children);
        Uncle uncle = new Uncle(wife, children);

        family.setAunty(aunty);
        family.setUncle(uncle);

        return family;
    }
}
