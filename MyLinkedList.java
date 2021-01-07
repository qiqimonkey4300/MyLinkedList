public class MyLinkedList{
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
  }

  public int size() {
    return size;
  }
  /*
  public boolean add(String value) { }

  public void add(int index, String value) { }

  public String get(int index) {}

  public String set(int index, String value) { }

  public String toString() { }

  public String toStringReversed() { }
  */
  //Any helper method that returns a Node object MUST BE PRIVATE!
  private Node getNode(int index) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }
}
