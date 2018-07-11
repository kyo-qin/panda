package org.panda.common.guava;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Throwables;

public class GuavaObjectCommons {
    public static void main(String[] args) {
        Objects.equal("a", "a"); // returns true
        Objects.equal(null, "a"); // returns false
        Objects.equal("a", null); // returns false
        Objects.equal(null, null); // returns true

        System.out.println(Objects.hashCode("12345"));

        // Returns "ClassName{x=1}"
       System.out.println(MoreObjects.toStringHelper(GuavaObjectCommons.class).add("x", 1).toString());

        // Returns "MyObject{x=1}"
        System.out.println(MoreObjects.toStringHelper("MyObject").add("x", 1).toString());
        
    }
}
