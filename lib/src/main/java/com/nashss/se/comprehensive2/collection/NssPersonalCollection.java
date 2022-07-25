package com.nashss.se.comprehensive2.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NssPersonalCollection {
    private final List<Collectable> collectables;

    public NssPersonalCollection(NssPersonalCollection nssPersonalCollection) {
        this(nssPersonalCollection.collectables);
    }

    public NssPersonalCollection(List<Collectable> collectables) {
        this.collectables = copy(collectables);
    }

    public List<Collectable> getCollection() {
        return copy(collectables);
    }

    public BigDecimal getCollectionValue() {
        BigDecimal collectionValue = BigDecimal.ZERO;
        for(Collectable collectable : collectables) {
            collectionValue = collectionValue.add(collectable.getValue());
        }

        return collectionValue;
    }

    private List<Collectable> copy(List<Collectable> collectables) {
        return new ArrayList<>(collectables);
    }
}