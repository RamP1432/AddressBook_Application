package com.example.addressbook.repositories;

import com.example.addressbook.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressEntity,Long> {

}
