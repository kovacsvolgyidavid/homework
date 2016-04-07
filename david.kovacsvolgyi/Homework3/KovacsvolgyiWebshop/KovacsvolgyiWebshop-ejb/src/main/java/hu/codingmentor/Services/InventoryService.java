/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor.Services;

import hu.codingmentor.DTO.MobileDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author keni
 */
@Singleton
@Startup
public class InventoryService {
    
    private final List<MobileDTO>mobiles=new ArrayList<>();
    
    
}
