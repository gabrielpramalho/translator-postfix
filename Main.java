/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class Main {
    
    
    public static void main(String[] args) throws Exception {
        
      Lexer l = new Lexer("2 + 2 - 3");
      Parser p = new Parser(l);
      p.Expr();
      System.out.println(p.output);
      
        
    }
 
}
