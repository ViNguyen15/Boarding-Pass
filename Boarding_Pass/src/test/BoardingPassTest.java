
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardingPassTest {
    BoardingPass testPass;

    @BeforeEach
    void setUp(){
        testPass = new BoardingPass("Jimmy",
                "Test@gmail.com", "404", "m", 21,
                "2/6/2022", "Georgia", "California", "22:00");
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
        assertEquals("404", testPass.getPhone(), "Error: getPhone failed");
    }

    @Test
    public void setPhoneTest(){
        testPass.setPhone("18006972345");
        assertEquals("18006972345", testPass.getPhone(), "Error: setPhone failed");
    }

    @Test
    public void getGenderTest(){
        assertEquals("m", testPass.getGender(), "Error: getGender failed");
    }

    @Test
    public void setGenderTest(){
        testPass.setGender("f");
        assertEquals("f",testPass.getGender(), "Error: setGender failed");
    }

    @Test
    public void getAgeTest(){
        assertEquals(21,testPass.getAge(), "Error: getAge failed");
    }

    @Test
    public void setAgeTest(){
        testPass.setAge(50);
        assertEquals(50, testPass.getAge(), "Error: setAge failed");
    }

    @Test
    public void getDateTest(){
        assertEquals("2/6/2022", testPass.getDate(), "Error: getDate failed");
    }

    @Test
    public void setDateTest(){
        testPass.setDate("2/7/2022");
        assertEquals("2/7/2022", testPass.getDate(), "Error: setDate failed");
    }

    @Test
    public void getDestinationTest(){
        assertEquals("California", testPass.getDestination(), "Error: getDestination failed");
    }

    @Test
    public void setDestinationTest(){
        testPass.setDestination("Hawaii");
        assertEquals("Hawaii", testPass.getDestination(), "Error: setDestination failed");
    }

    @Test
    public void getDepartureTimeTest(){
        assertEquals("22:00", testPass.getDepartureTime(), "Error: getDepartureTime failed");
    }

    @Test
    public void setDepartureTimeTest(){
        testPass.setDepartureTime("10:00");
        assertEquals("10:00", testPass.getDepartureTime(), "Error: getDepartureTime failed");
    }

    @Test
    public void getOriginTest(){
        assertEquals("Georgia", testPass.getOrigin(), "Error: getOrigin failed");
    }

    @Test
    public void setOriginTest(){
        testPass.setOrigin("Texas");
        assertEquals("Texas", testPass.getOrigin(), "Error: getOrigin failed");
    }

    @Test
    public void getEtaTest(){
        assertEquals(testPass.generateETA(testPass.getOrigin(), testPass.getDestination()),
                testPass.getEta(), "Error: getEta failed");
    }

    @Test
    public void setEtaTest(){
        testPass.setEta("5 hours");
        assertEquals("5 hours", testPass.getEta(), "Error: setEta failed");
    }

    @Test
    public void getPriceTest(){
        assertEquals(testPass.calculatePrice(50), testPass.getPrice(), "Error: getPrice failed");
    }

    @Test
    public void setPriceTest(){
        testPass.setPrice("100.00");
        assertEquals("100.00", testPass.getPrice(),"Error: setPrice failed");
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
        assertEquals("4 hours 37 minutes",
                testPass.generateETA("Georgia","California"),
                "Error: generateETA failed");
    }



}