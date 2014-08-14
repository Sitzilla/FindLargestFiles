package es.personalCode;

//class that holds the largest files in an array of objects 'Pair'
public class BiggestFiles {

	 Pair[] arrayOfFiles = new Pair[10]; //instantiates an array of 'Pair' objects of size 10
	
	public BiggestFiles(){
		//initializes the Pair array with base values
		for(int i = 0; i<=9; i++){
			arrayOfFiles[i] = new Pair("x",1);
		}
	}
	
	//method that checks if a file larger than the smallest file in the array, and if so replaces it
	public void addFileToArray(String s, double d){
		if (s==null) {
			s = "ERROR: Filename not found";
			//throw new NullPointerException("Can't add string with a value of 'null' to array.");
		}
		
		for (int i=0;i<arrayOfFiles.length;i++){
			if (d > arrayOfFiles[i].getSecond()){
				arrayOfFiles[i].addFirst(s);
				arrayOfFiles[i].addSecond(d);
				return;
			}
		}
	}
	
	//gets the value at the first (String) slot of the 'Pair' object, in the array at the passed-in position
	public String getFirst(int pos){
		return arrayOfFiles[pos].getFirst();
	}
	//gets the value at the second (double) slot of the 'Pair' object, in the array at the passed-in position
	public double getSecond(int pos){
		return arrayOfFiles[pos].getSecond();
	}
	
	//method that loops recursively through the array of 'Pair' objects and sorts them by their second slot item (the File size)
	public void sortArray(){
		double tempVariable1 = 0;
		String tempVariable2 = "x";
		
		for (int i=0;i<arrayOfFiles.length-1;i++){
			if (arrayOfFiles[i].getSecond()>arrayOfFiles[i+1].getSecond()){
				tempVariable1 = arrayOfFiles[i+1].getSecond();
				tempVariable2 = arrayOfFiles[i+1].getFirst();
				arrayOfFiles[i+1].addSecond(arrayOfFiles[i].getSecond());
				arrayOfFiles[i+1].addFirst(arrayOfFiles[i].getFirst());
				arrayOfFiles[i].addSecond(tempVariable1);
				arrayOfFiles[i].addFirst(tempVariable2);
				sortArray();
			}
			
		}
		
	}
	
}
