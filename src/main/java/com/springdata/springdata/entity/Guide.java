package com.springdata.springdata.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table
@NoArgsConstructor
public class Guide {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "guide", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students;
}
