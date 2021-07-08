package com.prashhanth.secuirty.repo.laptop;

import com.prashhanth.secuirty.entity.relation.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Integer> {
}
