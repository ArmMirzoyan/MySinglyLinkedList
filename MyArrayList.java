import java.util.Arrays;
import java.util.Iterator;

class MyArrayList<E> implements Iterable<E>{

    private static final int default_capacity = 10;
    private int size = 0;
    private Object elementData[] = {};

    public MyArrayList() {
        elementData = new Object[default_capacity];
    }

    public void add(E e) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = e;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elementData[index]; // return value on index.
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Object removedElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;

        return removedElement;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    public void display() {
        System.out.print("Displaying list : ");
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elementData[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) elementData[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}


