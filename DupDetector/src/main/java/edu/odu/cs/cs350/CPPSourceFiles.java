package edu.odu.cs.cs350;
import java.util.*;
public class CPPSourceFiles {
	protected static List<CPPSourceFiles>src;
	public String getPath()
	{
		return "/home/zeil/projects/cppProject1/src/foo.cpp";
	}
	List<Token> getTokens()
	{
		List<Token> results= new ArrayList<>();
		results.add(new Token("if",1,1));
		results.add(new Token("<",1,2));
		results.add(new Token("=",1,2));
		
		return results;
	}
	public static List getSourceFiles()
	{
		return src;
		
	}
}
