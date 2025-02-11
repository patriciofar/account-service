package com.aplication.account_service.repository;

import com.aplication.account_service.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, UUID> {
}
