package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecord;
import com.adoptapet.adoptapet.Entities.AdoptionRecord.AdoptionRecordId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRecordRepository extends JpaRepository<AdoptionRecord, AdoptionRecordId> {
}