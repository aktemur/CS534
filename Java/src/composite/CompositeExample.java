package composite;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CompositeExample {
	public static void main(String[] args) {
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		JPanel panel1 = new JPanel();
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		panel1.setLayout(new GridLayout(2,2));
		
		JPanel panel2 = new JPanel();
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(button7);
		panel2.add(button8);
		panel2.add(button9);		
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(panel1, BorderLayout.CENTER);
		panel3.add(panel2, BorderLayout.SOUTH);
		
		JFrame frame = new JFrame();
		frame.add(panel3);
		frame.setVisible(true);		
	}
}




