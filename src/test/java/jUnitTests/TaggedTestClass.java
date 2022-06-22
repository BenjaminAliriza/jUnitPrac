package jUnitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaggedTestClass {

    @BeforeAll
    void beforeAll (){
        System.out.println("I go FIRST!");
    }

    @BeforeEach
    void beforeEach (){
        System.out.println("I go before each test!");
    }

    @Test //MUST PUT STRING IN TAG PARAMS
    @Tag("sanity")
    void firstTest (){
        System.out.println("I'm the first test");
    }

    @Test
    @Tag("sanity")
    @Tag("acceptance")
    void secondTest (){
        System.out.println("I'm the second test");
    }

    @Test
    @Tag("acceptance")
    void thirdTest (){
        System.out.println("I'm the third test");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1,5,6})
    void intValues (int theParam){
        System.out.println("theParam = " + theParam);
    }

    @AfterEach
    void afterEach (){
        System.out.println("I go after each test");
    }

    @AfterAll
    void afterAll(){
        System.out.println("I come in LAST!");
    }
}
