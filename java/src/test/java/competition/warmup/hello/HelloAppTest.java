package competition.warmup.hello;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class HelloAppTest {

    @Test
    public void noArgs_shouldSayHelloWorld() {
        assertThat(HelloApp.run(new String[] {}), is("Hello, World!"));
    }

    @Test
    public void whenGivenAName_shouldSayHelloToThatName() {
        assertThat(HelloApp.run(new String[] {"John"}), is("Hello, John!"));
    }
}
