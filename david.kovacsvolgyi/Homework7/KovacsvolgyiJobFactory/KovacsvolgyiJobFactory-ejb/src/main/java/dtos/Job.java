package dtos;

import java.io.Serializable;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class Job implements Serializable {

    private Long id;
    private int time;//random 1-5

    public Job() {
        //For mapping reasons
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", time=" + time + '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
