package cap.wesantos.jali.rest.controller;

import cap.wesantos.jali.rest.controller.dto.AuthRequestTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthRequestTO login(@RequestBody AuthRequestTO authRequest) {
        return null;
    }
}
