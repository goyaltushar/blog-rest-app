package com.springboot.blog.entity;

import javax.persistence.*;

@Entity
@Table(name="roles", uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Column(length = 60)
    public void setName(String name) {
        this.name = name;
    }
}
