package xyz.codingmentor.producer;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.ws.rs.Produces;

/**
 *
 * @author Denes Laszlo <denes.laszlo.88@gmail.com>
 */
public class ValidatorProducer {

    @Produces
    public Validator produceLogger() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }
}
