import junit.framework.TestCase;

public class PritheeTest extends TestCase {

    public void testSplitSonnet() {
        Prithee testp = new Prithee();
        String[] wordBank = testp.splitSonnet();
        assertEquals(106, wordBank.length);
    }

    public void testCleanWord() {
        Prithee testp = new Prithee();
        assertEquals("hi", testp.cleanWord("hi,"));
        assertEquals("test", testp.cleanWord("Test."));
        assertEquals("one", testp.cleanWord("ONE"));
    }

    public void testCheckGuessRight() {
        Prithee testp = new Prithee();
        testp.setHiddenIndex(0);
        testp.checkGuess("Two");
        assertEquals(1, testp.correctGuesses);
        assertEquals(0, testp.incorrectGuesses);
    }

    public void testCheckGuessWrong(){
        Prithee testp = new Prithee();
        testp.setHiddenIndex(1);
        testp.checkGuess("In");
        assertEquals(0, testp.correctGuesses);
        assertEquals(1, testp.incorrectGuesses);
    }
}