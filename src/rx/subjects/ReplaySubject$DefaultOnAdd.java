package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$DefaultOnAdd<T>
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  final ReplaySubject.BoundedState<T> state;
  
  public ReplaySubject$DefaultOnAdd(ReplaySubject.BoundedState<T> paramBoundedState)
  {
    state = paramBoundedState;
  }
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    paramSubjectObserver.index(state.replayObserverFromIndex(state.head(), paramSubjectObserver));
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.DefaultOnAdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */