package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
//import edu.odu.cs.cs350.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
class UnitTest {

	@Test
	void tokenConstructor() {
		Token t= new Token("else",1,1);
		assertEquals(t.column,1);
		assertEquals(t.line,1);
		assertEquals(t.lex,"else");
		
		
	}
	@Test
	void tokenDefaultConstructor()
	{
		Token t2= new Token();
		assertEquals(t2.column,0);
		assertEquals(t2.line,0);
		assertEquals(t2.lex," ");
		
	}
	@Test
	void CPPSourceDefaultConstructor()
	{
		CPPSourceFiles c1= new CPPSourceFiles();
		assertEquals(c1.getPath(),"");
		assertEquals(c1.getSourceFiles(),null);
		assertEquals(c1.getTokens(),null);
	}
	@Test 
	void CPPSourceFileConstructor()
	{
		String p="/home/zeil/projects/cppProject1/src/foo.cpp";
		File f=new File(p);
		List<File>files=new ArrayList<>();
		files.add(f);
		List<String>Source=new ArrayList<>();
		Source.add(p);
		List<Token>tokens=new ArrayList<>();
		tokens.add(null);
		tokens.add(new Token("else",1,1));
		tokens.add(new Token("<",1,2));
		tokens.add(new Token("=",1,2));
		CPPSourceFiles c2= new CPPSourceFiles(p,Source,tokens,files);
		assertEquals(c2.getPath(),p);
		assertEquals(c2.getSourceFiles(),Source);
		assertEquals(c2.getTokens(),tokens);
		
	}
	//I made a set path function so I have to test it
    @Test 
    void testSetPath()
    {
    	String p="/home/zeil/projects/cppProject1/src/foo.cpp";
		File f=new File(p);
		List<File>files=new ArrayList<>();
		files.add(f);
		List<String>Source=new ArrayList<>();
		Source.add(p);
		List<Token>tokens=new ArrayList<>();
		tokens.add(null);
		tokens.add(new Token("else",1,1));
		tokens.add(new Token("<",1,2));
		tokens.add(new Token("=",1,2));
		CPPSourceFiles c2= new CPPSourceFiles(p,Source,tokens,files);
		c2.setPath("/home/cs_arobe022/CS350");
		assertEquals(c2.getPath(),"/home/cs_arobe022/CS350");
    }

	@Test
	void testAddFile() 
	{
		String p="/home/cs_arobe022/CS350";
		File f=new File(p);
		List<File>files=new ArrayList<>();
		files.add(f);
		List<String>Source=new ArrayList<>();
		Source.add(p);
		List<Token>tokens=new ArrayList<>();
		tokens.add(null);
		tokens.add(new Token("else",1,1));
		tokens.add(new Token("<",1,2));
		tokens.add(new Token("=",1,2));
		CPPSourceFiles c3= new CPPSourceFiles(p,Source,tokens,files);
		Refactoring.listFiles(c3, p);
		for(int i=0;i<c3.allFiles.size();i++)
		{
			assertEquals(c3.allFiles.get(i).getAbsolutePath(),files.get(i).getAbsolutePath());
		}
	
	}
	
	@Test
	void testfileType()	//testing the file type checker
	{
		String c = "/home/yes.cpp";
		String h = "/home/yes.h";
		String d = "/home";
		String x = "/home.x";
		
		char cpptest = Refactoring.fileType(c);
		char htest = Refactoring.fileType(h);
		char dirtest = Refactoring.fileType(d);
		char errortest = Refactoring.fileType(x);
		
		assertEquals(cpptest, 'c');
		assertEquals(htest, 'h');
		assertEquals(dirtest, 'd');
		assertEquals(errortest, 'x');
		
	}
	@Test
	void TestTokenization() throws IOException
	{
    	String p="/home/cs_arobe022/CS361/list_polyfact/term.cpp";
		File f=new File(p);
		File f2=new File(p);
		FileReader fileReader = new FileReader(f);
		SequenceOfTokens T = new SequenceOfTokens(fileReader);
		fileReader.close();
		FileReader fileReader2 = new FileReader(f2);
		SequenceOfTokens T2 = new SequenceOfTokens(fileReader2);
		fileReader.close();
		for(int i=0; i<T.sequenceOfLexemes.size();i++) {
			assertEquals(T.sequenceOfLexemes.get(i).lex,T2.sequenceOfLexemes.get(i).lex);
			assertEquals(T.sequenceOfLexemes.get(i).line,T2.sequenceOfLexemes.get(i).line);
			assertEquals(T.sequenceOfLexemes.get(i).column, T.sequenceOfLexemes.get(i).column);
		}
	}

}
 
 