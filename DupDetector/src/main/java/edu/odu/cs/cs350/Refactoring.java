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
	
	/*static void reportPart0()
	{
		System.out.print("Opportunity ");
		System.out.print(SequenceOfTokens.getOpportunity());
		System.out.print(", ");
		System.out.print(SequenceOfTokens.getSequenceSize());
		System.out.print(" tokens");
	}*/


public static void main(String[] argv) throws FileNotFoundException
{
	CPPSourceFiles K = new CPPSourceFiles();
	//reportPart0();
	ReportPart1(K);
}
}