package es.personalCode;

import java.io.File;


public class FileFinder{
	//initializes the variable fileArray of type BiggestFiles
	static BiggestFiles fileArray = new BiggestFiles();
	
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String myDirectoryPath = "C:\\";
			
		FileFinder(myDirectoryPath);
		
		//Print out the top 10 largest files in the C-Drive
		System.out.println("1st: " + fileArray.getFirst(0)+ " " + fileArray.getSecond(0));
		System.out.println("2nd: " + fileArray.getFirst(1)+ " " + fileArray.getSecond(1));
		System.out.println("3rd: " + fileArray.getFirst(2)+ " " + fileArray.getSecond(2));
		System.out.println("4th: " + fileArray.getFirst(3)+ " " + fileArray.getSecond(3));
		System.out.println("5th: " + fileArray.getFirst(4)+ " " + fileArray.getSecond(4));
		System.out.println("6th: " + fileArray.getFirst(5)+ " " + fileArray.getSecond(5));
		System.out.println("7th: " + fileArray.getFirst(6)+ " " + fileArray.getSecond(6));
		System.out.println("8th: " + fileArray.getFirst(7)+ " " + fileArray.getSecond(7));
		System.out.println("9th: " + fileArray.getFirst(8)+ " " + fileArray.getSecond(8));
		System.out.println("10th: " + fileArray.getFirst(9)+ " " + fileArray.getSecond(9));
		
		//length of time for the program to run
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total runtime was: " + totalTime/1000 + " seconds.");
		
	}
	
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
					String fileName = child.getName();
					double fileSize = child.length();

					fileArray.addFileToArray(fileName, fileSize);
					fileArray.sortArray();
					
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
	
	
	
	
}
