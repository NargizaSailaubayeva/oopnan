import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

public class timerCheck {
    public int countdownStarter;
    public timerCheck(int timerr) {
        this.countdownStarter = timerr;
    }

    public int timerRun() {

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            public void run() {
                System.out.println(countdownStarter);
                countdownStarter--;
                if (countdownStarter < 0) {
                    System.out.println("Timer is over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
        return 0;
    }
}