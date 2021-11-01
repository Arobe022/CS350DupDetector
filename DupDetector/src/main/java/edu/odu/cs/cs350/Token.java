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
	//token constructor for real
	public Token(String s,int col, int l)
	{
		
		lex=s;
		column=col;
		line=l;
		
	}
	//get the lexemes
	public String getLexemes() {
		lex="a";
		return lex;
		
	}
//get the line #
	public int getLine() {	//gets the token's line, I need this - bryan
		line=0;
		return line;
		
	}
	//get the column #
	public int getColumn() {//gets the token's collumn, i also need this -bryan
		column=0;
		return column;
	}
}
