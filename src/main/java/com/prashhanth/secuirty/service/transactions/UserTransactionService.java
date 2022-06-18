package com.prashhanth.secuirty.service.transactions;

import com.prashhanth.secuirty.entity.bank.UserAccount;
import com.prashhanth.secuirty.entity.user.User;
import com.prashhanth.secuirty.repo.UserRepo;
import com.prashhanth.secuirty.repo.transactions.UserAccountRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class UserTransactionService {

    Logger logger = LoggerFactory.getLogger(UserTransactionService.class);

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserAccountRepo userAccountRepo;

    private float amt=1000;

    public String transactions(User user){
        userRepo.save(user);
        logger.info("User Saved Successfully"+user.getUserId());
        UserAccount userAccount = new UserAccount();
        if(amt>0)
            amt = amt-100;
        userAccount.setBalance(amt);
        userAccount.setUserId(user.getUserId());
        userAccount.setBank("SBI");
        userAccount.setIFCode("UTBI7000002");
        userAccount.setTOT(new Date());
        userAccountRepo.save(userAccount);
        logger.info("User Act Saved Successfully"+user.getUserId());
        return "All Tranctions are completed!!";
    }


}
