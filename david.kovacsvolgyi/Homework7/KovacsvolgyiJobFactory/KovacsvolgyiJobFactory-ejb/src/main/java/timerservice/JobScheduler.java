package timerservice;


import dtos.Job;
import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.TimerService;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Stateless
public class JobScheduler {
    @Inject
    private JMSContext jmsContext;
    @Resource(lookup="dzsobKju")
    private Queue queue;
    @Resource(lookup="dzsobTopik")
    private Topic topic;
    @Resource
    private TimerService timerService;
    long lastId=0;
    @Schedule(hour="*",minute="*",second="0")
    public void scheduleJobs(){
        Job job;
        for (int i=0;i<10;i++){
        job=new Job();
        job.setId(++lastId);
        job.setTime((int) (Math.random() * 5 + 1));
        jmsContext.createProducer().send(queue, job);
        jmsContext.createProducer().send(topic, job.getId());
        }
    }
}
