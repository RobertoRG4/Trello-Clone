package com.trello_clone.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "files")
@Getter
@Setter
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "file")
    @Lob
    private byte[] file;

    public File(String name, byte[] file) {
        this.name = name;
        this.file = file;
    }
}
