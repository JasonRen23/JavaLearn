package cn.jasonren.javalearn.multiThread.SynchronizedTest;

public class SyncMethod {
    public int i;

    public synchronized void syncTask() {
        i++;
    }
}
