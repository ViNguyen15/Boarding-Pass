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
    private String departmentTime;

    // generate
    private int boardingPassNumber;
    private String origin;
    private String eta;
    private String price;


    //	The user will be required to enter their Name, Email, Phone Number, Gender, Age, Date, Destination, and Departure Time into the console or GUI (teams’ preference).
    public BoardingPass(String name, String email, String phone, String gender, int age, String date, String destination, String departmentTime) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.date = date;
        this.destination = destination;
        this.departmentTime = departmentTime;

        this.boardingPassNumber = 1;
        this.price = "10.00";
        this.eta = "forever";
    }


    // calculate price
    public String calculatePrice(){
        double price = 20;

        if(this.age <= 12 )
            return price * 0.50;

        return "0";
    }

    // The details should include valid data such as: name, email, phone number, gender, age, boarding pass number, date, origin, destination, estimated time of arrival (ETA), departure time.

    @Override
    public String toString() {
        return "BoardingPass: {" +
                " name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", phone: '" + phone + '\'' +
                ", gender: '" + gender + '\'' +
                ", age: " + age +
                ", date: '" + date + '\'' +
                ", destination: '" + destination + '\'' +
                ", departmentTime: '" + departmentTime + '\'' +
                ", boardingPassNumber: " + boardingPassNumber +
                ", origin: '" + origin + '\'' +
                ", eta: '" + eta + '\'' +
                ", price: '" + price + '\'' +
                " }";
    }
}
