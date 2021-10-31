package edu.odu.cs.cs350;
import java.util.*;
public class CPPSourceFiles {
	protected static List<String>src;
	protected static String path;
	public CPPSourceFiles ()
	{
		src=null;
		path ="";
	}
	public CPPSourceFiles(String p1,List<String>source)
	{	
		path=p1;
		src=source;
		
	}
	public String getPath()
	{
		path="/home/zeil/projects/cppProject1/src/foo.cpp";
		return path;
	}
	List<Token> getTokens()
	{
		//int ind=in;
		List<Token> results= new ArrayList<>();
		results.add(new Token("if",1,1));
		results.add(new Token("<",1,2));
		results.add(new Token("=",1,2));
		
		return results;
	}
	public List<CPPSourceFiles> getSourceFiles()
	{ 
		path="/home/zeil/projects/cppProject1/src/foo.cpp";
		src.add(path);
		List<CPPSourceFiles> resultsSrc= new ArrayList<>();
		resultsSrc.add(new CPPSourceFiles(path,src));
		return resultsSrc;
		
	}
}
