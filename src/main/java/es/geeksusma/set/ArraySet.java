package es.geeksusma.set;

import java.util.Arrays;

public class ArraySet {

  private static final int ARRAY_BLOCKS = 10;
  private int[] elements;

  private int size;

  public ArraySet() {
    elements = new int[ARRAY_BLOCKS];
    size = 0;
  }

  public Boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void add(int element) {
    increaseElements();
    if (exists(element)) {
      return;
    }
    appendElement(element);
  }

  private void appendElement(int element) {
    this.elements[size] = element;
    size++;
  }


  private void increaseElements() {
    if (this.elements.length == size) {
      this.elements = Arrays.copyOf(this.elements, this.elements.length + ARRAY_BLOCKS);
    }
  }

  public boolean contains(final int element) {
    return exists(element);
  }

  public boolean remove(int element) {
    final int index = getIndex(element);
    if (index > -1) {
      System.arraycopy(this.elements, index + 1, this.elements, index,
          this.elements.length - 1 - index);
      return true;
    }
    return false;
  }

  private boolean exists(int element) {
    return getIndex(element) >= 0;
  }

  private int getIndex(int element) {
    for (int index = 0; index < size; index++) {
      final int existingElement = this.elements[index];
      if (element == existingElement) {
        return index;
      }
    }
    return -1;
  }
}
