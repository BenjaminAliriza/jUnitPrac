package jUnitTests;

import Listeners.Listener;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

//runs test class through listener
@ExtendWith(Listener.class)
public class AssertionsTestClass {

    @Test
    void assertEqualsTest1(){
        assertEquals("firstString", "secondString", "The string values weren't equal.");
    }

    @Test
    void assertEqualsListTest(){
        List<String> expectedValues = Arrays.asList("string1", "string2", "string3", "string4");

        List<String> actualValues = Arrays.asList("string1", "string2", "string3", "string4");

        assertEquals(expectedValues, actualValues);
    }

    @Test
    void assertArraysEqualsTest(){
        int[] expectedValue = {1,2,3};
        int[] actualValue = {1,2,3};

        assertArrayEquals(expectedValue, actualValue);
    }

    @Test
    void assertTrueOrFalseTest(){
        assertTrue(false, "Not true, apparently");
        assertFalse(false, "Not true, apparently");
    }

    @Test
    void assertThrowsTest(){
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest(){
        assertAll(
                () -> assertEquals("firstString", "secondString", "The string values weren't equal."),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "Not true, apparently")
        );
    }

    //ASSERTIONS WITH HAMCREST
    @Test
    void assertForMapTest(){
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasValue(2));
        assertThat(theMap, hasKey("secondKey"));
    }

    @Test
    void assertForList(){
        List<String> theList = Arrays.asList("string1", "string2", "string3");

        assertThat(theList, hasItem("string2"));
    }

    @Test
    void assertForAnyOf(){
        List<String> theList = Arrays.asList("string1", "string2", "string3");
                                    //allOf works too, but must have all rather than any..
        assertThat(theList, anyOf(hasItem("string1"), hasItem("noString")));
    }

    @Test
    void assertForContainsInAnyOrder(){
        List<String> theList = Arrays.asList("string1", "string2", "string3");

        assertThat(theList, containsInAnyOrder("string1", "string3", "string2" ));
    }

}
