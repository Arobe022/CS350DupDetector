package edu.odu.cs.cs350;
import java.util.*;
import java.nio.file.Files;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CPPSourceFiles {
	//list of c++ source files
	protected static List<String>src;
	protected static File directory;
	//list of all files
	protected List<File> allFiles;
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
	//set the path
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
		}

