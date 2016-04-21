package restservice;

import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import statistic.StaticsBean;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Path("/")
public class JobRESTService {
    @Inject
    StaticsBean statisticBean;
    @GET
    public Map<Long,Double> getJobsDone(){
        return statisticBean.getResults();
    }
    
}
