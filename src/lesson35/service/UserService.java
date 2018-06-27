package lesson35.service;

import lesson35.model.User;
import lesson35.repository.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser (User user){
        //check business logic

        //if logic ok
        return userRepository.registerUser(user);
    }
}
