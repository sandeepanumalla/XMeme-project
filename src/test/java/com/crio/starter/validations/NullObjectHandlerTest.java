package com.crio.starter.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import com.crio.starter.data.Meme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class NullObjectHandlerTest {
    private CustomHandler handler;
    private Meme nullMemeObject = null;
//    Meme nonNullMemeObject = new Meme("123", "My Meme", "http://example.com/my-meme.jpg", "A funny caption", new Date());
//    Meme nonNullMemeObjectButEmptyField = new Meme("123", "hell", "http://example.com/my-meme.jpg", "A funny caption", null);

    // @BeforeEach
    // public void setup(){
    //     Handler nullObjectHandler = new NullObjectChecker();
    //     Handler nullAttributeHander = new NullAttributesChecker();
    //     nullObjectHandler.setHandler(nullAttributeHander);
    //     handler = nullObjectHandler;
    // }

    @Test
    @DisplayName("expecting issue(false) if null meme object is passed")
    public void shouldReturnTrueIfOjectIsNull() {
//        CustomHandler nullObjectChecker = new NullObjectChecker();
//        handler = nullObjectChecker;
//        boolean allOkay = handler.handle(nullMemeObject);
//        assertEquals(false, allOkay);
    }    

    @Test
    @DisplayName("expecting all okay(true) if object is not null and attributes are non empty")
    public void shouldReturnFalseIfOjectIsNotNull() {
//        CustomHandler nullObjectChecker = new NullObjectChecker();
//        CustomHandler isNullAttributeExists = new NullAttributesChecker();
//        isNullAttributeExists.setHandler(isNullAttributeExists);
//        handler = nullObjectChecker;
//        boolean allOkay = handler.handle(nonNullMemeObject);
//        assertEquals(true, allOkay);
    }    

    @Test
    @DisplayName("expecting issue(false) if object is not null but some attributes are empty")
    public void shouldReturnFalseIfOjectIsNotNullButSomeAttributeIsEmpty() {
//        CustomHandler isNullObjectExists = new NullObjectChecker();
//        CustomHandler isNullAttributeExists = new NullAttributesChecker();
//        isNullObjectExists.setHandler(isNullAttributeExists);
//        handler = isNullObjectExists;
//        boolean allOkay = handler.handle(nonNullMemeObjectButEmptyField);
//        assertEquals(false, allOkay);
    }


}
