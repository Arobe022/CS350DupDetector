package edu.odu.cs.cs350;

import static org.junit.jupiter.api.Assertions.*;
import edu.odu.cs.cs350.*;

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

}
 
 