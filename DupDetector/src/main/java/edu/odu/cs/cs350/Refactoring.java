package edu.odu.cs.cs350;
import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

 
public class Refactoring {
	int nSuggestions;
	static class Node {    
	    File data; 
	        Node left, right; 
	          
	        Node(File data){ 
	            this.data = data; 
	            left = null; 
	            right = null; 
	        }}

//static List<File>allFiles;
		
	


	static void ReportPart1(CPPSourceFiles Cpp)
	{
		//part one of report
		List<CPPSourceFiles>allSources=Cpp.getSourceFiles();
		System.out.print("Files Scanned:");
		System.out.print(System.lineSeparator());
		for(int i=0; i<allSources.size(); i++)
		{
			System.out.print(allSources.get(i).getPath());
			System.out.print(", ");
			System.out.print(allSources.get(i).getTokens().size());
		
		}
		for(int i=0; i<Cpp.allFiles.size();i++)
		{
			System.out.print(Cpp.allFiles.get(i).getAbsolutePath());
		}
		System.out.print(System.lineSeparator());
	}
	

	////output an opportunity; including its number, # of tokens, path/co-ords, and the lexemes
	//added code to have the path and lexemes be printed out, still stubby
	static void ReportPart2(CPPSourceFiles Cpp, SequenceOfTokens Tokens)
	{
		//List<CPPSourceFiles>allSources=Cpp.getSourceFiles(); //uuh
		Token removeMe = new Token();	//i should not need this but i do for now, delete it later once sequence of tokens contains tokens.
		
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
		System.out.print(removeMe.getColumn());	//print column#
		System.out.print(System.lineSeparator()); //endline
		
		List<Token> Lexmemes = new ArrayList<>(SequenceOfTokens.getSequenceOfLexemes());	//i shouldn't have to do this but the stubs have sequence of tokens
																				//stored as a list in itself instead of containing a list of the tokens that could have their lexemes acceded through them
																				//-bryan
		//print the list
		for (int i=0; i < Lexmemes.size(); i++)
		{
			System.out.print(SequenceOfTokens.getSequenceOfLexemes().get(i).getLexemes());
			System.out.print(" ");
		}
		System.out.print(System.lineSeparator()); //endline
		
		
		//}	//end brackat for big loop
	}


 

public static void main(String[] args) throws FileNotFoundException
{
	List<String>Source=new ArrayList<>();
	int numSuggestions = Integer.parseInt(args[0]);
	for(int i=1; i<args.length; i++) {
	File inputFile = new File(args[1]);
	String inputString= args[1];
	Source.add(inputString);
	
	List<File>fileList=new ArrayList<>();
	fileList.add(inputFile);
	List<Token>tokens=new ArrayList<>();
	tokens.add(new Token("else",1,1));
	tokens.add(new Token("<",1,2));
	tokens.add(new Token("=",1,2));
	CPPSourceFiles K = new CPPSourceFiles(inputString,Source,tokens,fileList);
	//K.listFiles(inputString);
	
	//CPPSourceFiles K = new CPPSourceFiles();
	
	SequenceOfTokens T = new SequenceOfTokens(); //stubs in here, i need them, also shouldn't the SequenceOfTokens class contain a list of tokens instead of 
													//token having a list of tokens?
	//reportPart0();
	
	ReportPart1(K);
	ReportPart2(K, T);
	}
}
	}
	
