package edu.odu.cs.cs350;

import java.util.*;

public class SequenceOfTokens {
	private static int sequenceSize;
	private static int opportunity;
	//private static String refactoredToken;
	static List<String>sequenceOfLexemes;
	
	//get opportunity value
	int getOpportunity()
	{
		opportunity=2;
		return opportunity;
	}
	//get the size of the sequence
	public int getSequenceSize()
	{
		sequenceSize=3;
		return sequenceSize;
	}
	//get the sequence
	public static List<String> getSequenceOfLexemes()
	{
		sequenceOfLexemes.add("x");
		sequenceOfLexemes.add("y");
		sequenceOfLexemes.add("1");
		return sequenceOfLexemes;
		
	}
	
}
