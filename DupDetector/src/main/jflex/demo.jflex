/**
 * jflex demo: generating and returning tokens
 *
 * This is a very simple language. It has identfiers,
 * integer literals, and a single keyword.
 *
 *
 * Steven J Zeil
 */


package edu.odu.cs.cs350;
import static edu.odu.cs.cs350.TokenKinds.*;
//@SuppressWarnings("unused")

%%

%public
%class GeneratedScanner


%line
%column

%type Token

%{
  StringBuilder string = new StringBuilder();
  
  private Token symbol(TokenKinds type) {
    return new Token(type, yyline+1, yycolumn+1);
  }

    private Token symbol(TokenKinds type, String value) {
    return new Token(type, yyline+1, yycolumn+1, value);
  }
  
 private long parseLong(int start, int end, int radix) {
    long result = 0;
    long digit;

    for (int i = start; i < end; i++) {
      digit  = Character.digit(yycharat(i),radix);
      result*= radix;
      result+= digit;
    }

    return result;
  }

%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} | 
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"


/* identifiers */
Identifier = [:jletter:][:jletterdigit:]*

/* integer literals */
IntegerLiteral = [0-9][0-9]* | [0-9][_0-9]*[0-9]

/* integer literals */
DecIntegerLiteral = 0 | [1-9][0-9]*
DecLongLiteral    = {DecIntegerLiteral} [lL]

HexIntegerLiteral = 0 [xX] 0* {HexDigit} {1,8}
HexLongLiteral    = 0 [xX] 0* {HexDigit} {1,16} [lL]
HexDigit          = [0-9a-fA-F]

OctIntegerLiteral = 0+ [1-3]? {OctDigit} {1,15}
OctLongLiteral    = 0+ 1? {OctDigit} {1,21} [lL]
OctDigit          = [0-7]
    
/* floating point literals */        
FloatLiteral  = ({FLit1}|{FLit2}|{FLit3}) {Exponent}? [fF]
DoubleLiteral = ({FLit1}|{FLit2}|{FLit3}) {Exponent}?

FLit1    = [0-9]+ \. [0-9]* 
FLit2    = \. [0-9]+ 
FLit3    = [0-9]+ 
Exponent = [eE] [+-]? [0-9]+
/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]
%state STRING, CHARLITERAL

%%


  /* keywords */
  "KEYWORD"                     { return symbol(TokenKinds.KEYWORD); }
  
  
  {IntegerLiteral}            { return symbol(TokenKinds.INTEGER_LITERAL, yytext()); }

  {Identifier}                   { return symbol(TokenKinds.IDENTIFIER, yytext()); } 
  
{WhiteSpace}                  {/* Ignore: don't return anything. */}

