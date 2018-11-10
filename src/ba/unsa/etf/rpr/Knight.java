package ba.unsa.etf.rpr;
import java.util.*;

public class Knight extends ChessPiece {

    public Knight(String position, Color color){
        super(position, color);
    }

    @Override
    public String getPosition() {
        return super.getPosition();
    }

    @Override
    public Color getColor(){
       return super.getColor();
    }
    @Override
    public Object clone(){
        return new Knight(position,color);
    }
    @Override
    public void move(String position){

        super.move(position); // prvo pozovem metodu iz bazne;
        IllegalChessMoveException izuzetak= new IllegalChessMoveException();
        if(this.position.equals(position)) throw izuzetak; //ako se pozicija ne mijenja u odnosu na pocetnu
       if((Math.abs(this.position.charAt(0)-position.charAt(0))==1 && Math.abs(this.position.charAt(1)-position.charAt(1))==2)
        || (Math.abs(this.position.charAt(0)-position.charAt(0))==2 && Math.abs(this.position.charAt(1)-position.charAt(1))==1))this.position=position;
        else throw izuzetak;
    }
}
