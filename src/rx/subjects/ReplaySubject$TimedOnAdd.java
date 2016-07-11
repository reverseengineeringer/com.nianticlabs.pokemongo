package rx.subjects;

import rx.Scheduler;
import rx.functions.Action1;

final class ReplaySubject$TimedOnAdd<T>
  implements Action1<SubjectSubscriptionManager.SubjectObserver<T>>
{
  final Scheduler scheduler;
  final ReplaySubject.BoundedState<T> state;
  
  public ReplaySubject$TimedOnAdd(ReplaySubject.BoundedState<T> paramBoundedState, Scheduler paramScheduler)
  {
    state = paramBoundedState;
    scheduler = paramScheduler;
  }
  
  public void call(SubjectSubscriptionManager.SubjectObserver<T> paramSubjectObserver)
  {
    if (!state.terminated) {}
    for (ReplaySubject.NodeList.Node localNode = state.replayObserverFromIndexTest(state.head(), paramSubjectObserver, scheduler.now());; localNode = state.replayObserverFromIndex(state.head(), paramSubjectObserver))
    {
      paramSubjectObserver.index(localNode);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.ReplaySubject.TimedOnAdd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */