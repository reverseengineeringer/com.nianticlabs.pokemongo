package rx.subjects;

abstract interface ReplaySubject$ReplayState<T, I>
{
  public abstract void complete();
  
  public abstract void error(Throwable paramThrowable);
  
  public abstract boolean isEmpty();
  
  public abstract T latest();
  
  public abstract void next(T paramT);
  
  public abstract boolean replayObserver(SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
  
  public abstract I replayObserverFromIndex(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver);
  
  public abstract I replayObserverFromIndexTest(I paramI, SubjectSubscriptionManager.SubjectObserver<? super T> paramSubjectObserver, long paramLong);
  
  public abstract int size();
  
  public abstract boolean terminated();
  
  public abstract T[] toArray(T[] paramArrayOfT);
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.ReplayState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */