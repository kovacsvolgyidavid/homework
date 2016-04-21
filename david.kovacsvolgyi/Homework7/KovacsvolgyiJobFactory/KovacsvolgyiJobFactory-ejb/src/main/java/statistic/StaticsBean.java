package statistic;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.MessageDriven;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Singleton
@Startup
@MessageDriven(mappedName="DzsobTopik")
public class StaticsBean implements MessageListener{
    private Map<Long,LocalDate> jobsInQueue=new HashMap<>();
    private Map<Long,Double> jobsDone=new HashMap<>();

    @Override
    public void onMessage(Message message) {
        //TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Map<Long,Double> getResults(){
        return jobsDone;
    }
}
