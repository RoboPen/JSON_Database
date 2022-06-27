package server;

import java.security.InvalidParameterException;
import java.util.*;

public class Database {
    private final int initialCapacity = 1000;
    private final String[] array = new String[initialCapacity];

    public Database() {
        Arrays.fill(array, "");
    }

    public String get(int numberCell) {
        if (this.array[numberCell - 1].isEmpty()) {
            throw new InvalidParameterException();
        }
        return this.array[numberCell - 1];
    }

    public void set(int numberCell, String text) {
        this.array[numberCell - 1] = text;
    }

    public void delete(int numberCell) {
        this.array[numberCell - 1] =  "";
    }
}
