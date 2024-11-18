package com.codeshuttle.cakebakerapplication.cakebakerapplication;


import org.springframework.stereotype.Component;

@Component
public class StrawBerrySyrup implements Syrup {

    public String getSyrupType() {
        return "Strawberry Syrup";
    }
}
