package edu.odu.cs.cs350;

import java.util.*;

public class SequenceOfTokens {
	private static int sequenceSize;
	private static int opportunity;
	static List<String>sequenceOfLexemes;
	
	static int getOpportunity()
	{
		opportunity=2;
		return opportunity;
	}
	
	public static int getSequenceSize()
	{
		sequenceSize=3;
		return sequenceSize;
	}
	public static List<String> getSequenceOfLexemes()
	{
		sequenceOfLexemes.add("x");
		sequenceOfLexemes.add("y");
		sequenceOfLexemes.add("1");
		return sequenceOfLexemes;
		
	}
	
}
