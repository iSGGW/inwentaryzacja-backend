package com.example.inwentaryzacjabackend.model;

import lombok.*;

import javax.persistence.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="room_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "floor_id", insertable = false, updatable = false, nullable = false)
    private Floor floor;

    @Column(name="room_nbr")
    private String number;

    @Column(name="type")
    private String type;
}
