/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author martin
 */
@Stateless
@LocalBean
public class NewSessionBean {

    public String businessMethod() {
        return "Réka";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
