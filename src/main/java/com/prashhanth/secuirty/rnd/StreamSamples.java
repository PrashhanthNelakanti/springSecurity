package com.prashhanth.secuirty.rnd;

import java.util.stream.IntStream;

public class StreamSamples {

    public static void main(String[] args) {
        IntStream.range(5,10).map(x->x+5).forEach(f-> System.out.println(f));
    }
}
