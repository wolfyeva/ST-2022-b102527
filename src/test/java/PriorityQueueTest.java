import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> streamProvider(){ //A static method that returns a Stream of Arguments
        return Stream.of(
                Arguments.of(new int[]{0,3,2},new int[]{0,2,3}), //argument 1
                Arguments.of(new int[]{0,-3,-2},new int[]{-3,-2,0}), //argument 2
                Arguments.of(new int[]{1,1,4,2},new int[]{1,1,2,4}), //argument 3
                Arguments.of(new int[]{0,3,4,1},new int[]{0,1,3,4}), //argument 4
                Arguments.of(new int[]{},new int[]{123}) //argument 5
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("streamProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array){ //Run test case
        PriorityQueue<Integer> queue = new PriorityQueue<>(); //declare a priority queue
        int i = 0; //declare variable index
        int[] result = new int[random_array.length]; //declare an array with the same length as random_array

        for(i = 0; i<random_array.length; i++){ //do loop
            queue.add(random_array[i]); //add numbers to priority queue
        }
        for(i = 0; i<random_array.length; i++){ //do loop
            result[i] = queue.poll(); //poll from priority queue to array
        }

        assertArrayEquals(correct_array, result); //assert that the result is the same
    }

    @Test
    public void whenExceptionThrown_thenInitialCapacityNotGreaterThanOne(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> { //lambda
            PriorityQueue queue=new PriorityQueue(0); //initial capacity of priority queue to 0
        });
    }

    @Test
    public void whenExceptionThrown_thenOfferIsNull(){
        Exception exception = assertThrows(NullPointerException.class, () -> { //lambda
            PriorityQueue queue=new PriorityQueue();
            queue.offer(null); //offer is null
        });
    }

    @Test
    public void whenExceptionThrown_thenNoElementCanRemove(){
        Exception exception = assertThrows(NoSuchElementException.class, () -> { //lambda
            PriorityQueue queue= new PriorityQueue();
            queue.remove(); //no element can remove
        });
    }
}
