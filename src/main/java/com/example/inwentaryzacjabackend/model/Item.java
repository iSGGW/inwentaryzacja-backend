package com.example.inwentaryzacjabackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class    Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name="name")
    private String name;

    // TO DO to establish if we want item characteristics
    @Column(name="type")
    private String type;

    @Column(name="manufacturer")
    private String manufacturer;

    @Column(name="serial_number")
    private String serialNumber;

    // 1 = na stanie
    // 2 = brak
    // 3 = do utylizacji
    // 4 = zutylizowane

    @Column(name="status")
    private BigInteger status;

    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updateDate;

    @CreatedBy
    @Column(name="created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name="last_updated_by")
    private String lastUpdatedBy;
}