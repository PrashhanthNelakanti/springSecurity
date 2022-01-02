package com.prashhanth.secuirty.service;


import com.prashhanth.secuirty.entity.ReachedContact;

import java.util.List;
import java.util.Optional;

public interface ReachedContactService {
    public ReachedContact addReachedContact(ReachedContact contact);
    public List<ReachedContact> getAllReachedContacts();
    public Optional<ReachedContact> getById(Long id);
    public Optional<ReachedContact> updateById(Long id);
    public void deleteById(Long id);
    public void deleteAll();
}
