package com.spencerchigananda.financialplanningtool.api;

import com.spencerchigananda.financialplanningtool.dto.InputDto;
import com.spencerchigananda.financialplanningtool.models.Country;
import com.spencerchigananda.financialplanningtool.models.api.ApiResponse;
import com.spencerchigananda.financialplanningtool.services.FinancialCalculationsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/api/v1/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
public class FinancialCalculationsController {

    private final FinancialCalculationsService financialCalculationsService;

    @Autowired
    public FinancialCalculationsController(FinancialCalculationsService financialCalculationsService) {
        this.financialCalculationsService = financialCalculationsService;
    }

    @GetMapping("/countries")
    public ApiResponse getAllCountries(){
        return new ApiResponse(200, "SUCCESS", financialCalculationsService.getAllCountries());
    }

    @GetMapping("/inflation-rate/{country-id}")
    public ApiResponse getInflationRateByCountry(@PathVariable("country-id") Integer countryId){
        Country country = financialCalculationsService.findCountryById(countryId);
        return new ApiResponse(200, "SUCCESS",
                financialCalculationsService.findInflationRateByCountry(country));
    }

    @GetMapping("/institution-types")
    public ApiResponse getAllInstitutionTypes(){
        return new ApiResponse(200, "SUCCESS", financialCalculationsService.getAllInstitutionTypes());
    }

    @PostMapping("/process-plan")
    public ApiResponse calculateFinancialPlan(@RequestBody InputDto inputDto){
        return new ApiResponse(201, "SUCCESS", financialCalculationsService.calculateFinancialPlan(inputDto));
    }
}
