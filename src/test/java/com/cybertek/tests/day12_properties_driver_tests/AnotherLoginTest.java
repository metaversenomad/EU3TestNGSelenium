package com.cybertek.tests.day12_properties_driver_tests;

import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {
    @Test
    public void test1(){
        driver.get("https://www.google.com");
    }

}
