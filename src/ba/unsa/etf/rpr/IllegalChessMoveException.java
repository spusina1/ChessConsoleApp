package ba.unsa.etf.rpr;
import java.util.*;

public class IllegalChessMoveException extends IllegalArgumentException {
    IllegalChessMoveException(){}
    IllegalChessMoveException(String str){
        super(str);
    }
}

