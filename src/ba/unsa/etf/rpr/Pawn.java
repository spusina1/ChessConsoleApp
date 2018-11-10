package ba.unsa.etf.rpr;
import java.util.*;

public class Pawn extends ChessPiece {

    public Pawn(String position, Color color){
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
        return new Pawn(position,color);
    }
    @Override
    public void move(String position){
        super.move(position);
        if(this.position.equals(position)) throw new IllegalChessMoveException(); //ako se pozicija ne mijenja u odnosu na pocetnu
        if(this.color.equals(Color.WHITE)) {
            if(position.charAt(0)==this.position.charAt(0) && position.charAt(1)==(this.position.charAt(1)+1)) this.position=position;
            else if(position.charAt(0)==this.position.charAt(0) && position.charAt(1)==(this.position.charAt(1)+2)) this.position=position;
           else if((this.position.charAt(0)-position.charAt(0)==1 && position.charAt(1)-this.position.charAt(1)==1) ||
                  (position.charAt(0)-this.position.charAt(0)==1 && position.charAt(1)-this.position.charAt(1)==1))this.position=position;
            else throw new  IllegalChessMoveException();
        }
        else if(this.color.equals(Color.BLACK)){
            if(position.charAt(0)==this.position.charAt(0) && position.charAt(1)==(this.position.charAt(1)-1)) this.position=position;
            else if(position.charAt(0)==this.position.charAt(0) && position.charAt(1)==(this.position.charAt(1)-2)) this.position=position;
            else if((this.position.charAt(0)-position.charAt(0)==1 && this.position.charAt(1)-position.charAt(1)==1) ||
                    (position.charAt(0)-this.position.charAt(0)==1 && this.position.charAt(1)-position.charAt(1)==1)) this.position=position;
            else throw new  IllegalChessMoveException();
        }


    }

}
