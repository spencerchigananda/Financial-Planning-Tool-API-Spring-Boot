package com.spencerchigananda.financialplanningtool.dao;

import com.spencerchigananda.financialplanningtool.models.InstitutionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitutionTypeRepository extends JpaRepository<InstitutionType, Integer> {
}
