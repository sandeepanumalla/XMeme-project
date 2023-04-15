package com.crio.starter.validations;

import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ExistsByUsernameAndCaptionAndUrlHandler")
public class ExistsByUsernameAndCaptionAndUrlHandler extends CustomHandler{

    @Autowired
    MemeRepository memeRepository;

    @Override
    public void handle(Meme object) throws UserDoesNotExistsException, NullFieldsException, DuplicateMemeException {
        if(memeRepository.existsByUsernameAndCaptionAndUrl(object.getUsername(), object.getCaption(), object.getUrl())) {
            throw new DuplicateMemeException("You are trying to create duplicate meme");
        }
        if(nextHandler != null) {
            nextHandler.handle(object);
        }
    }
}
