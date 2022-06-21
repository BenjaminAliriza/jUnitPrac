package jUnitTests;

import org.junit.jupiter.api.*;
//This \|/ tells class they will run in alphanumeric order based on method names
//@TestMethodOrder(MethodOrderer.MethodName.class)

//This \|/ tells class they will run in alphanumeric order based on applied display names
@TestMethodOrder(MethodOrderer.DisplayName.class)

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class OrderedTestClass1 {

    @BeforeAll
    void beforeAll (){
        System.out.println("I go FIRST!");
    }

    @BeforeEach
    void beforeEach (){
        System.out.println("I go before each test!");
    }

    @Test
    void firstTest (){
        System.out.println("I'm the first test");
    }

    @Test
    @DisplayName("You can use the DisplayName method to set specific name for test.")
    void secondTest (){
        System.out.println("I'm the second test");
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
