package edu.odu.cs.cs350;
import java.util.*;
public class CPPSourceFiles {
	protected static List<String>src;
	protected static List<Token>tokenList;
	protected static String path;
	//default constructor
	public CPPSourceFiles ()
	{
		src=null;
		path ="";
	}
	//realsies constructor
	public CPPSourceFiles(String p1,List<String>source,List<Token>t)
	{	
		path=p1;
		src=source;
		tokenList=t;
		
	}
	//get the path of the files
	public String getPath()
	{
		path="/home/zeil/projects/cppProject1/src/foo.cpp";
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
		resultsSrc.add(new CPPSourceFiles(p,Source,tokens));
		return resultsSrc;
		
	}
}
