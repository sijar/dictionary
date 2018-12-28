package englishdictionary;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Sijar Ahmed,Kumaresh Roy
 * 
 * 
 */
public class Dictionary {

	private static final Map<String, List<String>>	dictionaryA_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryB_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryC_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryD_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryE_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryF_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryG_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryH_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryI_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryJ_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryK_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryL_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryM_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryN_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryO_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryP_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryQ_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryR_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryS_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryT_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryU_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryV_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryW_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryX_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryY_Words	= new TreeMap<String, List<String>>();
	private static final Map<String, List<String>>	dictionaryZ_Words	= new TreeMap<String, List<String>>();

	private List<Integer>							startWordIndexes	= new ArrayList<Integer>();
	private List<Integer>							endWordIndexes		= new ArrayList<Integer>();
	private List<String>							wordList			= new ArrayList<String>();
	private List<List<String>>						meaningList			= new ArrayList<List<String>>();
	private static Dictionary						instance;

	/**
	 * Static initialization of Dictionary Data
	 */
	//	static {
	//		try {
	//			BufferedReader dictionaryReader = getFileBufferedReader();
	//			//Load entire dictionary file 
	//			if (null != dictionaryReader && MAX_LINE_READ_PER_PASS >= lines) {
	//				StringBuilder dictionaryContent = new StringBuilder();
	//				String line = null;
	//				for (int n = lines; (line = dictionaryReader.readLine()) != null && (0 < n); --n) {
	//					if (skipWord(line)) {
	//						continue;
	//					}
	//					dictionaryContent.append(line).append("\\n"); //append '\n' character
	//				}
	//				if (DEBUG_MODE_ON) {
	//					System.out.println("\n { " + dictionaryContent + " } \n");
	//				}
	//				parseDictionaryFile(dictionaryContent.toString());
	//			}
	//
	//		} catch (IOException e) {
	//			Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, e);
	//			System.err.println("Dictionary Files could not be loaded");
	//		}		
	//	}

