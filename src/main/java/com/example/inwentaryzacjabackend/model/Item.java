package com.example.inwentaryzacjabackend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

// TO DO complete model
// Excel generator

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 *Klasa Item służy do przechowywania informacji o skanowanych przemiotach
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class    Item {
    /**
     *id - zmienna typu Long służąca do przechowywania informacji o id skanowanego przedmiotu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
     *room - zmienna zawierająca informację o sali w której znajduje się skanowany przedmiot
     */
    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false)
    private Room room;
    /**
     *name - zmienna typu String zawierająca informację o nazwie skanowanego przedmiotu
     */
    @Column(name="name")
    private String name;

    // TO DO to establish if we want item characteristics
    /**
     *type - zmienna typu String zawierająca informację o typie skanowanego przedmiotu
     */
    @Column(name="type")
    private String type;
    /**
     *manufacturer - zmienna typu String zawierająca informację o producencie skanowanego przedmiotu
     */
    @Column(name="manufacturer")
    private String manufacturer;
    /**
     *serialNumber - zmienna typu String zawierająca informację o numerze seryjnym przedmiotu
     */
    @Column(name="serial_number")
    private String serialNumber;

    // 1 = na stanie
    // 2 = brak
    // 3 = do utylizacji
    // 4 = zutylizowane

    /**
     *status - zmienna typu String zawierająca informację o statusie skanowanego przedmiotu
     */
    @Column(name="status")
    private BigInteger status;

    /**
     *creationDate - zmienna typu String zawierająca informację o dacie wprowadzenia przedmiotu do bazy
     */
    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp creationDate;

    /**
     *updateDate - zmienna typu String zawierająca informację o dacie aktualizacjach informacji o przedmiocie
     */
    @UpdateTimestamp
    @Column(name="updated_at")
    private Timestamp updateDate;

    /**
     *createdBy - zmienna typu String zawierająca informację o tym kto wprowadził przedmiot do bazy
     */
    @CreatedBy
    @Column(name="created_by")
    private String createdBy;
    /**
     *lastUpdatedBy - zmienna typu String zawierająca informację o tym kto ostatni aktualizował informacje o przedmiocie
     */
    @LastModifiedBy
    @Column(name="last_updated_by")
    private String lastUpdatedBy;
}