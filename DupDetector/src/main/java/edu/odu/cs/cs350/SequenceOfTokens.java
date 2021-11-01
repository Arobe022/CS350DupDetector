package edu.odu.cs.cs350;

import java.util.*;

public class SequenceOfTokens {
	private static int sequenceSize;
	private static int opportunity;
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
	
}
