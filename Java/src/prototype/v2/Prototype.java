package prototype.v2;

class Note {
	private double duration;
	
	public Note(double duration) {
		this.duration = duration;
	}
	
	public double duration() {
		return duration;
	}
	
	public Object clone() {
		return new Note(duration);
	}
	
	public String toString() {
		return "My duration is: " + duration();
	}
}

class NoteButton {
	Note prototype;
	
	public NoteButton(Note prototype) {
		this.prototype = prototype;
	}
	
	public Note doClick() {
		return (Note)prototype.clone();
	}
}

public class Prototype {
	public static void main(String[] args) {
		NoteButton wholeNoteButton = new NoteButton(new Note(1));
		NoteButton halfNoteButton = new NoteButton(new Note(0.5));
		
		System.out.println(wholeNoteButton.doClick());
		System.out.println(wholeNoteButton.doClick());
		System.out.println(halfNoteButton.doClick());
	}
}
