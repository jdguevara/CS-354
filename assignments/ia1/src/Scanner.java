// This class is a scanner for the program
// and programming language being interpreted.

// Modified by: Jaime Guevara

import java.util.*;

public class Scanner {

    private String program;	// source program being interpreted
    private int pos;		// index of next char in program
    private Token token;	// last/current scanned token

    // sets of various characters and lexemes
    private Set<String> whitespace=new HashSet<String>();
    private Set<String> digits=new HashSet<String>();
    private Set<String> letters=new HashSet<String>();
    private Set<String> legits=new HashSet<String>();
    private Set<String> keywords=new HashSet<String>();
    private Set<String> operators=new HashSet<String>();
    
    // Additional sets for comments and signs
    private Set<String> comments=new HashSet<String>();
    private Set<String> signs=new HashSet<String>();
    
    // initializers for previous sets
    private void fill(Set<String> s, char lo, char hi) {
	for (char c=lo; c<=hi; c++)
	    s.add(c+"");
    }    

    private void initWhitespace(Set<String> s) {
	s.add(" ");
	s.add("\n");
	s.add("\t");
    }

    private void initDigits(Set<String> s) {
	fill(s,'0','9');
    }

    private void initLetters(Set<String> s) {
	fill(s,'A','Z');
	fill(s,'a','z');
    }

    private void initLegits(Set<String> s) {
	s.addAll(letters);
	s.addAll(digits);
    }

    private void initOperators(Set<String> s) {
	s.add("=");
	s.add("+");
	s.add("-");
	s.add("*");
	s.add("/");
	s.add("(");
	s.add(")");
	s.add(";");
    }

    private void initKeywords(Set<String> s) {
    }
    
    /**
     * used to register symbols 
     * that denote comments
     * in a Java program
     * 
     * @param s - set string holding our comment characters
     */
    private void initComments(Set<String> s) {
    	s.add("//"); // Single line comments
    	s.add("/*"); // Beginning of block comment
    	s.add("/**"); // Beginning of Javadoc
    	s.add("*/"); // End of block comment or Javadoc
    }
    
    /**
     * This is used to help with the implementation of
     * the unary minus operator so the scanner can tell
     * if a number is negative or not.
     * 
     * @param s - string holding our sign characters
     */
    private void initSigns(Set<String> s) {
    	s.add("-");
    }

    // constructor:
    //   - squirrel-away source program
    //   - initialize sets
    public Scanner(String program) {
	this.program=program;
	pos=0;
	token=null;
	initWhitespace(whitespace);
	initDigits(digits);
	initLetters(letters);
	initLegits(legits);
	initKeywords(keywords);
	initOperators(operators);
	initComments(comments); // Initializing comments
	initSigns(signs); // Initializing signs
    }

    // handy string-processing methods

    public boolean done() {
	return pos>=program.length();
    }

    private void many(Set<String> s) {
	while (!done() && s.contains(program.charAt(pos)+""))
	    pos++;
    }
    
    private void past(char c) {
	while (!done() && c!=program.charAt(pos))
	    pos++;
	if (!done() && c==program.charAt(pos))
	    pos++;
    }

    // scan various kinds of lexeme
    private void nextNumber() {
	int old=pos;
	many(digits);
	token=new Token("num",program.substring(old,pos));
    }

    private void nextKwId() {
	int old=pos;
	many(letters);
	many(legits);
	String lexeme=program.substring(old,pos);
	token=new Token((keywords.contains(lexeme) ? lexeme : "id"),lexeme);
    }

    private void nextOp() {
	int old=pos;
	pos=old+2;
	if (!done()) {
	    String lexeme=program.substring(old,pos);
	    if (operators.contains(lexeme)) {
		token=new Token(lexeme); // two-char operator
		return;
	    }
	}
	pos=old+1;
	String lexeme=program.substring(old,pos);
	token=new Token(lexeme); // one-char operator
    }
    
    /**
     * Looking to see if our next string will be a comment or not
     */
    private void nextComm() {
    	int old=pos;
    	pos = old+2; // We need to take the first two characters to see if what we have is a comment (i.e. // or /*)
    	many(comments);
    	// Check for different comment types and turn them to whitespace
    	String lexeme;
    	lexeme=program.substring(old,pos);
    	if (lexeme.matches("//")) { // Single-line comment
    		while(!done()) { // While the character at the given position does not equal a 
    			lexeme=program.substring(old,pos);
    			pos++;
    		}
    		lexeme=program.substring(old,pos);
    	} else if (lexeme.matches("/\\*") && !program.substring(old,pos+1).matches("/\\*\\*")) { // Regular comment block
    		while(!lexeme.endsWith("*/")) {
    			pos++;
    			lexeme=program.substring(old,pos);
    		}
    		lexeme=program.substring(old,pos);
    	} else if (program.substring(old, pos+1).matches("/\\*\\*")) { // Javadoc check
    		pos=pos+1;
    		lexeme=program.substring(old,pos);
    		while(!lexeme.endsWith("*/")) {
    			pos++;
    			lexeme=program.substring(old,pos);
    		}
    	}
    
    	// Check to see if we have more content after the commment, if we don't then set the Token as being "comment"
    	// Else if we do then move on and get try to find where we have a legit assignment to act on.
    	if (done()) {
    		token = new Token("comment");
    	} else {
    		next();
    	}
    }
    
    /**
     * Takes the next number based on sign and turns it into a token
     */
    private void nextSign() {
    	int old=pos;
    	pos=old+2;
    	String lexeme = program.substring(old,pos);
    	while (!done() && !lexeme.endsWith("-") && !lexeme.endsWith("+") && !lexeme.endsWith("*") && !lexeme.endsWith("/") && !lexeme.endsWith(";")) {
    		pos++;
    		lexeme = program.substring(old,pos);
    	}
    	pos--;
    	lexeme = program.substring(old,pos);
    	token=new Token("num",program.substring(old,pos));; // taking our next token to be 2 characters
    }
    
    // This method determines the kind of the next token (e.g., "id"),
    // and calls a method to scan that token's lexeme (e.g., "foo").
    public boolean next() {
	if (done())
	    return false;
	many(whitespace);
	String c=program.charAt(pos)+"";
	if (comments.contains(c+"/") || comments.contains(c + "*") || comments.contains(c+"**"))
		nextComm();
	else if (digits.contains(c))
	    nextNumber();
	else if (letters.contains(c))
	    nextKwId();
	else if (signs.contains(c))
		nextSign();
	else if (operators.contains(c))
	    nextOp();
	else {
	    System.err.println("illegal character at position "+pos);
	    pos++;
	    return next();
	}
	return true;
    }

    // This method scans the next lexeme,
    // if the current token is the expected token.
    public void match(Token t) throws SyntaxException {
	if (!t.equals(curr()))
	    throw new SyntaxException(pos,t,curr());
	next();
    }

    public Token curr() throws SyntaxException {
	if (token==null)
	    throw new SyntaxException(pos,new Token("ANY"),new Token("EMPTY"));
	return token;
    }

    public int pos() { return pos; }

    // for unit testing
    public static void main(String[] args) {
	try {
	    Scanner scanner=new Scanner(args[0]);
	    while (scanner.next())
		System.out.println(scanner.curr());
	} catch (SyntaxException e) {
	    System.err.println(e);
	}
    }

}
