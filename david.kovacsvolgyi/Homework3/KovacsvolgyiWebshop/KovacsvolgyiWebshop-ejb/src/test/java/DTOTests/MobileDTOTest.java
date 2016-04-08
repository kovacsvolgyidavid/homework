/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOTests;

import hu.codingmentor.DTO.MobileDTO;
import java.util.Set;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import java.util.UUID;
import javax.validation.ConstraintViolation;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author keni
 */
public class MobileDTOTest {
    private static ValidatorFactory vf;
    private static Validator validator;
    private static MobileDTO mobileTest;
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
    public void uuidPositive(){
        mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",100,0);
       
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    
    }
    @Test
    public void typePositive(){
        mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",100,0);
       
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    
    }
    @Test
    public void manufactorerPositive(){
        mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",100,0);
       
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    
    }
    @Test
    public void pricePositive(){
        mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",1,0);
       
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    
    }
    @Test
    public void piecesPositive(){
        mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",100,0);
       
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(0, violations.size());
    
    }
    @Test
    public void uuidNegative(){
        mobileTest=new MobileDTO("BadId","Z7","Samsung",100,30);
        
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
        mobileTest.setId("123456789012345678901234567890abcde)");
        Assert.assertEquals(1, violations.size());
    }
    
    @Test
    public void typeNegative(){
       mobileTest=new MobileDTO("123456789012345678901234567890abcdef",null,"Samsung",100,30);
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
      
    }
    @Test
    public void manufacturerNegative(){
       mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7",null,100,30);
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
      
    }
    @Test
    public void priceNegative(){
       mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",0,30);
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
      mobileTest.setPrice(-2);
      Assert.assertEquals(1, violations.size());
    }
     @Test
    public void pieceNegative(){
       mobileTest=new MobileDTO("123456789012345678901234567890abcdef","Z7","Samsung",1345,-1);
    Set<ConstraintViolation<MobileDTO>> violations;
        violations = validator.validate(mobileTest);
        Assert.assertEquals(1, violations.size());
      mobileTest.setPrice(-2);
      Assert.assertEquals(1, violations.size());
    }
    
}
