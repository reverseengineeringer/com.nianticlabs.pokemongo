package rx.observers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observer;
import rx.Subscriber;
import rx.annotations.Experimental;
import rx.exceptions.CompositeException;

public class TestSubscriber<T>
  extends Subscriber<T>
{
  private static final Observer<Object> INERT = new Observer()
  {
    public void onCompleted() {}
    
    public void onError(Throwable paramAnonymousThrowable) {}
    
    public void onNext(Object paramAnonymousObject) {}
  };
  private final long initialRequest;
  private volatile Thread lastSeenThread;
  private final CountDownLatch latch = new CountDownLatch(1);
  private final TestObserver<T> testObserver;
  
  public TestSubscriber()
  {
    this(-1L);
  }
  
  @Experimental
  public TestSubscriber(long paramLong)
  {
    this(INERT, paramLong);
  }
  
  public TestSubscriber(Observer<T> paramObserver)
  {
    this(paramObserver, -1L);
  }
  
  @Experimental
  public TestSubscriber(Observer<T> paramObserver, long paramLong)
  {
    if (paramObserver == null) {
      throw new NullPointerException();
    }
    testObserver = new TestObserver(paramObserver);
    initialRequest = paramLong;
  }
  
  public TestSubscriber(Subscriber<T> paramSubscriber)
  {
    this(paramSubscriber, -1L);
  }
  
  @Experimental
  public static <T> TestSubscriber<T> create()
  {
    return new TestSubscriber();
  }
  
  @Experimental
  public static <T> TestSubscriber<T> create(long paramLong)
  {
    return new TestSubscriber(paramLong);
  }
  
  @Experimental
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver)
  {
    return new TestSubscriber(paramObserver);
  }
  
  @Experimental
  public static <T> TestSubscriber<T> create(Observer<T> paramObserver, long paramLong)
  {
    return new TestSubscriber(paramObserver, paramLong);
  }
  
  @Experimental
  public static <T> TestSubscriber<T> create(Subscriber<T> paramSubscriber)
  {
    return new TestSubscriber(paramSubscriber);
  }
  
  @Experimental
  public void assertCompleted()
  {
    int i = testObserver.getOnCompletedEvents().size();
    if (i == 0) {
      throw new AssertionError("Not completed!");
    }
    if (i > 1) {
      throw new AssertionError("Completed multiple times: " + i);
    }
  }
  
  @Experimental
  public void assertError(Class<? extends Throwable> paramClass)
  {
    List localList = testObserver.getOnErrorEvents();
    if (localList.size() == 0) {
      throw new AssertionError("No errors");
    }
    if (localList.size() > 1)
    {
      paramClass = new AssertionError("Multiple errors: " + localList.size());
      paramClass.initCause(new CompositeException(localList));
      throw paramClass;
    }
    if (!paramClass.isInstance(localList.get(0)))
    {
      paramClass = new AssertionError("Exceptions differ; expected: " + paramClass + ", actual: " + localList.get(0));
      paramClass.initCause((Throwable)localList.get(0));
      throw paramClass;
    }
  }
  
  @Experimental
  public void assertError(Throwable paramThrowable)
  {
    List localList = testObserver.getOnErrorEvents();
    if (localList.size() == 0) {
      throw new AssertionError("No errors");
    }
    if (localList.size() > 1)
    {
      paramThrowable = new AssertionError("Multiple errors: " + localList.size());
      paramThrowable.initCause(new CompositeException(localList));
      throw paramThrowable;
    }
    if (!paramThrowable.equals(localList.get(0)))
    {
      paramThrowable = new AssertionError("Exceptions differ; expected: " + paramThrowable + ", actual: " + localList.get(0));
      paramThrowable.initCause((Throwable)localList.get(0));
      throw paramThrowable;
    }
  }
  
  public void assertNoErrors()
  {
    if (getOnErrorEvents().size() > 0) {
      throw new RuntimeException("Unexpected onError events: " + getOnErrorEvents().size(), (Throwable)getOnErrorEvents().get(0));
    }
  }
  
  @Experimental
  public void assertNoTerminalEvent()
  {
    List localList = testObserver.getOnErrorEvents();
    int i = testObserver.getOnCompletedEvents().size();
    if ((localList.size() > 0) || (i > 0))
    {
      if (localList.isEmpty()) {
        throw new AssertionError("Found " + localList.size() + " errors and " + i + " completion events instead of none");
      }
      if (localList.size() == 1)
      {
        localAssertionError = new AssertionError("Found " + localList.size() + " errors and " + i + " completion events instead of none");
        localAssertionError.initCause((Throwable)localList.get(0));
        throw localAssertionError;
      }
      AssertionError localAssertionError = new AssertionError("Found " + localList.size() + " errors and " + i + " completion events instead of none");
      localAssertionError.initCause(new CompositeException(localList));
      throw localAssertionError;
    }
  }
  
  @Experimental
  public void assertNoValues()
  {
    int i = testObserver.getOnNextEvents().size();
    if (i > 0) {
      throw new AssertionError("No onNext events expected yet some received: " + i);
    }
  }
  
  @Experimental
  public void assertNotCompleted()
  {
    int i = testObserver.getOnCompletedEvents().size();
    if (i == 1) {
      throw new AssertionError("Completed!");
    }
    if (i > 1) {
      throw new AssertionError("Completed multiple times: " + i);
    }
  }
  
  public void assertReceivedOnNext(List<T> paramList)
  {
    testObserver.assertReceivedOnNext(paramList);
  }
  
  public void assertTerminalEvent()
  {
    testObserver.assertTerminalEvent();
  }
  
  public void assertUnsubscribed()
  {
    if (!isUnsubscribed()) {
      throw new AssertionError("Not unsubscribed.");
    }
  }
  
  @Experimental
  public void assertValue(T paramT)
  {
    assertReceivedOnNext(Collections.singletonList(paramT));
  }
  
  @Experimental
  public void assertValueCount(int paramInt)
  {
    int i = testObserver.getOnNextEvents().size();
    if (i != paramInt) {
      throw new AssertionError("Number of onNext events differ; expected: " + paramInt + ", actual: " + i);
    }
  }
  
  @Experimental
  public void assertValues(T... paramVarArgs)
  {
    assertReceivedOnNext(Arrays.asList(paramVarArgs));
  }
  
  public void awaitTerminalEvent()
  {
    try
    {
      latch.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new RuntimeException("Interrupted", localInterruptedException);
    }
  }
  
  public void awaitTerminalEvent(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      latch.await(paramLong, paramTimeUnit);
      return;
    }
    catch (InterruptedException paramTimeUnit)
    {
      throw new RuntimeException("Interrupted", paramTimeUnit);
    }
  }
  
  public void awaitTerminalEventAndUnsubscribeOnTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    try
    {
      if (!latch.await(paramLong, paramTimeUnit)) {
        unsubscribe();
      }
      return;
    }
    catch (InterruptedException paramTimeUnit)
    {
      unsubscribe();
    }
  }
  
  public Thread getLastSeenThread()
  {
    return lastSeenThread;
  }
  
  public List<Notification<T>> getOnCompletedEvents()
  {
    return testObserver.getOnCompletedEvents();
  }
  
  public List<Throwable> getOnErrorEvents()
  {
    return testObserver.getOnErrorEvents();
  }
  
  public List<T> getOnNextEvents()
  {
    return testObserver.getOnNextEvents();
  }
  
  public void onCompleted()
  {
    try
    {
      lastSeenThread = Thread.currentThread();
      testObserver.onCompleted();
      return;
    }
    finally
    {
      latch.countDown();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      lastSeenThread = Thread.currentThread();
      testObserver.onError(paramThrowable);
      return;
    }
    finally
    {
      latch.countDown();
    }
  }
  
  public void onNext(T paramT)
  {
    lastSeenThread = Thread.currentThread();
    testObserver.onNext(paramT);
  }
  
  public void onStart()
  {
    if (initialRequest >= 0L) {
      requestMore(initialRequest);
    }
  }
  
  public void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.observers.TestSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */