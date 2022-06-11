package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="floor_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id", insertable = false, updatable = false, nullable = false)
    private Building building;

    @Column(name="level")
    private String level;

}