<YYINITIAL> {

  /* keywords */
  "abstract"                     { return symbol(TokenKinds.ABSTRACT); }
  "boolean"                      { return symbol(TokenKinds.BOOL); }
  "break"                        { return symbol(TokenKinds.BREAK); }
  "byte"                         { return symbol(TokenKinds.BYTE); }
  "case"                         { return symbol(TokenKinds.CASE); }
  "catch"                        { return symbol(TokenKinds.CATCH); }
  "char"                         { return symbol(TokenKinds.CHAR); }
  "class"                        { return symbol(TokenKinds.CLASS); }
  "const"                        { return symbol(TokenKinds.CONST); }
  "continue"                     { return symbol(TokenKinds.CONTINUE); }
  "do"                           { return symbol(TokenKinds.DO); }
  "double"                       { return symbol(TokenKinds.DOUBLE); }
  "else"                         { return symbol(TokenKinds.ELSE); }
  "extends"                      { return symbol(TokenKinds.EXTENDS); }
  "final"                        { return symbol(TokenKinds.FINAL); }
  "finally"                      { return symbol(TokenKinds.FINALLY); }
  "float"                        { return symbol(TokenKinds.FLOAT); }
  "for"                          { return symbol(TokenKinds.FOR); }
  "default"                      { return symbol(TokenKinds.DEFAULT); }
  "implements"                   { return symbol(TokenKinds.IMPLEMENTS); }
  "import"                       { return symbol(TokenKinds.IMPORT); }
  "instanceof"                   { return symbol(TokenKinds.INSTANCEOF); }
  "int"                          { return symbol(TokenKinds.INT); }
  "interface"                    { return symbol(TokenKinds.INTERFACE); }
  "long"                         { return symbol(TokenKinds.LONG); }
  "native"                       { return symbol(TokenKinds.NATIVE); }
  "new"                          { return symbol(TokenKinds.NEW); }
  "goto"                         { return symbol(TokenKinds.GOTO); }
  "if"                           { return symbol(TokenKinds.IF); }
  "public"                       { return symbol(TokenKinds.PUBLIC); }
  "short"                        { return symbol(TokenKinds.SHORT); }
  "super"                        { return symbol(TokenKinds.SUPER); }
  "switch"                       { return symbol(TokenKinds.SWITCH); }
  "synchronized"                 { return symbol(TokenKinds.SYNCHRONIZED); }
  "package"                      { return symbol(TokenKinds.PACKAGE); }
  "private"                      { return symbol(TokenKinds.PRIVATE); }
  "protected"                    { return symbol(TokenKinds.PROTECTED); }
  "transient"                    { return symbol(TokenKinds.TRANSIENT); }
  "return"                       { return symbol(TokenKinds.RETURN); }
  "void"                         { return symbol(TokenKinds.VOID); }
  "static"                       { return symbol(TokenKinds.STATIC); }
  "while"                        { return symbol(TokenKinds.WHILE); }
  "this"                         { return symbol(TokenKinds.THIS); }
  "throw"                        { return symbol(TokenKinds.THROW); }
  "throws"                       { return symbol(TokenKinds.THROWS); }
  "try"                          { return symbol(TokenKinds.TRY); }
  "volatile"                     { return symbol(TokenKinds.VOLATILE); }
  "strictfp"                     { return symbol(TokenKinds.STRICTFP); }

/* separators */  
"("                            { return symbol(TokenKinds.LPAREN); }
  ")"                            { return symbol(TokenKinds.RPAREN); }
  "{"                            { return symbol(TokenKinds.LBRACE); }
  "}"                            { return symbol(TokenKinds.RBRACE); }
  "["                            { return symbol(TokenKinds.LBRACK); }
  "]"                            { return symbol(TokenKinds.RBRACK); }
  ";"                            { return symbol(TokenKinds.SEMICOLON); }
  ","                            { return symbol(TokenKinds.COMMA); }
  "."                            { return symbol(TokenKinds.DOT); }
 
  
  /* operators */
  "="                            { return symbol(TokenKinds.EQ); }
  ">"                            { return symbol(TokenKinds.GT); }
  "<"                            { return symbol(TokenKinds.LT); }
  "!"                            { return symbol(TokenKinds.NOT); }
  "~"                            { return symbol(TokenKinds.COMP); }
  "?"                            { return symbol(TokenKinds.QUESTION); }
  ":"                            { return symbol(TokenKinds.COLON); }
  "=="                           { return symbol(TokenKinds.EQEQ); }
  "<="                           { return symbol(TokenKinds.LTEQ); }
  ">="                           { return symbol(TokenKinds.GTEQ); }
  "!="                           { return symbol(TokenKinds.NOTEQ); }
  "&&"                           { return symbol(TokenKinds.ANDAND); }
  "||"                           { return symbol(TokenKinds.OROR); }
  "++"                           { return symbol(TokenKinds.PLUSPLUS); }
  "--"                           { return symbol(TokenKinds.MINUSMINUS); }
  "+"                            { return symbol(TokenKinds.PLUS); }
  "-"                            { return symbol(TokenKinds.MINUS); }
  "*"                            { return symbol(TokenKinds.MULT); }
  "/"                            { return symbol(TokenKinds.DIV); }
  "&"                            { return symbol(TokenKinds.AND); }
  "|"                            { return symbol(TokenKinds.OR); }
  "^"                            { return symbol(TokenKinds.XOR); }
  "%"                            { return symbol(TokenKinds.MOD); }
  "<<"                           { return symbol(TokenKinds.LSHIFT); }
  ">>"                           { return symbol(TokenKinds.RSHIFT); }
  ">>>"                          { return symbol(TokenKinds.URSHIFT); }
  "+="                           { return symbol(TokenKinds.PLUSEQ); }
  "-="                           { return symbol(TokenKinds.MINUSEQ); }
  "*="                           { return symbol(TokenKinds.MULTEQ); }
  "/="                           { return symbol(TokenKinds.DIVEQ); }
  "&="                           { return symbol(TokenKinds.ANDEQ); }
  "|="                           { return symbol(TokenKinds.OREQ); }
  "^="                           { return symbol(TokenKinds.XOREQ); }
  "%="                           { return symbol(TokenKinds.MODEQ); }
  "<<="                          { return symbol(TokenKinds.LSHIFTEQ); }
  ">>="                          { return symbol(TokenKinds.RSHIFTEQ); }
  ">>>="                         { return symbol(TokenKinds.URSHIFTEQ); }
  "#" 							 { return symbol(TokenKinds.HASH);}

 
}


  
/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return symbol(TokenKinds.EOF); }
