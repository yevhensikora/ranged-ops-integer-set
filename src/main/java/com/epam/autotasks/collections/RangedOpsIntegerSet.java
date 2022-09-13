package com.epam.autotasks.collections;

import java.util.*;

class RangedOpsIntegerSet extends AbstractSet<Integer> {
    private TreeMap<Integer, Object> map;
    private static final Object PRESENT = new Object();

    public RangedOpsIntegerSet() {
        map = new TreeMap<>();
    }

    public boolean add(int fromInclusive, int toExclusive) {
        boolean actuallyAdded = false;
        for (int i = fromInclusive; i < toExclusive; i++ ) {
            if (add(i)) {
                actuallyAdded = true;
            }
        }
        return actuallyAdded;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        boolean actuallyRemoved = false;
        for (int i = fromInclusive; i < toExclusive; i++ ) {
            if (remove(i)) {
                actuallyRemoved = true;
            }
        }
        return actuallyRemoved;
    }

    @Override
    public boolean add(final Integer integer) {
       return map.put(integer, PRESENT) == null;
    }

    @Override
    public boolean remove(final Object o) {
        return map.remove(o, PRESENT);
    }

    @Override
    public Iterator<Integer> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
