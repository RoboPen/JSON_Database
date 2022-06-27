package server;

import com.beust.jcommander.Parameter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Args implements Serializable {
    @Parameter(names = "-t", required = true, description = "type of the request")
    private String command = "";

    @Parameter(names = "-i", description = "index of the cell")
    private String index = "";

    @Parameter(names = "-m", description = "value to save in the database")
    private String value = "";

    public String getCommand() {
        return command;
    }

    public String getIndex() {
        return index;
    }

    public String getValue() {
        return value;
    }
}
