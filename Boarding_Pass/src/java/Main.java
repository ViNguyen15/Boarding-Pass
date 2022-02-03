import javax.swing.*;

public class Main {
    static int windowX = 500;
    static int windowY = 400;
    static JTextField nameField, emailField, phoneField, genderField,
            ageField, dateField, departTimeField;

    static JLabel nameLabel, emailLabel, phoneLabel, genderLabel,
        ageLabel, dateLabel, destinationLabel, departTimeLabel, originLabel;

    static JComboBox originBox, destinationBox;

    final static String[] places = {
             "Alabama", "Alaska", "Arizona", "Arkansas"
            ,"California","Colorado","Connecticut"
            ,"Delaware","Florida","Georgia","Hawaii"
            ,"Idaho","Illinois","Indiana","Iowa"
            ,"Kansas","Kentucky","Louisiana","Maine"
            ,"Maryland","Massachusetts","Michigan","Minnesota"
            ,"Mississippi","Missouri","MontanaNebraska","Nevada"
            ,"New Hampshire","New Jersey","New Mexico","New York"
            ,"North Carolina","North Dakota","Ohio","Oklahoma"
            ,"Oregon","Pennsylvania","Rhode Island","South Carolina"
            ,"South Dakota","Tennessee","Texas","Utah"
            ,"Vermont","Virginia","Washington","West Virginia"
            ,"Wisconsin","Wyoming"
    };

    public static void main(String[] args) {

        customerFillOut();
    }

