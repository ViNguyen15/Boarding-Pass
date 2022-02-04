
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {
    BoardingPass testPass;

    @BeforeEach
    void setUp(){
        testPass = new BoardingPass("Jimmy",
                "Test@gmail.com", "404", "m", 21,
                "now", "Georgia", "California", "now");
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
    public void getEmailTest(){
        assertEquals("Test@gmail.com", testPass.getEmail(), "Error: getEmail failed");
    }

    @Test
    public void setEmailTest(){
        testPass.setEmail("TestTest@tester.net");
        assertEquals("TestTest@tester.net", testPass.getEmail(), "Error: getEmail failed");
    }

    @Test
    public void getPhoneTest(){

    }

    @Test
    public void setPhoneTest(){

    }

    @Test
    public void getGenderTest(){
        assertEquals("m", testPass.getGender(), "Error: getGender failed");
    }

    @Test
    public void setGenderTest(){

    }

    @Test
    public void getAgeTest(){

    }

    @Test
    public void setAgeTest(){

    }

    @Test
    public void getDateTest(){

    }

    @Test
    public void setDateTest(){

    }

    @Test
    public void getDestinationTest(){

    }

    @Test
    public void setDestinationTest(){

    }

    @Test
    public void getDepartureTimeTest(){

    }

    @Test
    public void setDepartureTimeTest(){

    }

    @Test
    public void getOriginTest(){

    }

    @Test
    public void setOriginTest(){

    }

    @Test
    public void getEtaTest(){

    }

    @Test
    public void setEtaTest(){

    }

    @Test
    public void getPriceTest(){

    }

    @Test
    public void setPriceTest(){

    }

    @Test
    public void generateBPNumberTest(){
        assertEquals(true,
                !( new FilesBP().bpID.contains( testPass.generateBPNumber() ) ),
                "Error: generateBPNumber failed" );
    }

    @Test
    public void calculatePriceTest(){
        testPass.setGender("female");
        assertEquals("75.0", testPass.calculatePrice(100),"Error: calculatePrice failed");
    }

    @Test
    public void generateETATest(){
        assertEquals("4 hours, 37 minutes",
                testPass.generateETA("Georgia","California"),
                "Error: generateETA failed");
    }



}