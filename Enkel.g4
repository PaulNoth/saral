//header
grammar Enkel;

//parser rules
compilationUnit : classDeclaration EOF ;
classDeclaration : className '{' classBody '}' ;
className : ID ;
classBody : function* ;
function : functionDeclaration '{' (blockStatement)* '}' ;
functionDeclaration : (type)? functionName '(' (functionArgument)* ')' ;
functionName : ID ;
functionArgument : type ID functionParamDefaultValue? ;
functionParamDefaultValue : '=' expression ;
type : primitiveType
     | classType ;
primitiveType : 'boolean' ('[' ']')*
              | 'string' ('[' ']')*
              | 'char' ('[' ']')*
              | 'byte' ('[' ']')*
              | 'short' ('[' ']')*
              | 'int' ('[' ']')*
              | 'long' ('[' ']')*
              | 'float' ('[' ']')*
              | 'double' ('[' ']')*
              | 'void' ('[' ']')* ;
classType : QUALIFIED_NAME ('[' ']') ;

blockStatement : ( variableDeclaration | printStatement | functionCall );
variableDeclaration : VARIABLE name EQUALS expression;
printStatement : PRINT expression ;
functionCall : functionName '(' expressionList ')' ;
name : ID;
expressionList : expression (',' expression )*;
expression :
            varReference
           | value
           | functionCall
          // |  '('expression '*' expression')' #MULTIPLY
           //| expression '*' expression  #MULTIPLY
           //| '(' expression '/' expression ')' #DIVIDE
           //| expression '/' expression #DIVIDE
           //| '(' expression '+' expression ')' #ADD
           //| expression '+' expression #ADD
           //| '(' expression '-' expression ')' #SUBSTRACT
           //| expression '-' expression #SUBSTRACT
           ;
varReference : ID ;
value : NUMBER
      | STRING ;

//lexer rules (tokens)
VARIABLE : 'var' ; //VARIABLE TOKEN must match exactly 'var'
PRINT : 'print' ;
EQUALS : '=' ; //must be '='
NUMBER : [0-9]+ ; //must consist only of digits
STRING : '"'.*'"' ; //must be anything in qutoes
ID : [a-zA-Z0-9]+ ; //must be any alphanumeric value
QUALIFIED_NAME : ID ('.' ID)+;
WS: [ \t\n\r]+ -> skip ; //special TOKEN for skipping whitespaces
