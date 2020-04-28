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
    private static final String EMPTY_FILE = "src/test/java/resources/emptyFileTest" + ".txt";
    private static final String WITH_IDENTICAL_WORDS_LENGTH_FILE = "src/test/java/resources" +
            "/SomeIdenticalWordsLengthFileTest";

    private static ConcatenateWordsInterface notEmptyChallengeSolver;
    private static ConcatenateWordsInterface emptyChallengeSolver;
    private static ConcatenateWordsInterface identicalLongestConcatenatedWord;
    private static ConcatenateWordsInterface digitalConcatenatedWord;

    @BeforeClass
    public static void setUp() {
        notEmptyChallengeSolver = new ConcatenateWordsApp();
        digitalConcatenatedWord = new ConcatenateWordsApp();
        emptyChallengeSolver = new ConcatenateWordsApp();
        identicalLongestConcatenatedWord = new ConcatenateWordsApp();
    }

    @Test
    public void findLongestConcatenatedWordSuccess() {
        notEmptyChallengeSolver.findConcatenateWords(WORDS_FILE);
        List<String> actualFirstLongestConcatenatedWord = notEmptyChallengeSolver
                .findFirstLongestConcatenatedWord();
        List<String> actualSecondLongestConcatenatedWord = notEmptyChallengeSolver
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
        int actualConcatWordsCount = notEmptyChallengeSolver.getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount + " but "
                + "was" + actualConcatWordsCount, expectedConcatWordsCount, actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromEmptyFile() {
        int expectedConcatWordsCount = 0;
        int actualConcatWordsCount = emptyChallengeSolver.getConcatWordsCount();
        Assert.assertEquals("Expected words concat counter is " + expectedConcatWordsCount + " , "
                + "but was " + actualConcatWordsCount, expectedConcatWordsCount, actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithIdenticalLength() {
        int expectedConcatWordsCount = 4;
        int actualConcatWordsCount = identicalLongestConcatenatedWord.getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void getCountConcatenatedWordsFromFileWithOnlyDigits() {
        int expectedConcatWordsCount = 2;
        int actualConcatWordsCount = digitalConcatenatedWord.getConcatWordsCount();
        Assert.assertEquals("Expected concat words count is " + expectedConcatWordsCount
                + " but was " + actualConcatWordsCount, expectedConcatWordsCount,
                actualConcatWordsCount);
    }

    @Test
    public void findLongestConcatenatedDigitalSuccess() {
        final String expectedLongestDig = "12345";
        digitalConcatenatedWord.findConcatenateWords(ALL_DIGITS_FILE);
        List<String> actualLongestConcatenatedDigital =
                digitalConcatenatedWord.findFirstLongestConcatenatedWord();
        Assert.assertEquals("Expected longest concatenated digital is \"12345\", but was "
                        + actualLongestConcatenatedDigital.get(0), expectedLongestDig,
                actualLongestConcatenatedDigital.get(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void findLongestConcatenatedWordWithEmptyFile() {
        emptyChallengeSolver.findConcatenateWords(EMPTY_FILE);
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyChallengeSolver.findFirstLongestConcatenatedWord().get(0));
        Assert.assertNull("Expected \"NoSuchElementException\".",
                emptyChallengeSolver.findSecondLongestConcatenatedWord().get(0));
    }

    @Test
    public void findLongestConcatenatedWordWithIdenticalWordsLength() {
        List<String> expectedResultsWithIdenticalLongestWords = new ArrayList<>(Arrays
                .asList("dogcatsdog", "dogcatsdog", "dogcatsdog"));
        String expectedSecondLongestConcatenatedWord = "ratcatdog";
        identicalLongestConcatenatedWord.findConcatenateWords(WITH_IDENTICAL_WORDS_LENGTH_FILE);
        String actualSecondLongestWord = identicalLongestConcatenatedWord
                .findSecondLongestConcatenatedWord().get(0);
        List<String> actualFirstLongestConcatenatedWord = identicalLongestConcatenatedWord
                .findFirstLongestConcatenatedWord();

        Assert.assertEquals(expectedResultsWithIdenticalLongestWords, actualFirstLongestConcatenatedWord);
        Assert.assertEquals("Second longest expected concatenated word should be \"\" but was "
                        + actualSecondLongestWord, expectedSecondLongestConcatenatedWord,
                actualSecondLongestWord);
    }
}