    public static void infoDisplay(BoardingPass pass){
        JFrame frame = new JFrame("Receipt");
        JLabel ty = new JLabel();
        JLabel eta = new JLabel();
        JLabel priceLabel = new JLabel();
        JButton btn = new JButton("OK");
        int fieldX = 150;
        int fieldY = 25;

        frame.setSize(windowX/4*3 + 50,windowY/4*3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ty.setText("Thank You " + pass.getName() + ", for your patience.");
        ty.setBounds(windowX - fieldX * 3, fieldY * 1, fieldX * 2, fieldY * 2);

        eta.setText("Your estimated time arrival is: " + pass.getEta() + " minutes.");
        eta.setBounds(windowX - fieldX * 3, fieldY * 3, fieldX * 2, fieldY * 2);

        priceLabel.setText("Your total price is: $" + String.format("%.2f", Double.parseDouble(pass.getPrice())));
        priceLabel.setBounds(windowX - fieldX * 3, fieldY * 5, fieldX * 2, fieldY * 2);

        int bSizeX = 100;
        int bSizeY = 25;
        btn.setBounds(windowX/4,fieldY * 8, bSizeX, bSizeY);

        btn.addActionListener( action -> {
            frame.dispose();
        });

        frame.add( ty );
        frame.add( eta );
        frame.add( priceLabel );
        frame.add( btn );

        frame.setLayout( null );
        frame.setVisible( true );

    }

    public static void customerFillOut(){
        JFrame frame = new JFrame("Boarding Pass Fill Out Sheet");
        frame.setSize(windowX,windowY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int fieldX = 150;
        int fieldY = 25;

        //region Components
        // text-fields and label
        //name
        nameField = new JTextField();
        nameField.setBounds(windowX - fieldX * 2, fieldY * 1, fieldX, fieldY);
        nameLabel = new JLabel();
        nameLabel.setText("Name");
        nameLabel.setBounds(windowX - fieldX * 3, fieldY * 1, fieldX, fieldY);

        //email
        emailField = new JTextField();
        emailField.setBounds(windowX - fieldX * 2, fieldY * 2, fieldX, fieldY);
        emailLabel = new JLabel();
        emailLabel.setText("Email");
        emailLabel.setBounds(windowX - fieldX * 3, fieldY * 2, fieldX, fieldY);

        //phone
        phoneField = new JTextField();
        phoneField.setBounds(windowX - fieldX * 2, fieldY * 3, fieldX, fieldY);
        phoneLabel = new JLabel();
        phoneLabel.setText("Phone Number");
        phoneLabel.setBounds(windowX - fieldX * 3, fieldY * 3, fieldX, fieldY);

        //gender
        genderField = new JTextField();
        genderField.setBounds(windowX - fieldX * 2, fieldY * 4, fieldX, fieldY);
        genderLabel = new JLabel();
        genderLabel.setText("Gender");
        genderLabel.setBounds(windowX - fieldX * 3, fieldY * 4, fieldX, fieldY);

        //age
        ageField = new JTextField();
        ageField.setBounds(windowX - fieldX * 2, fieldY * 5, fieldX, fieldY);
        ageField.setText("0");
        ageLabel = new JLabel();
        ageLabel.setText("Age");
        ageLabel.setBounds(windowX - fieldX * 3, fieldY * 5, fieldX, fieldY);

        //date
        dateField = new JTextField();
        dateField.setBounds(windowX - fieldX * 2, fieldY * 6, fieldX, fieldY);
        dateLabel = new JLabel();
        dateLabel.setText("Date");
        dateLabel.setBounds(windowX - fieldX * 3, fieldY * 6, fieldX, fieldY);

        //origin
        originBox = new JComboBox(places);
        originBox.setBounds(windowX - fieldX * 2, fieldY * 7, fieldX, fieldY);
        originBox.setSelectedIndex(9);
        originLabel = new JLabel();
        originLabel.setText("Origin");
        originLabel.setBounds(windowX - fieldX * 3, fieldY * 7, fieldX, fieldY);

        //destination
        destinationBox = new JComboBox(places);
        destinationBox.setBounds(windowX - fieldX * 2, fieldY * 8, fieldX, fieldY);
        destinationBox.setSelectedIndex(9);
        destinationLabel = new JLabel();
        destinationLabel.setText("Destination");
        destinationLabel.setBounds(windowX - fieldX * 3, fieldY * 8, fieldX, fieldY);

        //departure time
        departTimeField = new JTextField();
        departTimeField.setBounds(windowX - fieldX * 2, fieldY * 9, fieldX, fieldY);
        departTimeLabel = new JLabel();
        departTimeLabel.setText("Departure Time");
        departTimeLabel.setBounds(windowX - fieldX * 3, fieldY * 9, fieldX, fieldY);

        //message
        JLabel warning = new JLabel();
        warning.setBounds(windowX - fieldX * 3, fieldY * 10, fieldX*2, fieldY);

        //button
        int bSizeX = 100;
        int bSizeY = 25;
        JButton btn = new JButton("Submit");
        btn.setBounds(windowX - bSizeX * 2,windowY - bSizeY * 4,bSizeX,bSizeY);

        //event handler
        btn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = genderField.getText();
            String date = dateField.getText();
            String origin = originBox.getSelectedItem().toString();
            String destination = destinationBox.getSelectedItem().toString();
            String departureTime = departTimeField.getText();
            int age;
            try {
                age = Integer.parseInt(ageField.getText());
            }catch (Exception bad){
                System.out.println("Not a number");
                age = 0;
            }

            if(name.isEmpty()||email.isEmpty()||phone.isEmpty()||gender.isEmpty()||
                    date.isEmpty()||destination.isEmpty()||departureTime.isEmpty()||age<=0) {

                warning.setText("Please do not leave anything blank!");

                if(age<=0)
                    warning.setText("age needs to be a number");

            } else {
                BoardingPass bp = new BoardingPass(name, email, phone, gender, age, date, origin ,destination, departureTime);
                new FilesBP().writeToFile(bp);
                frame.dispose();
                infoDisplay(bp);
            }
        });

        //endregion

        //region adding to frames
        //adding stuff to frame
        frame.add( nameField );
        frame.add( nameLabel );

        frame.add( emailField );
        frame.add( emailLabel );

        frame.add( phoneField );
        frame.add( phoneLabel );

        frame.add( genderField );
        frame.add( genderLabel );

        frame.add( ageField );
        frame.add( ageLabel );

        frame.add( dateField );
        frame.add( dateLabel );

        frame.add( originBox );
        frame.add( originLabel );

        frame.add( destinationBox );
        frame.add( destinationLabel );

        frame.add( departTimeField );
        frame.add( departTimeLabel );

        frame.add( btn );

        frame.add( warning );

        //endregion

        frame.setLayout( null );
        frame.setVisible( true );
    }




}
