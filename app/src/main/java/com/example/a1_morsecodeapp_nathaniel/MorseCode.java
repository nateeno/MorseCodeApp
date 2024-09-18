package com.example.a1_morsecodeapp_nathaniel;

import java.util.HashMap;
import java.util.Map;


public class MorseCode {
    // Map to store Morse code values for each character
    private static final Map<String, Character> MORSE_CODE_MAP = new HashMap<String, Character>() {{
        put(".-", 'A'); put("-...", 'B'); put("-.-.", 'C'); put("-..", 'D'); put(".", 'E');
        put("..-.", 'F'); put("--.", 'G'); put("....", 'H'); put("..", 'I'); put(".---", 'J');
        put("-.-", 'K'); put(".-..", 'L'); put("--", 'M'); put("-.", 'N'); put("---", 'O');
        put(".--.", 'P'); put("--.-", 'Q'); put(".-.", 'R'); put("...", 'S'); put("-", 'T');
        put("..-", 'U'); put("...-", 'V'); put(".--", 'W'); put("-..-", 'X'); put("-.--", 'Y');
        put("--..", 'Z');
    }};

    // Define Morse code timing standards in milliseconds
    static final int UNIT_TIME = 200;      // Basic unit of time in Morse code (1 unit = 1 second)
    static final int DIT = 1 * UNIT_TIME; // Duration for a "dit" (dot)
    static final int DAH = 3 * UNIT_TIME; // Duration for a "dah" (dash)

    // Define intervals between elements, characters, and words
    static final int INTRA_SPACE = DIT;           // Space between parts of the same letter
    static final int INTER_SPACE = 3 * UNIT_TIME; // Space between letters
    static final int WORD_SPACE = 7 * UNIT_TIME;  // Space between words

    // Method to get the character corresponding to a Morse code
    public static Character getCharacter(String morseCode) {
        return MORSE_CODE_MAP.get(morseCode);
    }

    // Method to interpret the duration of a signal (dit or dah)
    public static String interpretDuration(long duration) {
        if (duration >= DAH) return "-";
        else if (duration >= DIT) return ".";
        else return "";
    }
}