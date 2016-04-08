package xyz.codingmentor.Exception;

/**
 *
 * @author Denes Laszlo <denes.laszlo.88@gmail.com>
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
