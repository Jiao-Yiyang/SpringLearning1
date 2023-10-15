package app.web;

import app.Contact;
import app.data.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/home")
public class ContactController {

    private final ContactRepo contactRepo;

    @Autowired
    public ContactController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("contactlist", contactRepo.findAll());
        return "home";
    }
    @PostMapping
    public String submitForm(@ModelAttribute("contact") @Valid Contact contact,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("contactlist",contactRepo.findAll());
            return "home";
        }

        contactRepo.save(contact);
        model.addAttribute("contact", new Contact());
        model.addAttribute("contactlist",contactRepo.findAll());
        return "home";
    }

}
