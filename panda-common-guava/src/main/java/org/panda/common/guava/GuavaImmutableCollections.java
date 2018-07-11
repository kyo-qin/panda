package org.panda.common.guava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.RangeSet;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Table;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeSet;
import com.google.common.primitives.Ints;

public class GuavaImmutableCollections {

    public static final ImmutableSet<String> COLOR_NAMES = ImmutableSet.of("red", "orange", "yellow", "green", "blue", "purple");

    public static void main(String[] args) {
        ImmutableSet.of("a", "b");
        Set<String> x = new HashSet<String>();
        ImmutableSet.copyOf(x);

        ListMultimap<String, Integer> treeListMultimap = MultimapBuilder.treeKeys().arrayListValues().build();
        treeListMultimap.put("a", 1);
        treeListMultimap.put("a", 2);
        treeListMultimap.put("a", 3);
        System.out.println(treeListMultimap.get("a"));

        // BiMap，K V可以反转，但是V必须唯一 HashBiMap
        BiMap<String, Integer> userId = HashBiMap.create();

        Table<Integer, Integer, Double> weightedGraph = HashBasedTable.create();
        weightedGraph.put(1, 2, 4.0);
        weightedGraph.put(1, 3, 20.0);
        weightedGraph.put(2, 3, 5.0);

        System.out.println(weightedGraph.row(1)); // returns a Map mapping v2 to
                                                  // 4, v3 to 20
        System.out.println(weightedGraph.column(3)); // returns a Map mapping v1
                                                     // to 20, v2 to 5

        Range.closed(1, 10);
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}

        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) =>
                                               // "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) =>
                                                 // "bar", [6, 10] => "foo",
                                                 // (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) =>
                                              // "bar", (11, 20) => "foo"}

        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        List<List<Integer>> parts = Lists.partition(countUp, 2);

        List<String> strings = ImmutableList.of("xx", "y", "zzz");

        // Maps工具类
        ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings.iterator(), new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        });
        System.out.println(stringsByIndex);
        
        
    }
}
