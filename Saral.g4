grammar Saral;

tokens { INDENT, DEDENT }

@lexer::members {
    private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();

    private java.util.Stack<Integer> indents = new java.util.Stack<>();

    private int opened = 0;

    private Token last = null;

    @Override
    public void emit(Token t) {
        super.setToken(t);
        tokens.offer(t);
    }

    @Override
    public Token nextToken() {
        // Check if the end-of-file is ahead and there are still some DEDENTS expected.
        if(_input.LA(1) == EOF && !this.indents.isEmpty()) {
            // Remove any trailing EOF tokens from our buffer.
            for(int i = tokens.size() - 1; i >= 0; i--) {
                if(tokens.get(i).getType() == EOF) {
                    tokens.remove(i);
                }
            }

            // First emit an extra line break that serves as the end of the statement.
            this.emit(commonToken(SaralParser.EOL, "\n"));

            // Now emit as much DEDENT tokens as needed.
            while(!this.indents.isEmpty()) {
                this.emit(createDedent());
                indents.pop();
            }

            // Put the EOF back on the token stream.
            this.emit(commonToken(SaralParser.EOF, "<EOF>"));
        }

        Token next = super.nextToken();
        if(next.getChannel() == Token.DEFAULT_CHANNEL) {
            // keep track of the latest token on the default channel
            this.last = next;
        }

        return tokens.isEmpty() ? next : tokens.poll();
    }

    private Token createDedent() {
        CommonToken dedent = commonToken(SaralParser.DEDENT, "");
        dedent.setLine(this.last.getLine());
        return dedent;
    }

    private CommonToken commonToken(int type, String text) {
        int stop = this.getCharIndex() - 1;
        int start = text.isEmpty() ? stop : stop - text.length() + 1;
        return new CommonToken(this._tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
    }

    // Calculates the indentation of the provided spaces, taking the
    // following rules into account:
    //
    // "Tabs are replaced (from left to right) by one to eight spaces
    //  such that the total number of characters up to and including
    //  the replacement is a multiple of eight [...]"
    static int getIndentationCount(String spaces) {
        int count = 0;

        for(char ch : spaces.toCharArray()) {
            switch(ch) {
                case '\t':
                    count += 8 - (count % 8);
                    break;
                default:
                    count++;
            }
        }
        return count;
    }

    boolean atStartOfInput() {
        return super.getCharPositionInLine() == 0 && super.getLine() == 1;
    }
}

init : statements ;

statements : statement*;
block : INDENT statements DEDENT;
func_block : INDENT statements ret DEDENT;
ret: RET ID EOL;

statement
	: simple_statement EOL
	| block_statement EOL?
	;

simple_statement : write
                 | variable
                 | proc_call
                 | func_call
                 ;
block_statement : proc_definition | func_definition | block;
proc_definition : FUNCTION ID LPAR arglist RPAR EOL block;
func_definition : FUNCTION TYPE ID LPAR arglist RPAR EOL func_block;
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
LPAR : '(' {opened++;};
RPAR : ')' {opened--;};
INT_T : 'neskutočné numeralio';
STRING_T : 'slovo';
VARIABLE : 'meňak' ;
PRINT : 'ciskaj' ;
EQUALS : '=' ;
RET : 'vrac';
NUMBER : [0-9]+ ;
STRING : '"'.*'"' ;
ID : [a-zA-Z0-9ľščťžýáíéäúôóďĺĽŠČŤŽÝÁÍÉÄÚÔÓĎĹ]+ ;
EOL :
    ({atStartOfInput()}? WS
    |
    ( '\r'? '\n' | '\r' ) WS?
    )
    {
        String newLine = getText().replaceAll("[^\r\n]+", "");
        String spaces = getText().replaceAll("[\r\n]+", "");
        int next = _input.LA(1);

        if(opened > 0 || next == '\r' || next == '\n') {
         // || next == '/') should skip comment
            skip();
        } else {
            emit(commonToken(EOL, newLine));

            int indent = getIndentationCount(spaces);
            int previous = indents.isEmpty() ? 0 : indents.peek();

            if(indent == previous) {
                // skip indents of the same size as the present indent-size
                skip();
            } else if(indent > previous) {
                indents.push(indent);
                emit(commonToken(SaralParser.INDENT, spaces));
            } else {
                // Possibly emit more than 1 DEDENT token.
                while(!indents.isEmpty() && indents.peek() > indent) {
                    this.emit(createDedent());
                    indents.pop();
                }
            }
        }
    }
    ;

EMPTY_LINE : {getCharPositionInLine()==0}? ((' '|'\t')* EOL) -> skip ;
WS: [ \t]+ -> skip ;
