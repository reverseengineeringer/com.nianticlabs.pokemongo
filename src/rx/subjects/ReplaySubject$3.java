package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$3
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$3(ReplaySubject.UnboundedReplayState paramUnboundedReplayState) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    Integer localInteger2 = (Integer)paramSubjectObserver.index();
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null) {
      localInteger1 = Integer.valueOf(0);
    }
    val$state.replayObserverFromIndex(localInteger1, paramSubjectObserver);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */