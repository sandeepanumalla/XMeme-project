package com.crio.starter.validations;

import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import org.springframework.stereotype.Component;

@Component
public class ParentMemeCheckHandler extends  CustomHandler{

    @Override
    public void handle(Meme object) throws UserDoesNotExistsException, NullFieldsException, DuplicateMemeException {

    }
}
