package ee.spring.materials;

import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StringController {

    @GetMapping("hello-world")
    public String helloWorld(){
        return "Hello, world!";
    }

    @GetMapping("hello-variable/{nimi}")
    public String helloVariable(@PathVariable String nimi) {
        return "Hello " + nimi + " 33!";
    }

    @GetMapping("multiply/{nr1}/{nr2}")
    public Integer multiply(@PathVariable Integer nr1, @PathVariable Integer nr2) {
        return nr1 * nr2;
    }

    @GetMapping("do-logs/{arv}")
    public void doLogs(@PathVariable Integer arv){
        for (int i = 0; i < arv; i++) {
            System.out.println("see on logi nr " + i);
        }
    }

    @GetMapping("random/{int1}/{int2}")
    public int random(@PathVariable int int1, @PathVariable int int2) {
        return (int) ((Math.random() * int2 - int1 +int1));
    }


}
