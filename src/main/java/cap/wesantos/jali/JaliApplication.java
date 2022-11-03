package cap.wesantos.jali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JaliApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaliApplication.class, args);
    }

}
