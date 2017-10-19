package mvc.die;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DieView extends JPanel {
	private JButton button;
	private JLabel label;
	
	public DieView() {
		button = new JButton("Roll");
		label = new JLabel("Roll the die.");
		
		setLayout(new BorderLayout());
		add(button, BorderLayout.SOUTH);
		add(label, BorderLayout.CENTER);
	}
	
	public void setLabel(String msg) {
		label.setText(msg);
	}
	
	public JButton getButton() {
		return button;
	}
}
