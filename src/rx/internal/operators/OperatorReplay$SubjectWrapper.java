package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.subjects.Subject;

public final class OperatorReplay$SubjectWrapper<T>
  extends Subject<T, T>
{
  final Subject<T, T> subject;
  
  public OperatorReplay$SubjectWrapper(Observable.OnSubscribe<T> paramOnSubscribe, Subject<T, T> paramSubject)
  {
    super(paramOnSubscribe);
    subject = paramSubject;
  }
  
  public boolean hasObservers()
  {
    return subject.hasObservers();
  }
  
  public void onCompleted()
  {
    subject.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    subject.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    subject.onNext(paramT);
  }
}

/* Location:
 * Qualified Name:     rx.internal.operators.OperatorReplay.SubjectWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */