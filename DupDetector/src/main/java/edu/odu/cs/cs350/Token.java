package edu.odu.cs.cs350;
import java.util.List;
public class Token {
	protected int line;
	protected int column;
	protected String lex;
	List<Token>tokenList;
	//default token constructor
	public Token ()
	{
		
		line=0;
		column=0;
		lex="";
		
	}
	//token constructor takes string, column and line #
	public Token(String s,int col, int l)
	{
		
		lex=s;
		column=col;
		line=l;
		
	}
	//get the lexemes
	public String getLexemes() {
		return lex;
		
	}

}
