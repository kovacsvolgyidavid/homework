package xyz.codingmentor.training.DTO;

import xyz.codingmentor.training.validation.OldEnough;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import xyz.codingmentor.training.annotation.Validate;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Validate
public class UserDTO {

    @Pattern(regexp = "....*")
    @NotNull
    String username;
    @Pattern(regexp = "(?=.*[0-9=+<>.,])(?=.*[a-z])(?=.*[A-Z]).{6,}$")
    String password;
    String firstname;
    String lastname;
    @OldEnough
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    LocalDate dateOfBirth;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    LocalDate registrationDate;
    boolean admin;
    List<MobileDTO> cart = new ArrayList<>();

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

    public void deleteCart() {
        this.cart.removeAll(cart);
    }

}
