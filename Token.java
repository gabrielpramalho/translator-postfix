
public class Token {
    public int type;
    public Integer value;

    public Token(int type, Integer value) {
        this.type = type;
        this.value = value;
    }
    
    public Token(int type){
        this.type = type;
        this.value = null;
    }
    
    public boolean hasValue(){
        if (value == null){
            return false;
        }else{
            return true;
        }
    }
    
   
}