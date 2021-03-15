package com.spencerchigananda.financialplanningtool.services;

import com.spencerchigananda.financialplanningtool.dto.InputDto;
import com.spencerchigananda.financialplanningtool.dto.OutputDto;
import com.spencerchigananda.financialplanningtool.models.Country;
import com.spencerchigananda.financialplanningtool.models.InflationRate;
import com.spencerchigananda.financialplanningtool.models.InstitutionType;

import java.util.List;

public interface FinancialCalculationsService {
    List<Country> getAllCountries();
    Country findCountryById(Integer id);
    List<InflationRate> getAllInflationRates();
    List<InstitutionType> getAllInstitutionTypes();
    InflationRate findInflationRateByCountry(Country country);
    OutputDto calculateFinancialPlan(InputDto inputDto);
}
