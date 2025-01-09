package ee.spring.materials;

import ee.spring.materials.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

@RestController
public class ProductListController {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Cola", 1, 0.06, true),
            new Product("Cola", 2, 0.07, true),
            new Product("Cola", 3, 0.08, true),
            new Product("Cola", 4, 0.09, true),
            new Product("Cola", 5, 0.1, true)
    ));

    @GetMapping("products")
    public List<Product> getAllproducts() {
        return products;
    }

    @GetMapping("remove-product/{index}")
    public List<Product> removeProduct(@PathVariable int index) {
        products.remove(index);
        return products;
    }

    @GetMapping("add-product/{id}/{name}/{price}/{active}")
    public List<Product> addProduct(
            @PathVariable int id,
            @PathVariable String name,
            @PathVariable double price,
            @PathVariable boolean active
    ){
        products.add(new Product(name, id, price, active));
        return products;
    }
    @GetMapping("most-expensive")
    public Product getMostExpensiveProduct() {
        // Предполагается, что список не пуст
        Product mostExpensive = products.get(0);
        for (Product product : products) {
            if (product.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }
}
