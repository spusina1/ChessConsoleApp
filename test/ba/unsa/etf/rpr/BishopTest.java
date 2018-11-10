package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class BishopTest {
    @org.junit.jupiter.api.Test
    void moveDiagonal() {
        Bishop k = new Bishop("E1", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveTwo() {
        Bishop k = new Bishop("F1", ChessPiece.Color.BLACK);
        assertThrows( IllegalChessMoveException.class,
                () -> k.move("A5")
        );
    }

    @org.junit.jupiter.api.Test
    void moveBack() {
        Bishop k = new Bishop("G6", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> k.move("B1")
        );
    }

    @org.junit.jupiter.api.Test
    void constructor1() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("I2", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor2() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new King("B9", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void constructor3() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Bishop("", ChessPiece.Color.WHITE)
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal1() {
        Bishop k = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("C0")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal2() {
        Bishop k = new Bishop("H1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("I1")
        );
    }

    @org.junit.jupiter.api.Test
    void moveIllegal3() {
        Bishop k = new Bishop("C1", ChessPiece.Color.BLACK);
        assertThrows(
                IllegalArgumentException.class,
                () -> k.move("")
        );
    }
}