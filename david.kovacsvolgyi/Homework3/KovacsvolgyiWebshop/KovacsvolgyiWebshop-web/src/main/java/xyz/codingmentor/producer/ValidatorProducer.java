package xyz.codingmentor.producer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Produces;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class ValidatorProducer {

    @Produces
    public Validator produceValidator() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
}
