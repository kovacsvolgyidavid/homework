/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.DTO;


import hu.codinmentor.validation.OldEnough;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 *
 * @author keni
 */
public class UserDTO {
    @Pattern(regexp="....*")
    @NotNull
    String username;
    @Pattern(regexp="(?=.*[0-9=+<>.,])(?=.*[a-z])(?=.*[A-Z]).{6,}$")
    String password;
    String firstname;
    String lastname;
    @OldEnough
    LocalDate dateOfBirth;
    LocalDate registrationDate;
    boolean admin;
    List<MobileDTO> cart=new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(String username, String password, String firstname, String lastname, LocalDate dateOfBirth, LocalDate registrationDate, boolean admin) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        this.admin = admin;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public List<MobileDTO> getCart() {
        return cart;
    }

    public void setCart(List<MobileDTO> cart) {
        this.cart = cart;
    }
    
    
}
