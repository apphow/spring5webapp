package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//annotate as a controller so to tell Spring that this is a Spring
//component. Because it's a Spring component we've given it a
//constructor for the AuthorRepository. Spring uses dependency injection
//to inject an instance of the author repository that has the CRUD operations.
// then we add a user request mapping to the map request/url (or path)
// of the authors. For that, we're asking Spring MVC to inject in an instance
// of the model when it's called. We're taking that model and adding an
// attribute of it called authors. We're getting an iterable from
//the author repository which will give everything in the database,
// and returning back the view (the identifier for the view,
// which is "authors/list", and by default, SpringBoot is
// configuring  thymeleaf to look at the templates directory.
// In the template's directory, it looks under the path of authors,
// and for the view called "list".
//then we added in the list.html to display the author's
//ID, firstName and lastName.
@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}