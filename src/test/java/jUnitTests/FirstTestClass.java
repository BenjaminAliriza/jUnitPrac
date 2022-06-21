package jUnitTests;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

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