	/**
	 * Singleton class
	 * 
	 * @throws IOException
	 */
	private Dictionary(final int lines) {
		try {
			BufferedReader dictionaryReader = getFileBufferedReader();
			//Load entire dictionary file 
			if (null != dictionaryReader && DictionaryUtil.MAX_LINE_READ_PER_PASS >= lines) {
				StringBuilder dictionaryContent = new StringBuilder();
				String line = null;
				for (int n = lines; (line = dictionaryReader.readLine()) != null && (0 < n); --n) {
					if (isSkipLine(line)) {
						continue;
					}
					dictionaryContent.append(line).append("\\n"); //append '\n' character
				}
				if (DictionaryUtil.DEBUG_MODE_ON) {
					System.out.println("\n { " + dictionaryContent + " } \n");
				}
				parseDictionaryFile(dictionaryContent.toString());
			}

		} catch (IOException e) {
			Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, null, e);
			System.err.println("Dictionary Files could not be loaded");
		}
	}

	public static Dictionary getInstance(final int lines) {
		if (null == instance)
			instance = new Dictionary(lines);
		return instance;
	}

	/**
	 * 
	 */
	public void init() {
		try {
			long t0 = System.nanoTime();
			if (DictionaryUtil.DEBUG_MODE_ON) {
				validateDictionary();
				System.out.println(" \n ==> Word List :" + wordList);
				displayDictionary();
			}
			System.out.println("\n ==> Dictonary loaded in nano-sec :" + (System.nanoTime() - t0));
			System.out.println("\n ==> Dictionary size :" + dictionaryA_Words.size());
			System.out.println("##########################################");
			System.out.println("########  DICTIONARY APPLICATON ##########");
			System.out.println("########                        ##########");
			System.out.println("########  [ Type ':q' to quit]  ##########");
			System.out.println("##########################################");
			while (true) {
				System.out.print("\nPlease enter word to search in dictionary (Press ENTER / ':q' to quit) :");
				Scanner inputScan = new Scanner(System.in);
				String searchWord = inputScan.nextLine();
				if (":q".equals(searchWord)) {
					System.err.println(" Thankyou for using :)");
					System.exit(1);//normal termination
				}
				WordMeaning meaning = searchWord(searchWord);
				if (null == meaning) {
					System.out.println("No meaning found in the dictionary for the word :" + searchWord);
				} else {
					System.out.println(meaning);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the wordList
	 */
	public List<String> getWordList() {
		return wordList;
	}

	/**
	 * 
	 * @param line
	 * @return
	 */
	private boolean isSkipLine(String line) {
		final String SKIP_LINE_REGEX = "";
		return line.matches(SKIP_LINE_REGEX); // check empty lines
	}

	/**
	 * 
	 * @param dictionaryContent
	 */
	private void parseDictionaryFile(final String dictionaryContent) {
		//CORRECT PARSING OF WORD
		final String DICTIONARY_WORD_REGEX = "[A-Z]{3,}" + "('S|;|\\s|-|[A-Z])*";

		// ==================================
		// To be added support for words like.
		// <1> SCROD; SCRODE <2> 'SDEATH <3> SCHWANN'S WHITE SUBSTANCE
		// <4> SCHWANN'S SHEATH <5> -'S
		// <6> ROSENMULLER'S ORGAN; ROSENMUELLER'S ORGAN
		// <7> ROPE'S-END <8> RAVEN'S-DUCK
		// <9> PRODUCER'S SURPLUS; PRODUCER'S RENT
		// ==================================
		Pattern pattern = Pattern.compile(DICTIONARY_WORD_REGEX);
		Matcher matcher = pattern.matcher(dictionaryContent);

		while (matcher.find()) {
			if (!isSkipWord(matcher.group())) {
				startWordIndexes.add(matcher.start());
				wordList.add(matcher.group());
				endWordIndexes.add(matcher.end());
			}
			if(DictionaryUtil.DEBUG_MODE_ON)System.out.print(", Skip Word found :"  + matcher.group());}			
		if (createDictionary(dictionaryContent) < 0) {
			throw new IllegalStateException(Dictionary.class + "Size of list endWordIndexes,startWordIndexes & wordList do not match");
		}
	}

	private boolean isSkipWord(String group) {
		boolean skip = false;		
		for(DictionaryUtil.SKIP_WORDS skipWord : DictionaryUtil.SKIP_WORDS.values()){
			if(DictionaryUtil.DEBUG_MODE_ON) System.out.print("Comparing with Skip word :" + skipWord.getValue());
			skip = skipWord.getValue().equals(group) ? true : false ;			
		}
		return skip;
	}

	/**
	 * 
	 * @param dictionaryContent
	 * @return
	 */
	private int createDictionary(final String dictionaryContent) {

		int k = 0;
		List<String> synonumous = null;

		if (!(startWordIndexes.size() == wordList.size() && endWordIndexes.size() == wordList.size()))
			return -1;
		// extract meaning
		for (; k < wordList.size(); ++k) {
			synonumous = new LinkedList<String>();
			if (DictionaryUtil.DEBUG_MODE_ON) {
				System.out.println("K:" + k + " Dictionary Content Size:" + dictionaryContent.length());
				System.out.println("EndIndex Size :" + endWordIndexes.size() + " --  StartIndex Size :" + startWordIndexes.size());
			}
			if (wordList.size() - 1 != k) {
				if (DictionaryUtil.DEBUG_MODE_ON) {
					System.out.println(" ==> [" + endWordIndexes.get(k) + " , " + wordList.get(k) + " ," + startWordIndexes.get(k + 1) + "] <==");
				}
				synonumous.add(escapeSpecialCharacters(dictionaryContent.substring(endWordIndexes.get(k), startWordIndexes.get(k + 1))));
				meaningList.add(k, synonumous);
			} else { // add the last word meaning
				if (DictionaryUtil.DEBUG_MODE_ON) {
					System.out.println(" ==> [" + endWordIndexes.get(k) + " , " + wordList.get(k) + " , " + dictionaryContent.length() + "] <==");
				}
				synonumous.add(escapeSpecialCharacters(dictionaryContent.substring(endWordIndexes.get(k), dictionaryContent.length())));
				meaningList.add(k, synonumous);
			}
			// fill word & meaning
			fillWordsMeaning(k);
		}
		return DictionaryUtil.DICTIONARY_LOAD_SUCCESS;
	}

	/**
	 * 
	 * @param substring
	 * @return
	 */
	private String escapeSpecialCharacters(String meaning) {
		char[] meaning_array = meaning.toCharArray();
		StringBuilder filteredMeaning = new StringBuilder();

		for (int i = 0; i < meaning_array.length; ++i) {
			//System.out.print(meaning_array[i]);			
			if ('\\' == meaning_array[i] && 'n' == meaning_array[++i]) {
				filteredMeaning.append(" ");
			} else {
				filteredMeaning.append(meaning_array[i]);
			}
		}
		return filteredMeaning.toString();
	}

	/**
	 * @param k
	 */
	private void fillWordsMeaning(int k) {
		switch (wordList.get(k).charAt(0)) {
			case 'A':
				dictionaryA_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'B':
				dictionaryB_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'C':
				dictionaryC_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'D':
				dictionaryD_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'E':
				dictionaryE_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'F':
				dictionaryF_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'G':
				dictionaryG_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'H':
				dictionaryH_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'I':
				dictionaryI_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'J':
				dictionaryJ_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'K':
				dictionaryK_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'L':
				dictionaryL_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'M':
				dictionaryM_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'N':
				dictionaryN_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'O':
				dictionaryO_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'P':
				dictionaryP_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'Q':
				dictionaryQ_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'R':
				dictionaryR_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'S':
				dictionaryS_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'T':
				dictionaryT_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'U':
				dictionaryU_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'V':
				dictionaryV_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'W':
				dictionaryW_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'X':
				dictionaryX_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'Y':
				dictionaryY_Words.put(wordList.get(k), meaningList.get(k));
				break;
			case 'Z':
				dictionaryZ_Words.put(wordList.get(k), meaningList.get(k));
				break;
			default:
				System.err.println(" INVALID WORD :" + wordList.get(k));
				throw new IllegalArgumentException("Invalid word");
		}
	}

	public void displayDictionary() {
		for (Entry<String, List<String>> entry : dictionaryA_Words.entrySet())
			System.out.println(" (A)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryB_Words.entrySet())
			System.out.println(" (B)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryC_Words.entrySet())
			System.out.println(" (C)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryD_Words.entrySet())
			System.out.println(" (D)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryE_Words.entrySet())
			System.out.println(" (E)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryF_Words.entrySet())
			System.out.println(" (F)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryG_Words.entrySet())
			System.out.println("(G)=>" + entry);

		for (Entry<String, List<String>> entry : dictionaryH_Words.entrySet())
			System.out.println(" (H)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryI_Words.entrySet())
			System.out.println(" (I)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryJ_Words.entrySet())
			System.out.println(" (J)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryK_Words.entrySet())
			System.out.println(" (K)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryL_Words.entrySet())
			System.out.println(" (L)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryM_Words.entrySet())
			System.out.println(" (M)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryN_Words.entrySet())
			System.out.println(" (N)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryO_Words.entrySet())
			System.out.println(" (O)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryP_Words.entrySet())
			System.out.println(" (P)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryQ_Words.entrySet())
			System.out.println(" (Q)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryR_Words.entrySet())
			System.out.println(" (R)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryS_Words.entrySet())
			System.out.println(" (S)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryT_Words.entrySet())
			System.out.println(" (T)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryU_Words.entrySet())
			System.out.println(" (U)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryV_Words.entrySet())
			System.out.println(" (V)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryW_Words.entrySet())
			System.out.println(" (W)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryX_Words.entrySet())
			System.out.println(" (X)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryY_Words.entrySet())
			System.out.println(" (Y)==> " + entry);

		for (Entry<String, List<String>> entry : dictionaryZ_Words.entrySet())
			System.out.println(" (Z)==> " + entry);

	}

	/**
	 * 
	 * @return
	 */
	private static BufferedReader getFileBufferedReader() {
		BufferedReader buffReader = null;		
		try {
			InputStream dicfileStream = Dictionary.class.getClassLoader().getResourceAsStream("englishdictionary/resources/dictionary");
			InputStreamReader streamReader = new InputStreamReader(dicfileStream);
			buffReader = new BufferedReader(streamReader);			
		} catch (Exception e) {
			Logger.getLogger(Dictionary.class.getName()).log(Level.SEVERE, "Unable to get dictionary file stream", e);
		}
		return buffReader;
	}
	
	private boolean validateDictionary() throws Exception {
		int grossDictionaryWord = dictionaryA_Words.size() + dictionaryB_Words.size() + dictionaryC_Words.size() + dictionaryD_Words.size()
				+ dictionaryE_Words.size() + dictionaryF_Words.size() + dictionaryG_Words.size() + dictionaryH_Words.size() + dictionaryI_Words.size()
				+ dictionaryJ_Words.size() + dictionaryK_Words.size() + dictionaryL_Words.size() + dictionaryM_Words.size() + dictionaryN_Words.size()
				+ dictionaryO_Words.size() + dictionaryP_Words.size() + dictionaryQ_Words.size() + dictionaryR_Words.size() + dictionaryS_Words.size()
				+ dictionaryT_Words.size() + dictionaryU_Words.size() + dictionaryV_Words.size() + dictionaryW_Words.size() + dictionaryX_Words.size()
				+ dictionaryY_Words.size() + dictionaryZ_Words.size();
		if (wordList.size() != grossDictionaryWord) {
			throw new Exception(" Incomplete dictionary ...");
		}
		return true;
	}

	public WordMeaning searchWord(String word) {

		WordMeaning meaning = null;

		if (DictionaryUtil.DEBUG_MODE_ON) System.out.println("Searching for word :" + word);
		if(null == word || 0 >= word.length()) return null;
		word = word.toUpperCase();
		switch (word.charAt(0)) {
			case 'A':
				if (dictionaryA_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryA_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'B':
				if (dictionaryB_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryB_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'C':
				if (dictionaryC_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryC_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'D':
				if (dictionaryD_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryD_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'E':
				if (dictionaryE_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryE_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'F':
				if (dictionaryF_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryF_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'G':
				if (dictionaryG_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryG_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'H':
				if (dictionaryH_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryH_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'I':
				if (dictionaryI_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryI_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'J':
				if (dictionaryJ_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryJ_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'K':
				if (dictionaryK_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryK_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'L':
				if (dictionaryL_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryL_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'M':
				if (dictionaryM_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryM_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'N':
				if (dictionaryN_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryN_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'O':
				if (dictionaryO_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryO_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'P':
				if (dictionaryP_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryP_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'Q':
				if (dictionaryQ_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryQ_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'R':
				if (dictionaryR_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryR_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'S':
				if (dictionaryS_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryS_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'T':
				if (dictionaryT_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryT_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'U':
				if (dictionaryU_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryU_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'V':
				if (dictionaryV_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryV_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'W':
				if (dictionaryW_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryW_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'X':
				if (dictionaryX_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryX_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'Y':
				if (dictionaryY_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryY_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;

			case 'Z':
				if (dictionaryZ_Words.containsKey(word)) {
					meaning = new WordMeaning();
					WordMeaning.Defination def = meaning.new Defination();
					def.setMeaning(dictionaryZ_Words.get(word).get(0));
					List<WordMeaning.Defination> defs = new LinkedList<WordMeaning.Defination>();
					defs.add(def);
					meaning.set_definations(defs);
				}
				break;
			default:return meaning;				
		}
		return meaning;
	}

	public void destroy() {
		//	
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Dictionary dictionary = Dictionary.getInstance(DictionaryUtil.MAX_LINE_READ_PER_PASS);
		dictionary.init();
		System.exit(1); //close JVM
	}

}
