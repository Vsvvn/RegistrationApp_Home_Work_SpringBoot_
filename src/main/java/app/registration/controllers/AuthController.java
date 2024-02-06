package app.registration.controllers;

import app.registration.dto.User;
import app.registration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    @Autowired
    public AuthController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    //    Контроллер для страницы логина
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    //    Контроллер для страницы регистрации
    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "auth/registration";
    }

    //    Контроллер для страницы регистрации пользователя регистрации возвращает на страницу логина
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user) {
        registrationService.register(user);

        return "redirect:/auth/login";
    }

    //    Контроллер для получения всех пользователей
    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", registrationService.getAll());
        return "auth/registration";
    }
}
