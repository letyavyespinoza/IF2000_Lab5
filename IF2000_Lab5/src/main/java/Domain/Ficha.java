
package Domain;

/**
 *
 * @author USER
 */
public class Ficha {
    private String color; 
    
    public Ficha(String color){
        this.color = color;
    }
    
    public String getColor(){
        return color;
    }

    @Override
    public String toString() {
        return color;
    }
    
    
}
