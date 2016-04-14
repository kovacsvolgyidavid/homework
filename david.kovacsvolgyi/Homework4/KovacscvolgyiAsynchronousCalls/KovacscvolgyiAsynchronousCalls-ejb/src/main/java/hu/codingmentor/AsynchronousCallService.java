/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor;

import java.math.BigInteger;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author keni
 */
@Stateless
@Asynchronous
public class AsynchronousCallService {
    @Resource
    private SessionContext context;

    public Future<BigInteger> asyncCall(){
        BigInteger operand1=new BigInteger("0");
        BigInteger operand2=new BigInteger("5");
        BigInteger i=new BigInteger("0");
        while(operand1.bitLength()<29){
           operand1= operand1.add(operand2);
           
            i=i.add(new BigInteger("1"));
        }
        
        if (context.wasCancelCalled()) {
            return new AsyncResult<>(new BigInteger("-1"));
        } else {
            return new AsyncResult<>(i);
        }
    }
}
