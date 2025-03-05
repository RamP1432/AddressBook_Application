package com.example.addressbook.controllers;
import java.util.List;
import java.util.Optional;

import com.example.addressbook.entities.AddressEntity;
import com.example.addressbook.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/contacts")
public class AddressBookController {
        @Autowired
        private AddressBookService service;

        @GetMapping("/getAll")
        public List<AddressEntity> getAllContacts() {
            return service.getAllContacts();
        }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AddressEntity>> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getContactById(id));
    }

        @PostMapping("/save")
        public AddressEntity addContact(@RequestBody AddressEntity contact) {
            System.out.println(contact.toString());
            return service.saveContact(contact);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteContact(@PathVariable Long id) {
            boolean flag = service.deleteContact(id);
            if (flag) {
                return ResponseEntity.ok("Contact deleted successfully");
            }
            return (ResponseEntity<String>) ResponseEntity.notFound();
        }
    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllContacts() {
        service.deleteAllContacts();
        return ResponseEntity.ok("All contacts deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressEntity> updateContact(@PathVariable Long id, @RequestBody AddressEntity updatedContact) {
        return ResponseEntity.ok(service.updateContact(id, updatedContact));
    }
}
