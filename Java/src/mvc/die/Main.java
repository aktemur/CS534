package mvc.die;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		Die model = new Die();
		DieView view = new DieView();
		DieController controller = new DieController(model, view);
		
		JFrame frame = new JFrame("MVC Example - Die");
		frame.setLayout(new BorderLayout());
		frame.add(view, BorderLayout.CENTER);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
