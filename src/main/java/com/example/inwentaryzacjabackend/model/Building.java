package com.example.inwentaryzacjabackend.model;

import javax.persistence.*;


@Entity
@Table(name="buildings")
public class Building {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="building_id")
    private Long buildingId;

    @Column(name="building_name")
    private String buildingName;

    @Column(name="building_nbr")
    private String buildingNbr;

    public Building() {

    }

    public Long getId() { return buildingId; }

    public void setId(Long id) {
        this.buildingId = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String name) {
        this.buildingName = buildingName;
    }

    public String getBuildingNbr() {
        return buildingNbr;
    }

    public void setBuildingNbr(String buildingNbr) {
        this.buildingNbr = buildingNbr;
    }
    
    @Override
    public String toString() {
        return "Building [building_id=" + buildingId + ", buildingName=" + buildingName+"]";
    }

}

