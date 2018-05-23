package pl.pkopy.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.pkopy.jpademo.models.BookEntity;
import pl.pkopy.jpademo.models.forms.BookForm;
import pl.pkopy.jpademo.models.repositories.BookRepository;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/book")

    public String book(Model model) {
        model.addAttribute("bookForm",new BookForm());
        return "book";
    }

    @PostMapping("/book")

    public String postBook(@ModelAttribute BookForm bookForm,
                            Model model) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setAuthor(bookForm.getAuthor());
        bookEntity.setTitle(bookForm.getTitle());
        bookEntity.setPages(bookForm.getPages());

        bookRepository.save(bookEntity);


//        StringBuilder result = new StringBuilder();
//        for(BookEntity book : bookEntity1){
//            result.append("<b>" + book.getAuthor() + "</b>\n" );
//        }

        Iterable<BookEntity> bookEntity1 = bookRepository.findAll();
        model.addAttribute("bookAuthor",bookEntity1);


        return "book";

    }
}