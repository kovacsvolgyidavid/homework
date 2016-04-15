package xyz.codingmentor.training.config;

import xyz.codingmentor.training.restservice.AsynchronusRESTService;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author David Kovacsvolgyi<kovacsvolgyi.david@gmail.com>
 */
@ApplicationPath("/")
public class ApplicationConfig extends Application {

    private final Set<Class<?>> classes;

    public ApplicationConfig() {
        HashSet<Class<?>> c = new HashSet<>();
        c.add(AsynchronusRESTService.class);

        classes = Collections.unmodifiableSet(c);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}
