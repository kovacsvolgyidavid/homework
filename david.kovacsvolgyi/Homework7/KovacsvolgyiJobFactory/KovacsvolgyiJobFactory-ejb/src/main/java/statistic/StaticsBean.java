package statistic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
@Singleton
public class StaticsBean {

    private final Map<Long, Calendar> jobsInQueue = new HashMap<>();
    private final List<JobsDoneEntry> jobsDone = new ArrayList<>();

    public void addMessage(Long id) {
        if (jobsInQueue.containsKey(id)) {
            jobsDone.add(new JobsDoneEntry(id, (double) (Calendar.getInstance().getTimeInMillis()
                    - jobsInQueue.get(id).getTimeInMillis()) / 1000));
        } else {
            jobsInQueue.put(id, Calendar.getInstance());
        }
    }

    public List<JobsDoneEntry> getResults() {
        return jobsDone;
    }
}
