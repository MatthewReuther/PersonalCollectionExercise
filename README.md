# Personal Collection Exercise

## Consider the following code snippets

```
public class Stamp {
    private BigDecimal value;

    public Stamp(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }
}

```

```
public class Coin {
    private BigDecimal faceValue;
    private BigDecimal collectorValue;

    public Coin(BigDecimal faceValue, BigDecimal collectorValue) {
        this.faceValue = faceValue;
        this.collectorValue = collectorValue;
    }

    public BigDecimal getValue() {
        return faceValue.add(collectorValue);
    }
}

```

```
public class PersonalCollection {
    private List<Stamp> stampCollectables;
    private List<Coin> coinCollectables;

    public PersonalCollection(List<Coin> collectables) {
        this.coinCollectables = collectables;
    }

    public PersonalCollection(List<Stamp> collectables) {
        this.stampCollectables = collectables;
    }

    public PersonalCollection(List<Stamp> stampCollectables, List<Coin> coinCollectables) {
        this.stampCollectables = stampCollectables;
        this.coinCollectables = coinCollectables;
    }
}

```

## Implement a new class , `NssPersonalCollection`, with a better solution that...

-   Allows storing/retrieving Coins and Stamps from the same List.
-   Allows computing the total value of the entire collection with a `getCollectionValue()` method
-   Allows constructing an `NssPersonalCollection` with a single `List`
-   Bonus: Create a copy constructor for your class

> **NOTE:** You may need to create multiple types. If so, you'll need to create seperate files in IntelliJ, but paste each class/interface in the single box below, one after the other.








