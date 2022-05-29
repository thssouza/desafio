package com.atech.desafio.voos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atech.desafio.voos.model.Pilot;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, Long> {

}
