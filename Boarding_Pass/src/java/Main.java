import javax.swing.*;

public class Main {


    // give option for user to select between managing pass and creating pass
    public void userOptions(){

        // width and height of frame
        int width = 300;
        int height = 300;

        JFrame frame = new JFrame();
        frame.setSize(width,height);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setTitle("User Options");

        // displaying message to user
        JLabel messageLebel = new JLabel();
        messageLebel.setText("Choose what you want to do?");
        messageLebel.setBounds((width - 200) / 2, 20 , 200, 25);

        // button to create new boarding pass
        JButton boardingPassButton = new JButton("New Boarding Pass");
        boardingPassButton.setBounds( (width - 200) / 2,((height / 3)  ) - 30, 200, 40 );
        boardingPassButton.addActionListener( pressed -> {
            BoardingPassMenu bpMenu = new BoardingPassMenu();
            frame.dispose();
            bpMenu.customerFillOut();
        });

        // button to edit existing boarding pass
        JButton editButton = new JButton("Edit");
        editButton.setBounds( (width - 200) / 2,((height / 3) * 2  ) - 50, 200, 40 );
        editButton.addActionListener( pressed -> {
            ManagingPass mp = new ManagingPass();
            frame.dispose();
            mp.selectionMenu();
        });

        // adding to frame
        frame.add( editButton );
        frame.add( messageLebel );
        frame.add( boardingPassButton );

        // misc
        frame.setLocationRelativeTo(null);
        frame.setLayout( null );
        frame.setVisible( true );
    }

    public static void main(String[] args) {
        new Main().userOptions();

    }
}
