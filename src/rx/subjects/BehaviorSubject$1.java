package rx.subjects;

import rx.functions.Action1;

final class BehaviorSubject$1
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  BehaviorSubject$1(SubjectSubscriptionManager paramSubjectSubscriptionManager) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubjectObserver.emitFirst(val$state.get(), val$state.nl);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.BehaviorSubject.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */