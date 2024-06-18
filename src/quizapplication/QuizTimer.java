package quizapplication;

import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
    private Timer timer;
    private boolean timeUp;

    public QuizTimer(int seconds) {
        timer = new Timer();
        timeUp = false;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
                System.out.println("Time's up!");
            }
        }, seconds * 1000);
    }

    public boolean isTimeUp() {
        return timeUp;
    }

    public void stop() {
        timer.cancel();
    }
}
