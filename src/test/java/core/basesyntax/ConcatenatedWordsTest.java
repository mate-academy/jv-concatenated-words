package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConcatenatedWordsTest {
    private final static String LONGEST_CONCATENATED_WORD = "ratcatdogcat";
    private final static String SECOND_LONGEST_CONCATENATED_WORD_WHEN_SAME_LENGTH = "catdogcatrat";
    private final static String SECOND_LONGEST_CONCATENATED_WORD = "catsdogcats";
    private final static String NO_CONCATENATED_WORD = "";
    private final static Integer TOTAL_COUNT_OF_CONCATENATED_WORDS = 3;
    private final static Integer TOTAL_COUNT_WHEN_NO_CONCATENATED_WORDS = 0;
    private final static List<String> ARRAY_OF_WORDS = List.of("cat", "cats", "catsdogcats",
            "dog", "hippopotamuses", "rat",
            "ratcatdogcat", "dogcatsdog");
    private final static List<String> ARRAY_OF_NOCONCATENATED_WORDS = List.of("cat", "cats", "dog",
            "hippopotamuses", "rat");
    private final static List<String> ARRAY_WITH_CONCATENATED_WORDS_OF_SAME_LENGTH =
            List.of("cat", "cats", "catsdogcats",
                    "ratcatdogcat", "dog", "hippopotamuses",
                    "rat", "ratcatdogcat", "dogcatsdog");
    private List<String> listOfWords;
    private List<String> emptyListOfWords;
    private List<String> listWithNoConcatenatedWords;
    private List<String> listOfWordsWhereTheSameLengthOfConcatenatedWord;
    private ConcatenatedWords concatenatedWords;

    @Before
    public void init() {
        listOfWords = List.copyOf(ARRAY_OF_WORDS);

        emptyListOfWords = new ArrayList<>();

        listWithNoConcatenatedWords = List.copyOf(ARRAY_OF_NOCONCATENATED_WORDS);

        listOfWordsWhereTheSameLengthOfConcatenatedWord =
                List.copyOf(ARRAY_WITH_CONCATENATED_WORDS_OF_SAME_LENGTH);
    }

    @Test
    public void longestConcatenatedWord() {
        concatenatedWords = new ConcatenatedWords(listOfWords);
        Assert.assertEquals("The longest concatenated word expected: \"ratcatdogcat\". " +
                        "But is: " + concatenatedWords.longestConcatenatedWord(),
                LONGEST_CONCATENATED_WORD, concatenatedWords.longestConcatenatedWord());
    }

    @Test
    public void secondLongestConcatenatedWord() {
        concatenatedWords = new ConcatenatedWords(listOfWords);
        Assert.assertEquals("The second longest concatenated word expected: \"catsdogcats\". " +
                        "But is: " + concatenatedWords.secondLongestConcatenatedWord(),
                SECOND_LONGEST_CONCATENATED_WORD, concatenatedWords.secondLongestConcatenatedWord());
    }

    @Test
    public void longestConcatenatedWordWithSampleLength() {
        concatenatedWords = new ConcatenatedWords(listOfWordsWhereTheSameLengthOfConcatenatedWord);
        Assert.assertEquals("The answer for the longest concatenated word, " +
                        "when there are concatenated words with same length, is \"ratcatdogcat\". " +
                        "But is: " + concatenatedWords.longestConcatenatedWord(),
                LONGEST_CONCATENATED_WORD,
                concatenatedWords.longestConcatenatedWord());
    }

    @Test
    public void secondLongestConcatenatedWordWithSameLength() {
        concatenatedWords = new ConcatenatedWords(listOfWordsWhereTheSameLengthOfConcatenatedWord);
        Assert.assertEquals("The answer for the second longest concatenated word " +
                        "when there are concatenated words with same length is: \"catdogcatrat\". " +
                        "But is: " + concatenatedWords.secondLongestConcatenatedWord(),
                SECOND_LONGEST_CONCATENATED_WORD_WHEN_SAME_LENGTH,
                concatenatedWords.secondLongestConcatenatedWord());
    }

    @Test
    public void totalCountOfAllTheConcatenatedWords() {
        concatenatedWords = new ConcatenatedWords(listOfWords);
        Assert.assertEquals("The total count of all the concatenated words is: 3" +
                        "But got: " + concatenatedWords.totalCountOfAllTheConcatenatedWords(),
                TOTAL_COUNT_OF_CONCATENATED_WORDS,
                concatenatedWords.totalCountOfAllTheConcatenatedWords());
    }

    @Test
    public void longestConcatenatedWordWithEmptyList() {
        concatenatedWords = new ConcatenatedWords(emptyListOfWords);
        Assert.assertEquals("The answer for the longest concatenated " +
                        "word when empty list is empty string. " +
                        "But is: " + concatenatedWords.longestConcatenatedWord(),
                NO_CONCATENATED_WORD, concatenatedWords.longestConcatenatedWord());
    }

    @Test
    public void secondLongestConcatenatedWordWithEmptyList() {
        concatenatedWords = new ConcatenatedWords(emptyListOfWords);
        Assert.assertEquals("The answer for the second longest concatenated " +
                        "word when empty list is empty string. " +
                        "But is: " + concatenatedWords.secondLongestConcatenatedWord(),
                NO_CONCATENATED_WORD, concatenatedWords.secondLongestConcatenatedWord());
    }

    @Test
    public void totalCountOfAllTheConcatenatedWordsWithEmptyList() {
        concatenatedWords = new ConcatenatedWords(emptyListOfWords);
        Assert.assertEquals("The total count of concatenated words in the empty list is: 0" +
                        "But got: " + concatenatedWords.totalCountOfAllTheConcatenatedWords(),
                TOTAL_COUNT_WHEN_NO_CONCATENATED_WORDS,
                concatenatedWords.totalCountOfAllTheConcatenatedWords());
    }

    @Test
    public void longestConcatenatedWordWhenNoConcatenatedWords() {
        concatenatedWords = new ConcatenatedWords(listWithNoConcatenatedWords);
        Assert.assertEquals("The answer for the longest concatenated word " +
                        "when there aren't concatenated words in list is empty string. " +
                        "But is: " + concatenatedWords.longestConcatenatedWord(),
                NO_CONCATENATED_WORD, concatenatedWords.longestConcatenatedWord());
    }

    @Test
    public void secondLongestConcatenatedWordWhenNoConcatenatedWords() {
        concatenatedWords = new ConcatenatedWords(listWithNoConcatenatedWords);
        Assert.assertEquals("The answer for the second longest concatenated word " +
                        "when there aren't concatenated words in list is empty string. " +
                        "But is: " + concatenatedWords.secondLongestConcatenatedWord(),
                NO_CONCATENATED_WORD, concatenatedWords.secondLongestConcatenatedWord());
    }

    @Test
    public void totalCountOfAllTheConcatenatedWordsWhenNoConcatenatedWords() {
        concatenatedWords = new ConcatenatedWords(listWithNoConcatenatedWords);
        Assert.assertEquals("The total count of concatenated words " +
                        "when there aren't concatenated words is: 0" +
                        "But got: " + concatenatedWords.totalCountOfAllTheConcatenatedWords(),
                TOTAL_COUNT_WHEN_NO_CONCATENATED_WORDS,
                concatenatedWords.totalCountOfAllTheConcatenatedWords());
    }
}
