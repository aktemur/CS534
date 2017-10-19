package prototype.v0;

abstract class Note {
	public abstract double duration();
	
	public String toString() {
		return "My duration is: " + duration();
	}
}

class WholeNote extends Note {
	public double duration() {
		return 1;
	}
}

class HalfNote extends Note {
	public double duration() {
		return 0.5;
	}
}

abstract class NoteButton {
	public abstract Note doClick();
}

class WholeNoteButton extends NoteButton {
	public Note doClick() {
		return new WholeNote();
	}
}

class HalfNoteButton extends NoteButton {
	public Note doClick() {
		return new HalfNote();
	}
}

public class WithoutPrototype {
	public static void main(String[] args) {
		NoteButton wholeNoteButton = new WholeNoteButton();
		NoteButton halfNoteButton = new HalfNoteButton();
		
		System.out.println(wholeNoteButton.doClick());
		System.out.println(wholeNoteButton.doClick());
		System.out.println(halfNoteButton.doClick());
	}
}










