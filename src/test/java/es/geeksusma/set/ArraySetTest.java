package es.geeksusma.set;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ArraySetTest {

  @Test
  void should_returnTrue_when_emptySet() {
    //given
    ArraySet mySet = new ArraySet();

    //when
    final Boolean empty = mySet.isEmpty();

    //then
    assertThat(empty).isTrue();
  }

  @Test
  void should_returnZero_when_isEmpty() {
    //given
    ArraySet mySet = new ArraySet();

    //when
    final int size = mySet.size();

    //then
    assertThat(size).isZero();
  }

  @Test
  void should_notEmpty_when_add() {
    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);

    //when
    final Boolean empty = mySet.isEmpty();

    //then
    assertThat(empty).isFalse();

  }

  @Test
  void should_returnSize_when_add() {
    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(2);
    mySet.add(5);
    mySet.add(2);

    //when
    final int size = mySet.size();

    //then
    assertThat(size).isEqualTo(3);
  }

  @Test
  void should_keepOneElement_when_addedTwice() {
    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(1);

    //when
    final int size = mySet.size();

    //then
    assertThat(size).isEqualTo(1);
  }

  @Test
  void should_grow_when_sizeIsExceeded() {
    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(2);
    mySet.add(3);
    mySet.add(4);
    mySet.add(5);
    mySet.add(6);
    mySet.add(7);
    mySet.add(8);
    mySet.add(9);
    mySet.add(10);
    mySet.add(11);

    //when
    final int size = mySet.size();

    //then
    assertThat(size).isEqualTo(11);
  }

  @Test
  void should_returnTrue_when_elementExists() {

    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);

    //when
    final boolean exists = mySet.contains(1);

    //then
    assertThat(exists).isTrue();
  }

  @Test
  void should_returnFalse_when_elementDoesNotExists() {

    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(2);

    //when
    final boolean exists = mySet.contains(3);

    //then
    assertThat(exists).isFalse();
  }

  @Test
  void should_elementNotExistAnymore_when_removed() {

    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(2);

    //when
    final boolean removed = mySet.remove(1);

    //then
    assertThat(mySet.contains(1)).isFalse();
    assertThat(removed).isTrue();

  }

  @Test
  void should_skipDeletion_when_notFound() {

    //given
    ArraySet mySet = new ArraySet();
    mySet.add(1);
    mySet.add(2);

    //when
    final boolean removed = mySet.remove(4);

    //then
    assertThat(mySet.size()).isEqualTo(2);
    assertThat(removed).isFalse();

  }


  @Test
  void should_skipDeletion_when_empty() {

    //given
    ArraySet mySet = new ArraySet();

    //when
    final boolean removed = mySet.remove(4);

    //then
    assertThat(mySet.isEmpty()).isTrue();
    assertThat(removed).isFalse();

  }
}
