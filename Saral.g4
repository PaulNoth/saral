grammar Saral;

INDENT : '__INDENT';
DEDENT : '__DEDENT';

init : statements ;

statements : statement*;
block : INDENT statements DEDENT;
func_block : INDENT statements ret DEDENT;
ret: RET expression EOL;

statement
	: simple_statement EOL
	| block_statement EOL?
	;

simple_statement : write
                 | write2
                 | read
                 | read2
                 | var_definition
                 | assignment
                 | var_declaration
                 | const_definition
                 | array_declaration
                 | proc_call
                 | func_call
                 ;
block_statement : proc_definition
                | if_statement
                | while_statement
                | func_definition
                | for_statement
                | block;
proc_definition : FUNCTION ID LPAR arglist RPAR EOL block;
func_definition : FUNCTION typeBasic ID LPAR arglist RPAR EOL func_block;
arglist : (type ID (',' type ID)*)? ;

if_statement
	: IF expression THEN EOL block (ELSE EOL block)?
	;

while_statement
	: WHILE expression DO EOL block
	;

for_statement
	: FOR var FROM val TO val EOL block
	;

var_definition : VARIABLE type ID '=' expression;
var_declaration
	: VARIABLE type ID
	;
const_definition
	: CONST type ID '=' expression
	;
array_declaration
    : typeArray ID LBRACK expression RBRACK
    ;

write : 'ciskaj' var ;
write2
	: 'povidz' var
	;
read
	: 'vežmi' var
	;
read2
	: 'sluchaj' var
	;

proc_call: PROC_CALL ID LPAR paramlist RPAR;
func_call: FUNC_CALL ID LPAR paramlist RPAR;
paramlist: (var (',' var)*)? ;
var
	: ID # VarID
	| ID LBRACK expression RBRACK #VarArray
	;

val : var # ValVar
    | INT # ValInt
    | FLOAT # ValFloat
    | STRING # ValString
    | CHAR # ValChar
    | BOOL # ValBool
    ;
expression : LPAR expression RPAR # Paren
           | func_call #Func
           | op=SUB expression # UnaryMinus
           | expression op=(MUL | DIV | MOD) expression # Mul
           | expression op=(ADD | SUB) expression # Add
           | expression op=(EQ | NE | LE | GE | GT | LT) expression # Compare
           | op=NOT expression # BoolNot
           | expression op=AND expression # BoolAnd
           | expression op=OR expression # BoolOr
           | val #Value
           ;
assignment
    : var '=' expression
    ;
type: typeArray
	| typeBasic
	;
typeArray
	: ARRAY typeBasic
	;
typeSimple
	: INT_T | BOOL_T | FLOAT_T | CHAR_T ;
typeBasic
	: typeSimple | STRING_T
	;

FUNCTION: 'bar';
PROC_CALL : 'paľ do baru';
FUNC_CALL : 'vrac z baru';

LPAR : '(';
RPAR : ')';
LBRACK: '[';
RBRACK: ']';

AND : 'a';
OR : 'abo';
NOT : 'ne';

ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/' | ':';
MOD: '%';

EQ: '==';
NE: '<>';
LE: '<=';
GE: '>=';
GT: '>';
LT: '<';

BOOL_T : 'logický';
INT_T : 'neskutočné numeralio';
FLOAT_T: 'skutočné numeralio';
CHAR_T: 'písmeno';
STRING_T: 'slovo';

VARIABLE : 'meňak' ;
WHILE : 'kým';
DO : 'rob';
CONST : 'furt';
ARRAY : 'dimenzion'? WS* 'funduš';

FOR : 'zrob s meňakom';
FROM : 'od';
TO : 'do';
RET : 'vrac';
IF : 'keď';
THEN : 'potom';
ELSE : 'inak';

BOOL : 'pravda' | 'ošaľ' | 'skoroošaľ';
INT : NUMBER;
FLOAT : NUMBER '.' DIGIT*;
STRING : '"' (~'"' | EOL)* '"';
CHAR : '\'' (~'\'') '\'';

NUMBER : '0' | [1-9]DIGIT*;
DIGIT : [0-9];

ID : '_'?(LETTER)(LETTER | DIGIT | '_')* ;
LETTER : [a-zA-ZľščťžýáíéäúôóďĺĽŠČŤŽÝÁÍÉÄÚÔÓĎĹ];
EMPTY_LINE : {getCharPositionInLine()==0}? ((' '|'\t')* COMMENT? EOL) -> skip ;
COMMENT: '//' ~[\r\n]* -> skip;

EOL : '\r'? '\n' | '\r';
WS : (' ' | '\t')+ -> skip;
