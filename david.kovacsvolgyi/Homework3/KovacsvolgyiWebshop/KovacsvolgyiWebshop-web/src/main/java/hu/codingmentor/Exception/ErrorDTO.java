package hu.codingmentor.Exception;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class ErrorDTO {

    private String errorMessage;

    public ErrorDTO() {
    }

    public ErrorDTO(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
}
