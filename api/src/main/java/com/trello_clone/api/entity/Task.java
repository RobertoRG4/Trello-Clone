package com.trello_clone.api.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

/**
 *
 * @author cds3h
 */
@Entity
@Table(name = "tareas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status", nullable = false)
    private String status;
}