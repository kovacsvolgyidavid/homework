package statistic;

import java.io.Serializable;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class JobsDoneEntry implements Serializable {

    private Long id;
    private Double time;

    public JobsDoneEntry(Long id, Double time) {
        this.id = id;
        this.time = time;
    }

    public JobsDoneEntry() {
        //mapping reasons
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

}
