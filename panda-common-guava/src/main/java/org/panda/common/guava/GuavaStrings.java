package org.panda.common.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;

public class GuavaStrings {
    public static void main(String[] args) {
        // Joiner
        Joiner joiner = Joiner.on("; ").skipNulls();
        System.out.println(joiner.join("a", "c", "l"));
        System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split("foo,bar,,   qux"));

        String theDigits = CharMatcher.digit().retainFrom("12345qintao"); // only
                                                                          // the
                                                                          // digits
        System.out.println(theDigits);

        CharMatcher cm = CharMatcher.forPredicate(new Predicate<Character>() {

            @Override
            public boolean apply(Character input) {
                if (input.equals('a'))
                    return true;
                return false;
            }

        });

       String theA = cm.retainFrom("abacc");
       System.out.println(theA);
       
       
    }
}
