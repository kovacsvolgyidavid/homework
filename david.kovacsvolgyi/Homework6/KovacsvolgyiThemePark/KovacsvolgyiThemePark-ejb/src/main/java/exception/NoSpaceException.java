package exception;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class NoSpaceException extends RuntimeException {

    public NoSpaceException(String string) {
        super(string);
    }
    
}
