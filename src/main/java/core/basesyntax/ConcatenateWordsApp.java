package core.basesyntax;

import java.util.List;

public class ConcatenateWordsApp implements ConcatenateWordsInterface {

    private List<String> wordsFromFile;

    public ConcatenateWordsApp(List<String> wordsFromFile) {
        this.wordsFromFile = wordsFromFile;
    }

    @Override
    public String findFirstLongestConcatenatedWord(List<String> concatenatedWords) {
        return null;
    }

    @Override
    public String findSecondLongestConcatenatedWord(List<String> concatenatedWords) {
        return null;
    }

    @Override
    public int getConcatenatedWordsCount() {
        return 0;
    }
}
