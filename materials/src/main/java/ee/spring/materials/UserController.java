package ee.spring.materials;

import ee.spring.materials.models.Product;
import ee.spring.materials.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    User user = new User("Max", 1488,"ChatGPT", true);

    @GetMapping("user")
    public User getUser() {
        return user;
    }
}
