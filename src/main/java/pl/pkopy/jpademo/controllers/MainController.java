package pl.pkopy.jpademo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pkopy.jpademo.models.BarcodeEntity;
import pl.pkopy.jpademo.models.BookEntity;
import pl.pkopy.jpademo.models.CustomerEntity;
import pl.pkopy.jpademo.models.forms.BarcodeForm;
import pl.pkopy.jpademo.models.repositories.BarcodeRepository;
import pl.pkopy.jpademo.models.repositories.BookRepository;
import pl.pkopy.jpademo.models.repositories.CustomerRepository;
import pl.pkopy.jpademo.models.services.BasketService;

import java.lang.instrument.IllegalClassFormatException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    BarcodeRepository barcodeRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BasketService basketService;

    @GetMapping("/")

    public String index(Model model){





            model.addAttribute("barcodeForm", new BarcodeForm());
//            model.addAttribute("allBarcodes", barcodeRepository.findAllByBarcodeContainsAndBarcodeContainsAndWeightGreaterThan("%1%","%2%", 9));
//            model.addAttribute("allBarcodes", barcodeRepository.findAllByWeightLessThanAndWeightGreaterThan(21,14));
            return "addBarcode";


//        BarcodeEntity barcodeEntity = new BarcodeEntity();
//        barcodeEntity.setProductCompany("Fivarto");
//        barcodeEntity.setProductName("baza danych");
//        barcodeEntity.setBarcode("1231231231239");
//        barcodeEntity.setWeight(10);
//
//        barcodeRepository.save(barcodeEntity);

//        BookEntity bookEntity = new BookEntity();
//        bookEntity.setId(2);
//        bookEntity.setAuthor("Papcio Chmiel XXX");
//        bookEntity.setTitle("Tytus, Romek i Atomek");
//        bookEntity.setPages(150);
//
//        bookRepository.save(bookEntity);

//        CustomerEntity customerEntity = new CustomerEntity();
//        customerEntity.setName("Tadek");
//        customerEntity.setLastName("Rydzyk");
//
//        customerRepository.save(customerEntity);


//        return "Poszło zapytanie";
    }

    @PostMapping("/")

    public String index(@ModelAttribute BarcodeForm barcodeForm){
        BarcodeEntity barcodeEntity = new BarcodeEntity(barcodeForm);

        barcodeRepository.save(barcodeEntity);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(Model model){
        model.addAttribute("barcodeForm", new BarcodeForm());

        return "search";
    }

    @PostMapping("/search")
    public String search(@RequestParam("search") String search, Model model){
        List<BarcodeEntity> barcodeEntities = new ArrayList<>();
        barcodeEntities.addAll(barcodeRepository.findAllByProductNameContains(search));
        barcodeEntities.addAll(barcodeRepository.findAllByProductCompanyContains(search));

        model.addAttribute("barcodeForm", new BarcodeForm());
        model.addAttribute("allBarcodes", barcodeEntities);
        return "addBarcode";


    }

    @GetMapping("/add/{id}")

    public String add(@PathVariable("id") int id){

        basketService.addProductToBasket(barcodeRepository.findById(id).orElseThrow(IllegalStateException::new));
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")

    public String remove(@PathVariable("id") int id){

        basketService.removeProductFromBasket(barcodeRepository.findById(id).orElseThrow(IllegalStateException::new));
        return "redirect:/";
    }

    @GetMapping("/basket")
    @ResponseBody
    public String basket(){


        String result = Integer.toString(basketService.basketLength());



        return result;
    }


}
