package com.example.a1_morsecodeapp_nathaniel;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelManager {

    public static class Level {
        private int levelNumber;
        private Map<String, Character> morseCodeMap;

        private boolean isHardLevel;

        public Level(int levelNumber, Map<String, Character> morseCodeMap, boolean isHardLevel) {
            this.levelNumber = levelNumber;
            this.morseCodeMap = morseCodeMap;
            this.isHardLevel = isHardLevel;
        }

        public int getLevelNumber() {
            return levelNumber;
        }

        public Map<String, Character> getMorseCodeMap() {
            return morseCodeMap;
        }

        public boolean isHardLevel() {
            return isHardLevel;
        }
    }

    public class LevelItem {
        private String levelName;
        private boolean isLocked;

        public LevelItem(String levelName, boolean isLocked) {
            this.levelName = levelName;
            this.isLocked = isLocked;
        }

        public String getLevelName() {
            return levelName;
        }

        public boolean isLocked() {
            return isLocked;
        }
    }

    public static String getIntroMessage(int levelIndex, Context context) {
        String resourceName = "intro_message_level_" + (levelIndex + 1);
        int resId = context.getResources().getIdentifier(resourceName, "string", context.getPackageName());
        if (resId != 0) {
            return context.getString(resId);
        } else {
            return context.getString(R.string.intro_message_default, levelIndex + 1);
        }
    }

    public static List<Level> initializeLevels() {
        List<Level> levels = new ArrayList<>();

        // Level 1 includes Morse code for E only
        Map<String, Character> level1Map = new HashMap<String, Character>() {{
            put(".", 'E');
        }};
        levels.add(new Level(1, level1Map, false));

        // Level 2 includes Morse code for T only
        Map<String, Character> level2Map = new HashMap<String, Character>() {{
            put("-", 'T');
        }};
        levels.add(new Level(2, level2Map, false));

        // Hard Level 3 includes Morse code for E only
        Map<String, Character> level3Map = new HashMap<String, Character>() {{
            put(".", 'E');
        }};
        levels.add(new Level(3, level3Map, true));

        // Level 4 includes Morse code for I only
        Map<String, Character> level4Map = new HashMap<String, Character>() {{
            put("..", 'I');
        }};
        levels.add(new Level(4, level4Map, false));

        // Hard Level 5 includes Morse code for T only
        Map<String, Character> level5Map = new HashMap<String, Character>() {{
            put("-", 'T');
        }};
        levels.add(new Level(5, level5Map, true));

        // Level 6 includes Morse code for A only
        Map<String, Character> level6Map = new HashMap<String, Character>() {{
            put(".-", 'A');
        }};
        levels.add(new Level(6, level6Map, false));

        // Hard Level 7 includes Morse code for I only
        Map<String, Character> level7Map = new HashMap<String, Character>() {{
            put("..", 'I');
        }};
        levels.add(new Level(7, level7Map, true));

        // Level 8 includes Morse code for N only
        Map<String, Character> level8Map = new HashMap<String, Character>() {{
            put("-.", 'N');
        }};
        levels.add(new Level(8, level8Map, false));

        // Hard Level 9 includes Morse code for A only
        Map<String, Character> level9Map = new HashMap<String, Character>() {{
            put(".-", 'A');
        }};
        levels.add(new Level(9, level9Map, true));

        // Level 10 includes Morse code for M only
        Map<String, Character> level10Map = new HashMap<String, Character>() {{
            put("--", 'M');
        }};
        levels.add(new Level(10, level10Map, false));

        // Hard Level 11 includes Morse code for N only
        Map<String, Character> level11Map = new HashMap<String, Character>() {{
            put("-.", 'N');
        }};
        levels.add(new Level(11, level11Map, true));

        // Level 12 includes Morse code for S only
        Map<String, Character> level12Map = new HashMap<String, Character>() {{
            put("...", 'S');
        }};
        levels.add(new Level(12, level12Map, false));

        // Hard Level 13 includes Morse code for M only
        Map<String, Character> level13Map = new HashMap<String, Character>() {{
            put("--", 'M');
        }};
        levels.add(new Level(13, level13Map, true));

        // Level 14 includes Morse code for U only
        Map<String, Character> level14Map = new HashMap<String, Character>() {{
            put("..-", 'U');
        }};
        levels.add(new Level(14, level14Map, false));

        // Hard Level 15 includes Morse code for S only
        Map<String, Character> level15Map = new HashMap<String, Character>() {{
            put("...", 'S');
        }};
        levels.add(new Level(15, level15Map, true));

        // Level 16 includes Morse code for R only
        Map<String, Character> level16Map = new HashMap<String, Character>() {{
            put(".-.", 'R');
        }};
        levels.add(new Level(16, level16Map, false));

        // Hard Level 17 includes Morse code for U only
        Map<String, Character> level17Map = new HashMap<String, Character>() {{
            put("..-", 'U');
        }};
        levels.add(new Level(17, level17Map, true));

        // Level 18 includes Morse code for W only
        Map<String, Character> level18Map = new HashMap<String, Character>() {{
            put(".--", 'W');
        }};
        levels.add(new Level(18, level18Map, false));

        // Hard Level 19 includes Morse code for R only
        Map<String, Character> level19Map = new HashMap<String, Character>() {{
            put(".-.", 'R');
        }};
        levels.add(new Level(19, level19Map, true));

        // Level 20 includes Morse code for D only
        Map<String, Character> level20Map = new HashMap<String, Character>() {{
            put("-..", 'D');
        }};
        levels.add(new Level(20, level20Map, false));

        // Hard Level 21 includes Morse code for W only
        Map<String, Character> level21Map = new HashMap<String, Character>() {{
            put(".--", 'W');
        }};
        levels.add(new Level(21, level21Map, true));

        // Level 22 includes Morse code for K only
        Map<String, Character> level22Map = new HashMap<String, Character>() {{
            put("-.-", 'K');
        }};
        levels.add(new Level(22, level22Map, false));

        // Hard Level 23 includes Morse code for D only
        Map<String, Character> level23Map = new HashMap<String, Character>() {{
            put("-..", 'D');
        }};
        levels.add(new Level(23, level23Map, true));

        // Level 24 includes Morse code for G only
        Map<String, Character> level24Map = new HashMap<String, Character>() {{
            put("--.", 'G');
        }};
        levels.add(new Level(24, level24Map, false));

        // Hard Level 25 includes Morse code for K only
        Map<String, Character> level25Map = new HashMap<String, Character>() {{
            put("-.-", 'K');
        }};
        levels.add(new Level(25, level25Map, true));

        // Level 26 includes Morse code for O only
        Map<String, Character> level26Map = new HashMap<String, Character>() {{
            put("---", 'O');
        }};
        levels.add(new Level(26, level26Map, false));

        // Hard Level 27 includes Morse code for G only
        Map<String, Character> level27Map = new HashMap<String, Character>() {{
            put("--.", 'G');
        }};
        levels.add(new Level(27, level27Map, true));

        // Level 28 includes Morse code for H only
        Map<String, Character> level28Map = new HashMap<String, Character>() {{
            put("....", 'H');
        }};
        levels.add(new Level(28, level28Map, false));

        // Hard Level 29 includes Morse code for O only
        Map<String, Character> level29Map = new HashMap<String, Character>() {{
            put("---", 'O');
        }};
        levels.add(new Level(29, level29Map, true));

        // Level 30 includes Morse code for V only
        Map<String, Character> level30Map = new HashMap<String, Character>() {{
            put("...-", 'V');
        }};
        levels.add(new Level(30, level30Map, false));

        // Hard Level 31 includes Morse code for H only
        Map<String, Character> level31Map = new HashMap<String, Character>() {{
            put("....", 'H');
        }};
        levels.add(new Level(31, level31Map, true));

        // Level 32 includes Morse code for F only
        Map<String, Character> level32Map = new HashMap<String, Character>() {{
            put("..-.", 'F');
        }};
        levels.add(new Level(32, level32Map, false));

        // Hard Level 33 includes Morse code for V only
        Map<String, Character> level33Map = new HashMap<String, Character>() {{
            put("...-", 'V');
        }};
        levels.add(new Level(33, level33Map, true));

        // Level 34 includes Morse code for L only
        Map<String, Character> level34Map = new HashMap<String, Character>() {{
            put(".-..", 'L');
        }};
        levels.add(new Level(34, level34Map, false));

        // Hard Level 35 includes Morse code for F only
        Map<String, Character> level35Map = new HashMap<String, Character>() {{
            put("..-.", 'F');
        }};
        levels.add(new Level(35, level35Map, true));

        // Level 36 includes Morse code for P only
        Map<String, Character> level36Map = new HashMap<String, Character>() {{
            put(".--.", 'P');
        }};
        levels.add(new Level(36, level36Map, false));

        // Hard Level 37 includes Morse code for L only
        Map<String, Character> level37Map = new HashMap<String, Character>() {{
            put(".-..", 'L');
        }};
        levels.add(new Level(37, level37Map, true));

        // Level 38 includes Morse code for J only
        Map<String, Character> level38Map = new HashMap<String, Character>() {{
            put(".---", 'J');
        }};
        levels.add(new Level(38, level38Map, false));

        // Hard Level 39 includes Morse code for P only
        Map<String, Character> level39Map = new HashMap<String, Character>() {{
            put(".--.", 'P');
        }};
        levels.add(new Level(39, level39Map, true));

        // Level 40 includes Morse code for B only
        Map<String, Character> level40Map = new HashMap<String, Character>() {{
            put("-...", 'B');
        }};
        levels.add(new Level(40, level40Map, false));

        // Hard Level 41 includes Morse code for J only
        Map<String, Character> level41Map = new HashMap<String, Character>() {{
            put(".---", 'J');
        }};
        levels.add(new Level(41, level41Map, true));

        // Level 42 includes Morse code for X only
        Map<String, Character> level42Map = new HashMap<String, Character>() {{
            put("-..-", 'X');
        }};
        levels.add(new Level(42, level42Map, false));

        // Hard Level 43 includes Morse code for B only
        Map<String, Character> level43Map = new HashMap<String, Character>() {{
            put("-...", 'B');
        }};
        levels.add(new Level(43, level43Map, true));

        // Level 44 includes Morse code for C only
        Map<String, Character> level44Map = new HashMap<String, Character>() {{
            put("-.-.", 'C');
        }};
        levels.add(new Level(44, level44Map, false));

        // Hard Level 45 includes Morse code for X only
        Map<String, Character> level45Map = new HashMap<String, Character>() {{
            put("-..-", 'X');
        }};
        levels.add(new Level(45, level45Map, true));

        // Level 46 includes Morse code for Y only
        Map<String, Character> level46Map = new HashMap<String, Character>() {{
            put("-.--", 'Y');
        }};
        levels.add(new Level(46, level46Map, false));

        // Hard Level 47 includes Morse code for C only
        Map<String, Character> level47Map = new HashMap<String, Character>() {{
            put("-.-.", 'C');
        }};
        levels.add(new Level(47, level47Map, true));

        // Level 48 includes Morse code for Z only
        Map<String, Character> level48Map = new HashMap<String, Character>() {{
            put("--..", 'Z');
        }};
        levels.add(new Level(48, level48Map, false));

        // Hard Level 49 includes Morse code for Y only
        Map<String, Character> level49Map = new HashMap<String, Character>() {{
            put("-.--", 'Y');
        }};
        levels.add(new Level(49, level49Map, true));

        // Level 50 includes Morse code for Q only
        Map<String, Character> level50Map = new HashMap<String, Character>() {{
            put("--.-", 'Q');
        }};
        levels.add(new Level(50, level50Map, false));

        // Hard Level 51 includes Morse code for Z only
        Map<String, Character> level51Map = new HashMap<String, Character>() {{
            put("--..", 'Z');
        }};
        levels.add(new Level(51, level51Map, true));

        // Level 52 includes Morse code for 1 only
        Map<String, Character> level52Map = new HashMap<String, Character>() {{
            put(".----", '1');
        }};
        levels.add(new Level(52, level52Map, false));

        // Hard Level 53 includes Morse code for Q only
        Map<String, Character> level53Map = new HashMap<String, Character>() {{
            put("--.-", 'Q');
        }};
        levels.add(new Level(53, level53Map, true));

        // Level 54 includes Morse code for 2 only
        Map<String, Character> level54Map = new HashMap<String, Character>() {{
            put("..---", '2');
        }};
        levels.add(new Level(54, level54Map, false));

        // Hard Level 55 includes Morse code for 1 only
        Map<String, Character> level55Map = new HashMap<String, Character>() {{
            put(".----", '1');
        }};
        levels.add(new Level(55, level55Map, true));

        // Level 56 includes Morse code for 3 only
        Map<String, Character> level56Map = new HashMap<String, Character>() {{
            put("...--", '3');
        }};
        levels.add(new Level(56, level56Map, false));

        // Hard Level 57 includes Morse code for 2 only
        Map<String, Character> level57Map = new HashMap<String, Character>() {{
            put("..---", '2');
        }};
        levels.add(new Level(57, level57Map, true));

        // Level 58 includes Morse code for 4 only
        Map<String, Character> level58Map = new HashMap<String, Character>() {{
            put("....-", '4');
        }};
        levels.add(new Level(58, level58Map, false));

        // Hard Level 59 includes Morse code for 3 only
        Map<String, Character> level59Map = new HashMap<String, Character>() {{
            put("...--", '3');
        }};
        levels.add(new Level(59, level59Map, true));

        // Level 60 includes Morse code for 5 only
        Map<String, Character> level60Map = new HashMap<String, Character>() {{
            put(".....", '5');
        }};
        levels.add(new Level(60, level60Map, false));

        // Hard Level 61 includes Morse code for 4 only
        Map<String, Character> level61Map = new HashMap<String, Character>() {{
            put("....-", '4');
        }};
        levels.add(new Level(61, level61Map, true));

        // Level 62 includes Morse code for 6 only
        Map<String, Character> level62Map = new HashMap<String, Character>() {{
            put("-....", '6');
        }};
        levels.add(new Level(62, level62Map, false));

        // Hard Level 63 includes Morse code for 5 only
        Map<String, Character> level63Map = new HashMap<String, Character>() {{
            put(".....", '5');
        }};
        levels.add(new Level(63, level63Map, true));

        // Level 64 includes Morse code for 7 only
        Map<String, Character> level64Map = new HashMap<String, Character>() {{
            put("--...", '7');
        }};
        levels.add(new Level(64, level64Map, false));

        // Hard Level 65 includes Morse code for 6 only
        Map<String, Character> level65Map = new HashMap<String, Character>() {{
            put("-....", '6');
        }};
        levels.add(new Level(65, level65Map, true));

        // Level 66 includes Morse code for 8 only
        Map<String, Character> level66Map = new HashMap<String, Character>() {{
            put("---..", '8');
        }};
        levels.add(new Level(66, level66Map, false));

        // Hard Level 67 includes Morse code for 7 only
        Map<String, Character> level67Map = new HashMap<String, Character>() {{
            put("--...", '7');
        }};
        levels.add(new Level(67, level67Map, true));

        // Level 68 includes Morse code for 9 only
        Map<String, Character> level68Map = new HashMap<String, Character>() {{
            put("----.", '9');
        }};
        levels.add(new Level(68, level68Map, false));

        return levels;
    }
}