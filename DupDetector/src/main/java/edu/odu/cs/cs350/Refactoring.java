package edu.odu.cs.cs350;
import java.util.*;
import java.io.*;
public class Refactoring {

	static void ReportPart1(CPPSourceFiles Cpp)
	{
		List<CPPSourceFiles>allSources=Cpp.getSourceFiles();
		System.out.print("Files Scanned:");
		System.out.print(System.lineSeparator());
		for(int i=0; i<allSources.size(); i++)
		{
			System.out.print(allSources.get(i).getPath());
			System.out.print(", ");
			System.out.print(allSources.get(i).getTokens().size());
		
		}
		System.out.print(System.lineSeparator());
	}
	

	////output an opportunity; including its number, # of tokens, path/co-ords, and the lexemes
	//added code to have the path and lexemes be printed out, still stubby
	static void ReportPart2(CPPSourceFiles Cpp, SequenceOfTokens Tokens)
	{
		//List<CPPSourceFiles>allSources=Cpp.getSourceFiles(); //uuh
		Token removeMe = new Token;	//i should not need this but i do for now, delete it later once sequence of tokens contains tokens.
		
		//make loopy when not stubby???
		//for(int i=0; i<allSources.size(); i++)	//start of big loop
		//{
		//output opportunity and token#
		System.out.print("Opportunity "); //words
		System.out.print(Tokens.getOpportunity()); //opportunity number
		System.out.print(", "); //text
		System.out.print(Tokens.getSequenceSize()); //how many tokens lol
		System.out.print(" tokens"); //words
		System.out.print(System.lineSeparator()); //endline
		
		//System.out.print(allSources.get(i).getPath());
		
		//output the path and token coordinates -bryan
		System.out.print(Cpp.getPath()); //output paths
		System.out.print(":");	//colon
		System.out.print(removeMe.getLine());//print line#
		System.out.print(":");	//colon
		System.out.print(removeMe.getColumn);	//print column#
		System.out.print(System.lineSeparator()); //endline
		
		List<String> Lexmemes = new ArrayList<>(Tokens.getSequenceOfLexemes());	//i shouldn't have to do this but the stubs have sequence of tokens
																				//stored as a list in itself instead of containing a list of the tokens that could have their lexemes acceded through them
																				//-bryan
		//print the list
		for (int i; i < Lexmemes.size(); i++)
		{
			System.out.print(Lexmemes.get(i));
			System.out.print(" ");
		}
		System.out.print(System.lineSeparator()); //endline
		
		
		//}	//end brackat for big loop
	}

public static void main(String[] argv) throws FileNotFoundException
{
	CPPSourceFiles K = new CPPSourceFiles();
	
	SequenceOfTokens T = new SequenceOfTokens(); //stubs in here, i need them, also shouldn't the SequenceOfTokens class contain a list of tokens instead of 
													//token having a list of tokens?
	//reportPart0();
	ReportPart1(K, T);
	
}
}