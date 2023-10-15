package app.data;

import app.Contact;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ContactRepositoryImpl implements ContactRepository {
    List<Contact> tmp = new ArrayList<>();

    public ContactRepositoryImpl(){
    }
    @Override
    public List<Contact> findAll() {
        return tmp;
    }

    @Override
    public void save(Contact contact) {
        tmp.add(contact);
    }

    @Override
    public void clear() {
        tmp = new ArrayList<>();
    }
}
