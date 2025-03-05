package com.example.addressbook.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address_book_table")
@Data
public class AddressEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String phone;
        private String email;
        private String address;
}
