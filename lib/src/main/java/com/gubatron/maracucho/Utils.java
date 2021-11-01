package com.gubatron.maracucho;

public final class Utils {
    static final Thread MAIN_THREAD = Thread.currentThread();

    public static void assertInMainThread() {
        if (!Thread.currentThread().equals(MAIN_THREAD)) {
            throw new RuntimeException("assertInMainThread() failed");
        }
        System.out.println("Main Thread ID -> " + Thread.currentThread().getId() + " == " + MAIN_THREAD.getId());
    }

    public static void assertInBackgroundThread() {
        if (Thread.currentThread().equals(MAIN_THREAD)) {
            throw new RuntimeException("assertInBackgroundThread() failed");
        }
    }
}
