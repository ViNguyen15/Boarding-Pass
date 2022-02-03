import java.io.File;
import java.util.Locale;

public class BoardingPass {

    // person info
    private String name;
    private String email;
    private String phone;
    private String gender;
    private int age;

    // boarding pass info
    private String date;
    private String destination;
    private String departureTime;

    // generate
    private int boardingPassNumber;
    private String origin;
    private String eta;
    private String price;


    //	The user will be required to enter their Name, Email, Phone Number, Gender, Age, Date, Destination,
    //	and Departure Time into the console or GUI (teams’ preference).
    public BoardingPass(String name, String email, String phone, String gender,
                        int age, String date, String destination, String departureTime) {
        // user input
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departureTime = departureTime;

        // auto generated
        this.boardingPassNumber = generateBPNumber();
        this.price = calculatePrice();
        this.eta = generateETA(25, "1235");

        this.origin = "here";
    }

    //region getter and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getBoardingPassNumber() {
        return boardingPassNumber;
    }

    public void setBoardingPassNumber(int boardingPassNumber) {
        this.boardingPassNumber = boardingPassNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {

        this.eta = eta;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    //endregion

    // calculate price
    public String calculatePrice(){
        double price = 20;
        if( this.age <= 12 )
            return "" + (price - (price * 0.50) );
        if( this.age >= 60 )
            return "" + (price - (price * 0.60) );
        if( this.gender.toLowerCase().charAt(0) == 'f')
            return "" + (price - (price * 0.25) );
        return "" + price;
    }

    // should generate unique number
    public int generateBPNumber(){
        if(new FilesBP().bpID.isEmpty()) return 1;

        int max = 0;
        for(int num : new FilesBP().bpID){
            if (num > max)
                max = num;
        }
        return max + 1;
    }

    //generate eta
    public String generateETA( int speed, String distance){

        StringBuilder result = new StringBuilder();

        char[] endPoint =distance.toCharArray();
        int location = 0;
        for (
                int i = 0;
                i < endPoint.length; i++) {
            int x
                    = location * 10
                    + Character.getNumericValue(
                    endPoint[i]);
            result.append(x / speed);
            location = x % speed;
        }

        // Remove any leading zeros
        for (
                int i = 0;
                i < result.length(); i++) {
            if (
                    result.charAt(i) != '0') {
                return result.substring(i);
            }
           // return "";
            //We can call the numbers in main. This code goes to main
//            public static void main(String[] args){
//                String distance
//                        = "124812";  //remember distance  == destination
//
//                int speed = 25;
//                System.out.println(
//                        generateETA(
//                                distance, speed));
            }
        return result.toString();
    }

    // The details should include valid data such as: name, email, phone number, gender, age, boarding pass number, date, origin, destination, estimated time of arrival (ETA), departure time.
    @Override
    public String toString() {
        return "BoardingPass{" +
                " name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", phone: '" + phone + '\'' +
                ", gender: '" + gender + '\'' +
                ", age: '" + age + '\'' +
                ", date: '" + date + '\'' +
                ", destination: '" + destination + '\'' +
                ", departmentTime: '" + departureTime + '\'' +
                ", boardingPassNumber: '" + boardingPassNumber + '\'' +
                ", origin: '" + origin + '\'' +
                ", eta: '" + eta + "mins" + '\'' +
                ", price: '" + price + '\'' +
                " }";
    }


}
