package tasks.task1;

import lombok.Getter;

@Getter
public class parsedString {

    private static final String SEPARATOR = "";

    private String[] symbols;

    public parsedString(String initialString){
        symbols = initialString.split(SEPARATOR);
    }
}
