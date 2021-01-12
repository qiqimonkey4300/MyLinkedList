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

  public String get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("This index isn't allowed");
    }
    return getNode(index).getData();
  }

  public String set(int index, String value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("This index isn't allowed");
    }
    String t = get(index);
    getNode(index).setData(value);
    return t;
  }

  public String toString() {
    String x = "[";
    Node current = start;
    while (current != null) {
      x += current.getData() + ", ";
      current = current.getNext();
    }
    if (x.length() > 1) x = x.substring(0, x.length()-2);
    else x = x.substring(0, 1);
    x += "]";
    return x;
  }

  public String toStringReversed() {
    String x = "[";
    Node current = end;
    while (current != null) {
      x += current.getData() + ", ";
      current = current.getPrev();
    }
    if (x.length() > 1) x = x.substring(0, x.length()-2);
    else x = x.substring(0, 1);
    x += "]";
    return x;
  }

  public String remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("This index isn't allowed");
    }
    String t = get(index);
    if (size == 1) {
      start = null;
      end = null;
    } else if (index == 0) {
      getNode(1).setPrev(null);
      start = getNode(1);
    } else if (index == size - 1) {
      getNode(index - 1).setNext(null);
      end = getNode(index - 1);
    } else {
      Node front = getNode(index - 1);
      Node back = getNode(index + 1);
      front.setNext(back);
      back.setPrev(front);
    }
    size--;
    return t;
  }

  public void extend(MyLinkedList other) {
    if (size == 0) {
      start = other.start;
      end = other.end;
    } else if (other.size > 0) {
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
    }
    size += other.size();
    other.size = 0;
    other.start = null;
    other.end = null;
  }

  //Any helper method that returns a Node object MUST BE PRIVATE!
  private Node getNode(int index) {
    Node current = start;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current;
  }
}
