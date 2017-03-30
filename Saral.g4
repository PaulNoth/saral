grammar Saral;

INDENT : '{' ;
DEDENT : '}' ;

statements : statement* EOF;
block : INDENT simpleStatement* DEDENT;

statement : simpleStatement
            | block_statement;

simpleStatement : (write | variable | proc_call);
block_statement : proc_definition;
proc_definition : FUNCTION ID LPAR arglist RPAR block;
arglist : (arg (',' arg)*)?;
arg : TYPE ID ;

variable : VARIABLE TYPE ID EQUALS value;
write : PRINT ID ;
proc_call: PROC_CALL ID LPAR paramlist RPAR;
paramlist: (var (',' var)*)? ;
var: ID;

value : NUMBER
      | STRING ;
TYPE : STRING_T
     | INT_T;

FUNCTION: 'bar';
PROC_CALL : 'paľ do baru';
LPAR : '(';
RPAR : ')';
INT_T : 'neskutočné numeralio';
STRING_T : 'slovo';
VARIABLE : 'meňak' ;
PRINT : 'ciskaj' ;
EQUALS : '=' ;
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9ľščťžýáíéäúôóďĺĽŠČŤŽÝÁÍÉÄÚÔÓĎĹ]+ ;
WS: [ \t\n\r]+ -> skip ;
