HW1 Prithee
Shelby Brewer
computing id - bqz6dz
1/21/2026

sonnet for reference
Two households, both alike in dignity,
In fair Verona, where we lay our scene,
From ancient grudge break to new mutiny,
Where civil blood makes civil hands unclean.
From forth the fatal loins of these two foes
A pair of star-cross’d lovers take their life;
Whose misadventured piteous overthrows
Do with their death bury their parents’ strife.
The fearful passage of their death-mark’d love,
And the continuance of their parents’ rage,
Which, but their children’s end, nought could remove,
Is now the two hours’ traffic of our stage;
The which if you with patient ears attend,
What here shall miss, our toil shall strive to mend.

PLANNING
split the sonnet by the whitespace and store it in an array

Pseudocode
let correctGuesses = 0
let incorrectGuesses = 0
let sonnet = full sonnet text
allWords array = sonnet split by whitespace

while correctGuesses < 3 and incorrectGuesses < 3
    generate a new rand
    let hiddenIndex = rand between zero and the length of the allWords array

    for i = 0 through length of the allWords array incrementing by 1
        if i is equal to the hiddenIndex
            print underscores and stop printing
        else
            if allWords[i] is equal to any of the words that end lines
                print word then do a line break
            else
                print word

    initialize a new scanner
    ask the user to fill in the blank
    guess = scanner input

    convert the guess to lowercase version
    let string target = allWords[hiddenIndex]
    convert the target to lowercase
    remove any . or , in the guess word
    remove any . or , or ; in the target word

    if the guess is the same as target
        increment correctGuesses
        print congrats message and tell them how many they currently have right and wrong
    else
        increment incorrectGuesses
        print that they did it wrong and tell them how many they currently have right and wrong

if correctGuesses is 3
    print that they won the game
else
    print that they lost

tests
do it correctly 3x
do it wrong 3x
input a capitalized/uncapitalized version
input an answer with a trailing punctuation