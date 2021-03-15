package com.spencerchigananda.financialplanningtool.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Country {
    private Integer id;
    private String name;
    private String isoCode;
    private Timestamp dateCreated;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "iso_code")
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @Basic
    @Column(name = "date_created")
    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(isoCode, country.isoCode) && Objects.equals(dateCreated, country.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isoCode, dateCreated);
    }
}
