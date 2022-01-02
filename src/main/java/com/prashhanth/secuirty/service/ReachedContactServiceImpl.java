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
        return null;
    }

    @Override
    public List<ReachedContact> getAllReachedContacts() {
        return null;
    }

    @Override
    public Optional<ReachedContact> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<ReachedContact> updateById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }
}
