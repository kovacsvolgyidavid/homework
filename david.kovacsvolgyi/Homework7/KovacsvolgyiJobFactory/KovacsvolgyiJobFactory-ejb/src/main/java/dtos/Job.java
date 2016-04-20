package dtos;

import java.io.Serializable;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public class Job implements Serializable {
    private long id;
    private int time;//random 1-5

    public Job() {
        //For mapping reasons
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
}
