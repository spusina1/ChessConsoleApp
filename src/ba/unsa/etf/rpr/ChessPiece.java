package ba.unsa.etf.rpr;
import java.util.*;

public abstract class ChessPiece{


    protected static enum Color { BLACK, WHITE};
    protected String position;
    protected Color color;

    public ChessPiece(String position, Color color){
        if(position.length()!=2 || ((position.charAt(0)<'a'|| position.charAt(0)>'h') && (position.charAt(0)<'A'|| position.charAt(0)>'H')) ||
                (position.charAt(1)<'1' || position.charAt(1)>'8')) throw new IllegalArgumentException("Neispravna pozicija");
        this.position=position;
        this.color=color;
    }

    public String getPosition(){
        return position;
    }
    public Color getColor(){
        return color;
    }
    public  abstract Object clone();

    public void move(String position){
        if(position.length()!=2 || ((position.charAt(0)<'a'|| position.charAt(0)>'h') && (position.charAt(0)<'A'|| position.charAt(0)>'H')) ||
                (position.charAt(1)<'1' || position.charAt(1)>'8')) throw new IllegalArgumentException();
    }



  /*  @Override
    public int compareTo(ChessPiece chessPiece) {
        return (getPosition().compareTo(chessPiece.getPosition()) && getColor().compareTo(chessPiece.getColor()));}*/

}
