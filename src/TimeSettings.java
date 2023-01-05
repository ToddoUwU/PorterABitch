public class TimeSettings {

    private int show_timer = 0;

    private int delay_timer = 0;

    public int getShow_timer() {
        return show_timer;
    }

    //will set the show timer in minutes
    public void setShow_timer_in_minutes(int show_timer) {
        this.show_timer = show_timer;
    }

    public int getDelay_timer() {
        return delay_timer;
    }

    //will set the delay timer in minutes
    public void setDelay_timer_in_minutes(int delay_timer) {
        this.delay_timer = delay_timer;
    }

}
