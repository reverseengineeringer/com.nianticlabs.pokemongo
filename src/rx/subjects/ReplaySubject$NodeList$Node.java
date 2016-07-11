package rx.subjects;

final class ReplaySubject$NodeList$Node<T>
{
  volatile Node<T> next;
  final T value;
  
  ReplaySubject$NodeList$Node(T paramT)
  {
    value = paramT;
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.NodeList.Node
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */