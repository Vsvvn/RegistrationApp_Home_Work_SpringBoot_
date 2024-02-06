package app.registration.services;

import app.registration.dto.User;
import app.registration.repositories.UserRepository;
import app.registration.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //метод для поиска пользователя по имени, если найден то возвратить иначе выбросить исключение "User not found!"
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(s);

        if (user.isEmpty())
            throw new UsernameNotFoundException("User not found!");

        return new UserDetails(user.get());
    }
}
