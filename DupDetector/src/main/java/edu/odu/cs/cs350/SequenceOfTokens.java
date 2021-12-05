package edu.odu.cs.cs350;

import java.io.Reader;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

public class SequenceOfTokens implements Iterable<Token>{
	private static int sequenceSize;
	private static int opportunity;
	int nSuggestions;
	//private static String refactoredToken;
	static List<Token>sequenceOfLexemes;
	public SequenceOfTokens()
	{
		sequenceSize=3;
		opportunity=2;
		List<Token>temp=new ArrayList<>();
		temp.add(new Token("x",1,1));
		temp.add(new Token("y",1,2));
		temp.add(new Token("y",1,2));
		sequenceOfLexemes=temp;
	}
	
	public SequenceOfTokens(final FileReader input) {
        sequenceOfLexemes = new LinkedList<Token>();
        GeneratedScanner scanner = new GeneratedScanner (input);
        try {
            Token token = scanner.yylex();
            while (token != null && token.getKind() != TokenKinds.EOF) {
                sequenceOfLexemes.add (token);
                token = scanner.yylex();
            }
        } catch (IOException ex) {
            // Not necessarily a problem, depending on the input source
        }
    }
	//get opportunity value
	int getOpportunity()
	{
		opportunity=2;
		return opportunity;
	}


	//get the size of the sequence
	public int getSequenceSize()
	{
		sequenceSize=6;
		return sequenceSize;
	}
	//get the sequence
	public static List<Token> getSequenceOfLexemes()
	{
		sequenceOfLexemes.add(new Token("x",1,1));
		sequenceOfLexemes.add(new Token("y",1,2));
		sequenceOfLexemes.add(new Token("1",1,2));
		return sequenceOfLexemes;
		
	}
	 @Override
	    public final Iterator<Token> iterator() {
	        return sequenceOfLexemes.iterator();
	    }

	
}
