package core.basesyntax;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConcatenateAppTest {

    private static final String WORDS_FILE = "src/test/java/resources/SameWordsFileTest.txt";
    private static final String ALL_DIGITS_FILE = "src/test/java/resources/AllDigitalFileTest.txt";
    private static final String EMPTY_FILE = "src/test/java/resources/emptyFileTest.txt";
    private static final String WITH_IDENTICAL_WORDS_LENGTH_FILE =
            "src/test/java/resources/SomeIdenticalWordsLengthFileTest.txt";

    private static ConcatenateWordsInterface notEmptyFileConcatenateWordsApp;
    private static ConcatenateWordsInterface emptyFileConcatenateWordsApp;
    private static ConcatenateWordsInterface identicalWordLengthFileConcatenateWordsApp;
    private static ConcatenateWordsInterface digitalFileConcatenateWordsApp;

    @BeforeClass
    public static void setUp() {
        notEmptyFileConcatenateWordsApp = new ConcatenateWordsApp();
        notEmptyFileConcatenateWordsApp.findConcatenateWords(WORDS_FILE);
        digitalFileConcatenateWordsApp = new ConcatenateWordsApp();
        digitalFileConcatenateWordsApp.findConcatenateWords(ALL_DIGITS_FILE);
        emptyFileConcatenateWordsApp = new ConcatenateWordsApp();
        emptyFileConcatenateWordsApp.findConcatenateWords(EMPTY_FILE);
        identicalWordLengthFileConcatenateWordsApp = new ConcatenateWordsApp();
        identicalWordLengthFileConcatenateWordsApp
                .findConcatenateWords(WITH_IDENTICAL_WORDS_LENGTH_FILE);
    }

    @Test
    public void findLongestConcatenatedWordSuccess() {
        List<String> actualFirstLongestConcatenatedWord = notEmptyFileConcatenateWordsApp
                .findFirstLongestConcatenatedWord();
        List<String> actualSecondLongestConcatenatedWord = notEmptyFileConcatenateWordsApp
                .findSecondLongestConcatenatedWord();
        String expectedConcatenatedLongestWord = "dogcatsdoghippopotamuses";
        Assert.assertEquals("Expected longest concatenated word is \"dogcatsdoghippopotamuses\", "
                        + "but was " + actualFirstLongestConcatenatedWord.get(0),
                expectedConcatenatedLongestWord,
                actualFirstLongestConcatenatedWord.get(0));
        String secondExpectedConcatenatedLongestWord = "ratcatdogcat";
        Assert.assertEquals("Expected second longest concatenated word is \"ratcatdogcat\", but "
                        + "was " + actualSecondLongestConcatenatedWord.get(0),
                secondExpectedConcatenatedLongestWord,
                actualSecondLongestConcatenatedWord.get(0));
    }

    @Test
    public void getCountConcatenatedWordsFromWordsFile() {
        int expectedConcatWordsCount = 4;
        int actualConcatWordsCount = notEmptyFileConcatenateWordsApp.getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount + " but "
                + "was" + actualConcatWordsCount, expectedConcatWordsCount, actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromEmptyFile() {
        int expectedConcatWordsCount = 0;
        int actualConcatWordsCount = emptyFileConcatenateWordsApp.getConcatWordsCount();
        Assert.assertEquals("Expected words concat counter is " + expectedConcatWordsCount
                        + " , but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithIdenticalLength() {
        int expectedConcatWordsCount = 4;
        int actualConcatWordsCount = identicalWordLengthFileConcatenateWordsApp
                .getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                        + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithOnlyDigits() {
        int expectedConcatWordsCount = 2;
        int actualConcatWordsCount = digitalFileConcatenateWordsApp.getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                        + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void findLongestConcatenatedDigitalSuccess() {
        final String expectedLongestDig = "12345";
        List<String> actualLongestConcatenatedDigital =
                digitalFileConcatenateWordsApp.findFirstLongestConcatenatedWord();
        Assert.assertEquals("Expected longest concatenated digital is \"12345\", but was "
                        + actualLongestConcatenatedDigital.get(0), expectedLongestDig,
                actualLongestConcatenatedDigital.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void findLongestConcatenatedWordWithEmptyFile() {
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyFileConcatenateWordsApp.findFirstLongestConcatenatedWord().get(0));
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyFileConcatenateWordsApp.findSecondLongestConcatenatedWord().get(0));
    }

    @Test
    public void findLongestConcatenatedWordWithIdenticalWordsLength() {
        List<String> expectedResultsWithIdenticalLongestWords = new ArrayList<>(Arrays
                .asList("dogcatsdog", "dogcatsdog", "dogcatsdog"));
        List<String> expectedSecondLongestConcatenatedWord = new ArrayList<>(
                Arrays.asList("ratcatdog"));
        List<String> actualSecondLongestWord = identicalWordLengthFileConcatenateWordsApp
                .findSecondLongestConcatenatedWord();
        List<String> actualFirstLongestConcatenatedWord =
                identicalWordLengthFileConcatenateWordsApp.findFirstLongestConcatenatedWord();

        Assert.assertEquals(expectedResultsWithIdenticalLongestWords,
                actualFirstLongestConcatenatedWord);
        Assert.assertEquals("Second longest expected concatenated word should be \"\" but was "
                        + actualSecondLongestWord, expectedSecondLongestConcatenatedWord,
                actualSecondLongestWord);
    }
}
