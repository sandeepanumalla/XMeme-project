package com.crio.starter.validations;

import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;

public abstract class CustomHandler {
    protected CustomHandler nextHandler;
    public abstract void handle(Meme object) throws UserDoesNotExistsException, NullFieldsException, DuplicateMemeException;
    public void setHandler(CustomHandler handler){
        this.nextHandler = handler;
    }
}
