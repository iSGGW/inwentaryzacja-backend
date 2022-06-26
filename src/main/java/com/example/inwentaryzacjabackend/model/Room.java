package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;
/**
 *Klasa Room służy do przechowywania informacji o salach
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {
    /**
     *id - zmienna typu Long zawierająca informację o ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
     *floor - zmienna zawierająca informację o piętrze na którym znajduje się sala
     */
    @ManyToOne
    @JoinColumn(name = "floor_id", insertable = false, updatable = false, nullable = false)
    private Floor floor;
    /**
     *number - zmienna typu String zawierająca informację o numerze sali
     */
    @Column(name="room_nbr")
    private String number;
    /**
     *type - zmienna typu String zawierająca informację o typie sali
     */
    @Column(name="type")
    private String type;
}
