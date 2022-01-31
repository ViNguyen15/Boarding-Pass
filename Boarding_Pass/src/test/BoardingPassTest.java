import org.junit.Before;
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
    public void calculatePriceTest(){
        assertEquals(20, testPass.calculatePrice(), "Error: calculatePrice failed");
    }

}