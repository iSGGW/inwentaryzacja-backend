package com.example.inwentaryzacjabackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

// TO DO complete model
// Excel generator

import javax.persistence.*;
import java.sql.Date;

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
    @JoinColumn(name = "room_id", insertable = false)
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

    @Column(name="status")
    private String status;

    @CreationTimestamp
    @Column(name="created_at")
    private Date creationDate;

    @UpdateTimestamp
    @Column(name="updated_at")
    private Date updateDate;

    @CreatedBy
    @Column(name="created_by")
    private String createdBy;

    @LastModifiedBy
    @Column(name="last_updated_by")
    private String lastUpdatedBy;
}