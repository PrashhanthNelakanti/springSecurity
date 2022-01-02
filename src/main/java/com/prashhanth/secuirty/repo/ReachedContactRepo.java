package com.prashhanth.secuirty.repo;

import com.prashhanth.secuirty.entity.ReachedContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReachedContactRepo extends JpaRepository<ReachedContact,Long> {

}
