package xyz.codingmentor.training.exceptions;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class ErrorDTO {

    private String errorMessage;

    public ErrorDTO() {
        //contructor without param for mapping reasons.
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
