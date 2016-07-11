package rx.subjects;

import rx.functions.Action1;

final class ReplaySubject$5
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  ReplaySubject$5(ReplaySubject.BoundedState paramBoundedState) {}
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    ReplaySubject.NodeList.Node localNode2 = (ReplaySubject.NodeList.Node)paramSubjectObserver.index();
    ReplaySubject.NodeList.Node localNode1 = localNode2;
    if (localNode2 == null) {
      localNode1 = val$state.head();
    }
    val$state.replayObserverFromIndex(localNode1, paramSubjectObserver);
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */