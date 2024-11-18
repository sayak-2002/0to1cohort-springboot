package com.codeshuttle.cakebakerapplication.cakebakerapplication;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class StrawBerryFrosting implements Frosting {

    @Override
    public String getFrostingType() {
        return "Strawberry Frosting";
    }
}
