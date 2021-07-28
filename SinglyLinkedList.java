import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {
    private int size;
    private Elem head;

    public SinglyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    public void add(T item) {
        Elem elem = new Elem();
        elem.item = item;
        Elem current = this.head;

        if (this.head == null) {
            this.head = elem;
            this.head.next = null;
            this.size = 1;

        } else {
            while (current.next != null) {
                current = current.next;
            }

            current.next = elem;
            elem.next = null;
            this.size += 1;
        }
    }

    public class Elem {
        public T item;
        public Elem next;
    }

    public void insertFirst(T item) {
        Elem elem = new Elem();
        elem.item = item;
        elem.next = this.head;
        this.head = elem;
        this.size++;
    }

    public void insertElemAt(T item, int position) {
        Elem elem = new Elem();
        elem.item = item;
        Elem current = this.head;

        if (this.head != null && position <= this.size) {
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            elem.next = current.next;
            current.next = elem;
            this.size += 1;
        } else {
            System.out.println("Current size is " + size);
        }
    }

    public void deleteFirstElem() {
        if (head != null) {
            this.head = this.head.next;
            this.size--;
        } else {
            System.out.println("Linked list has no element");
        }
    }

    public void deleteLastElem() {
        Elem currentElem = this.head;
        if (size == 1) {
            head = null;
            size = 0;
        } else {
            Elem prevElem = null;
            while (currentElem.next != null) {
                prevElem = currentElem;
                currentElem = currentElem.next;
            }
            prevElem.next = null;
            this.size--;
        }
    }

    public void deleteElemAt(int position) {
        if (position <= this.size && this.head != null) {
            Elem currentElem = this.head;
            Elem prevElem = null;
            for (int i = 0; i < position; i++) {
                prevElem = currentElem;
                currentElem = currentElem.next;
            }
            prevElem.next = currentElem.next;
            this.size--;
        } else {
            System.out.println("No node exist at position: " + position);
        }
    }

    public void find(T item) {
        Elem elem = this.head;
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (elem.item.equals(item)) {
                System.out.println("Item " + item + " found at location " + i);
                found = true;
            }
            elem = elem.next;
        }

        if (!found) {
            System.out.println("Item " + item + " found in the Linked list");
        }
    }

    public void findElemAt(int location) {
        Elem elem = this.head;
        if (head != null && location <= size) {
            for (int i = 0; i < location; i++) {
                elem = elem.next;
            }
            System.out.println("Elem item at location " + location + " is " + elem.item);
        }
    }

    public void findLastElem() {
        Elem elem = this.head;
        if (head != null) {
            for (int i = 0; i < size - 1; i++) {
                elem = elem.next;
            }
            System.out.println("Elem item at last location is " + elem.item);
        }
    }

    public void printElem() {
        if (this.size < 1) {
            System.out.println("No nodes in the linked list");
        } else {
            Elem current = this.head;
            for (int i = 0; i < this.size; i++) {
                System.out.println("Elem " + current.item + " is at location " + i);
                current = current.next;
            }
        }
    }

    public int getListSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Elem current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T item = current.item;
                    current = current.next;
                    return item;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not didnt.");
            }
        };
    }
}

