package org.panda.common.guava;

import com.google.common.base.Optional;

public class GuavaOptional {
    
    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent()); // returns true
        System.out.println(possible.get()); // returns 5
    }
    
}
