import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener {
			//This is a string containing all TF2 Classes.
	static String[] classes = {"Scout", "Soldier", "Pyro", "Demoman", "Heavy", "Engineer", "Medic", "Sniper", "Spy"};
	
	public JButton button1;
	public JTextField textField;
	public JTextField textField2;
	
	MyFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(330, 200)); //770, 150
		this.getContentPane().setBackground(new Color(0,2,37));
		
		button1 = new JButton("Pick a random class");	//Button settings.
		button1.setPreferredSize(new Dimension(200,40));
		button1.setBackground(new Color(255,247,229));
		button1.setBorder(BorderFactory.createEmptyBorder());
		button1.setFont(new Font("Arial",Font.PLAIN,16));
		button1.addActionListener(this);
		button1.setFocusable(false);
		
		textField = new JTextField();					//Class text settings
		textField.setPreferredSize(new Dimension(250,40));
		textField.setBackground(new Color(255,229,229));
		textField.setFont(new Font("Arial",Font.PLAIN,18));
		textField.setText("Class...");
		textField.setEditable(false);
		
		textField2 = new JTextField();					//Loadout slot text settings
		textField2.setPreferredSize(new Dimension(250,40));
		textField2.setBackground(new Color(255,229,229));
		textField2.setFont(new Font("Arial",Font.PLAIN,18));
		textField2.setText("Loadout slot...");
		textField2.setEditable(false);
		
		this.add(button1);
		this.add(textField);
		this.add(textField2);
		this.pack();
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button1) {			//if pressed on the generate button do the next:
			int temp_Index = (int) (Math.random() * classes.length);
			
			int slot = 1;
			if (((int) (Math.random() * 3) + 1) <= 2) //1/3 chance that the slot would be 1-2 and 2/3 1-4.
			{
				slot = (int) (Math.random() * 4);
			}
			else
			{
				slot = (int) (Math.random() * 2);
			}
			
			textField.setText("Class: " + classes[temp_Index]);
			textField2.setText("Loadout slot: " + (slot + 1));
		}
	}
}
