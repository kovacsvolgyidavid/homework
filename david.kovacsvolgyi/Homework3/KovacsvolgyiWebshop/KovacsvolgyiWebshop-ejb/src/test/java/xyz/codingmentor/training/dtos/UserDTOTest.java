package xyz.codingmentor.training.dtos;

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
    public void passwordPositive1() {
        UserDTO userTest = new UserDTO("proba", "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void passwordPositive2() {
        UserDTO userTest = new UserDTO("proba", "GoodPasswordWithSpecialChar.=+<>.,", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
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
        Assert.assertEquals("{OldEnough.message}", violations.iterator().next().getMessage());
        Assert.assertEquals(userTest, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{OldEnough.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void passwordNegative1() {
        UserDTO userTest = new UserDTO("proba", "GbS2", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);//has all the char needed, but too short
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("meg kell felelnie a \"(?=.*[0-9=+<>.,])(?=.*[a-z])"
                + "(?=.*[A-Z]).{6,}$\" reguláris kifejezésnek", violations.iterator().next().getMessage());
        Assert.assertEquals("GbS2", violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{javax.validation.constraints.Pattern.message}", violations.iterator().next().getMessageTemplate());

    }

    @Test
    public void passwordNegative2() {
        UserDTO userTest = new UserDTO("proba", "Dummypassword", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("meg kell felelnie a \"(?=.*[0-9=+<>.,])"
                + "(?=.*[a-z])(?=.*[A-Z]).{6,}$\" reguláris kifejezésnek", violations.iterator().next().getMessage());
        Assert.assertEquals("Dummypassword", violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{javax.validation.constraints.Pattern.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void passwordNegative3() {
        UserDTO userTest = new UserDTO("proba", "verybadpassword2.", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("meg kell felelnie a \"(?=.*[0-9=+<>.,])"
                + "(?=.*[a-z])(?=.*[A-Z]).{6,}$\" reguláris kifejezésnek", violations.iterator().next().getMessage());
        Assert.assertEquals("verybadpassword2.", violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{javax.validation.constraints.Pattern.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void usernameNegative() {
        UserDTO userTest = new UserDTO(null, "GoodPassword1", "John", ""
                + "Doe", LocalDate.now().minusDays(1), LocalDate.now(), true);
        Set<ConstraintViolation<UserDTO>> violations;
        violations = validator.validate(userTest);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals("nem lehet null-érték", violations.iterator().next().getMessage());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{javax.validation.constraints.NotNull.message}", violations.iterator().next().getMessageTemplate());
    }

}
