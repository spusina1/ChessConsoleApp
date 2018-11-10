package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    @org.junit.jupiter.api.Test
    void move1() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("E4")
        );
    }
    @org.junit.jupiter.api.Test
    void move12() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("E5")
        );
    }

    @org.junit.jupiter.api.Test
    void move13() {
        Pawn p = new Pawn("E2", ChessPiece.Color.WHITE);
        assertThrows( IllegalChessMoveException.class,
                () -> p.move("C4")
        );
    }

    @org.junit.jupiter.api.Test
    void move4() {
        Pawn p = new Pawn("E3", ChessPiece.Color.WHITE);
        assertDoesNotThrow(
                () -> p.move("D4")
        );
    }

}