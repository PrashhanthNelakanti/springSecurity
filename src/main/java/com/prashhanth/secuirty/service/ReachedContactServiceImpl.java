package com.prashhanth.secuirty.service;


import com.prashhanth.secuirty.entity.ReachedContact;
import com.prashhanth.secuirty.repo.ReachedContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReachedContactServiceImpl implements ReachedContactService {

    @Autowired
    ReachedContactRepo reachedContactRepo;

    @Override
    public ReachedContact addReachedContact(ReachedContact contact) {
        return reachedContactRepo.save(contact);
    }

    @Override
    public List<ReachedContact> getAllReachedContacts() {
        return reachedContactRepo.findAll();
    }

    @Override
    public Optional<ReachedContact> getById(Long id) {
        return reachedContactRepo.findById(id);
    }

    @Override
    public Optional<ReachedContact> updateById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        reachedContactRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        reachedContactRepo.deleteAll();
    }
}
