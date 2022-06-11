package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="building_id")
    private Long buildingId;

    @Column(name="name")
    private String name;

    @Column(name="number")
    private String number;

    @Column(name="address")
    private String address;

}

