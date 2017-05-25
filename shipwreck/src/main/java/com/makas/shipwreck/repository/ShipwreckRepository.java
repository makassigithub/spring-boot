package com.makas.shipwreck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.makas.shipwreck.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long>{

}
