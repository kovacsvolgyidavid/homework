/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.codingmentor;


import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
/**
 *
 * @author keni
 */
@Path("/")
public class AsynchronusRESTService {
   
    @Inject
    AsynchronousCallService asyncService;
    @GET
    @Path("/mail")
    public Boolean sendMail(@Context HttpServletRequest request) throws InterruptedException, ExecutionException{
        
    Future<BigInteger> future=asyncService.asyncCall();
    
    while(!future.isDone()){
        System.out.println("I have the power");
        if(future.isCancelled())throw new RuntimeException("i have been disrupted");
    }
        System.out.println(future.get());  
       return true; 
    }
        
    }

