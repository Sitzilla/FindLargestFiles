package es.personalCode;

//class that represents a hash of a String and an associated double.  These are meant to represent a pairing of file name and file size.
public class Pair {
	private String first;
	private double second;
	
	//initializes the 'Pair' object with a String 'first' value and a double 'second' value
	public Pair(String first, double second){
		this.first = first;
		this.second = second;
	}
	
	//returns the first value in the pair
	public String getFirst(){
		return first;
	}
	
	//returns the second value in the pair
	public double getSecond(){
		return second;
	}
	
	//adds a passed in value to the 'first' value in the object
	public void addFirst(String str){
		first = str;
	}
	
	//adds a passed in value to the 'second' value in the object
	public void addSecond(double dbl){
		second = dbl;
	}
	
	
}
