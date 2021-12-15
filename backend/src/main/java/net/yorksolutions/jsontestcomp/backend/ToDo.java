package net.yorksolutions.jsontestcomp.backend;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @JsonProperty
    String text;

    public ToDo(String text) {
        this.text = text;
    }

    public ToDo() {

    }
}