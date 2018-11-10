package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.ChessPiece.Color;

import java.lang.reflect.Type;
import java.util.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Board {


    private ChessPiece[][] chessBoard = new ChessPiece[8][8];
    private  IllegalChessMoveException izuzetak = new IllegalChessMoveException();

    public Board() {

        chessBoard[0][0] = new Rook("A1", Color.WHITE);
        chessBoard[0][1] = new Knight("B1", Color.WHITE);
        chessBoard[0][2] = new Bishop("C1", Color.WHITE);
        chessBoard[0][3] = new Queen("D1", Color.WHITE);
        chessBoard[0][4] = new King("E1", Color.WHITE);
        chessBoard[0][5] = new Bishop("F1", Color.WHITE);
        chessBoard[0][6] = new Knight("G1", Color.WHITE);
        chessBoard[0][7] = new Rook("H1", Color.WHITE);
        chessBoard[1][0] = new Pawn("A2", Color.WHITE);
        chessBoard[1][1] = new Pawn("B2", Color.WHITE);
        chessBoard[1][2] = new Pawn("C2", Color.WHITE);
        chessBoard[1][3] = new Pawn("D2", Color.WHITE);
        chessBoard[1][4] = new Pawn("E2", Color.WHITE);
        chessBoard[1][5] = new Pawn("F2", Color.WHITE);
        chessBoard[1][6] = new Pawn("G2", Color.WHITE);
        chessBoard[1][7] = new Pawn("H2", Color.WHITE);

        chessBoard[7][0] = new Rook("A8", Color.BLACK);
        chessBoard[7][1] = new Knight("B8", Color.BLACK);
        chessBoard[7][2] = new Bishop("C8", Color.BLACK);
        chessBoard[7][3] = new Queen("D8", Color.BLACK);
        chessBoard[7][4] = new King("E8", Color.BLACK);
        chessBoard[7][5] = new Bishop("F8", Color.BLACK);
        chessBoard[7][6] = new Knight("G8", Color.BLACK);
        chessBoard[7][7] = new Rook("H8", Color.BLACK);
        chessBoard[6][0] = new Pawn("A7", Color.BLACK);
        chessBoard[6][1] = new Pawn("B7", Color.BLACK);
        chessBoard[6][2] = new Pawn("C7", Color.BLACK);
        chessBoard[6][3] = new Pawn("D7", Color.BLACK);
        chessBoard[6][4] = new Pawn("E7", Color.BLACK);
        chessBoard[6][5] = new Pawn("F7", Color.BLACK);
        chessBoard[6][6] = new Pawn("G7", Color.BLACK);
        chessBoard[6][7] = new Pawn("H7", Color.BLACK);

    }


    private void provjeriHorizontalno(int i, int j, int novoJ){
        if(j<novoJ)
            for(int k=j+1; k<novoJ; k++)
                if(chessBoard[i][k]!=null) throw izuzetak;
         else
             for (int n=novoJ+1; n<j; n++)
                 if(chessBoard[i][n]!=null) throw izuzetak;
    }

    private void provjeriVertikalno(int i, int novoI, int j){
        if(i<novoI){
            for(int k=i+1; k<novoI; k++)
                if(chessBoard[k][j]!=null) throw izuzetak;}
        else {
            for (int n=novoI+1; n<i; n++)
                if(chessBoard[n][j] !=null) throw izuzetak;
        }

    }

    private  void provjeriDijagonalni(int i, int j, int novoI, int novoJ) {
        int x = 0;
        int y = 0;
        if (i < novoI && j < novoJ) {
             x = i + 1;
             y = j + 1;
            while (x != novoI) {
                if (chessBoard[x][y] != null) throw izuzetak;
                x++;
                y++;
            }
        } else if (i < novoI && j > novoJ) {
             x = i + 1;
             y = j - 1;
            while (x != novoI) {
                if (chessBoard[x][y] != null) throw izuzetak;
                x++;
                y--;
            }
        } else if (i > novoI && j > novoJ) {
             x = i - 1;
             y = j - 1;
            while (x != novoI) {
                if (chessBoard[x][y] != null) throw izuzetak;
                x--;
                y--;
            }
        } else if (i > novoI && j < novoJ) {
             x = i-1;
             y = j+1;
            while (x != novoI) {
                if (chessBoard[x][y] != null) throw izuzetak;
                x--;
                y++;
            }
        }
    }
    private void provjeriVertikalnoZaPijuna(int i, int novoI, int j){

        if(chessBoard[novoI][j]!=null) throw izuzetak;
        int x=0;
        int y=0;
        if(i<novoI){
            x=i+1;
            while(x!=novoI){
                if(chessBoard[x][j]!=null) throw izuzetak;
                x++;
            }
        }
        else if(i>novoI){
            x=i-1;
            while ((x!=novoI)){
                if(chessBoard[x][j] != null ) throw  izuzetak;
                x--;
            }
        }
    }

    private void provjeriDijagonalnoZaPijuna(int novoI, int novoJ){
        if(chessBoard[novoI][novoJ]==null) throw izuzetak;

    }

    public void move(Class type, ChessPiece.Color color, String position){

      int koordinataI=0;
      int koordinataJ=0;
        Vanjska2:  for (int i = 0; i < 8; i++) {
            String str = Integer.toString(i+1);
            for (int j = 0; j < 8; j++) {
                String trazenaPozicija = (char) (j + 65) + str;
                String trazenaPozicija2 = (char) (j + 97) + str;
                if (trazenaPozicija.equals(position) || trazenaPozicija2.equals(position)) {
                    if (chessBoard[i][j] != null) {
                        if (chessBoard[i][j].getColor().equals(color)) {
                            throw izuzetak;
                        }
                    }
                    koordinataI=i;
                    koordinataJ=j;
                    break Vanjska2;
                }
            }
        }
        int pamtiI=0;
        int pamtiJ=0;
      boolean pomjeren=false;
        Vanjska: for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                if(chessBoard[i][j]!=null){
                if (chessBoard[i][j].getClass() == type && chessBoard[i][j].getColor().equals(color)) {
                    pamtiI=i;
                    pamtiJ=j;
                    try {
                        if (chessBoard[i][j] instanceof King) {
                            King klon = (King) chessBoard[i][j].clone();
                            klon.move(position);
                            pomjeren = true;
                            break Vanjska;
                        } else if (chessBoard[i][j] instanceof Queen) {
                            Queen klon1 = (Queen) chessBoard[i][j].clone();
                            klon1.move(position);
                            if (i == koordinataI) provjeriHorizontalno(i, j, koordinataJ);
                            else if (j == koordinataJ) provjeriVertikalno(i, koordinataI, j);
                            else provjeriDijagonalni(i, j, koordinataI, koordinataJ);
                            pomjeren = true;
                            break Vanjska;
                        } else if (chessBoard[i][j] instanceof Knight) {
                            Knight klon2 = (Knight)chessBoard[i][j].clone();
                            klon2.move(position);
                            pomjeren = true;
                            break Vanjska;
                        } else if (chessBoard[i][j] instanceof Rook) {
                            Rook klon3 = (Rook) chessBoard[i][j].clone();
                            klon3.move(position);
                            if (i == koordinataI) provjeriHorizontalno(i, j, koordinataJ);
                            else if (j == koordinataJ) provjeriVertikalno(i, koordinataI, j);
                            pomjeren = true;
                            break Vanjska;
                        } else if (chessBoard[i][j] instanceof Bishop) {
                            Bishop klon4 = (Bishop) chessBoard[i][j].clone();
                            klon4.move(position);
                            provjeriDijagonalni(i, j, koordinataI, koordinataJ);
                            pomjeren = true;
                            break Vanjska;
                        } else if (chessBoard[i][j] instanceof Pawn) {
                            Pawn klon5 = (Pawn) chessBoard[i][j].clone();
                            klon5.move(position);
                            if (j == koordinataJ) provjeriVertikalnoZaPijuna(i, koordinataI, j);
                            else provjeriDijagonalnoZaPijuna(koordinataI, koordinataJ);
                            pomjeren = true;
                            break Vanjska;
                        }

                    } catch (IllegalArgumentException e) {

                    }
                }

            }
            }
        }
        if(!pomjeren) throw izuzetak;
        chessBoard[pamtiI][pamtiJ].move(position);
        chessBoard[koordinataI][koordinataJ]=chessBoard[pamtiI][pamtiJ];
        chessBoard[pamtiI][pamtiJ]=null;
    }
    void move(String oldPosition, String newPosition){
            for (int i = 0; i < 8; i++) {
            String str = Integer.toString(i+1);
            for (int j = 0; j < 8; j++) {
                String trazenaPozicija = (char) (j + 65) + str;
                String trazenaPozicija2 = (char) (j + 97) + str;
                if (trazenaPozicija.equals(oldPosition) || trazenaPozicija2.equals(oldPosition)) {
                    if (chessBoard[i][j] == null) throw izuzetak;
                    else {
                       this.move(chessBoard[i][j].getClass(), chessBoard[i][j].getColor(), newPosition);
                        }
                    }

                }
            }
        }

    public boolean isCheck(Color color){
    Color bojaFigura=Color.BLACK;
    if(color.equals(Color.BLACK)) bojaFigura=Color.WHITE;
    String position="";
    int koordinataI=0;
    int koordinataJ=0;
    for(int i=0; i<8; i++){
        for(int j=0; j<8; j++){
            if(chessBoard[i][j]!=null)
            if(chessBoard[i][j] instanceof King && chessBoard[i][j].getColor().equals(color)){
               position=chessBoard[i][j].getPosition();
               koordinataI=i;
               koordinataJ=j;

            }
        }
    }


        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                if(chessBoard[i][j]!=null){
                    if (chessBoard[i][j].getColor().equals(bojaFigura)) {
                        try {
                            if (chessBoard[i][j] instanceof King) {
                                King klon =(King)chessBoard[i][j].clone();
                                klon.move(position);
                                return true;

                            } else if (chessBoard[i][j] instanceof Queen) {
                                Queen klon1 = (Queen) chessBoard[i][j].clone();
                                klon1.move(position);
                                if (i == koordinataI) provjeriHorizontalno(i, j, koordinataJ);
                                else if (j == koordinataJ) provjeriVertikalno(i, koordinataI, j);
                                else provjeriDijagonalni(i, j, koordinataI, koordinataJ);
                                return true;

                            } else if (chessBoard[i][j] instanceof Knight) {
                                Knight klon2 = (Knight)chessBoard[i][j].clone();
                                klon2.move(position);
                                return true;

                            } else if (chessBoard[i][j] instanceof Rook) {
                                Rook klon3 = (Rook) chessBoard[i][j].clone();
                                klon3.move(position);
                                if (i == koordinataI) provjeriHorizontalno(i, j, koordinataJ);
                                else if (j == koordinataJ) provjeriVertikalno(i, koordinataI, j);
                                return  true;

                            } else if (chessBoard[i][j] instanceof Bishop) {
                                Bishop klon4 = (Bishop) chessBoard[i][j].clone();
                                klon4.move(position);
                                provjeriDijagonalni(i, j, koordinataI, koordinataJ);
                                return  true;

                            } else if (chessBoard[i][j] instanceof Pawn) {
                                Pawn klon5 = (Pawn) chessBoard[i][j].clone();
                                klon5.move(position);
                                if (j == koordinataJ) provjeriVertikalnoZaPijuna(i, koordinataI, j);
                                else provjeriDijagonalnoZaPijuna(koordinataI, koordinataJ);
                                return true;
                            }

                        } catch (IllegalArgumentException e) {

                        }
                    }

                }
            }
        }
        return false;

    }
}

