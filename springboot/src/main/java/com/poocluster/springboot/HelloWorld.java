package com.poocluster.springboot;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity  // JPA annotation to note object is ready for storage
class HelloWorld {

    private @Id @GeneratedValue Long id;  // primary key of JPA storage
    private String name;                  // a field for HelloWorld JPA storage

    HelloWorld() {}

    HelloWorld(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof HelloWorld))
            return false;
        HelloWorld other = (HelloWorld) o;
        return this.id == other.id && this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "HelloWorld{id=" + id + ", name=" + name + "}";
    }
}