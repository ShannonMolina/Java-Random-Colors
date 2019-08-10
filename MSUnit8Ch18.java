/**************************************************************************
*MSUnit8Ch18
*Molina
*This program displays a JFrame window with 5 buttons. The buttons will
*be used to control the background color. The button’s text will be
*randomly chosen from 5 colors and the background color will
*change to the color shown on the button.
**************************************************************************/

import java.awt.*; //for FlowLayout
import java.awt.event.*; //forActionListener, ActionEvent
import javax.swing.*; //for JFrame
import java.util.ArrayList; //array list of colors
import java.util.Collections; //using collections to shuffle list of colors

 public class MSUnit8Ch18 extends JFrame
 {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 200;

	//create 5 buttons
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;

	private ArrayList<String> colors; //list of colors

/**************************************************************************/

	public MSUnit8Ch18()
	{
		setTitle("Color Changing Frame");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);

	}//end MSUnit8Ch18 constructor

/**************************************************************************/

	private void randomOrder() //we use this in the listener
	{
		Collections.shuffle(colors); //arraylist switches to random order
		button1.setText(colors.get(0)); //button1 is set to whatever color is now in 0 of arraylist
		button2.setText(colors.get(1)); //button2 is set to whatever color is now in 1 of arraylist
		button3.setText(colors.get(2)); //button3 is set to whatever color is now in 2 of arraylist
		button4.setText(colors.get(3)); //button4 is set to whatever color is now in 3 of arraylist
		button5.setText(colors.get(4)); //button5 is set to whatever color is now in 4 of arraylist
	}

/**************************************************************************/

	private Color getColor(String color) //we use this in the listener
	{
		//return Color corresponds to the string
		//if string is red, then color is red
		//if string is blue, then color is blue
		// etc...

		if (color.equals("Red"))
		{
			return Color.RED;
		}
		else if (color.equals("Blue"))
		{
			return Color.BLUE;
		}
		else if (color.equals("Yellow"))
		{
			return Color.YELLOW;
		}
		else if (color.equals("Green"))
		{
			return Color.GREEN;
		}
		else //if (color.equals("White"))
		{
			return Color.WHITE;
		}
	}//end getColor

/**************************************************************************/

	private void createContents()
	{
		colors = new ArrayList<String>();
		colors.add("Red");
		colors.add("Blue");
		colors.add("Yellow");
		colors.add("Green");
		colors.add("White");

		Listener listener = new Listener();

		button1 = new JButton("Red"); //intital button1 label is Red
		button1.addActionListener(listener); //create listener for button1
		add(button1);


		button2 = new JButton("Blue"); //initial button2 label is blue
		button2.addActionListener(listener); //create listener for button2
		add(button2);

		button3 = new JButton("Yellow"); //initial button3 label is yellow
		button3.addActionListener(listener); //create listener for button3
		add(button3);

		button4 = new JButton("Green"); //initial button4 label is green
		button4.addActionListener(listener); //create listener for button4
		add(button4);

		button5 = new JButton("White"); //initial button5 label is white
		button5.addActionListener(listener); //create listener for button5
		add(button5);

}//end createContents

/**************************************************************************/

//Inner class for event handling.

private class Listener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	 	{
			Container contentPane = getContentPane();

				if (e.getSource() == button1)
				{
					//Change the window background color to string color
					contentPane.setBackground(getColor(button1.getText())); //string color is button1.getText()
																			//which is button1's label
				}
				if (e.getSource() == button2)
				{
					//Change the window background color to string color
					contentPane.setBackground(getColor(button2.getText())); //string color is button2.getText()
																			//which is button2's label
				}
				if (e.getSource() == button3)
				{
					//Change the window background color to string color
					contentPane.setBackground(getColor(button3.getText())); //string color is button3.getText()
																			//which is button3's label
				}
				if (e.getSource() == button4)
				{
					//Change the window background color to string color
					contentPane.setBackground(getColor(button4.getText())); //string color is button4.getText()
																			//which is button4's label
				}
				if (e.getSource() == button5)
				{
					//Change the window background color to string color
					contentPane.setBackground(getColor(button5.getText())); //string color is button5.getText()
																			//which is button5's label
				}

				randomOrder(); //shuffles the arraylist
								//and assigns each button a new color

		 }//end ActionPerformed
	 }//end ButtonListener

/**************************************************************************/


 	public static void main(String[] args)
 	{
 		new MSUnit8Ch18();

 	}//end main

 }//end MSUnit8Ch18
