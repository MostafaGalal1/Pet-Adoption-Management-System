package com.adoptapet.adoptapet.Repositories;

import com.adoptapet.adoptapet.Entities.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends JpaRepository<Shelter, Integer> {

    Shelter getShelterByLocation(String location);

    Shelter getShelterByLocationAndId(String location, int id);
}