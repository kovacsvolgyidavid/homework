package worker;

import dtos.Job;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Singleton
@Startup
public class FastWorker {

    @Inject
    private JMSContext jmsContext;
    private WorkRate workrate = WorkRate.FAST;
    private static final Logger LOGGER = Logger.getLogger(FastWorker.class.getName());
    @Resource(lookup = "dzsobTopik")
    private Topic topic;

    public FastWorker() {
        //For mapping reasons
    }

    @Asynchronous
    public void work(Job job) {

        if (job != null) {
            try {
                Thread.sleep((long) ((double) (1000 * job.getTime()) * workrate.getSpeed()));
            } catch (InterruptedException ex) {
                LOGGER.log(Level.SEVERE, null, ex);
            }
            LOGGER.log(Level.INFO, "{0} is done by FastWorker", job.toString());
            jmsContext.createProducer().send(topic, job.getId());
        }

    }

    public WorkRate getWorkrate() {
        return workrate;
    }

    public void setWorkrate(WorkRate workrate) {
        this.workrate = workrate;
    }

}
