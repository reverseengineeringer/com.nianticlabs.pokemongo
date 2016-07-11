package rx.observers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Notification;
import rx.Observer;

public class TestObserver<T>
  implements Observer<T>
{
  private static Observer<Object> INERT = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private final Observer<T> delegate;
  private final ArrayList<Notification<T>> onCompletedEvents = new ArrayList();
  private final ArrayList<Throwable> onErrorEvents = new ArrayList();
  private final ArrayList<T> onNextEvents = new ArrayList();
  
  public TestObserver()
  {
    delegate = INERT;
  }
  
  public TestObserver(Observer<T> paramObserver)
  {
    delegate = paramObserver;
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    if (onNextEvents.size() != paramList.size()) {
      throw new AssertionError("Number of items does not match. Provided: " + paramList.size() + "  Actual: " + onNextEvents.size());
    }
    int i = 0;
    while (i < paramList.size())
    {
      if (paramList.get(i) == null)
      {
        if (onNextEvents.get(i) != null) {
          throw new AssertionError("Value at index: " + i + " expected to be [null] but was: [" + onNextEvents.get(i) + "]");
        }
      }
      else if (!paramList.get(i).equals(onNextEvents.get(i))) {
        throw new AssertionError("Value at index: " + i + " expected to be [" + paramList.get(i) + "] (" + paramList.get(i).getClass().getSimpleName() + ") but was: [" + onNextEvents.get(i) + "] (" + onNextEvents.get(i).getClass().getSimpleName() + ")");
      }
      i += 1;
    }
  }
  
  public void assertTerminalEvent()
  {
    if (onErrorEvents.size() > 1) {
      throw new AssertionError("Too many onError events: " + onErrorEvents.size());
    }
    if (onCompletedEvents.size() > 1) {
      throw new AssertionError("Too many onCompleted events: " + onCompletedEvents.size());
    }
    if ((onCompletedEvents.size() == 1) && (onErrorEvents.size() == 1)) {
      throw new AssertionError("Received both an onError and onCompleted. Should be one or the other.");
    }
    if ((onCompletedEvents.size() == 0) && (onErrorEvents.size() == 0)) {
      throw new AssertionError("No terminal events received.");
    }
  }
  
  public List<Object> getEvents()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(onNextEvents);
    localArrayList.add(onErrorEvents);
    localArrayList.add(onCompletedEvents);
    return Collections.unmodifiableList(localArrayList);
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return Collections.unmodifiableList(onCompletedEvents);
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return Collections.unmodifiableList(onErrorEvents);
  }
  
  public List<T> getOnNextEvents()
  {
    return Collections.unmodifiableList(onNextEvents);
  }
  
  public void onCompleted()
  {
    onCompletedEvents.add(Notification.createOnCompleted());
    delegate.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    onErrorEvents.add(paramThrowable);
    delegate.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    onNextEvents.add(paramT);
    delegate.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.observers.TestObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */