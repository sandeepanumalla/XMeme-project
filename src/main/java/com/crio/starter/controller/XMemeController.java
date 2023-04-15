package com.crio.starter.controller;

import com.crio.starter.data.Meme;
import com.crio.starter.exceptions.DuplicateMemeException;
import com.crio.starter.exceptions.NullFieldsException;
import com.crio.starter.exchange.MemeDto;
import com.crio.starter.service.MemeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/memes")
public class XMemeController {

  private final MemeService memeService;

  @Autowired
    public XMemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @GetMapping("")
  public ResponseEntity<?> getAllMemes(){
    List<MemeDto> listOfMemes =  memeService.getTopHundredMemes();
    return new ResponseEntity<>(listOfMemes, HttpStatus.OK);
  }
    
    @PostMapping("")
    public ResponseEntity<?> postMeme(@RequestBody Meme meme){
        System.out.println(meme.toString());
        MemeDto savedMeme;
        try {
            savedMeme = memeService.createNewMeme(meme);
            if (savedMeme == null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(savedMeme, HttpStatus.CREATED);
        } catch (NullFieldsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch(DuplicateMemeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMemeById(@PathVariable String id) {
        MemeDto dto = memeService.getMemeById(id);
        if (dto == null) {
            return new ResponseEntity<>("no meme found for id "+id, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/top100")
    public ResponseEntity<?> getTopHundredMemes() {
        List<MemeDto> listOfMemes =  memeService.getTopHundredMemes();
        return new ResponseEntity<>(listOfMemes, HttpStatus.OK);
    }
}
