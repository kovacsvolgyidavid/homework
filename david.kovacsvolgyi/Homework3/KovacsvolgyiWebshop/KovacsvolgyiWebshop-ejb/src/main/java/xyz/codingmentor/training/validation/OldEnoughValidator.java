package xyz.codingmentor.training.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class OldEnoughValidator implements ConstraintValidator<OldEnough, LocalDate> {

    @Override
    public void initialize(OldEnough constraintAnnotation) {
        //Only overide puposes
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value.isBefore(LocalDate.now());
    }

}
