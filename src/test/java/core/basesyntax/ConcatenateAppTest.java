package core.basesyntax;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcatenateAppTest {

    private static final List<String> DIFFERENT_WORDS = List.of("cat", "cats", "catsdogcats",
            "dog", "dogcatsdog", "dogcatsdoghippopotamuses", "hippopotamuses", "rat",
            "ratcatdogcat");
    private static final List<String> EMPTY_FILE = Collections.emptyList();
    private static final List<String> WORDS_WITH_SAME_LENGTH = List.of("cat", "cats",
            "catsdogcats", "dog", "dogcatsdog", "dogcatsdoghippopotamuses", "hippopotamuses",
            "rat", "ratcatdogcat");
    private static final List<String> ALL_DIGITS = List.of("1", "2", "123", "345", "3", "12345",
            "234678");

    private static ConcatenateWordsInterface notEmptyFileConcatenateWordsApp;
    private static ConcatenateWordsInterface emptyFileConcatenateWordsApp;
    private static ConcatenateWordsInterface identicalWordLengthFileConcatenateWordsApp;
    private static ConcatenateWordsInterface digitalFileConcatenateWordsApp;

    @BeforeClass
    public static void setUp() {
        notEmptyFileConcatenateWordsApp = new ConcatenateWordsApp(DIFFERENT_WORDS);
        digitalFileConcatenateWordsApp = new ConcatenateWordsApp(ALL_DIGITS);
        emptyFileConcatenateWordsApp = new ConcatenateWordsApp(EMPTY_FILE);
        identicalWordLengthFileConcatenateWordsApp =
                new ConcatenateWordsApp(WORDS_WITH_SAME_LENGTH);
    }

    @Test
    public void findConcatenatedWordSuccess() {
        String actualFirstLongestConcatenatedWord = notEmptyFileConcatenateWordsApp
                .findFirstLongestConcatenatedWord(DIFFERENT_WORDS);
        String actualSecondLongestConcatenatedWord = notEmptyFileConcatenateWordsApp
                .findSecondLongestConcatenatedWord(DIFFERENT_WORDS);
        String expectedConcatenatedLongestWord = "dogcatsdoghippopotamuses";
        Assert.assertEquals("Expected longest concatenated word is \"dogcatsdoghippopotamuses\", "
                        + "but was " + actualFirstLongestConcatenatedWord,
                expectedConcatenatedLongestWord, actualFirstLongestConcatenatedWord);
        String secondExpectedConcatenatedLongestWord = "ratcatdogcat";
        Assert.assertEquals("Expected second longest concatenated word is \"ratcatdogcat\", but "
                        + "was " + actualSecondLongestConcatenatedWord,
                secondExpectedConcatenatedLongestWord, actualSecondLongestConcatenatedWord);
    }

    @Test
    public void getCountConcatenatedWordsFromWordsFile() {
        int expectedConcatWordsCount = 4;
        int actualConcatWordsCount = notEmptyFileConcatenateWordsApp.getConcatenatedWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount + " but "
                + "was" + actualConcatWordsCount, expectedConcatWordsCount, actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromEmptyFile() {
        int expectedConcatWordsCount = 0;
        int actualConcatWordsCount = emptyFileConcatenateWordsApp.getConcatenatedWordsCount();
        Assert.assertEquals("Expected words concat counter is " + expectedConcatWordsCount
                        + " , but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithIdenticalLength() {
        int expectedConcatWordsCount = 4;
        int actualConcatWordsCount = identicalWordLengthFileConcatenateWordsApp
                .getConcatenatedWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                        + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithOnlyDigits() {
        int expectedConcatWordsCount = 2;
        int actualConcatWordsCount = digitalFileConcatenateWordsApp.getConcatenatedWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                        + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void findLongestConcatenatedDigitalSuccess() {
        final String expectedLongestDig = "12345";
        String actualLongestConcatenatedDigital =
                digitalFileConcatenateWordsApp.findFirstLongestConcatenatedWord(ALL_DIGITS);
        Assert.assertEquals("Expected longest concatenated digital is \"12345\", but was "
                        + actualLongestConcatenatedDigital, expectedLongestDig,
                actualLongestConcatenatedDigital);
    }

    @Test(expected = NoSuchElementException.class)
    public void findLongestConcatenatedWordWithEmptyFile() {
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyFileConcatenateWordsApp.findFirstLongestConcatenatedWord(EMPTY_FILE));
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyFileConcatenateWordsApp.findSecondLongestConcatenatedWord(EMPTY_FILE));
    }

    @Test
    public void findLongestConcatenatedWordWithIdenticalWordsLength() {
        String expectedResultsWithIdenticalLongestWords = "dogcatsdoghippopotamuses";
        String expectedSecondLongestConcatenatedWord = "ratcatdogcat";
        String actualSecondLongestWord = identicalWordLengthFileConcatenateWordsApp
                .findSecondLongestConcatenatedWord(WORDS_WITH_SAME_LENGTH);
        String actualFirstLongestConcatenatedWord =
                identicalWordLengthFileConcatenateWordsApp
                        .findFirstLongestConcatenatedWord(WORDS_WITH_SAME_LENGTH);

        Assert.assertEquals("Second longest expected concatenated word should be \""
                        + expectedResultsWithIdenticalLongestWords + "\" but was "
                        + actualSecondLongestWord, expectedResultsWithIdenticalLongestWords,
                actualFirstLongestConcatenatedWord);
        Assert.assertEquals("Second longest expected concatenated word should be \""
                        + expectedSecondLongestConcatenatedWord + "\" but was "
                        + actualSecondLongestWord, expectedSecondLongestConcatenatedWord,
                actualSecondLongestWord);
    }
}
