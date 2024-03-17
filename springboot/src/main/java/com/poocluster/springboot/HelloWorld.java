package com.poocluster.springboot;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity  // JPA annotation to note object is used for storage
class HelloWorld {

    private @Id @GeneratedValue Long id;  // primary key of JPA storage
    private String message;               // a field for HelloWorld JPA storage

    HelloWorld() {}

    HelloWorld(String message) {
        this.message = message;
    }

    public Long getId() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HelloWorld))
            return false;
        HelloWorld other = (HelloWorld) o;
        return this.id == other.id && this.message.equals(other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message);
    }

    @Override
    public String toString() {
        return "HelloWorld{id=" + id + ", message=" + message + "}";
    }
}