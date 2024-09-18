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
        // AUTOMATISER?
        switch(levelIndex) {
            case 0:
                return context.getString(R.string.intro_message_level_1);
            case 1:
                return context.getString(R.string.intro_message_level_2);
            case 2:
                return context.getString(R.string.intro_message_level_3);
            case 3:
                return context.getString(R.string.intro_message_level_4);
            default:
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

        // Level 3 includes Morse code for E only
        Map<String, Character> level3Map = new HashMap<String, Character>() {{
            put(".", 'E');
        }};
        levels.add(new Level(3, level3Map, true));

        // Level 4 includes Morse code for E only
        Map<String, Character> level4Map = new HashMap<String, Character>() {{
            put("-", 'T');
        }};
        levels.add(new Level(4, level4Map, true));

        // Level 5 includes Morse code for E only
        Map<String, Character> level5Map = new HashMap<String, Character>() {{
            put("..", 'I');
        }};
        levels.add(new Level(5, level5Map, false));



        /*

        - **LEVLER**

            1. E: .
            2. T: -
            3. I: ..
            4. A: .-
            5. N: -.
            6. M: --
            7. S: ...
            8. U: ..-
            9. R: .-.
            10. W: .--
            11. D: -..
            12. K: -.-
            13. G: --.
            14. O: ---
            15. H: ....
            16. V: ...-
            17. F: ..-.
            18. L: .-..
            19. P: .--.
            20. J: .---
            21. B: -...
            22. X: -..-
            23. C: -.-.
            24. Y: -.--
            25. Z: --..
            26. Q: --.-

         */

        return levels;
    }
}