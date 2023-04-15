package com.crio.starter.validations;

import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import org.springframework.stereotype.Component;

import com.crio.starter.data.Meme;

@Component("NullObjectChecker")
public class NullObjectChecker extends CustomHandler{

    @Override
    public void handle(Meme object) throws NullFieldsException, UserDoesNotExistsException, DuplicateMemeException {
        if (object == null){
            throw new NullFieldsException("please fill all details");
        }
        if (nextHandler != null)
             nextHandler.handle(object);
    }
}