package mk.ukim.finki.wpaud.bootstrap;

import lombok.Data;
import mk.ukim.finki.wpaud.model.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();


//    @PostConstruct
//    public void init () {
//        categories.add(new Category("Software", "Software Category"));
//        categories.add(new Category("Hardware", "Hardware Category"));
//
//        users.add(new User("kostadin.mishev","km","Kostadin","Mishev"));
//        users.add(new User("riste.stojanov","rs","Riste","Stojanov"));
//        users.add(new User("hana.hasanicaj","hh","Hana","Hasanicaj"));
//
//        Category category = new Category("Accessories", "Accessories category");
//        categories.add(category);
//
//        Manufacturer manufacturer = new Manufacturer("AMD", "NY NY");
//        manufacturers.add(manufacturer);
//        manufacturers.add(new Manufacturer("Android", "LA LA"));
//
//        products.add(new Product("Tablet", 350.0, 3, category, manufacturer));
//        products.add(new Product("Processor", 500.0, 3, category, manufacturer));
//
//
//    }
}
