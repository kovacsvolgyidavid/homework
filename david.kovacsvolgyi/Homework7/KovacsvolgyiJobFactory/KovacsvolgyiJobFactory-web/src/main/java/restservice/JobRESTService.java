package restservice;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import statistic.JobsDoneEntry;
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
    @Produces("application/json")
    public List<JobsDoneEntry> getJobsDone() {
        return statisticBean.getResults();
    }

    @GET
    @Path("/health")
    @Produces("plain/text")
    public String getStatus() {
        return "ok";
    }

}
