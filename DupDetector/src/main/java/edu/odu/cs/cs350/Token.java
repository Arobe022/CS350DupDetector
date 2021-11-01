package edu.odu.cs.cs350;
import java.util.List;
public class Token {
	protected int line;
	protected int column;
	protected String lex;
	List<Token>tokenList;
	
	public Token ()
	{
		
		line=0;
		column=0;
		lex="";
		
	}
	public Token(String s,int col, int l)
	{
		
		lex=s;
		column=col;
		line=l;
		
	}
	public String getLexemes() {
		lex="a";
		return lex;
		
	}

	public int getLine() {	//gets the token's line, I need this - bryan
		line=0;
		return line;
		
	}
	
	public int getColumn() {//gets the token's collumn, i also need this -bryan
		column=0;
		return column;
	}
}
