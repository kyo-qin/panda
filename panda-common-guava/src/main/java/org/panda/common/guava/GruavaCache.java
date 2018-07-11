package org.panda.common.guava;

import java.util.concurrent.ExecutionException;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.graph.Graph;

public class GruavaCache {

    public static void main(String[] args) {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder().maximumSize(1000).build(new CacheLoader<String, String>() {
            public String load(String key) {
                System.out.println("loading");
                return key+" yahaha";
            }
        });
        try {
            System.out.println(graphs.get("qintao"));
            System.out.println(graphs.get("qintao"));
            System.out.println(graphs.asMap());
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
