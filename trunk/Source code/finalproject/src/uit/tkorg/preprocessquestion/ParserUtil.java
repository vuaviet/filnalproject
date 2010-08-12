package uit.tkorg.preprocessquestion;
import java.io.IOException;
import opennlp.tools.lang.english.TreebankParser;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;

/**
 *
 * @author hungnt
 */

public class ParserUtil {
	private Parser	parser;
	/**
	 * 
	 * @param dataDir : Directory contains model
	 * @throws IOException
	 *  
	 */
    private ParserUtil(String dataDir) throws IOException {
		this.parser	=	TreebankParser.getParser(dataDir);
		
	}
    /**
	 * @return ParserUtil if dataDir is correct, else return null
	 * @param dataDir : Directory contains model
	 * @throws IOException
	 * 
	 */
    public static ParserUtil createParseUtil(String dataDir) throws IOException
    {
    	ParserUtil result	=	null;
    	try {
			 result	=	new ParserUtil(dataDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e; 
		}
		return result;
    }
    /**
     * @param line : line will be parsed
     * @author hungnt
     * @param numParses: number of Parses
     * @return Array of Parse
     */
    public  Parse[] parseLine(String line, int numParses) {
    	return TreebankParser.parseLine(line, parser, numParses);
    }
    
	public static void main(String[] args) throws IOException
    {
		ParserUtil	parserutil	=	ParserUtil.createParseUtil("stores\\model\\english\\parser");
        Parse p = parserutil.parseLine("Who work for WHO ?", 1)[0];

        p.show();
        p.showCodeTree();



    }
}





