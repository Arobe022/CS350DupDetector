package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
//import edu.odu.cs.cs350.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

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
		List<String>Source=new ArrayList<>();
		Source.add(p);
		List<Token>tokens=new ArrayList<>();
		tokens.add(null);
		tokens.add(new Token("else",1,1));
		tokens.add(new Token("<",1,2));
		tokens.add(new Token("=",1,2));
		CPPSourceFiles c2= new CPPSourceFiles(p,Source,tokens);
		assertEquals(c2.getPath(),p);
		assertEquals(c2.getSourceFiles(),Source);
		assertEquals(c2.getTokens(),tokens);
		
	}

}
 
 