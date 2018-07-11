package org.panda.common.guava;

import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class GuavaOrdering {

    public static void main(String[] args) {

        Ordering<String> byLengthOrdering = new Ordering<String>() {
            public int compare(String left, String right) {
                return Ints.compare(left.length(), right.length());
            }
        };

    }

}
