package jUnitTests;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ParamProvider {

//    |
//    v   when method being called is in a different class, make it static
    static Stream<Arguments> sourceStream_StringDouble(){
        return Stream.of(arguments("apple", 1.6),arguments("guava",5.9));
    }

}
