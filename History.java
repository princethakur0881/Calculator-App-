package calculator;

import java.util.ArrayList;
import java.util.List;

public class History {

    private final List<String> historyList = new ArrayList<>();

    public void add(String entry) {
        historyList.add(entry);
    }

    public List<String> getAll() {
        return historyList;
    }
}
