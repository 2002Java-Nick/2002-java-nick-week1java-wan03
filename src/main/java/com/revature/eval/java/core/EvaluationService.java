package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.temporal.ChronoUnit;
import java.time.LocalDateTime;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] tempPhrase = phrase.split("[\\s-]+");
		String acronym = "";
		
		for (int i = 0; i < tempPhrase.length; i++) {
			
			String letter = String.valueOf(tempPhrase[i].charAt(0));
			acronym = acronym.concat(letter);
		}
		
		acronym = acronym.toUpperCase();
		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(sideOne == sideTwo && sideTwo == sideThree) {
				return true;
			}else {
				
				return false;
			}
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(sideOne == sideTwo || sideTwo == sideThree || sideOne == sideThree) {
				return true;
			}else {
				
				return false;
			}
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(sideOne != sideTwo || sideTwo != sideThree) {
				return true;
			}else {
				
				return false;
			}
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		String eval = string.toLowerCase();
		int score = 0;
		for (int i = 0; i < eval.length(); i++) {
			char temp = eval.charAt(i);
			switch (temp) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'l':
			case 'n':
			case 'r':
			case 's':
			case 't':
				score+=1;
				break;
			case 'd':
			case 'g':
				score+=2;
				break;
			case 'b':
			case 'c':
			case 'm':
			case 'p':
				score+=3;
				break;
			case 'f':
			case 'h':
			case 'v':
			case 'w':
			case 'y':
				score+=4;
				break;
			case 'k':
				score+=5;
				break;
			case 'j':
			case 'x':
				score+=8;
				break;
			case 'q':
			case 'z':
				score+=10;
				break;
			default:
				break;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		String clean = string.replaceAll("[^0-9]", "");
		//String clean = string.replaceAll("[\\s\\,\\(\\)\\.\\-]+", "");
		
		if (clean.length() != 10) {
			
			throw new IllegalArgumentException();
			
		}
		return clean;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		String[] wordsArray = string.split("\\s+|,\\s*|\\.\\s*");
		//ArrayList<String> submissionArray = new ArrayList<String>();
		//ArrayList<Integer> submissionNumberArray = new ArrayList<Integer>();
		
		Map<String, Integer> submissionMap = new HashMap<String, Integer> ();
		int count = 0;
		
		for (int i = 0; i < wordsArray.length; i++) {
			String word = wordsArray[i];
			
			if (submissionMap.containsKey(word)) {
				count = submissionMap.get(word);
				submissionMap.replace(word, count, count+1);
				
			} else {
				
				submissionMap.put(word, 1);
			}
			
			
		}
		
		return submissionMap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int minIndex = 0;
			int maxIndex = getSortedList().size() - 1;
			int currentIndex = 0;
			int currentValue = 0;
			int searchValue = 0;			
			
			try {
				
				searchValue = (int)t;
				
			} catch (Exception e) {
				
				searchValue = Integer.parseInt((String) t);
			}
			
			//return searchValue;
			while (minIndex <= maxIndex) {
				
				currentIndex = Math.round((minIndex + maxIndex) / 2);
				
				try {
					
					currentValue = (int) getSortedList().get(currentIndex);
					
				} catch (Exception e) {
					
					currentValue = Integer.parseInt((String) getSortedList().get(currentIndex));
				}
				
				
				if (searchValue > currentValue) {
					
					minIndex = currentIndex + 1;
					
				}else if (searchValue < currentValue) {
					
					maxIndex = currentIndex - 1;
					
				}else {
					//System.out.println("Hi from while loop");
					//System.out.println(currentValue);
					return currentIndex;
				}
			}
			
			
			return -1;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		  	char a = 'a';
		    char e = 'e';
		    char i = 'i';
		    char o = 'o';
		    char u = 'u';

		    int start = 0;
		    int firstVowel = 0;
		    int end = string.length();
		    
		    
		    for(int x = 0; x < end; x++) {
		        char c = Character.toLowerCase(string.charAt(x));
		        //System.out.println(c);
		        if(c == a || c == e || c == i || c == o || c == u) {
		            firstVowel = x;
		            //System.out.println(x);
		            break;
		        }
		    }
		    
		    if(start != firstVowel) {
		        String startString = string.substring(firstVowel, end);
		        String endString = string.substring(start, firstVowel) + "ay";
		        String translatedString = startString+endString;
		        return translatedString;
		    } else {
		    	String translatedString = string + "ay";
		    	return translatedString;
		    }
		
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
		String number = String.valueOf(input);		
		String[] numArray = number.split("");
		int power = numArray.length;
		int count = 0;
		
		
		for (int i = 0; i < power; i++) {
			
			long currentNum = Long.parseLong(numArray[i]);
			
			count += Math.pow(currentNum, power);
		
			
		}
		
		if (count == input) {
			
			return true;
			
		} else {
			return false;
		}
		
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		ArrayList<Long> factorArray = new ArrayList<Long>();
		
		for (int i=2; i <= l; i++) {
			while (l % i == 0) {
				factorArray.add((long)i);
				l /= i;
			}
		}
		
		return factorArray;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
			
			
			ArrayList <String> temp = new ArrayList<String>();
			
			for (int i = 0; i < string.length(); i++) {
				
				if (Character.isWhitespace(string.charAt(i))) {
					temp.add(" ");
				} else if(Character.isLetter(string.charAt(i))){
					
					int position = alphabet.indexOf(string.charAt(i));
					int shiftedPosition = position + key;
					String newLetter = String.valueOf(alphabet.charAt(shiftedPosition));
					
					temp.add(newLetter);
					
				} else {

					String newLetter = String.valueOf(string.charAt(i));
					temp.add(newLetter);
				
				}	 
			
			
			}
			
			String cipher = String.join("", temp);
			//System.out.println(cipher);
			return cipher;
		}

	}
	

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		int result = 0;
		int count = 0;
		
		if (i < 1) {
			throw new IllegalArgumentException();
		} else {
			
		
		for (int x = 2; count < i; x++) {
			result = x;
			
			if (x == 2 || x == 3 || x == 5) {
				
				count++;
				
			} else if (x % 2 != 0 && x % 3 != 0 && x % 5 != 0) {
				//System.out.println("here");
				count++;
				
			}
			
		
		}
		}
		//System.out.println(result);
		return result;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String cipher = "zyxwvutsrqponmlkjihgfedcba";
			String clean = string.replaceAll("[^a-zA-Z0-9]+", "");
			String encode = clean.toLowerCase();
			int count = 0;
			
			ArrayList <String> temp = new ArrayList<String>();
			
			for (int i = 0; i < encode.length(); i++) {
				
				char currentLetter = encode.charAt(i);
				//System.out.println(currentLetter);
				if (Character.isDigit(currentLetter)) {
					
					temp.add(String.valueOf(currentLetter));
					count++;
				} else {
					
				
				int position = alphabet.indexOf(encode.charAt(i));
				String newLetter = String.valueOf(cipher.charAt(position));
				
				
				if (count % 5 == 0 && count != 0) {
					temp.add(" ");
					temp.add(newLetter);
					count++;
				} else {
					temp.add(newLetter);
					count++;
					
				}
				}
				
			}
			
			String result = String.join("", temp);
			
			
			return result;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			
			
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String cipher = "zyxwvutsrqponmlkjihgfedcba";
			String encode = string.replaceAll("[^a-zA-Z0-9]+", "");
			
			
			ArrayList <String> temp = new ArrayList<String>();
			
			for (int i = 0; i < encode.length(); i++) {
				
				char currentLetter = encode.charAt(i);
				//System.out.println(currentLetter);
				if (Character.isDigit(currentLetter)) {
					
					temp.add(String.valueOf(currentLetter));
					
				} else {
					
				
				int position = cipher.indexOf(encode.charAt(i));
				String newLetter = String.valueOf(alphabet.charAt(position));
				
				temp.add(newLetter);
				
				
			}
			}
		
			String result = String.join("", temp);
			
			
			return result;
		
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		
		
		String clean = string.replaceAll("[^0-9X]", "");
		System.out.println(clean);
		char[] temp = clean.toCharArray();
		
		int[] values = new int[temp.length];

		for (int i = 0; i < temp.length; i++) {
		    values[i] = Character.digit(temp[i], 10);
		}
		if (values.length == 10) {
			
		
			int sum = values[0] * 10 + values[1] * 9 + values[2] * 8 + values[3] * 7 + values[4] * 6 + values[5] * 5 + values[6] * 4 + values[7] * 3 + values[8] * 2 + values[9] * 1;
			
			int solution = sum % 11;
			
			if (solution == 0) {
				return true;
			}
			
		}
		
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		int count = 0;
		
		for (int i = 0; i < alphabet.length(); i++) {
			char currentLetter = alphabet.charAt(i);
			
			if (string.indexOf(currentLetter) >= 0) {
				count+=1;
			}
		}
		
		if (count == 26) {
			
			return true;
		}
		
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
//		DateTimeFormatter formatter = DateTimeFormatter
//				.ofPattern("yyyyMMdd HH:mm:ss");
		//System.out.println("g" + given);
