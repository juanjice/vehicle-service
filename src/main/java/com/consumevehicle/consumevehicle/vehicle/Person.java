package com.consumevehicle.consumevehicle.vehicle;

import org.springframework.context.annotation.Bean;

import java.util.*;

/**
 * @author Juan Manuel Jimenez Celis
 */

public class Person {
    private String documentTypeId;
    private String documentTypeName;
    private String document;
    private String name;
    //a list of names, this should be persisted in a database
    public static final List<String> NOMBRES= new ArrayList<String>(){
        {
            add("Stewie Griffin");
            add("Walter wide");
            add("Brian");
            add("Oliver Twist");
            add("Rain Wilson");
            add("Andres Palpatine");
        }
    };            ;

    public Person(String documentTypeId, String documentTypeName, String document, String name) {
        this.documentTypeId = documentTypeId;
        this.documentTypeName = documentTypeName;
        this.document = document;
        this.name = name;
    }
    //static method to generate a random person
    public static Person getRandomPerson(){
        Random rand = new Random();
        return new Person("1",
                "cedula",
                UUID.randomUUID().toString(),
                NOMBRES.get(rand.nextInt(NOMBRES.size())));
    }

    public String getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(String documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
