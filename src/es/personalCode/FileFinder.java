package es.personalCode;

import java.io.File;

public class FileFinder{
	//initializes the variable fileArray of type BiggestFiles
	static BiggestFiles fileArray = new BiggestFiles();
	
	
//	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
//		String output;
//		String myDirectoryPath = "C:\\";
////		String runtime = null;
//			
//		FileFinder(myDirectoryPath);
//		
//		//Return the top 10 largest files in the C-Drive as a string
//		output = concatenateAnswers();
//		
//		//length of time for the program to run
//		long endTime   = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
////		System.out.println("Total runtime was: " + totalTime/1000 + " seconds.");
//		output += "\n" + "\n" + "***Total runtime was: " + totalTime/1000 + " seconds.";
//		
//		//show output
//		JOptionPane.showMessageDialog(null, output, "Final Output", JOptionPane.INFORMATION_MESSAGE);
////		JOptionPane.showMessageDialog(null, runtime, "Final Output", JOptionPane.INFORMATION_MESSAGE);
//		System.out.println(File.listRoots());
//	}
	//Method in the class FileFinder that takes in a directory path as an input and finds the size 
	//of all files in that folder and all subfolders
	public static void FileFinder(String myDirectoryPath) {
		
		
		File directory = new File(myDirectoryPath);  //file object that is used to find an individual directory path
		File[] directoryListings = directory.listFiles(); //list of file objects in a particular folder
			
		if(directoryListings!=null){
			//for all file/folder items in list directoryListings
			for (File child : directoryListings){
				
				//if the child object is a file then return its size, otherwise assume it is a folder and call FileFolder recursively
				if(child.isFile()){
					String fileName = child.getAbsolutePath();
					double fileSize = child.length();
					//checks if the size of the folder being checked in the folder is greater than the first item in the BiggestFiles array
					if (fileArray.checkGreaterThanStandard(fileSize, fileArray.getSecond(0))== true){
						fileArray.addFileToArray(fileName, fileSize);
						fileArray.sortArray();
					}
				}
				else {
					//recursive call if the path is not null
					if(child.getAbsolutePath()!=null){
					FileFinder(child.getAbsolutePath());
					}
				}
			}
		}
			
			
	}
	//method that combines the 10 largest files into a string that is returned
	public static String concatenateAnswers(){
		String str = "";
		int ranking;
		
		for (int i = 9; i > -1; i--){
			ranking = (10 - i);
			str += Integer.toString(ranking) + ". " + fileArray.getFirst(i) + ", " + fileArray.getSecond(i) + " KB" + "\n";	
		}
		return str;
	}
	
	
	
}
