package xyz.codingmentor.training.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.training.dtos.UserDTO;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class OldEnoughValidator implements ConstraintValidator<OldEnough, UserDTO> {

    @Override
    public void initialize(OldEnough constraintAnnotation) {
        //Only overide puposes
    }

    @Override
    public boolean isValid(UserDTO user, ConstraintValidatorContext context) { 
        if (user.getDateOfBirth() == null) {
            return true;
        }
        if(user.getDateOfBirth().isBefore(user.getRegistrationDate())){
        return user.getDateOfBirth().isBefore(LocalDate.now());
        }
        else{
        return false;
        }
    }

}
