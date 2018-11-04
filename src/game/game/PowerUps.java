package game;


public enum PowerUps {
	SLOWTIME, INVICIBILITY, LIFEUP;
	
	public String toString() {
		switch(this) {
			case SLOWTIME: return "slowtime";
			case INVICIBILITY: return "invicibility";
			case LIFEUP: return "lifeup";
		}
		return "n/a";
	}
}
