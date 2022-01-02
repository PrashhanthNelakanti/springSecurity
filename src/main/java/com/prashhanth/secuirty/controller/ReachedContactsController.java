package com.prashhanth.secuirty.controller;


import com.prashhanth.secuirty.entity.ReachedContact;
import com.prashhanth.secuirty.service.ReachedContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*",allowedHeaders="*")
@RestController
@RequestMapping("/profile")
public class ReachedContactsController {

    @Autowired
    ReachedContactService service;

    @PostMapping("/add/contact")
    public ReachedContact createUser(@RequestBody ReachedContact contact){
        return service.addReachedContact(contact);
    }

    @GetMapping("/get/contactId/{id}")
    public Optional<ReachedContact> findOneApi(@RequestParam("id") Long contactId){
        return service.getById(contactId);
    }

    @GetMapping("/all/contacts")
    public List<ReachedContact> findAll(){
        return service.getAllReachedContacts();
    }

    @PutMapping("/{id}")
    public Optional<ReachedContact> updateById(@PathVariable("id") Long id, @RequestBody ReachedContact contact  ){
        Optional<ReachedContact> contactUpdate = service.getById(id);
        contactUpdate.get().setContactName(contact.getContactName());
        contactUpdate.get().setDescrption(contact.getDescrption());
        contactUpdate.get().setOrg(contact.getOrg());
        contactUpdate.get().setStatus(contact.getStatus());
        return Optional.ofNullable(service.addReachedContact(contactUpdate.get()));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        service.deleteById(id);
    }

    //@DeleteMapping("/deleteAll")
    public void deleteAll(){
        service.deleteAll();
    }


}
