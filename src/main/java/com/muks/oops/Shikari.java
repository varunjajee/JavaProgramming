package oops;

public class Shikari {
	
	private Animal animal;
	
	public Shikari(Animal animal) {
		this.animal = animal;
	}
	
	public void eat(){
		System.out.println("Eating:");
		animal.shout();
	}

}
