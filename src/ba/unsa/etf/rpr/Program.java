package ba.unsa.etf.rpr;
import java.util.*;
import ba.unsa.etf.rpr.ChessPiece.Color;
import javafx.beans.binding.When;

public class Program {
     public static void main(String[] args) {
    	Board sahovskaPloca=new Board();
    	boolean logicka=true;
    	while(true) {

            while (true) {
                boolean pomjerenBijeli = false;
                Scanner ulaz = new Scanner(System.in);
                System.out.println("Unesite X za predaju!");
                System.out.println("White move:");
                String potez = ulaz.next();
                potez=potez.toUpperCase();
                if(potez.equals("X")){ logicka=false; break;}
                char karakter;
                if (potez.length() == 3) {
                    karakter = potez.charAt(0);
                    String pozicija = "";
                    pozicija += potez.charAt(1);
                    pozicija += potez.charAt(2);
                    try {
                        switch (karakter) {
                            case 'K':
                                sahovskaPloca.move(King.class, Color.WHITE, pozicija);
                                if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                pomjerenBijeli = true;
                                break;
                            case 'Q':
                                sahovskaPloca.move(Queen.class, Color.WHITE, pozicija);
                                if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                pomjerenBijeli = true;
                                break;

                            case 'R':
                                sahovskaPloca.move(Rook.class, Color.WHITE, pozicija);
                                if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                pomjerenBijeli = true;
                                break;
                            case 'N':
                                sahovskaPloca.move(Knight.class, Color.WHITE, pozicija);
                                if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                pomjerenBijeli = true;
                                break;
                            case 'B':
                                sahovskaPloca.move(Bishop.class, Color.WHITE, pozicija);
                                if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                pomjerenBijeli = true;
                                break;

                        }
                    } catch (IllegalArgumentException i) {

                    }
                    if (!pomjerenBijeli) System.out.println("Illegal move!");
                    else break;
                } else {
                    Petlja:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (sahovskaPloca.chessBoard[i][j] != null)
                                if (sahovskaPloca.chessBoard[i][j].getColor().equals(Color.WHITE)) {
                                    try {
                                        sahovskaPloca.move(sahovskaPloca.chessBoard[i][j].getClass(), Color.WHITE, potez);
                                        if (sahovskaPloca.isCheck(Color.BLACK)) System.out.println("CHECK!!!");
                                        pomjerenBijeli = true;
                                        break Petlja;
                                    } catch (IllegalArgumentException e) {

                                    }
                                }
                        }
                    }
                    if (!pomjerenBijeli) System.out.println("Illegal move!");
                    else break;
                }
            }
            if(!logicka) {System.out.println("Bijeli igrac se predao"); break;}
            while (true) {
                boolean pomjerenCrni = false;
                Scanner ulaz = new Scanner(System.in);
                System.out.println("Unesite X za predaju!");
                System.out.println("Black move:");
                String potez = ulaz.next();
                potez=potez.toUpperCase();
                if(potez.equals("X")){ logicka=false; break;}
                char karakter;
                if (potez.length() == 3) {
                    karakter = potez.charAt(0);
                    String pozicija = "";
                    pozicija += potez.charAt(1);
                    pozicija += potez.charAt(2);
                    try {
                        switch (karakter) {
                            case 'K':
                                sahovskaPloca.move(King.class, Color.BLACK, pozicija);
                                if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                pomjerenCrni = true;
                                break;
                            case 'Q':
                                sahovskaPloca.move(Queen.class, Color.BLACK, pozicija);
                                if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                pomjerenCrni = true;
                                break;

                            case 'R':
                                sahovskaPloca.move(Rook.class, Color.BLACK, pozicija);
                                if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                pomjerenCrni = true;
                                break;
                            case 'N':
                                sahovskaPloca.move(Knight.class, Color.BLACK, pozicija);
                                if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                pomjerenCrni = true;
                                break;
                            case 'B':
                                sahovskaPloca.move(Bishop.class, Color.BLACK, pozicija);
                                if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                pomjerenCrni = true;
                                break;

                        }
                    } catch (IllegalArgumentException i) {

                    }
                    if (!pomjerenCrni) System.out.println("Illegal move!");
                    else break;
                } else {
                    Petlja:
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (sahovskaPloca.chessBoard[i][j] != null)
                                if (sahovskaPloca.chessBoard[i][j].getColor().equals(Color.BLACK)) {
                                    try {
                                        sahovskaPloca.move(sahovskaPloca.chessBoard[i][j].getClass(), Color.BLACK, potez);
                                        if (sahovskaPloca.isCheck(Color.WHITE)) System.out.println("CHECK!!!");
                                        pomjerenCrni= true;
                                        break Petlja;
                                    } catch (IllegalArgumentException e) {

                                    }
                                }
                        }
                    }
                    if (!pomjerenCrni) System.out.println("Illegal move!");
                    else break;
                }
            }
            if(!logicka) {System.out.println("Crni igrac se predao"); break;}
        }
    }
}
