package rx.internal.operators;

import java.util.NoSuchElementException;
import rx.Subscriber;

final class OperatorSingle$ParentSubscriber<T>
  extends Subscriber<T>
{
  private final Subscriber<? super T> child;
  private final T defaultValue;
  private final boolean hasDefaultValue;
  private boolean hasTooManyElements = false;
  private boolean isNonEmpty = false;
  private T value;
  
  OperatorSingle$ParentSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, T paramT)
  {
    child = paramSubscriber;
    hasDefaultValue = paramBoolean;
    defaultValue = paramT;
  }
  
  public void onCompleted()
  {
    if (hasTooManyElements) {
      return;
    }
    if (isNonEmpty)
    {
      child.onNext(value);
      child.onCompleted();
      return;
    }
    if (hasDefaultValue)
    {
      child.onNext(defaultValue);
      child.onCompleted();
      return;
    }
    child.onError(new NoSuchElementException("Sequence contains no elements"));
  }
  
  public void onError(Throwable paramThrowable)
  {
    child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (isNonEmpty)
    {
      hasTooManyElements = true;
      child.onError(new IllegalArgumentException("Sequence contains too many elements"));
      unsubscribe();
      return;
    }
    value = paramT;
    isNonEmpty = true;
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorSingle.ParentSubscriber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */