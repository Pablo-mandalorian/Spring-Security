package com.pablotelles.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pablotelles.springsecurity.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
