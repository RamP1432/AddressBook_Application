package com.example.addressbook.services;
import java.util.List;
import com.example.addressbook.entities.AddressEntity;
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

        public AddressEntity saveContact(AddressEntity contact) {
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
}