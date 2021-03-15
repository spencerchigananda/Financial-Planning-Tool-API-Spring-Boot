package com.spencerchigananda.financialplanningtool.services;

import com.spencerchigananda.financialplanningtool.dao.CountryRepository;
import com.spencerchigananda.financialplanningtool.dao.InflationRateRepository;
import com.spencerchigananda.financialplanningtool.dao.InstitutionTypeRepository;
import com.spencerchigananda.financialplanningtool.dto.InputDto;
import com.spencerchigananda.financialplanningtool.dto.OutputDto;
import com.spencerchigananda.financialplanningtool.models.Country;
import com.spencerchigananda.financialplanningtool.models.InflationRate;
import com.spencerchigananda.financialplanningtool.models.InstitutionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class FinancialCalculationsServiceImpl implements FinancialCalculationsService{

    private final CountryRepository countryRepository;
    private final InflationRateRepository inflationRateRepository;
    private final InstitutionTypeRepository institutionTypeRepository;

    @Autowired
    public FinancialCalculationsServiceImpl(CountryRepository countryRepository, InflationRateRepository inflationRateRepository, InstitutionTypeRepository institutionTypeRepository) {
        this.countryRepository = countryRepository;
        this.inflationRateRepository = inflationRateRepository;
        this.institutionTypeRepository = institutionTypeRepository;
    }


    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        if (countries.isEmpty()){
            throw new EntityNotFoundException("Countries not found");
        }
        return countries;
    }

    @Override
    public Country findCountryById(Integer id) {
        Optional<Country> country = countryRepository.findById(id);
        if (!country.isPresent()){
            throw new EntityNotFoundException("Country not found");
        }
        return country.get();
    }


    @Override
    public List<InflationRate> getAllInflationRates() {
        List<InflationRate> inflationRates = inflationRateRepository.findAll();
        if (inflationRates.isEmpty()){
            throw new EntityNotFoundException("Inflation rates not found.");
        }
        return inflationRates;
    }

    @Override
    public List<InstitutionType> getAllInstitutionTypes() {
        List<InstitutionType> institutionTypes = institutionTypeRepository.findAll();
        if (institutionTypes.isEmpty()){
            throw new EntityNotFoundException("Institution types not found.");
        }
        return institutionTypes;
    }

    @Override
    public InflationRate findInflationRateByCountry(Country country) {
        InflationRate inflationRate = inflationRateRepository.findByCountry(country);
        if (inflationRate == null){
            throw new EntityNotFoundException("Inflation rate for country "
                    .concat(country.getName())
                    .concat(" not found."));
        }
        return inflationRate;
    }

    @Override
    public OutputDto calculateFinancialPlan(InputDto inputDto) {
        return null;
    }
}
