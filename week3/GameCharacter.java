package week3;

 abstract class GameCharacter {
	 abstract String attack();
	 abstract String defend();

	 
}
 class Warrior extends GameCharacter{
	@Override
	 String attack() {
		return "Warrior!";
		 
	 }

	@Override
	String defend() {
		// TODO Auto-generated method stub
		return "Defend!";
	}
 }
 class Archer extends GameCharacter {
	    @Override
	    public String attack() {
	        return "Archer shoots an arrow with precision!";
	    }

	    @Override
	    public String defend() {
	        return "Archer swiftly dodges the incoming attack!";
	    }
	}

	