//		
		//Temporal formatedDate =  given.;
//		String formatedDate =  formatter.format(given);
//		System.out.println("f" + formatedDate);
		
		if (given.isSupported(ChronoUnit.SECONDS)) {
			
			Temporal calculatedDate = given.plus(1000000000, ChronoUnit.SECONDS);
			return calculatedDate;
		} else {
			
			String test = given + "T00:00:00";
			//System.out.println(test);
			//Temporal usableDate = Instant.parse(test);
			LocalDateTime localDateTime = LocalDateTime.parse(test);
			//System.out.println("u" + localDateTime);
			Temporal calculatedDate = localDateTime.plus(1000000000, ChronoUnit.SECONDS);
			//System.out.println("c" + calculatedDate);
			
			return calculatedDate;
		}
		
		
		
	}

	

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		int count = 0;
		
		 ArrayList <Integer> numbersArray = new ArrayList<Integer>();
		
		for (int x = 0; x < set.length; x++) {
			
			int currentNumber = set[x];
			
			//System.out.println(currentNumber);
				
			for (int y = 1; y < i; y++) {
							
				if(y % currentNumber == 0) {
					
					if (!numbersArray.contains(y)) {
						
						numbersArray.add(y);
						count+=y;
					}
				}
			
			
			}
		}
		
		//System.out.println("end" + count);
		return count;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		
		if (string.contains("-") || string.contains("a")) {
			return false;
		} else {
			
		String clean = string.replaceAll("[^0-9]", "");
		
		int count = 0;
		int lenght = clean.length() + 1;
		
		for (int i = 1; i < lenght; i++) {
			
			if (i % 2 == 0) {
				
				int temp = Character.getNumericValue(clean.charAt(i-1)) * 2;
				
				//System.out.println(temp);
				if (temp > 9) {
					
					int temp2 = temp - 9;
					
					count+= temp2;
					
				} else {
					
					count += temp;
				}			
				
			} else {
				
				count += Character.getNumericValue(clean.charAt(i-1));
			}
			
			
		}
		
		if (count % 10 == 0) {
			
			//System.out.println(count);
			
			return true;
		} else {
			//System.out.println("f" + count);
			return false;
			
		}
		}
		
		
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		
		String[] problemArray = string.split(" ");
		String operator = problemArray[3];
		//System.out.println(problemArray.length);
		
		if (problemArray.length < 6) {
			
			int firstNumberAS = Integer.parseInt(problemArray[2]);
			String temp = problemArray[4];
			int secondNumberAS = Integer.parseInt(temp.replace("?", ""));
			
			switch (operator) {
			
			case "plus":
				return firstNumberAS + secondNumberAS;
				
				
			case "minus":
				return firstNumberAS - secondNumberAS;
				
			default:
				return 0;
			
			}
			
		} else {
			
			int firstNumberMD = Integer.parseInt(problemArray[2]);
			String temp = problemArray[5];
			int secondNumberMD = Integer.parseInt(temp.replace("?", ""));
			switch (operator) {		
			
			case "multiplied":
				return firstNumberMD * secondNumberMD;
				
				
			case "divided":
				return firstNumberMD / secondNumberMD;
				
				
			default:
				return 0;
			
			}
		}
		
	
		
		
	}

}
