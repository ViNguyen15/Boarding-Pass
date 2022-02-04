import javax.swing.*;

public class ManagingPass {
    FilesBP file = new FilesBP();
    BoardingPass selectedPass;
    int selectedNumber;

    // user picks which boarding pass base on their number
    public void selectionMenu(){
        int height = 200;
        int width = 200;

        JFrame frame = new JFrame();
        frame.setTitle("Update Selection");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int lblX = 180;
        int lblY = 50;
        JLabel selectionLabel = new JLabel();
        selectionLabel.setText("Select the Boarding Pass ID");
        selectionLabel.setBounds((height - lblX)/2,0, lblX, lblY);

        String[] choices = new String[file.allBP.size()];
        for(int i = 0; i < choices.length; i++){
            choices[i] = String.valueOf( file.allBP.get(i).getBoardingPassNumber() );
        }
        JComboBox selectionBox = new JComboBox( choices );
        int boxX = 45;
        int boxY = 20;
        selectionBox.setBounds(width/2 - boxX/2,height/2 - boxY*2, boxX, boxY);

        JButton editBtn = new JButton("edit");
        editBtn.setBounds(65 ,height - boxY*5, 70, boxY);
        editBtn.addActionListener( e -> {
            this.selectedPass = file.allBP.get( selectionBox.getSelectedIndex() );
            this.selectedNumber = selectionBox.getSelectedIndex();
            toEditMenu();
            frame.dispose();
        });

        frame.add( editBtn );
        frame.add( selectionLabel );
        frame.add( selectionBox );
        frame.setLayout( null );
        frame.setVisible( true );

    }

    // window for updating information
    public void toEditMenu(){
        JFrame menu = new JFrame();

        menu.setTitle("Edit Boarding Pass Menu");
        menu.setSize(500,800);

        // region creating all components
        JTextField nameField = fieldComponent( selectedPass.getName(), 80);
        JLabel nameLabel = fieldLabel("Name: ", 80);

        JTextField emailField = fieldComponent( selectedPass.getEmail(), 130);
        JLabel emailLabel = fieldLabel("Email: ", 130);

        JTextField phoneField = fieldComponent( selectedPass.getPhone(), 180);
        JLabel phoneLabel = fieldLabel("Phone #: ", 180);

        JTextField genderField = fieldComponent( selectedPass.getGender(), 230);
        JLabel genderLabel = fieldLabel("Gender: ", 230);

        JTextField ageField = fieldComponent(String.valueOf(selectedPass.getAge()), 280);
        JLabel ageLabel = fieldLabel("Age: ", 280);

        JTextField dateField = fieldComponent( selectedPass.getDate(), 330);
        JLabel dateLabel = fieldLabel("Date: ", 330);

        JTextField originField = fieldComponent( selectedPass.getOrigin(), 380);
        JLabel originLabel = fieldLabel("Origin: ", 380);

        JTextField destinationField = fieldComponent( selectedPass.getDestination(), 430);
        JLabel destinationLabel = fieldLabel("Destination: ", 430);

        JTextField etaField = fieldComponent( selectedPass.getEta(), 480);
        JLabel etaLabel = fieldLabel("ETA: ", 480);

        JTextField priceField = fieldComponent( selectedPass.getPrice(), 530);
        JLabel priceLabel = fieldLabel("Price: ", 530);

        JTextField departTimeField = fieldComponent(String.valueOf(selectedPass.getDepartureTime()), 580);
        JLabel departTimeLabel = fieldLabel("Departure Time: ", 580);

        JLabel boardPassNumLabel = new JLabel(
                "Boarding Pass Number: " + selectedPass.getBoardingPassNumber());
        boardPassNumLabel.setBounds(150,30,200,30);

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(200,700,100,30);
        //endregion

        // update button gets clicked will save changes to textfile
        updateBtn.addActionListener( e -> {
            selectedPass.setName( nameField.getText() );
            selectedPass.setGender( genderField.getText() );
            selectedPass.setEmail( emailField.getText() );
            selectedPass.setPhone( phoneField.getText() );
            selectedPass.setDate( dateField.getText() );
            selectedPass.setDepartureTime( departTimeField.getText() );
            selectedPass.setAge( Integer.parseInt( ageField.getText() ) );
            selectedPass.setEta( etaField.getText() );
            selectedPass.setPrice( priceField.getText() );
            selectedPass.setOrigin( originField.getText() );
            selectedPass.setDestination( destinationField.getText() );

            file.allBP.set(this.selectedNumber, this.selectedPass);

            file.reWriteFile();
            menu.dispose();
            JOptionPane.showMessageDialog(menu,"File has been Updated");
        });

        // region adding all components
        menu.add( nameField );
        menu.add( nameLabel );
        menu.add( emailField );
        menu.add( emailLabel );
        menu.add( phoneField );
        menu.add( phoneLabel );
        menu.add( genderField );
        menu.add( genderLabel );
        menu.add( ageField );
        menu.add( ageLabel );
        menu.add( dateField );
        menu.add( dateLabel );
        menu.add( originField );
        menu.add( originLabel );
        menu.add( destinationField );
        menu.add( destinationLabel );
        menu.add( etaField );
        menu.add( etaLabel );
        menu.add( priceField );
        menu.add( priceLabel );
        menu.add( departTimeField );
        menu.add( departTimeLabel );
        menu.add( boardPassNumLabel );

        menu.add( updateBtn );
        // endregion

        menu.setLayout( null );
        menu.setVisible( true );
    }

    // textfield automation
    public JTextField fieldComponent( String toChange, int y){
        int x = 200;
        JTextField field = new JTextField();
        field.setText(toChange);
        field.setBounds(x,y,150,30);
        return field;
    }

    // label automation
    public JLabel fieldLabel(String name, int y){
        JLabel label = new JLabel();
        label.setText(name);
        label.setBounds(100,y,90,30);
        return label;
    }

    public static void main(String[] args) {
        ManagingPass mp = new ManagingPass();

        mp.selectionMenu();

    }
}
