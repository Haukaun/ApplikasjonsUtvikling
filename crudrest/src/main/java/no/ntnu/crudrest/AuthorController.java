package no.ntnu.crudrest;

import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;


/**
 * Restcontroller for book collection.
 */
@RestController
public class AuthorController {
    private List<Author> authors;

    public AuthorController(){
        initializeData();
    }

    private void initializeData() {
        authors = new LinkedList<>();
        authors.add(new Author(1, "Håkon", "Sætre", 1999));
        authors.add(new Author(2, "Petter", "Molnes", 2000));
        authors.add(new Author(3, "Mati", "Pitecheta", 2000));
    }

}
