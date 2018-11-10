package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class RookTest {


    @org.junit.jupiter.api.Test
    void moveIllegal() {
        Rook k = new Rook("A8", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("A9")
        );
    }
    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Rook k = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal12() {
        Rook k = new Rook("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C9")
        );
    }
    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Rook k = new Rook("A8", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,

                () -> k.move("H9")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal4() {
        Rook k = new Rook("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal5() {
        Rook k = new Rook("B6", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalChessMoveException.class,
                () -> k.move("C4")
        );
    }
    @org.junit.jupiter.api.Test
    void moveBack() {
        Rook k = new Rook("D4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("D3")
        );
    }
    @org.junit.jupiter.api.Test
    void moveLegal() {
        Rook k = new Rook("F4", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("B4")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Rook("", ChessPiece.Color.WHITE)
        );
    }


}