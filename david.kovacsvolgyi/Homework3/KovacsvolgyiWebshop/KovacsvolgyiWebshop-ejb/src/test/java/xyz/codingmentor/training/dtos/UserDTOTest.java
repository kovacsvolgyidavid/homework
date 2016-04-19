package xyz.codingmentor.training.dtos;

import xyz.codingmentor.training.dtos.UserDTO;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import junit.framework.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
public class UserDTOTest {

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
    public void usernamePositive() {
        UserDTO userTest = new UserDTO("proba", "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void passwordPositive() {
        UserDTO userTest = new UserDTO("proba", "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(0, violations.size());
        userTest.setPassword("GoodPasswordWithSpecialChar.=+<>.,");
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void dateOfBirthPositive() {
        UserDTO userTest = new UserDTO("proba", "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void dateOfBirthNegative() {
        UserDTO userTest = new UserDTO("proba", "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().plusDays(1), LocalDate.of(1990, 10, 12), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void passwordNegative() {
        UserDTO userTest = new UserDTO("proba", "Dummypassword", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
        userTest.setPassword("verybadpassword2.");
        Assert.assertEquals(1, violations.size());
        userTest.setPassword("GbS2");//has all the char needed, but too short
        Assert.assertEquals(1, violations.size());
    }

    @Test
    public void usernameNegative() {
        UserDTO userTest = new UserDTO(null, "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
    }

}
