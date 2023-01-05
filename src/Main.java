import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String windowMessage = "Porter a bitch";

    public static Runnable run(TimeSettings runTimer) {

        Runnable task = () -> {
            try {
                Timer timer = new Timer();
                WindowDisplay simpleWindow = new WindowDisplay(windowMessage);

                TimerTask timerTask = new TimerTask() {


                    @Override
                    public void run() {
                        // display window here
                        SwingUtilities.invokeLater(simpleWindow::display);
                        try {
                            Thread.sleep((long) runTimer.getShow_timer() * 60 * 1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {

                            SwingUtilities.invokeLater(() -> {
                                simpleWindow.getJFrame().dispose();
                            });
                            timer.cancel();
                        }
                    }
                };

                timer.schedule(timerTask, 0);
            }catch(Exception e){
                e.printStackTrace();
            }


    };
       return task;
    }

    public static void main(String[] args) {
        TimeSettings timer = new TimeSettings();
        timer.setShow_timer_in_minutes(1);
        timer.setDelay_timer_in_minutes(30);

        ScheduledExecutorService executorService;
            executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(run(timer), 0, timer.getDelay_timer(), TimeUnit.MINUTES);

    }


}