package ba.unsa.etf.rpr;
import ba.unsa.etf.rpr.ChessPiece.Color;

import java.lang.reflect.Type;
import java.util.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Board {


    public ChessPiece[][] chessBoard = new ChessPiece[8][8];
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


}

