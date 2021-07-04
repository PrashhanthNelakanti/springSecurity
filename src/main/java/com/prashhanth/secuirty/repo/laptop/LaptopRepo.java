package com.prashhanth.secuirty.repo.laptop;

import com.prashhanth.secuirty.entity.relation.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop,Integer> {

}
