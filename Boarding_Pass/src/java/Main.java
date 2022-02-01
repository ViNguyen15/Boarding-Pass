import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static int windowX = 500;
    static int windowY = 400;
    static JTextField nameField, emailField, phoneField, genderField,
            ageField, dateField, destinationField, departTimeField;

    static JLabel nameLabel, emailLabel, phoneLabel, genderLabel,
        ageLabel, dateLabel, destinationLabel, departTimeLabel;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Boarding Pass");
        frame.setSize(windowX,windowY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        int fieldX = 150;
        int fieldY = 25;

        // textfields and label
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
        ageLabel = new JLabel();
        ageLabel.setText("Age");
        ageLabel.setBounds(windowX - fieldX * 3, fieldY * 5, fieldX, fieldY);

        //date
        dateField = new JTextField();
        dateField.setBounds(windowX - fieldX * 2, fieldY * 6, fieldX, fieldY);
        dateLabel = new JLabel();
        dateLabel.setText("Date");
        dateLabel.setBounds(windowX - fieldX * 3, fieldY * 6, fieldX, fieldY);

        //destination
        destinationField = new JTextField();
        destinationField.setBounds(windowX - fieldX * 2, fieldY * 7, fieldX, fieldY);
        destinationLabel = new JLabel();
        destinationLabel.setText("Destination");
        destinationLabel.setBounds(windowX - fieldX * 3, fieldY * 7, fieldX, fieldY);

        //depature time
        departTimeField = new JTextField();
        departTimeField.setBounds(windowX - fieldX * 2, fieldY * 8, fieldX, fieldY);
        departTimeLabel = new JLabel();
        departTimeLabel.setText("Departure Time");
        departTimeLabel.setBounds(windowX - fieldX * 3, fieldY * 8, fieldX, fieldY);



        //button
        int bSizeX = 100;
        int bSizeY = 25;
        JButton btn = new JButton("Submit");
        btn.setBounds(windowX - bSizeX * 2,windowY - bSizeY * 4,bSizeX,bSizeY);

        btn.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = genderField.getText();
            int age = Integer.parseInt( ageField.getText() );
            String date = dateField.getText();
            String destination = destinationField.getText();
            String departureTime = departTimeField.getText();

            BoardingPass bp = new BoardingPass(name,email,phone,gender,age,date,destination,departureTime);
            new FilesBP().writeToFile(bp);
            frame.dispose();

        });



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

        frame.add( destinationField );
        frame.add( destinationLabel );

        frame.add( departTimeField );
        frame.add( departTimeLabel );

        frame.add( btn );


        frame.setLayout(null);
        frame.setVisible(true);


    }



}