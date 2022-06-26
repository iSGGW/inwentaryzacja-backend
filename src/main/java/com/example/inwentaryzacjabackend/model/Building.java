package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;
/**
 *Klasa Building służy do przechowywania informacji o gmachach na terenie SGGW
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="buildings")
public class Building {
    /**
     *id - zmienna typu Long służąca do przechowywania id gmachu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
     *name - zmienna typu String służąca do przechowywania nazwy gmachu
     */
    @Column(name="name")
    private String name;
    /**
     *number - zmienna typu String służąca do przechowywania numeru gmachu
     */
    @Column(name="number")
    private String number;
    /**
     *address - zmienna typu String służąca do przechowywania adresu pod jakim znajduje się gmach
     */
    @Column(name="address")
    private String address;
}

