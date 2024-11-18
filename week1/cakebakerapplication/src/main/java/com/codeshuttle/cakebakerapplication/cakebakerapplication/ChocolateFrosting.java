package com.codeshuttle.cakebakerapplication.cakebakerapplication;

import org.springframework.stereotype.Component;

@Component
public class ChocolateFrosting implements Frosting {

    public String getFrostingType() {
        return "Chocolate Frosting";
    }
}
