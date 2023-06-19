package com.example.MonitoringLocation.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persons" )
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user ;
    private String name;
    private String token;
    private String avatar;
}
