grammar Saral;

//parser rules
statements : statement* EOF;
statement : simpleStatement;

simpleStatement : (write | variable);
variable : VARIABLE TYPE ID EQUALS value;
write : PRINT ID ;
value : NUMBER
      | STRING ;
TYPE : STRING_T
     | INT_T;

//lexer rules (tokens)
INT_T : 'neskutočné numeralio';
STRING_T : 'slovo';
VARIABLE : 'meňak' ; //VARIABLE TOKEN must match exactly 'var'
PRINT : 'ciskaj' ;
EQUALS : '=' ; //must be '='
NUMBER : [0-9]+ ; //must consist only of digits
STRING : '"'.*'"' ; //must be anything in qutoes
ID : [a-zA-Z0-9ľščťžýáíéäúôóďĺĽŠČŤŽÝÁÍÉÄÚÔÓĎĹ]+ ; //must be any alphanumeric value
WS: [ \t\n\r]+ -> skip ; //special TOKEN for skipping whitespaces
