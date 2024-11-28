/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
        String string1 = withoutSpaces(preProcess(str1)) ;
		String string2 = withoutSpaces(preProcess(str2));
        int count1 = 0;
        int count2 = 0;

		if (string1.length() == string2.length())
		{
            for (int i = 0; i < string1.length(); i++)
            {
                for (int n = 0; n < string2.length(); n++)
                {
                    if (string1.charAt(i) == string2.charAt(n))
                    {
                        count2++;
                    }
                    if (string1.charAt(i) == string1.charAt(n)) {
                        count1++;
                    }
                }
            }
                if (count1 == count2) 
                {
                    return true;
                }
                else
                {
                    return false;
                }
		}
            else
            {
                return false;
            }
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		int i = 0;
        char letter = ' ';
        int asciValue = 0;
        String newString = " ";
        while (i < str.length())
        {
            letter = str.charAt(i);
            asciValue = letter;
            if (asciValue > 122 || asciValue < 97)
            {
                if (asciValue >= 65 && asciValue <= 95)
                {
                    newString += (char)(asciValue + 32);
                }
                else if (asciValue == 32)
                {
                    newString += " ";
                }
            }
            else if (asciValue <= 122 && asciValue >= 97) {
                newString += (char)asciValue;
            }
            i++;
        }
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
        int saveRandom = 0;
        for (int i = 0; i < str.length(); i++)
        {
            saveRandom = (int)(Math.random() * str.length());
            newString += str.charAt(saveRandom);
            newString = newString + str.charAt(i);
            str = str.substring(0, i) + str.substring(i + 1);
        }
		return newString;
	}


	public static String withoutSpaces(String str)
    {
        String newString = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) != ' ') {
                newString += str.charAt(i);               
            }
        }
        return newString;
    }

}
