/**************************************************************************
*MSUnit7Ch17
*Molina
*
*This program displays a dialog box that shows a message and a randomly
*chosen color. This random color is to be used as the background color of
*a JFrame window which should appear after “OK” is selected. The window
*should ask your name and thank you for playing once “Enter” is pressed.
**************************************************************************/

import java.awt.*; //for FlowLayout
import java.awt.event.*; //forActionListener, ActionEvent
import javax.swing.*; //for JFrame, JLabel, JTextField
import java.util.Random; //to generate random number


 public class MSUnit7Ch17 extends JFrame
 {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;
	private JTextField nameBox; //holds user's name
	private JLabel thanks; //thanks for playing message
	private JLabel namePrompt; //what is your name message
	private String color;

/**************************************************************************/

	public MSUnit7Ch17()
	{
		setTitle("Color Changing Frame");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);

	}//end MSUnit7Ch17 constructor

/**************************************************************************/

	private void createContents()
	{
		namePrompt = new JLabel("What is your name: ");
		nameBox = new JTextField(15);
		thanks = new JLabel();

		add(namePrompt);
		add(nameBox);
		add(thanks);

		nameBox.addActionListener(new Listener()); //create listener for event

		Random rand = new Random();
		int i = rand.nextInt(5) + 1; //5 because there are 5 colors

		Container contentPane = getContentPane();

	 switch(i)
	 {

 		case 1: //green background and blue text
 			contentPane.setBackground(Color.GREEN);
 			contentPane.setForeground(Color.BLUE);
 			color = "GREEN";
 		break;

 		case 2: //red background and white text
 			contentPane.setBackground(Color.RED);
 			contentPane.setForeground(Color.WHITE);
 			color = "RED";
 		break;

 		case 3: //white background and black text
 			contentPane.setBackground(Color.WHITE);
 			contentPane.setForeground(Color.BLACK);
 			color = "WHITE";
 		break;

 		case 4: //blue background and white text
 			contentPane.setBackground(Color.BLUE);
 			contentPane.setForeground(Color.WHITE);
 			color = "BLUE";
 		break;

 		case 5: //yellow background and black text
 			contentPane.setBackground(Color.YELLOW);
 			contentPane.setForeground(Color.BLACK);
 			color = "YELLOW";

 		}//end switch

		//Utilize showMessageDialog
 		JFrame frame = new JFrame("Message");
		JOptionPane.showMessageDialog(frame, "The Following window color will be randomly chosen from\n" +
				 								"Red, White, Yellow, Green, Blue\n\n" +
		 										"Your Color will be: " + color);
	}//end createContents
/**************************************************************************/

private class Listener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	 	{

		 String message = "Thanks for playing " + nameBox.getText();
		 nameBox.setVisible(false); //remove textbox
		 namePrompt.setVisible(false); //remove label
		 thanks.setText(message); //set thanks for playing into thanks label

		 }
	 }//end listener

/**************************************************************************/

 	public static void main(String[] args)
 	{
 		new MSUnit7Ch17();

 	}//end main

 }//end MSUnit7Ch17
