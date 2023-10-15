package app;

import app.data.ContactRepository;
import app.data.ContactRepositoryImpl;
import app.service.ContactService;
import app.service.ContactServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContactConfig {
    @Bean
    public ContactRepository contactRepository(){
        return new ContactRepositoryImpl();
    }
    @Bean
    public ContactService contactService(){
        return new ContactServiceImpl(contactRepository());
    }
}
