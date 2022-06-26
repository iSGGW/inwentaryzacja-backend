package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;
/**
 *Klasa Floor służy do przechowywania informacji o piętrach
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "floors")
public class Floor {
    /**
     *id - zmienna typu Long służąca do przechowywania id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
     *building - zmienna zawierająca informację o budynku
     */
    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false, nullable = false)
    private Building building;
    /**
     *level - zmienna typu String zawierająca informację o poziomie w budynku
     */
    @Column(name="level")
    private String level;

}
