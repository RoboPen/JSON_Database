package server;

import java.security.InvalidParameterException;

public class Menu {
    private final Database database = new Database();
    public String start(Args commandLineObject) {
        while (true) {
            int numberCell;
            switch (commandLineObject.getCommand()) {
                case "get":
                    try {
                        numberCell = Integer.parseInt(commandLineObject.getIndex());
                        return database.get(numberCell);
                    } catch (IndexOutOfBoundsException | InvalidParameterException exception) {
                        return "ERROR";
                    }
                case "set":
                    try {
                        numberCell = Integer.parseInt(commandLineObject.getIndex());
                        database.set(numberCell, commandLineObject.getValue());
                        return "OK";
                    } catch (IndexOutOfBoundsException exception) {
                        return "ERROR";
                    }
                case "delete":
                    try {
                        numberCell = Integer.parseInt(commandLineObject.getIndex());
                        database.delete(numberCell);
                        return "OK";
                    } catch (IndexOutOfBoundsException exception) {
                        return "ERROR";
                    }
            }
        }
    }
}
