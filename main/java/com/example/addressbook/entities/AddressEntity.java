package com.example.addressbook.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address_book_table")
@Data
public class AddressEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
        private Long id;
        private String name;
        private String phone;
        private String email;
        private String address;

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        @Override
        public String toString() {
                return "AddressEntity{" +
                        "address='" + address + '\'' +
                        ", id=" + id +
                        ", name='" + name + '\'' +
                        ", phone='" + phone + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
