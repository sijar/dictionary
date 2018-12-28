/**
 * 
 */
package englishdictionary;

import java.util.List;

/**
 * @author Sijar Ahmed
 *
 */
public class WordMeaning {

	private String _pronunciation;
	private String _entomology;
	private PARTS_OF_SPEECH _part_of_speech;
	private List<Defination> _definations;
	private List<String> _synonymous;
	private List<String> _antonymous;
	
	
	/**
	 * 
	 * @author Sijar Ahmed
	 *
	 */
	public enum PARTS_OF_SPEECH{		
		//change this accordingly
		NOUN("n.","noun"),
		PRONOUN("p.","pronoun"),
		ADJECTIVE("a.","adjective"),
		VERB("v.","verb"),
		ADVERB("ad.","adverb"),
		PREPOSITION("po.","preposition"),
		CONJUNCTION("cn.","conjunction"),
		INTERJECTION("in.","interjection");
		
		private final String abbreviation;
		private final String value;

		PARTS_OF_SPEECH(String abbreviation, String value){
			this.abbreviation = abbreviation;
			this.value = value;
		}

		/**
		 * @return the abbreviation
		 */
		public String getAbbreviation() {
			return abbreviation;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		
		
	};
	
	/**
	 * @author Sijar Ahmed
	 *
	 */
	public class Defination {
		private String meaning;	

		/**
		 * @return the meaning
		 */
		public String getMeaning() {
			return meaning;
		}

		/**
		 * @param meaning the meaning to set
		 */
		public void setMeaning(String meaning) {
			this.meaning = meaning;
		}

		/**
		 * @param meaning
		 */
		public Defination(String meaning) {
			this.meaning = meaning;
		}

		/**
		 * 
		 */
		public Defination() {
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return meaning;
		}	
		
	}
	

	
	
	
	/**
	 * 
	 */
	public WordMeaning() {
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the _pronunciation
	 */
	public String get_pronunciation() {
		return _pronunciation;
	}




	/**
	 * @param _pronunciation the _pronunciation to set
	 */
	public void set_pronunciation(String _pronunciation) {
		this._pronunciation = _pronunciation;
	}




	/**
	 * @return the _entomology
	 */
	public String get_entomology() {
		return _entomology;
	}




	/**
	 * @param _entomology the _entomology to set
	 */
	public void set_entomology(String _entomology) {
		this._entomology = _entomology;
	}




	/**
	 * @return the _part_of_speech
	 */
	public PARTS_OF_SPEECH get_part_of_speech() {
		return _part_of_speech;
	}




	/**
	 * @param _part_of_speech the _part_of_speech to set
	 */
	public void set_part_of_speech(PARTS_OF_SPEECH _part_of_speech) {
		this._part_of_speech = _part_of_speech;
	}




	/**
	 * @return the _definations
	 */
	public List<Defination> get_definations() {
		return _definations;
	}




	/**
	 * @param _definations the _definations to set
	 */
	public void set_definations(List<Defination> _definations) {
		this._definations = _definations;
	}




	/**
	 * @return the _synonymous
	 */
	public List<String> get_synonymous() {
		return _synonymous;
	}




	/**
	 * @param _synonymous the _synonymous to set
	 */
	public void set_synonymous(List<String> _synonymous) {
		this._synonymous = _synonymous;
	}




	/**
	 * @return the _antonymous
	 */
	public List<String> get_antonymous() {
		return _antonymous;
	}




	/**
	 * @param _antonymous the _antonymous to set
	 */
	public void set_antonymous(List<String> _antonymous) {
		this._antonymous = _antonymous;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pronunciation=").append(_pronunciation);
		builder.append(",\nEntomology=").append(_entomology);
		builder.append(",\nPart_of_speech=").append(_part_of_speech);
		for(Defination def : _definations){
			builder.append(",\nDefinations=").append(def);
		}
		builder.append(",\nSynonymous=").append(_synonymous);
		builder.append(",\nAntonymous=").append(_antonymous);		
		return builder.toString();
	}

	
	
	
	
}
