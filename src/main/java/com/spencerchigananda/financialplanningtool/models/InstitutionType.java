package com.spencerchigananda.financialplanningtool.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "institution_type", schema = "financial_planning_tool", catalog = "")
public class InstitutionType {
    private Long id;
    private String type;
    private BigDecimal costPerYear;
    private Timestamp dateCreated;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "cost_per_year")
    public BigDecimal getCostPerYear() {
        return costPerYear;
    }

    public void setCostPerYear(BigDecimal costPerYear) {
        this.costPerYear = costPerYear;
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
        InstitutionType that = (InstitutionType) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(costPerYear, that.costPerYear) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, costPerYear, dateCreated);
    }
}
