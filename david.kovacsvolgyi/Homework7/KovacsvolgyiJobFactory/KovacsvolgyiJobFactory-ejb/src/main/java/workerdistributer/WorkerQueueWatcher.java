package workerdistributer;

import dtos.Job;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@MessageDriven(mappedName = "dzsobKju")
public class WorkerQueueWatcher implements MessageListener {

    @Inject
    WorkerCommunicator workerCommunicator;

    @Override
    public void onMessage(Message message) {
        Job job = null;
        try {
            job = message.getBody(Job.class);
        } catch (JMSException ex) {
            Logger.getLogger(WorkerQueueWatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        workerCommunicator.addJob(job);
    }

}
