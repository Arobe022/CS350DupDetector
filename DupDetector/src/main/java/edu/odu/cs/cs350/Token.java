package edu.odu.cs.cs350;
import java.util.List;
public class Token {
	//private TokenKinds kind;
	protected int line;
	protected int column;
	protected String lex;
	private TokenKinds kind;
	
	//default token constructor
	
	public Token (final TokenKinds theKind, final int lineN, final int columnN) {
		kind=theKind;
		lex="";
		line=lineN;
		column=columnN;
		
	}
	public Token (final TokenKinds theKind, final int lineN, final int columnN,
			final String theLexeme) {
		kind=theKind;
		lex=theLexeme;
		line=lineN;
		column=columnN;
		
		
	}
	public Token()
	{
		
		lex="x";
		column=0;
		line=0;
		
	}
	//token constructor for real
	public Token(String s,int col, int l)
	{
		
		lex=s;
		column=col;
		line=l;
		
	}
	//get the kind of token
    public final TokenKinds getKind() {
        return kind;
    }

	//get the lexemes
	public final String getLexemes() {
		return lex;
		
	}
//get the line #
	public int getLine() {	//gets the token's line, I need this - bryan
		
		return line;
		
	}
	//get the column #
	public int getColumn() {//gets the token's collumn, i also need this -bryan
		
		return column;
	}

@Override
public final String toString() {
    if (getLexemes().length() > 0) {
        return getKind() + ":" + getLexemes();
    } else {
        return getKind().toString();
    }
}
}



