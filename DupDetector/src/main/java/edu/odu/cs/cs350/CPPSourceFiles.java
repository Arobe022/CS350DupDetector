package edu.odu.cs.cs350;
import java.util.*;
public class CPPSourceFiles {
	public String getPath()
	{
		return "test.cpp";
	}
	List<Token> getTokens()
	{
		List<Token> results= new ArrayList<>();
		results.add(new Token("if"));
		results.add(new Token("<"));
		results.add(new Token("="));
		
		return results;
	}
}
