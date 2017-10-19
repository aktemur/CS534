package prototype.v1;

abstract class Note {
	public abstract double duration();
	
	public abstract Note clone();
	
	public String toString() {
		return "My duration is: " + duration();
	}
}

class WholeNote extends Note {
	public double duration() {
		return 1;
	}
	
	public Note clone() {
		return new WholeNote();
	}
}

class HalfNote extends Note {
	public double duration() {
		return 0.5;
	}
	
	public Note clone() {
		return new HalfNote();
	}
}

class NoteButton {
	Note prototype;
	
	public NoteButton(Note prototype) {
		this.prototype = prototype;
	}
	
	public Note doClick() {
		return prototype.clone();
	}
}

public class Prototype {
	public static void main(String[] args) {
		NoteButton wholeNoteButton = new NoteButton(new WholeNote());
		NoteButton halfNoteButton = new NoteButton(new HalfNote());
		
		System.out.println(wholeNoteButton.doClick());
		System.out.println(wholeNoteButton.doClick());
		System.out.println(halfNoteButton.doClick());		
	}
}











