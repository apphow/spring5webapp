package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());


        Author eric= new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher xyz = new Publisher();
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "45454545");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        Author rylee = new Author("Rylee", "Howard");
        Book cats = new Book("Cats Play", "12345678");
        rylee.getBooks().add(cats);
        cats.getAuthors().add(rylee);

        cats.setPublisher(publisher);
        publisher.getBooks().add(cats);

        authorRepository.save(rylee);
        bookRepository.save(cats);
        publisherRepository.save(publisher);

        Author parker = new Author("Parker", "Howard");
        Book cs = new Book("CS150", "12344444");
        parker.getBooks().add(cs);
        cats.getAuthors().add(parker);

        cats.setPublisher(publisher);
        publisher.getBooks().add(cs);

        authorRepository.save(parker);
        bookRepository.save(cs);
        publisherRepository.save(publisher);

        Author cameron = new Author("Cameron", "Howard");
        Book riches = new Book("Managing Wealth", "48484848");
        cameron.getBooks().add(riches);
        riches.getAuthors().add(cameron);

        riches.setPublisher(publisher);
        publisher.getBooks().add(riches);

        authorRepository.save(cameron);
        bookRepository.save(riches);
        publisherRepository.save(publisher);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}