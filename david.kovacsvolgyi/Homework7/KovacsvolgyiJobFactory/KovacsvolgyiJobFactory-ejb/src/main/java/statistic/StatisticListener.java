package statistic;

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
@MessageDriven(mappedName = "dzsobTopik")
public class StatisticListener implements MessageListener {

    @Inject
    StaticsBean statistics;
    private static final Logger LOGGER = Logger.getLogger(StatisticListener.class.getName());

    @Override
    public void onMessage(Message message) {
        Long id;
        try {
            id = message.getBody(Long.class);
            statistics.addMessage(id);
        } catch (JMSException ex) {
            LOGGER.log(Level.INFO, "Message unwrap cause exception:{0}", ex);
        }
    }

}
