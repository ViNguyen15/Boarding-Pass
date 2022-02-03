
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {
    BoardingPass testPass;

    @BeforeEach
    void setUp(){
        testPass = new BoardingPass("Jimmy",
                "Fluffy", "404", "m", 21,
                "now", "there", "now");
    }

    @Test
    public void getNameTest(){
        assertEquals("Jimmy",testPass.getName(),"Error: getName failed");
    }

    @Test
    public void setNameTest(){
        testPass.setName("Joey");
        assertEquals("Joey", testPass.getName(), "Error: setName failed");
    }


    @Test
    public void calculatePriceTest(){
        assertEquals("20.0", testPass.calculatePrice(), "Error: calculatePrice failed");
    }

    @Test
    public void generateBPNumberTest(){

    }



}