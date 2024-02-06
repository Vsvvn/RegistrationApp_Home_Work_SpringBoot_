package app.registration.services;

import app.registration.dto.User;
import app.registration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RegistrationService {

    private final UserRepository userRepository;
    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Метод добавления пользователя
    @Transactional
    public void register(User user) {
        userRepository.save(user);
    }

    //метод получения всех пользователей
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
