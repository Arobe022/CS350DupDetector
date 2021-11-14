package edu.odu.cs.cs350;
import java.util.*;
import java.nio.file.Files;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CPPSourceFiles {
	protected static List<String>src;
	protected static File directory;
	protected static List<File> allFiles;
	protected static List<Token>tokenList;
	protected static String path;
	//default constructor
	public CPPSourceFiles ()
	{
		src=null;
		allFiles=null;
		tokenList=null;
		path ="";
	}
	//realsies constructor
	public CPPSourceFiles(String p1,List<String>source,List<Token>t,List<File>f)
	{	
		path=p1;
		src=source;
		//directory=new File(p1);
		tokenList=t;
		allFiles=f;
		
	}
	public String setPath(String p1)
	{
		return path=p1;
	}
	//get the path of the files
	public String getPath()
	{
		return path;
	}

	//get the tokens and store them in a list
	List<Token> getTokens()
	{
		//int ind=in;
		//List<Token> tokenList= new ArrayList<>();
		tokenList.add(new Token("if",1,1));
		tokenList.add(new Token("<",1,2));
		tokenList.add(new Token("=",1,2));
		
		return tokenList;
	}
	//get the list containing source files and tokens
	public List<CPPSourceFiles> getSourceFiles()
	{ 
		String p="/home/zeil/projects/cppProject1/src/foo.cpp";
		List<String>Source=new ArrayList<>();
		Source.add(p);
		List<CPPSourceFiles> resultsSrc= new ArrayList<>();
		List<Token>tokens=new ArrayList<>();
		tokens.add(new Token("else",1,1));
		tokens.add(new Token("<",1,2));
		tokens.add(new Token("=",1,2));
		File testFile=new File(getPath());
		List<File>f=new ArrayList<>();
		f.add(testFile);
		resultsSrc.add(new CPPSourceFiles(p,Source,tokens,f));
		return resultsSrc;
		
	}
	 public void listFiles(String startingDir)
	 {
		 //this section of code is modified from a recursive file retrieval https://stackabuse.com/java-list-files-in-a-directory/
		 File dire = new File(startingDir);
		 File[] files = dire.listFiles();
		 if(files != null && files.length >0)
		 {
			 for (File file: files)
			 {
				 if(file.isDirectory())
				 {
					 listFiles(file.getAbsolutePath());
					allFiles.add(file);
				 }
				 else
				 {
					 allFiles.add(file);
				 }
			 }
		 }
	 }
}
