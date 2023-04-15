package com.crio.starter.validations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import org.springframework.stereotype.Component;

import com.crio.starter.data.Meme;

@Component("NullAttributesChecker")
public class NullAttributesChecker extends CustomHandler{

    @Override
    public void handle(Meme object) throws NullFieldsException, UserDoesNotExistsException, DuplicateMemeException {
        Field[] fields = null;
        try {
            fields = object.getClass().getDeclaredFields();
            for(Field attributeField: fields) {
                attributeField.setAccessible(true);
                if(attributeField.getName().equals("id")) continue;
                if(attributeField.get(object) == null 
                   || attributeField.get(object).toString().trim().isEmpty()){
                    throw new NullFieldsException("please fill all details");
                }
            }
            Arrays h;
        } catch(IllegalAccessException e) {
            System.out.println("illegal access exception!!");
        }
        if (nextHandler != null){
            nextHandler.handle(object);
        }
    }
}
