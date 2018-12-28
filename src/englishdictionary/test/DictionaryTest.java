package englishdictionary.test;

import englishdictionary.Dictionary;
import englishdictionary.DictionaryUtil;
import englishdictionary.WordMeaning;
import englishdictionary.WordMeaning.Defination;
//import junit.framework.TestCase;
//import junit.textui.TestRunner;

/**
 * The class <code>DictionaryTest</code> contains tests for the class {@link
 * <code>Dictionary</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 10/26/12 5:35 PM
 *
 * @author Sijar Ahmed
 *
 * @version $Revision$
 */
/*
public class DictionaryTest extends TestCase
{
	Dictionary dictionary;
	
	public DictionaryTest(String name)
	{
		super(name);		
	}

	public static void main(String[] args)
	{
		TestRunner.run(DictionaryTest.class);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
		dictionary = Dictionary.getInstance(DictionaryUtil.MAX_LINE_READ_PER_PASS);
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
		dictionary.destroy();
	}

	public void testSearchWord()
	{	
		System.out.println("Meaning not found for the word");
		for(String word : dictionary.getWordList()){			
			WordMeaning meaning = dictionary.searchWord(word);
				if(null != meaning){
					if(null != meaning.get_definations()){						 
						for(WordMeaning.Defination defs : meaning.get_definations()){
							if(null != defs)System.out.println(word + " , ");
						}
				}								
			}			
		}
	}
}


/*$CPS$ This comment was generated by CodePro. Do not edit it.
 * patternId = com.instantiations.assist.eclipse.pattern.testCasePattern
 * strategyId = com.instantiations.assist.eclipse.pattern.testCasePattern.junitTestCase
 * additionalTestNames = 
 * assertTrue = false
 * callTestMethod = true
 * createMain = true
 * createSetUp = true
 * createTearDown = true
 * createTestFixture = false
 * createTestStubs = false
 * methods = searchWord(QString;)
 * package = englishdictionary
 * package.sourceFolder = collabpro/src
 * superclassType = junit.framework.TestCase
 * testCase = DictionaryTest
 * testClassType = englishdictionary.Dictionary
 */