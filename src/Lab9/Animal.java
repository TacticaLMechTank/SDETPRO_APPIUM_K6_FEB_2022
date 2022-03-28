package Lab9;

import java.security.SecureRandom;

public class Animal {
    private boolean flyable;
    private int speed;
    private String name;

    protected Animal(Builder builder) {
        flyable = builder.flyable;
        speed = builder.speed;
        name = builder.name;
    }

    private Animal() {

    }

    //read only
    public boolean isFlyable() {
        return flyable;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public static class Builder {
        private boolean flyable;
        private int speed;
        private String name;

        //write only
        public Builder withFlyable (boolean flyable){
            this.flyable = flyable;
            return this;
        }

        public Builder withSpeed(int speed) {
            this.speed = new SecureRandom().nextInt(speed);
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}
