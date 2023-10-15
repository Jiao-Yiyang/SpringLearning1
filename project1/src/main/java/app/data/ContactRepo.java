package app.data;

import app.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepo
        extends CrudRepository<Contact, String> {
}
