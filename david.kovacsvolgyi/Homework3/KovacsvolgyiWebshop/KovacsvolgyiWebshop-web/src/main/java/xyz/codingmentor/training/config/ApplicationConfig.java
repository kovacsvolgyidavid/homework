package xyz.codingmentor.training.config;

import hu.codingmentor.RESTServices.CartRESTService;
import hu.codingmentor.RESTServices.InventoryRESTService;
import hu.codingmentor.RESTServices.UserRESTService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import xyz.codingmentor.Exception.GeneralExceptionMapper;
import xyz.codingmentor.Exception.IdNotMatchExceptionMapper;
import xyz.codingmentor.Exception.ValidationExceptionMapper;


/**
 *
 * @author Keni
 */
@ApplicationPath("/")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(InventoryRESTService.class);
        c.add(UserRESTService.class);
        
        c.add(IdNotMatchExceptionMapper.class);
        c.add(CartRESTService.class);
        c.add(ValidationExceptionMapper.class);
        c.add(GeneralExceptionMapper.class);
        
        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
