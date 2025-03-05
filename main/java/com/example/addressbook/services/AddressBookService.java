package com.example.addressbook.services;
import java.util.List;
import java.util.Optional;

import com.example.addressbook.entities.AddressEntity;
import com.example.addressbook.entities.AddressEntityDTO;
import com.example.addressbook.repositories.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {
        @Autowired
        private AddressBookRepository repository;

        public List<AddressEntity> getAllContacts() {
            return repository.findAll();
        }

    public Optional<AddressEntity> getContactById(Long id) {
        return repository.findById(id);
    }

        public AddressEntity saveContact(AddressEntityDTO contactDTO) {
            AddressEntity contact = new AddressEntity();
            contact.setName(contactDTO.getName());
            contact.setPhone(contactDTO.getPhone());
            contact.setEmail(contactDTO.getEmail());
            contact.setAddress(contactDTO.getAddress());
            return repository.save(contact);
        }

        public boolean deleteContact(Long id) {
            if(repository.findById(id).isPresent()){
               repository.deleteById(id);
               return true;}
            return false;
        }

    public void deleteAllContacts() {
        repository.deleteAll();
    }
    public AddressEntity updateContact(Long id, AddressEntityDTO updatedContact) {
        return repository.findById(id).map(contact -> {
            contact.setName(updatedContact.getName());
            contact.setPhone(updatedContact.getPhone());
            contact.setEmail(updatedContact.getEmail());
            contact.setAddress(updatedContact.getAddress());
            return repository.save(contact);
        }).orElse(null);
    }
}