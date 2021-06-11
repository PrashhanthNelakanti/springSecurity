package com.prashhanth.secuirty.repo.moto;

import com.prashhanth.secuirty.entity.moto.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepo extends JpaRepository<Motor,Integer> {
}
