package com.prashhanth.secuirty.repo.roles;

import com.prashhanth.secuirty.entity.roles.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    Optional<Roles> findByRoleName(String name);
}
