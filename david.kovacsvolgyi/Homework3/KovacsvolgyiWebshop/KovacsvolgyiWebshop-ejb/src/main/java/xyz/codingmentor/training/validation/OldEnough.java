package xyz.codingmentor.training.validation;

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
@Target({ElementType.TYPE})
@Retention(RUNTIME)
public @interface OldEnough {
    String message() default "{OldEnough.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
