//Shelby Brewer
//bqz6dz
//1/21/2026
import java.util.Scanner;
import java.util.Random;

public class Prithee {
    public int correctGuesses = 0;
    public int incorrectGuesses = 0;
    public String sonnet = "Two households, both alike in dignity, " +
            "In fair Verona, where we lay our scene, " +
            "From ancient grudge break to new mutiny, " +
            "Where civil blood makes civil hands unclean. " +
            "From forth the fatal loins of these two foes " +
            "A pair of star-cross’d lovers take their life; " +
            "Whose misadventured piteous overthrows " +
            "Do with their death bury their parents’ strife. " +
            "The fearful passage of their death-mark’d love, " +
            "And the continuance of their parents’ rage, " +
            "Which, but their children’s end, nought could remove, " +
            "Is now the two hours’ traffic of our stage; " +
            "The which if you with patient ears attend, " +
            "What here shall miss, our toil shall strive to mend.";

    private Random rand;
    private Scanner scan;
    private int hiddenIndex;
    private String[] allWords;

    //constructor
    public Prithee(){
        rand = new Random();
        scan = new Scanner(System.in);
        allWords = splitSonnet();
    }

    //splits the string by the whitespace
    public String[] splitSonnet(){
        return sonnet.split(" ");
    }

    //calculates the hiddenIndex
    public void generateHidden(){
        hiddenIndex = rand.nextInt(0,allWords.length);
    }

    //prints out the problem, keeps in mind the line breaks and will stop printing when it gets to the special word
    public void printProblem(){
        for (int i=0; i<allWords.length; i++){
            if(i==hiddenIndex){
                System.out.print("______");
                i = allWords.length;
            }
            else{
                if((allWords[i].equals("dignity,")) || (allWords[i].equals("scene,")) || (allWords[i].equals("mutiny,")) || (allWords[i].equals("unclean.")) || (allWords[i].equals("foes")) || (allWords[i].equals("life;")) || (allWords[i].equals("overthrows")) || (allWords[i].equals("strife.")) || (allWords[i].equals("love,")) || (allWords[i].equals("rage,")) || (allWords[i].equals("remove,")) || (allWords[i].equals("stage;")) || (allWords[i].equals("attend")) || (allWords[i].equals("mend"))){
                    System.out.print(allWords[i] + " ");
                    System.out.println();
                }
                else{
                    System.out.print(allWords[i]+" ");
                }
            }
        }
        System.out.println();
    }

    //use this on the guess and the compareto word
    public String cleanWord(String word){
        word = word.toLowerCase();
        word = word.replace(".","");
        word = word.replace(",","");
        word = word.replace(";","");
        return word;
    }

    public void checkGuess(String guess){
        String compareTo = cleanWord(allWords[hiddenIndex]);
        String cleanGuess = cleanWord(guess);

        if(cleanGuess.equals(compareTo)){
            correctGuesses++;
            System.out.println("Congratulations you are correct! You have guessed correctly " + correctGuesses + " times and incorrectly " + incorrectGuesses + " times");
        }
        else{
            incorrectGuesses++;
            System.out.println("That is incorrect! You have guessed correctly " + correctGuesses + " times and incorrectly " + incorrectGuesses + " times");
        }
    }
    //for junit testing
    public void setHiddenIndex(int inputIndex){
        this.hiddenIndex = inputIndex;
    }

    public void runPrithee(){
        while(correctGuesses<3 && incorrectGuesses<3){
            generateHidden();
            printProblem();
            System.out.println("What word goes in the dashed line???");
            String guess = scan.nextLine();
            checkGuess(guess);
        }
        if(correctGuesses==3){
            System.out.println("Congratulations! You know your lines and have won the game");
        }
        else{
            System.out.println("Oh no! Practice your lines some more and try again");
        }
    }
}
