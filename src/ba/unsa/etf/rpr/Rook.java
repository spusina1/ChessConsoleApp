package ba.unsa.etf.rpr;
import java.util.*;

public class Rook extends ChessPiece{

    public Rook(String position, Color color){
        super(position, color);
    }

    @Override
    public String getPosition() {
        return  super.getPosition();
    }

    @Override
    public Color getColor(){
        return  super.getColor();
    }

    @Override
    public Object clone(){
        return new Rook(position,color);
    }

    @Override
    public void move(String position){
        super.move(position); // prvo pozovem metodu iz bazne;
        if(this.position.equals(position)) throw new  IllegalChessMoveException(); //ako se pozicija ne mijenja u odnosu na pocetnu
        if(position.charAt(0)==this.position.charAt(0) || position.charAt(1)==this.position.charAt(1)) this.position=position;
        else throw new IllegalChessMoveException();
    }
}
