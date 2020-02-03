import java.util.Scanner;
//Design patterns → Encapsulating object creation → Clock factory
class ClockFactory {

    private boolean produceToyClock;

    public ClockFactory(boolean produceToyClock) {
        this.produceToyClock = produceToyClock;
    }

    /**
     * It produces a clock according to a specified type: SAND, DIGITAL or MECH.
     * If some other type is passed, the method produces ToyClock.
     */
    public Clock produce(String type) {
        switch (type) {
            case "SAND": return new SandClock();
            case "DIGITAL": return new DigitalClock();
            case "MECH": return new MechanicalClock();
        }
        if (produceToyClock) return new ToyClock();
        return null;
    }
}

/* Do not change code below */
interface Clock {

    void tick();
}

class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

class ToyClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...tick...");
    }
}

public class Main {
    public static void main(String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final boolean produceToy = scanner.nextBoolean();
        final ClockFactory factory = new ClockFactory(produceToy);
        final Clock clock = factory.produce(type);
        if (clock != null) {
            clock.tick();
        } else {
            System.out.println(clock);
        }
    }
}

/*
Code Challenge — Write a program
There is a hierarchy of clocks with the base interface Clock and the class ClockFactory to produces instances.

Implement the method produce of the factory. It should return a clock according to the specified type string:

"SAND" - SandClock;
"DIGITAL" - DigitalClock;
"MECH" - MechanicalClock.
The single constructor of the factory takes the boolean parameter produceToyClock. It determines what the factory does when an unsuitable type of clock is passed. If it is true, the factory should produce an instance of ToyClock, otherwise, return null.
 */