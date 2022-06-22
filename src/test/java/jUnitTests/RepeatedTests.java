package jUnitTests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.time.LocalDateTime;

public class RepeatedTests {

//    requires number of repetitions, at least
    @RepeatedTest(5)
    void firstRepeatedMethod(){
        System.out.println(LocalDateTime.now().getSecond());
    }

//    when more than just number of repeats is needed, value = repetition number and name allows to name the tests in
//    console. Notice how the functions, {currentRepetition} & {totalRepetition} are in the string but between curlies.
    @RepeatedTest(value = 3, name = "This is run number: {currentRepetition}." +
            " Total repetitions is : {totalRepetitions}"  )
    @DisplayName("This method gets the minute of the day")
    void secondRepeatedMethod(){
        System.out.println(LocalDateTime.now().getMinute());
    }

    @RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo){
        int numOfRepeats = repetitionInfo.getCurrentRepetition();
        System.out.println("This code will run at each repetition");
        Assumptions.assumingThat(numOfRepeats==3,
                () -> System.out.println("This code is repetition "+ numOfRepeats));
    }
}
