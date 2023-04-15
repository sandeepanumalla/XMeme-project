package com.crio.starter.validations;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.crio.starter.data.Meme;

@Component
public class MemeResourceValidator extends CustomHandler{
    
    @Override
    public void handle(Meme object) {
        String Url = object.getUrl();
    }

}