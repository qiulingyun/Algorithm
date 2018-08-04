package nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.ognl.Token;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import util.ExcelParser;

public class TestParser {

	public HashMap<Integer, String> lineNum2OriTxtMap = new HashMap<Integer, String>();
	public HashMap<Integer, ArrayList<String>> parsedMap = new HashMap<Integer, ArrayList<String>>();
	public HashMap<String, List<String>> stdwordMap = null;
	
	public void getOriginText(String txtUrl) throws IOException{
		URL url = TestParser.class.getClassLoader().getResource(txtUrl);
		File file = new File(url.getFile());
		BufferedReader breader= new BufferedReader(new FileReader(file));
		String line = null;
		int lineNumber = 1;
		while((line = breader.readLine()) != null){
			System.out.println("Line " + lineNumber + ":" + line);
			lineNum2OriTxtMap.put(lineNumber, line);
			lineNumber++;
		}
		breader.close();
	}
	
	public void parseOriginText() throws IOException{
		if(lineNum2OriTxtMap.isEmpty()){
			return;
		}
		for(Map.Entry<Integer, String> entry : lineNum2OriTxtMap.entrySet()){
			ArrayList<String> list = parsedMap.get(entry.getKey());
			if(list == null){
				list = new ArrayList<String>();
				parsedMap.put(entry.getKey(), list);
			}
			String lineText = entry.getValue();
			if(lineText == null || lineText.isEmpty()){
				continue;
			}
			
			Analyzer analyzer = new StandardAnalyzer();
			TokenStream ts = analyzer.tokenStream("", lineText);
			ts.reset();
			CharTermAttribute cta = ts.addAttribute(CharTermAttribute.class);
			while(ts.incrementToken()){
//				System.out.println(cta.toString() );
				list.add(cta.toString());
			}
			ts.end();
	        ts.close();
			
		}
	}
	
	public void loadStdWordMap(String xlsxUrl){
		URL url = TestParser.class.getClassLoader().getResource(xlsxUrl);
		ExcelParser ep = new ExcelParser();
		ep.analyzeExcel(url.getFile());
		stdwordMap = ep.getStdWordMap();
	}
	
	public static void main(String[] args) throws IOException {
		TestParser tp = new TestParser();
		tp.getOriginText("mail.txt");
		tp.parseOriginText();
		
		tp.loadStdWordMap("stdword.xlsx");
		
        

	}

}
