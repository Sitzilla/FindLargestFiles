package es.personalCode;

//class that holds the largest files in an array of objects 'Pair'
public class BiggestFiles {

	private static final int ARRAYSIZE = 10; 	
	 private final Pair[] arrayOfFiles = new Pair[ARRAYSIZE]; //instantiates an array of 'Pair' objects of size 10
	
	public BiggestFiles(){
		//initializes the Pair array with base values
		for(int i = 0; i<ARRAYSIZE; i++){
			arrayOfFiles[i] = new Pair("",0);
		}
	}
	
	//method to add a file and its size to the arrayOfFiles array
	public void addFileToArray(String filePath, final double fileSize){
		if (filePath==null) {
			filePath = "ERROR: Filename not found";
			//throw new NullPointerException("Can't add string with a value of 'null' to array.");
		}
		//check if element is null
//		for (int i=0;i<arrayOfFiles.length;i++){
//			if (d > arrayOfFiles[i].getSecond()){
				arrayOfFiles[0].addFirst(filePath);
				arrayOfFiles[0].addSecond(fileSize);
				
				
				return;
//			}
//		}
	}
	//method that checks if a file larger than the smallest file in the array
	public boolean checkGreaterThanStandard(final double checking, final Double standard){
		if (checking>standard){
			return true;
		}
		else{
			return false;
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
		
		for (int i=0;i<arrayOfFiles.length;i++){
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
