/**
 *	2014年11月10日 上午11:04:03
 *	TangLi
 */
package tika;

import java.io.File;
import java.io.FileInputStream;

import org.apache.tika.Tika;
import org.apache.tika.language.LanguageIdentifier;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

/**
 * @author TangLi 2014年11月10日上午11:04:03
 */
public class TikaDoc
{

	public static void main(String[] ar) throws Exception
	{
		BodyContentHandler handler = new BodyContentHandler();
		Metadata metadata = new Metadata();

		File file = new File("tika_tutorial.pdf");
//		File file = new File("新健康标准/学生基本信息模版(1).xls");
		FileInputStream inputstream = new FileInputStream(file);
		ParseContext pcontext = new ParseContext();
		
		PDFParser parser = new PDFParser();
//		OOXMLParser parser = new OOXMLParser();
//		XMLParser parser = new XMLParser(); 
//		HtmlParser parser = new HtmlParser(); 
//		TXTParser parser = new TXTParser(); 
		parser.parse(inputstream, handler, metadata, pcontext);

//		 System.out.println("Contents of the PDF :" + handler.toString());

		// getting metadata of the document
		System.out.println("--------------detect dmetadata");
		String[] metadataNames = metadata.names();

		for (String name : metadataNames)
		{
			System.out.println(name + " : " + metadata.get(name));
		}

		System.out.println("--------------detect document type");
		// Instantiating tika facade class
		Tika tika = new Tika();
		// detecting the file type using detect method
		String filetype = tika.detect(file);
		System.out.println(filetype);

		System.out.println("--------------detect Language");
		LanguageIdentifier identifier = new LanguageIdentifier(handler.toString());
		String language = identifier.getLanguage();
		System.out.println("Language of the given content is : " + language);
		
	}

}
