/**
 * 
 */
package englishdictionary;

/**
 * @author Sijar Ahmed
 * 
 */
public interface DictionaryUtil {

	public static final int		MAX_LINE_READ_PER_PASS	= 1000000;
	public static final int		DICTIONARY_LOAD_SUCCESS	= 1;
	public static final boolean	DEBUG_MODE_ON			= false;

	/**
	 * 
	 * @author Sijar Ahmed
	 * 
	 */
	static enum SKIP_WORDS {
		OHG(1, "OHG"), MHG(2, "MGH"), OF(3, "OF"), 
		I(4, "I"), II(5, "II"), III(6, "III"), IV(7, "IV"), V(8, "V"), VII(9, "VII"), VIII(10, "VIII"), 
		OE(11, "OE"), LL(12, "LL"), AS(13, "AS"), NL(14, "NL"), OD(15, "OD"), OS(16, "OS");

		private final String	value;

		/**
		 * @param value
		 */
		SKIP_WORDS(int no, String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		//		public List<SKIP_WORDS> getValues() {
		//			List<SKIP_WORDS> list = new LinkedList<SKIP_WORDS>();
		//			Collections.addAll(list, values());
		//			return list;
		//		}

	}
}
