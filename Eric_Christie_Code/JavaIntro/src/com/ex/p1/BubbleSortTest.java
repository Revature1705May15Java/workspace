package com.ex.p1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BubbleSortTest {

  BubbleSort b;
  static BubbleSort sb;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.out.println("in setUpBeforeClass()");
    sb = new BubbleSort();
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    System.out.println("in tearDownAfterClass()");
    sb = null;
  }

  // there's really no need to instantiate a BubbleSort object in setUp() and
  // tearDown()
  // since sort() and numbers are static members
  @Before
  public void setUp() throws Exception {
    b = new BubbleSort();
    System.out.println("in setUp()");
  }

  @After
  public void tearDown() throws Exception {
    b = null;
    System.out.println("in tearDown()");
  }

  @Test
  public void test() {
    // fail("Not yet implemented");
    ArrayList<Integer> input = BubbleSort.numbers;

    ArrayList<Integer> expected = new ArrayList<>(/*
                                                   * {0, 1, 2, 3, 3, 4, 5, 6, 7,
                                                   * 8, 9}
                                                   */);

    ArrayList<Integer> actual = BubbleSort.sort(input);

    assertEquals(input.size(), actual.size());
    assertArrayEquals(expected.toArray(), actual.toArray());
  }

  @Test
  public void test2() {
    ArrayList<Integer> input = new ArrayList<>(/* {1, 2, 3, 4, 5, 6, 7} */);

    ArrayList<Integer> expected = input;

    ArrayList<Integer> actual = BubbleSort.sort(input);

    assertEquals(input.size(), actual.size());
    assertArrayEquals(expected.toArray(), actual.toArray());
  }

}
