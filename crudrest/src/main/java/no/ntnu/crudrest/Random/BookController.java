package no.ntnu.crudrest.Random;

import no.ntnu.crudrest.Random.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Restcontroller for book collection.
 */
@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController(){
        initializeData();
    }

    /**
     * Initialize dummy book data for the collection
     */
    private void initializeData() {
        books = new LinkedList<>();
        books.add(new Book(1, "Computer Networks", 2016, 800));
        books.add(new Book(2, "12 Rules for Life", 2019, 1200));
    }



    @GetMapping
    public List<Book> getAll(){
        return books;
    }

    @GetMapping("/count")
    public int getCountOfBooks(){
        return books.size();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getOne(@PathVariable int id){
        ResponseEntity<Book> response;
        Book book = findBookById(id);
        if(book != null){
            response = new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Book book){
        ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (book != null && book.isValid()) {
            Book existingBook = findBookById(book.getId());
            if (existingBook == null) {
                books.add(book);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        ResponseEntity<String> response;
        Book book = findBookById(id);
        if(book != null){
            books.remove(book);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Book book){
        ResponseEntity<String> response;
        String errormessage = null;
        Book existingBook = findBookById(id);

        if(existingBook == null) {
            errormessage = "No book with id "+ id + " found";
        }

        if (book == null || !book.isValid()){
            errormessage = "Wrong data in request body";
        } else if(book.getId() != id){
            errormessage = "Book id in the URL does not match the id in JSON data (response body)";
        }

        if (errormessage == null){
            books.remove(existingBook);
            books.add(book);
            response = new ResponseEntity<>(HttpStatus.OK);
        } else {
            response = new ResponseEntity<>(errormessage,HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    private Book findBookById(int id){
        Book book = null;
        Iterator<Book> it = books.iterator();
        while (it.hasNext() && book == null){
            Book b = it.next();
            if(b.getId() == id){
                book = b;
            }
        }
        return book;
    }




}
