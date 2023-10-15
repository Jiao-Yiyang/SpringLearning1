package app.service;

import app.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAll();

    void add(Contact contact);
}
