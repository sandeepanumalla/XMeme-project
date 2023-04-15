package com.crio.starter.service;

import java.util.*;
import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exceptions.UserDoesNotExistsException;
import com.crio.starter.exchange.MemeDto;
import com.crio.starter.repository.MemeRepository;
import com.crio.starter.validations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MemeService {

    private final MemeRepository memeRepository;
    private final CustomHandler nullObjectHandler;
    private final CustomHandler nullAttributeHandler;
    private final CustomHandler userExistsHandler;
    private final CustomHandler existsByUsernameAndCaptionAndUrlHandler;

    @Autowired
    MemeService(MemeRepository memeRepository,
                @Qualifier("NullAttributesChecker") CustomHandler isNullAttributeExists,
                @Qualifier("NullObjectChecker") CustomHandler nullObjectHandler,
                @Qualifier("UserExistsHandler") CustomHandler userExistsHandler,
                @Qualifier("ExistsByUsernameAndCaptionAndUrlHandler") CustomHandler existsByUsernameAndCaptionAndUrlHandler
                ) {

        this.memeRepository = memeRepository;
        this.nullAttributeHandler = isNullAttributeExists;
        this.nullObjectHandler = nullObjectHandler;
        this.userExistsHandler = userExistsHandler;
        this.existsByUsernameAndCaptionAndUrlHandler = existsByUsernameAndCaptionAndUrlHandler;
    }
    
    public List<MemeDto> getAllMemes() {
        List<Meme> listOfMemes = memeRepository.findAll();
        List<MemeDto> listOfDtos = new ArrayList<>();
        for(Meme meme : listOfMemes){
            MemeDto dto = new ModelMapper().map(meme, MemeDto.class);
            listOfDtos.add(dto);
        }
        return listOfDtos;
    }

    public MemeDto createNewMeme(Meme meme) throws NullFieldsException, DuplicateMemeException, UserDoesNotExistsException {
        meme.setDateCreated(new Date());
        Meme savedEntity = null;
        this.nullObjectHandler.setHandler(this.nullAttributeHandler);
        nullAttributeHandler.setHandler(this.userExistsHandler);
        nullAttributeHandler.setHandler(this.existsByUsernameAndCaptionAndUrlHandler);
        nullObjectHandler.handle(meme);
        savedEntity = memeRepository.saveWithDate(meme);
        MemeDto memeDto = null;
        if(savedEntity != null)
            memeDto = new ModelMapper().map(savedEntity, MemeDto.class);
        return memeDto;
    }

    public MemeDto getMemeById (String id){
        Optional<Meme> meme = memeRepository.findById(id);
        MemeDto dto = null;
        if (meme.isPresent()){
            dto = new ModelMapper().map(meme.get(), MemeDto.class);
        }
        return dto;
    }

    public List<MemeDto> getTopHundredMemes(){
        return memeRepository.findTop100ByOrderByDateCreatedDesc();
    }
}
