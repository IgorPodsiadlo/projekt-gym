package pl.edu.pjatk.gym_management_system.springSecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "This is Home Page";
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/admin")
    public String admin(){
        return "This is Admin Page";
    }
}
