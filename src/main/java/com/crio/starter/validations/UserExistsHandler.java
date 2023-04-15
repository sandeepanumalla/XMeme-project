package com.crio.starter.validations;

import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import com.crio.starter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("UserExistsHandler")
public class UserExistsHandler extends CustomHandler{

    private final UserRepository userRepository;

    @Autowired
    public UserExistsHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void handle(Meme object) throws UserDoesNotExistsException, NullFieldsException, DuplicateMemeException {
        if(object == null) {
            throw new NullFieldsException("please fill all details");
        }
        if(!userRepository.existsByUsername(object.getUsername())) {
            throw new UserDoesNotExistsException("User does not exists");
        }
        if(nextHandler != null) {
            nextHandler.handle(object);
        }
    }
}
