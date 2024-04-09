package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class BagOfTokens {
    private final List<Token> tokens;
    private final Lock lock;

    public BagOfTokens(int n) {
        tokens = new ArrayList<>();
        lock = new ReentrantLock();

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                tokens.add(new Token(i, j));
            }
        }
        Collections.shuffle(tokens);
    }

    public Token extractToken() {
        lock.lock();
        Token token = null;
        if (!tokens.isEmpty()) {
            token = tokens.remove(0);
        }
        lock.unlock();
        return token;
    }
}
