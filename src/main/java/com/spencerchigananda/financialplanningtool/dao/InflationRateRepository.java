package com.spencerchigananda.financialplanningtool.dao;

import com.spencerchigananda.financialplanningtool.models.Country;
import com.spencerchigananda.financialplanningtool.models.InflationRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InflationRateRepository extends JpaRepository<InflationRate, Integer> {
    InflationRate findByCountry(Country country);
}
