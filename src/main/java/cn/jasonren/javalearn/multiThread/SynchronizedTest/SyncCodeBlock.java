package cn.jasonren.javalearn.multiThread.SynchronizedTest;

public class SyncCodeBlock {
    public int i;
    public void syncTask() {
        synchronized (this) {
            i++;
        }
    }
}
