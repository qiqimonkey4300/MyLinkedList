public class MyLinkedList {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node newest = new Node(value);
    if (size == 0) {
      start = newest;
    } else {
      newest.setPrev(end); end.setNext(newest);
    }
    end = newest;
    size++;
    return true;
  }

  public void add(int index, String value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("This index isn't allowed");
    }
    if (size == 0 || index == size) {
      add(value);
    } else {
      Node newest = new Node(value);
      if (index == 0) {
        newest.setPrev(null);
        newest.setNext(start);
        start.setPrev(newest);
        start = newest;
      }
      else {
        newest.setPrev(getNode(index - 1));
        newest.setNext(getNode(index));
        getNode(index - 1).setNext(newest);
        getNode(index + 1).setPrev(newest);
      }
      size++;
    }
  }

  //public String get(int index) {}

  //public String set(int index, String value) { }

  //public String toString() {}

  //public String toStringReversed() { }

  //Any helper method that returns a Node object MUST BE PRIVATE!
  private Node getNode(int index) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }
}
