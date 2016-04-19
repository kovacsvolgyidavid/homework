package xyz.codingmentor.training.dtos;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import xyz.codingmentor.training.annotation.Validate;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Validate
public class MobileDTO implements Serializable {

    @Pattern(regexp = "[a-z0-9-]{36}")
    private String id;
    @NotNull
    private String type;
    @NotNull
    private String manufacturer;
    @Min(1)
    private int price;
    @Min(0)
    private int piece;

    public MobileDTO(String id, String type, String manufacturer, int price, int piece) {
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.piece = piece;
    }

    public MobileDTO() {
        //For mapping reasons
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPiece() {
        return piece;
    }

    public void setPiece(int piece) {
        this.piece = piece;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + Objects.hashCode(this.manufacturer);
        hash = 13 * hash + this.price;
        hash = 13 * hash + this.piece;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MobileDTO other = (MobileDTO) obj;
        if (this.price != other.price) {
            return false;
        }
        if (this.piece != other.piece) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        return true;
    }

}
