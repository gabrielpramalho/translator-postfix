
public class Parser {
    public String output = "";
    private Lexer lexer;
    private Token lookAhead;
    
    
    public Parser (Lexer lexer){
        this.lexer = lexer;
        this.lookAhead = lexer.nextToken();
    }

    private void Match(Token token) throws Exception{
        if(lookAhead.type == token.type && lookAhead.value == token.value){
            lookAhead = lexer.nextToken();
        }else{
            throw new Exception("Systax Error! Match");
        }
    }
    
    public void Expr() throws Exception{
        Term();
        Rest();
    }
    
    public void Rest() throws Exception{
        if(lookAhead.type == 1){  // + <term> <rest>
            Match(lookAhead);
            Term();
            output += ("+ ");
            Rest();
        }else if(lookAhead.type == 2){  // - <term> <rest>
            Match(lookAhead);
            Term();
            output += ("- ");
            Rest();
        }else{
            if(lookAhead.type != 99){
                throw new Exception("Syntax Error! Parser");
            }
        }
    }
    
    public void Term() throws Exception{
        if(lookAhead.type == 0){
            output += lookAhead.value + " ";
            Match(lookAhead);
        }else{
            throw new Exception("Syntax Error!");
        }
    }
    
    
    
}
