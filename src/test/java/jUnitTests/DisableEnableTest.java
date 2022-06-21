package jUnitTests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class DisableEnableTest {

    @Test
    @Disabled(value = "Disabled for demo of @Disabled")
    void firstTest (){
        System.out.println("I'm the first test");
    }

    @Test//you can also do EnabledOnOs to run on specific OS
    @DisabledOnOs(value = OS.WINDOWS, disabledReason = "This is disabled to demo @DisabledOnOs")
    void secondTest (){
        System.out.println("I'm the second test");
    }

    @Test//properties can be set via "edit configurations" the right of the build hammer above
    @DisabledIfSystemProperty(named = "env", matches = "staging",
    disabledReason = "Disabled for demo of @DisabledIfSystemProperty")
    void thirdTest () { System.out.println("I'm the third test"); }

    @Test
    void fourthTest (){
        System.out.println("I'm the fourth test");
    }

    @Test
    void fifthTest () { System.out.println("I'm the fifth test"); }

}
