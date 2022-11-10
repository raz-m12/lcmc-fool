grammar Exp;

@lexer::members {
public int lexicalErrors=0;
}

// PARSER RULES

prog : exp EOF {System.out.println("Parsing finished!");} ;

// (TIME | DIV) vuol dire che le produzioni hanno la stessa priorità
// L'utilizzo di grammatiche EBNF (Extended Backus-Naur Form)
// permette utilizzare gli operatori delle espressioni regolari dentro le produzioni
exp     : exp (TIMES | DIV) exp    #expProd1 // <assoc=right> exp TIMES exp
        | exp (PLUS | MINUS) exp   #expProd2 // <assoc=right> exp PLUS exp
        | LPAR exp RPAR            #expProd3
        | MINUS? NUM               #expProd4 // MINUS? vuol dire che minus è opzionale
        ;
          
// LEXER RULES

PLUS	: '+' ;
TIMES	: '*' ;
MINUS	: '-' ;	
DIV	    : '/' ;
LPAR    : '(' ;
RPAR    : ')' ;
// ? vuol dire che lo stringa è opzionale
// NUM     : '0' | '-'? ('1'..'9')('0'..'9')* ;
NUM     : '0' | ('1'..'9')('0'..'9')* ;

WHITESP	: (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN) ;
COMMENT : '/*' .*? '*/' -> channel(HIDDEN) ;

ERR 	: . {System.out.println("Invalid char: "+ getText()); lexicalErrors++;} -> channel(HIDDEN) ; 



