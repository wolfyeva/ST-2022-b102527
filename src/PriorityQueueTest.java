import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){

        return null;
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){

    }

    @Test
    public void whenExceptionThrown_thenInitialCapacotyNotGreaterThanOne(){

    }

    @Test
    public void whenExceptionThrown_thenOfferEisNull(){

    }

    @Test
    public void whenExceptionThrown_thenNoElementCanRemove(){

    }
}
