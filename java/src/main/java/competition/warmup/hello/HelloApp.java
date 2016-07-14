package competition.warmup.hello;

/**
 * Created by Chris on 14/07/2016.
 */
public class HelloApp {
    public static String hello() {
        return "Hello, World!";
    }

    public static String hello(String name) {
        return String.format("Hello, %s!", name);
    }

    public static String run(String... args) {
        if (args.length == 0) {
            return hello();
        } else {
            return hello(args[0]);
        }
    }
}
