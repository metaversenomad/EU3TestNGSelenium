package com.cybertek.tests.day12_properties_driver_tests;

import org.testng.annotations.Test;

public class Singleton {

    @Test
    public void test1(){}
        private static String str;

        public static String getInstance(){
            if(str==null){
                System.out.println("str is null. assigning value it");
                str="somevalue";
            }else {
                System.out.println("it has value, just returning it");
            }
            return str;
        }
}
