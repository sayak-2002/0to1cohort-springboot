package com.codeshuttle.cakebakerapplication.cakebakerapplication;


import org.springframework.stereotype.Component;

@Component
public class CakeBaker {


    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {

        System.out.println("Baking a cake with " + frosting.getFrostingType() + " and " + syrup.getSyrupType());

    }

}
