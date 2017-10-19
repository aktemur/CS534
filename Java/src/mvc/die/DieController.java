package mvc.die;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DieController implements ActionListener {
	private Die die;
	private DieView view;
	
	public DieController(Die die, DieView view) {
		this.die = die;
		this.view = view;
		view.getButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Modify the model
		die.roll();
		
		// Update the view by reading and passing the state of the model
		String faceValue = String.valueOf(die.getFaceValue()); 
		view.setLabel(faceValue);
	}
}
