package com.erikhdezv.crud_reactivo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Integer id;

    @Column("name")
    private String name;

    @Column("age")
    private Integer age;

    @Column("gender")
    private String gender;

    @Column("date_of_birth")
    private LocalDate date_of_birth;

    @Column("blood_type")
    private String blood_type;
}
