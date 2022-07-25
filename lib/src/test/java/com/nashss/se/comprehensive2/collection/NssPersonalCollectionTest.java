package com.nashss.se.comprehensive2.collection;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NssPersonalCollectionTest {

    private static final BigDecimal SINGLE_COLLECTABLE_VALUE = new BigDecimal(1);
    private static final BigDecimal SINGLE_COIN_FACE_VALUE = new BigDecimal(0.50);
    private static final Stamp STAMP = new Stamp(SINGLE_COLLECTABLE_VALUE);
    private static final Coin COIN = new Coin(SINGLE_COIN_FACE_VALUE, SINGLE_COLLECTABLE_VALUE);
    private static final List<Collectable> FIVE_STAMPS = Arrays.asList(STAMP, STAMP, STAMP, STAMP, STAMP);
    private static final List<Collectable> FIVE_COINS = Arrays.asList(COIN, COIN, COIN, COIN, COIN);

    @Test
    void getCollection_fromEmptyCollection_returnsEmtpyList() {
        NssPersonalCollection emptyCollection = new NssPersonalCollection(new ArrayList<>());

        List<Collectable> collectableList = emptyCollection.getCollection();

        assertTrue(collectableList.isEmpty(), "Expected empty collection contents to be empty");
    }

    @Test
    void getCollectionValue_fromEmptyCollection_returnsZero() {
        NssPersonalCollection emptyCollection = new NssPersonalCollection(new ArrayList<>());

        BigDecimal value = emptyCollection.getCollectionValue();

        assertEquals(BigDecimal.ZERO, value, "Expected empty collection to have a value of zero");
    }

    @Test
    void getCollection_fromStampCollection_returnsStamps() {
        NssPersonalCollection stampCollection = new NssPersonalCollection(FIVE_STAMPS);

        List<Collectable> result = stampCollection.getCollection();

        assertEquals(FIVE_STAMPS, result, "Expected stamp collection to contain stamps");
    }

    @Test
    void getCollection_fromCoinCollection_returnsCoins() {
        NssPersonalCollection coinCollection = new NssPersonalCollection(FIVE_COINS);

        List<Collectable> result = coinCollection.getCollection();

        assertEquals(FIVE_COINS, result, "Expected coin collection to contain coins");
    }

    @Test
    void getCollection_fromStampAndCoinCollection_returnsStampsAndCoins() {
        List<Collectable> collectables = new ArrayList<>(FIVE_STAMPS);
        collectables.addAll(FIVE_COINS);

        NssPersonalCollection collection = new NssPersonalCollection(collectables);

        List<Collectable> result = collection.getCollection();

        assertEquals(collectables, result, "Expected collection to contain stamps and coins");
    }

    @Test
    void getCollectionValue_fromStampCollection_returnsValue() {
        NssPersonalCollection stampCollection = new NssPersonalCollection(FIVE_STAMPS);

        BigDecimal result = stampCollection.getCollectionValue();

        BigDecimal expected = SINGLE_COLLECTABLE_VALUE.multiply(new BigDecimal(FIVE_STAMPS.size()));
        assertEquals(expected, result,
                String.format("Expected collection value to be %s", expected));
    }

    @Test
    void getCollectionValue_fromCoinCollection_returnsValue() {
        NssPersonalCollection coinCollection = new NssPersonalCollection(FIVE_COINS);

        BigDecimal result = coinCollection.getCollectionValue();

        BigDecimal expected =
                SINGLE_COLLECTABLE_VALUE
                        .multiply(new BigDecimal(FIVE_COINS.size()))
                        .add(SINGLE_COIN_FACE_VALUE.multiply(new BigDecimal(FIVE_COINS.size())));

        assertEquals(expected, result,
                String.format("Expected collection value to be %s", expected));
    }

    @Test
    void getCollectionValue_fromStampsAndCoinCollection_returnsValue() {
        List<Collectable> collectables = new ArrayList<>(FIVE_STAMPS);
        collectables.addAll(FIVE_COINS);

        NssPersonalCollection collection = new NssPersonalCollection(collectables);

        BigDecimal result = collection.getCollectionValue();


        BigDecimal expected =
                SINGLE_COLLECTABLE_VALUE
                        .multiply(new BigDecimal(FIVE_COINS.size()))
                        .add(SINGLE_COIN_FACE_VALUE.multiply(new BigDecimal(FIVE_COINS.size())))
                        .add(SINGLE_COLLECTABLE_VALUE.multiply(new BigDecimal(FIVE_STAMPS.size())));

        assertEquals(expected, result,
                String.format("Expected collection value to be %s", expected));
    }

}