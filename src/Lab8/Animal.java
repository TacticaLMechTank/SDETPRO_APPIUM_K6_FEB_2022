package Lab8;

import java.security.SecureRandom;

public class Animal {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = new SecureRandom().nextInt(speed);
    }
}
