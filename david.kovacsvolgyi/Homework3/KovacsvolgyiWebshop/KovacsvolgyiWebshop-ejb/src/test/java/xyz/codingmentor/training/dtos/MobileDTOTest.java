package xyz.codingmentor.training.dtos;

import xyz.codingmentor.training.dtos.MobileDTO;
import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import javax.validation.ConstraintViolation;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class MobileDTOTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @AfterClass
    public static void close() {
        vf.close();
    }

    @Test
    public void uuidPositive() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 100, 0);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());

    }

    @Test
    public void typePositive() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 100, 0);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void manufactorerPositive() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 100, 0);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void pricePositive() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 1, 0);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void piecesPositive() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 100, 0);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void uuidNegative1() {//TODO
        MobileDTO mobileTest = new MobileDTO("BadId", "Z7", "Samsung", 100, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("", violations.iterator().next().getMessage());
        Assert.assertEquals("dummyEmail", violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{Email.message}", violations.iterator().next().getMessageTemplate());
    }
    @Test
    public void uuidNegative2() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcde)", "Z7", "Samsung", 100, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
    }


    @Test
    public void typeNegative() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", null, "Samsung", 100, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void manufacturerNegative() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", null, 100, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void priceNegative1() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 0, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
        
    }
    @Test
    public void priceNegative2() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", -2, 30);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void pieceNegative() {
        MobileDTO mobileTest = new MobileDTO("123456789012345678901234567890abcdef", "Z7", "Samsung", 1345, -1);
        Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
        mobileTest.setPrice(-2);
        Assert.assertEquals(1, violations.size());
    }

}
