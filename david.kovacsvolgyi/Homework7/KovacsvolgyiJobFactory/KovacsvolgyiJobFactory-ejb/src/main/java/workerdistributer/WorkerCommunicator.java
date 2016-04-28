package workerdistributer;

import dtos.Job;
import javax.annotation.Resource;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import worker.FastWorker;
import worker.SlowWorker;
import worker.Worker;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Singleton
@Startup
@DependsOn("FastWorker")
public class WorkerCommunicator {

    @Inject
    private FastWorker fastWorker;
    @Inject
    Worker worker;
    @Inject
    SlowWorker slowWorker;
    @Resource(lookup = "dzsobTopik")
    private Topic topic;
    @Inject
    private JMSContext jmsContext;

    public WorkerCommunicator() {
        //for mapping reasons
    }

    public void addJob(Job job) {
        int schedule = (int) (Math.random() * 3 + 1);
        switch (schedule) {
            case 1:
                fastWorker.work(job);
                break;
            case 2:
                worker.work(job);
                break;
            case 3:
                slowWorker.work(job);
                break;
            default:
                throw new IllegalArgumentException("No worker has been sarted on this job:"
                        + job.toString());
        }

        jmsContext.createProducer().send(topic, job.getId());
    }

}
