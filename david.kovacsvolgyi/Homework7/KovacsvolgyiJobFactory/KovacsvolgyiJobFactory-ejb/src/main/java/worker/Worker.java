package worker;

import dtos.Job;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class Worker {
    @Inject
    private JMSContext jmsContext;
    WorkRate workrate;
    @Resource (lookup="DzsobKju")
    Queue queue;
    Job job;
    
    public Worker() {
    //For mapping reasons
    }
    @Asynchronous
    public void work() throws InterruptedException{
        while(true){
        job=jmsContext.createConsumer(queue).receiveBody(Job.class);
        Thread.sleep((long) ((double)(1000*job.getTime())*workrate.getSpeed()));
        }
    }
    
    public WorkRate getWorkrate() {
        return workrate;
    }

    public void setWorkrate(WorkRate workrate) {
        this.workrate = workrate;
    }
    
    
}
