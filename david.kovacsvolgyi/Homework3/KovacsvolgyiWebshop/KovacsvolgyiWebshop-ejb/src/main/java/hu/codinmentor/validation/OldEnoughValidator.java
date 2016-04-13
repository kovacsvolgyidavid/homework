/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codinmentor.validation;

import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class OldEnoughValidator implements ConstraintValidator<OldEnough, LocalDate >{

    @Override
    public void initialize(OldEnough constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
       if(value==null){
       return false;
       }
        return value.isBefore(LocalDate.now());
    }
    
}
