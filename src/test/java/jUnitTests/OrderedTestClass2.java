package jUnitTests;

import org.junit.jupiter.api.*;

//This \|/ allows you to set order with specified int value
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass2 {

    @BeforeAll
    void beforeAll (){
        System.out.println("I go FIRST!");
    }

    @BeforeEach
    void beforeEach (){
        System.out.println("I go before each test!");
    }

    @Test
    @Order(2)
    void firstTest (){
        System.out.println("I'm the first test");
    }

    @Test
    @Order(3)
    void secondTest (){
        System.out.println("I'm the second test");
    }

    @Test
    @Order(1)
    void thirdTest(){System.out.println("I'm the third test"); }

    @AfterEach
    void afterEach (){
        System.out.println("I go after each test");
    }

    @AfterAll
    void afterAll(){
        System.out.println("I come in LAST!");
    }
}
