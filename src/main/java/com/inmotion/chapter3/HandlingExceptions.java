package com.inmotion.chapter3;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 例外の取り扱い
 */
public class HandlingExceptions {

    public void doInOrder(Runnable first, Runnable second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    first.run();
                    second.run();
                } catch (Throwable t) {
                    handler.accept(t);
                }
            }
        };
        t.start();
    }

    public <T> void doInOrderAsync(Supplier<T> first, Consumer<T> second, Consumer<Throwable> handler) {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result);
                } catch (Throwable t) {
                    handler.accept(t);
                }
            }
        };
        t.start();
    }

    public <T> Supplier<T> unchecked(Callable<T> f) {
        return () -> {
            try {
                return f.call();
            } catch (Exception e) {
                throw new RuntimeException();
            } catch (Throwable t) {
                throw t;
            }
        };
    }

    public void sampleMethod() {
        unchecked(() -> new String(Files.readAllBytes(Paths.get("/etc/password")), StandardCharsets.UTF_8));
    }

}
