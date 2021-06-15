
public class Lexer {
    
    String spaces = " \n\t";
    public int position;
    public String input;

    public Lexer() {
    }

    public Lexer(String input) {
        position = 0;
        this.input = input;
    }

    public int getPosition() {
        return position;
    }

    public String getInput() {
        return input;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setInput(String input) {
        this.input = input;
    }
    
    public boolean hasInput(){
        return input.isEmpty() && position < input.length();
    }
    
    static class TokenType {
        static int number = 0;
        static int sum = 1;
        static int sub = 2;
        static int EOF = 99;
        static int invalid = -1;
    }
    
    private Character NextChar(){
        if(position == input.length()){
            return Character.MIN_VALUE;
        }
        return input.charAt(position++);
    }
    
    public Token nextToken(){
        Character peek;
        do{
            peek = NextChar();
        } while(peek == ' ' || peek == '\n' || peek == '\t');
        
        if(Character.isDigit(peek)){
            String v = "";
            do{
                v += peek;
                peek = NextChar();
            }while(Character.isDigit(peek));
            
            if(peek != Character.MIN_VALUE){
                position--; 
            }
            return new Token(TokenType.number, Integer.parseInt(v));
        }
        
        if(peek == '+'){
            return new Token(TokenType.sum);
        }else if(peek == '-'){
            return new Token(TokenType.sub);
        }else if(peek == Character.MIN_VALUE){
            return new Token(TokenType.EOF);
        }else{
            return new Token(TokenType.invalid);
        }
    }

}
