package timerservice;

import dtos.Job;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.DeliveryMode;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class JobScheduler implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(JobScheduler.class.getName());
    @Inject
    private transient JMSContext jmsContext;
    @Resource(lookup = "dzsobKju")
    private transient Queue queue;
    long lastId = 0;

    @Schedule(hour = "*", minute = "*", second = "0")
    public void scheduleJobs() {
        Job job;
        for (int i = 0; i < 10; i++) {
            job = new Job();
            job.setId(++lastId);
            job.setTime((int) (Math.random() * 5 + 1));
            LOGGER.log(Level.INFO, "Scheduling job : {0}", job.toString());
            jmsContext.createProducer().setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, job);
        }
    }
}
