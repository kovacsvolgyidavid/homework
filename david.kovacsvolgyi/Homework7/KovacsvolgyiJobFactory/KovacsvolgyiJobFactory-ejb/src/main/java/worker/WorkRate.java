package worker;

/**
 *
 * @author David Kovacsvolgyi <kovacsvolgyi.david@gmail.com>
 */
public enum WorkRate {
    SLOW(0.5),MEDIUM(1),FAST(2);
    private final double speed;
    
    WorkRate (double speed){
    this.speed=speed;
    }

    public double getSpeed() {
        return speed;
    }
    
}
