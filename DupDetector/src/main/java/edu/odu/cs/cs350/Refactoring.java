package edu.odu.cs.cs350;
import java.util.*;
import java.io.*;
public class Refactoring {
	//displays path and amount of tokens
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
	



public static void main(String[] argv) throws FileNotFoundException
{
	CPPSourceFiles K = new CPPSourceFiles();
	ReportPart1(K);
}
}