grammar Saral;

INDENT : '{' ;
DEDENT : '}' ;

init : statements ;

statements : statement*;
block : INDENT statements DEDENT;
func_block : INDENT statements ret DEDENT;
ret: RET ID ;

statement : simpleStatement
            | block_statement;

simpleStatement : (write | variable | proc_call | func_call);
block_statement : proc_definition | func_definition;
proc_definition : FUNCTION ID LPAR arglist RPAR block;
func_definition : FUNCTION TYPE ID LPAR arglist RPAR func_block;
arglist : (arg (',' arg)*)?;
arg : TYPE ID ;

variable : VARIABLE TYPE ID EQUALS value;
write : PRINT ID ;
proc_call: PROC_CALL ID LPAR paramlist RPAR;
func_call: FUNC_CALL ID LPAR paramlist RPAR;
paramlist: (var (',' var)*)? ;
var: ID;

value : NUMBER
      | STRING ;
TYPE : STRING_T
     | INT_T;

FUNCTION: 'bar';
PROC_CALL : 'paľ do baru';
FUNC_CALL : 'vrac z baru';
LPAR : '(';
RPAR : ')';
INT_T : 'neskutočné numeralio';
STRING_T : 'slovo';
VARIABLE : 'meňak' ;
PRINT : 'ciskaj' ;
EQUALS : '=' ;
RET : 'vrac';
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9ľščťžýáíéäúôóďĺĽŠČŤŽÝÁÍÉÄÚÔÓĎĹ]+ ;
WS: [ \t\n\r]+ -> skip ;
