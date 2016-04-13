/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import xyz.codingmentor.training.annotation.Validate;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@Validate
public class MobileDTO {
    @Pattern(regexp="[a-z0-9-]{36}")
    String id;
    @NotNull
    String type;
    @NotNull
    String manufacturer;
    @Min(1)
    int price;
    @Min(0)
    int piece;
   public MobileDTO(String id, String type, String manufacturer, int price, int piece) {
        
        this.id = id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.price = price;
        this.piece = piece;
    }
    public MobileDTO() {
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
    

}
