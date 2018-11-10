package ba.unsa.etf.rpr;
import java.util.*;

public class King extends ChessPiece{

    public King(String position, Color color){
        super(position, color);
    }

    @Override
    public String getPosition() {
        return  super.getPosition();
    }

    @Override
    public Color getColor(){
       return super.getColor();
    }
    @Override
    public Object clone(){
        return new King(position,color);
    }
    @Override
    public void move(String position){
        super.move(position); // prvo pozovem metodu iz bazne;
        if(this.position.equals(position)) throw new IllegalChessMoveException();
        if((Math.abs(position.charAt(0)-this.position.charAt(0))==1 && position.charAt(1)==this.position.charAt(1))
            || (Math.abs(position.charAt(1)-this.position.charAt(1))==1 && position.charAt(0)==this.position.charAt(0))
        || (Math.abs(position.charAt(0)-this.position.charAt(0))==1 && Math.abs(position.charAt(1)-this.position.charAt(1))==1))
            this.position=position;

        else throw new  IllegalChessMoveException();
    }
}
