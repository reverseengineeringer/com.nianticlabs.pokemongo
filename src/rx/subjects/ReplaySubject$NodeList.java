package rx.subjects;

final class ReplaySubject$NodeList<T>
{
  final Node<T> head = new Node(null);
  int size;
  Node<T> tail = head;
  
  public void addLast(T paramT)
  {
    Node localNode = tail;
    paramT = new Node(paramT);
    next = paramT;
    tail = paramT;
    size += 1;
  }
  
  public void clear()
  {
    tail = head;
    size = 0;
  }
  
  public boolean isEmpty()
  {
    return size == 0;
  }
  
  public T removeFirst()
  {
    if (head.next == null) {
      throw new IllegalStateException("Empty!");
    }
    Node localNode = head.next;
    head.next = next;
    if (head.next == null) {
      tail = head;
    }
    size -= 1;
    return (T)value;
  }
  
  public int size()
  {
    return size;
  }
  
  static final class Node<T>
  {
    volatile Node<T> next;
    final T value;
    
    Node(T paramT)
    {
      value = paramT;
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.NodeList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */