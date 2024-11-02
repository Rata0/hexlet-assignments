package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> findById(Long id) {
        return userRepository.findById(Math.toIntExact(id));
    }

    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> update(User data, Long id) {
        return userRepository.findById(Math.toIntExact(id))
                .map(existingUser -> {
                    existingUser.setFirstName(data.getFirstName());
                    existingUser.setLastName(data.getLastName());
                    existingUser.setEmail(data.getEmail());
                    return existingUser;
                })
                .flatMap(userRepository::save);
    }


    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(Math.toIntExact(id));
    }
    // END
}
