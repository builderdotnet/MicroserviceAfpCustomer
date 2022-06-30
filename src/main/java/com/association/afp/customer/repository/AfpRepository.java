package com.association.afp.customer.repository;

import com.association.afp.customer.domain.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfpRepository extends JpaRepository<Afp, Integer> {
}