package com.prashhanth.secuirty.repo.transactions;

import com.prashhanth.secuirty.entity.bank.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepo extends JpaRepository<UserAccount,String> {
}
