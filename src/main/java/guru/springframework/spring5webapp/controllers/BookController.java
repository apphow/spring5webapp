package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// signals to use this as an MVC Controller
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}


    /*
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //give a path to the specific URL with @RequestMapping
    //@RequestMapping("/books")
    // grabs the books and returns the model object to the view
    // view will get a copy of the model
    @RequestMapping("/books")
    public String getBooks(Model model) {
    // we want to enhance the model with a list of books
        // by injecting a book repository above (private final BookRepository bookRepository
        // then add constructor so when spring initiates it, it'll inject an instance of the bookRepository
        // into this controller

        // grab model and add

        model.addAttribute("books", bookRepository.findAll());

        return "Books";
    }
}

     */
