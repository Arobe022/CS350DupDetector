package edu.odu.cs.cs350;
import java.util.List;
public class Token {
	protected String token;
	List<Token>tokenList;
	public Token ()
	{
		token="";
	}
	public Token(String s)
	{
		token=s;
	}
	public Token getTokens() {
		return this;
	}

}
