package org.panda.common.guava;

import com.google.common.base.Preconditions;

public class GuavaPreconditions {
    public static void main(String[] args) {
        Preconditions.checkArgument(3 > 2);
        System.out.println(Preconditions.checkNotNull(new Integer(1), "null......"));
    }
}
