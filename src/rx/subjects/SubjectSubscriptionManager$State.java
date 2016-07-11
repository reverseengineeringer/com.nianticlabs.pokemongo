package rx.subjects;

public final class SubjectSubscriptionManager$State<T>
{
  static final State EMPTY = new State(false, NO_OBSERVERS);
  static final SubjectSubscriptionManager.SubjectObserver[] NO_OBSERVERS = new SubjectSubscriptionManager.SubjectObserver[0];
  static final State TERMINATED = new State(true, NO_OBSERVERS);
  final SubjectSubscriptionManager.SubjectObserver[] observers;
  final boolean terminated;
  
  public SubjectSubscriptionManager$State(boolean paramBoolean, SubjectSubscriptionManager.SubjectObserver[] paramArrayOfSubjectObserver)
  {
    terminated = paramBoolean;
    observers = paramArrayOfSubjectObserver;
  }
  
  public State add(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
  {
    int i = observers.length;
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver = new SubjectSubscriptionManager.SubjectObserver[i + 1];
    System.arraycopy(observers, 0, arrayOfSubjectObserver, 0, i);
    arrayOfSubjectObserver[i] = paramSubjectObserver;
    return new State(terminated, arrayOfSubjectObserver);
  }
  
  public State remove(SubjectSubscriptionManager.SubjectObserver paramSubjectObserver)
  {
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver2 = observers;
    int m = arrayOfSubjectObserver2.length;
    State localState;
    if ((m == 1) && (arrayOfSubjectObserver2[0] == paramSubjectObserver)) {
      localState = EMPTY;
    }
    SubjectSubscriptionManager.SubjectObserver[] arrayOfSubjectObserver1;
    int j;
    SubjectSubscriptionManager.SubjectObserver localSubjectObserver;
    do
    {
      do
      {
        return localState;
        localState = this;
      } while (m == 0);
      arrayOfSubjectObserver1 = new SubjectSubscriptionManager.SubjectObserver[m - 1];
      j = 0;
      i = 0;
      if (j >= m) {
        break;
      }
      localSubjectObserver = arrayOfSubjectObserver2[j];
      if (localSubjectObserver == paramSubjectObserver) {
        break label150;
      }
      localState = this;
    } while (i == m - 1);
    int k = i + 1;
    arrayOfSubjectObserver1[i] = localSubjectObserver;
    int i = k;
    label150:
    for (;;)
    {
      j += 1;
      break;
      if (i == 0) {
        return EMPTY;
      }
      paramSubjectObserver = arrayOfSubjectObserver1;
      if (i < m - 1)
      {
        paramSubjectObserver = new SubjectSubscriptionManager.SubjectObserver[i];
        System.arraycopy(arrayOfSubjectObserver1, 0, paramSubjectObserver, 0, i);
      }
      return new State(terminated, paramSubjectObserver);
    }
  }
}

/* Location:
 * Qualified Name:     rx.subjects.SubjectSubscriptionManager.State
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */