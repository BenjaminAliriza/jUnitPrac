package jUnitTests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterizedTests {

//    USING PARAMETERIZEDTEST

    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues (int theParam){
        System.out.println("theParam = " + theParam);
    }


    @ParameterizedTest(name = "Number {index} - The word is {arguments}")
//    @NullSource
//    @EmptySource
    //line 23 is line 20 + line 21 :D
    @NullAndEmptySource
    @ValueSource(strings = {"will", "born"})
    void stringValues (String theParam){
        System.out.println("theParam = " + theParam);
    }

//    USING CSVSOURCE WITH PARAMETERIZEDTEST

    @ParameterizedTest
    //csv = comma separated values
    @CsvSource(value = {"steve,rogers", "bat,man", "peter,parker"})
    void csvSource_StringString(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve,2,true", "bat,3,false", "peter,4,true"})
    void csvSource_StringIntBoolean(String param1, int param2, boolean param3){
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve rogers, 'captain,america'", "will smith,'slapper,of,chris'"})
    void csvSource_StringWithComma(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

    @ParameterizedTest
    @CsvSource(value = {"steve?rogers", "bat?man"}, delimiter = '?')
    void csvSource_CustomDelimiter(String param1, String param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }

//    USING CSVSOURCEFILE WITH PARAMETERIZEDTEST

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    void csvFileSource_StringDoubleIntStringString(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/params/shoppinglist3.csv", numLinesToSkip = 1, delimiterString = "___")
    void csvFileSource_StringDoubleIntStringStringCustomDelimiter(String name, double price, int qty, String uom, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", uom = " + uom + ", provider = " + provider);
    }

//    USING METHODSOURCE WITH PARAMETERIZEDTEST
//    EXPERIMENTING WITH LISTS AND STREAMS

    @ParameterizedTest
    @MethodSource(value = "sourceString")
    void methodSource_String(String param1){
        System.out.println("param1 = " + param1);
    }

    @ParameterizedTest
    @MethodSource(value = "sourceStringAsStream")
    void methodSource_StringStream(String param1){
        System.out.println("param1 = " + param1);
    }

    List<String> sourceString() {
        //processing done here
    return Arrays.asList("tomato", "carrot", "cabbage");
    }

    Stream<String> sourceStringAsStream(){
        //processing
        return Stream.of("fruit", "other fruit", "last fruit");
    }

    List<Arguments> sourceList_StringDouble(){
        //processing
        return Arrays.asList(arguments("tomato", 2.0),
                arguments("cabbage", 7.8));
    }

    @ParameterizedTest
    @MethodSource(value = "sourceList_StringDouble")
    void methodSource_StringDoubleList(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


    @ParameterizedTest                    //notice the hashtag between class and method names
    @MethodSource(value = "jUnitTests.ParamProvider#sourceStream_StringDouble")
    void methodSource_StringDoubleStream(String param1, double param2){
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
    }


}
