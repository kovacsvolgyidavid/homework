/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codinmentor.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Constraint(validatedBy = OldEnoughValidator.class)
@Target({ElementType.FIELD})
@Retention(RUNTIME)
public @interface OldEnough {
     String message() default "OldEnough to registrate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
