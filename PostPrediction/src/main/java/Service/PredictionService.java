package Service;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.ExcelData;
import Model.Header;
import Model.Post;
import Suggestion.PostSuggestion;
import Utility.ExcelParser;

@Service
public class PredictionService {

	private ExcelData excel;
	private HashMap<String, ArrayList<Post>> business2postMap;
	private HashMap<Header, ArrayList<Post>> header2postMap;
	private boolean isInitialized;
	@Autowired
	private PostSuggestion postSuggestion;

	public PredictionService() {
		super();
		business2postMap = new HashMap<String, ArrayList<Post>>();
		header2postMap = new HashMap<Header, ArrayList<Post>>();
		isInitialized = false;
	}
	
	public Post doPredict(Post post){
		Header header = post.getHeader();
		if(header == null){
			return null;
		}
		
		Set<Header> set = header2postMap.keySet();
		for(Iterator<Header> iter = set.iterator(); iter.hasNext(); ){
			Header header1 = iter.next();
			if(header1.getCompanyCode() == header.getCompanyCode() &&
					header1.getJournalEntryType() == header.getJournalEntryType() &&
					header1.getTransactionCurrency() == header.getTransactionCurrency()){
				System.out.println("Found!!!!");
			}
		}
		ArrayList<Post> postList = header2postMap.get(header);
		if(postList == null){
			return null;
		}
		SortedMap<Double, ArrayList<Post>> scoreMap = new TreeMap<Double, ArrayList<Post>>();
		for(int i = 0; i < postList.size(); i++){
			Post postTmp = postList.get(i);
			double simiScore;
			try {
				simiScore = postSuggestion.calSimilarityByFiscalYear(header, postTmp.getHeader());
			} catch (ParseException e) {
				e.printStackTrace();
				continue;
			}
			ArrayList<Post> tmpList = scoreMap.get(simiScore);
			if(tmpList == null){
				tmpList = new ArrayList<Post>();
			}
			tmpList.add(postTmp);
			scoreMap.put(simiScore, tmpList);
		}
		
		System.out.println(scoreMap);
		
		return scoreMap.get(scoreMap.lastKey()).get(0);
	}

	public boolean initByUpload(InputStream is) {
		excel = ExcelParser.parseXlsx(is);
		if (excel == null) {
			return false;
		}

		ArrayList<Post> postList = excel.getPostList();
		if (postList != null) {
			for (int i = 0; i < postList.size(); i++) {
				Post post = postList.get(i);
				if (post == null) {
					continue;
				}
				
				String business = post.getBusiness();
				ArrayList<Post> dataList = business2postMap.get(business);
				if (dataList == null) {
					dataList = new ArrayList<Post>();
					business2postMap.put(business, dataList);
				}
				dataList.add(post);
				
				Header header = post.getHeader();
				dataList = header2postMap.get(header);
				if (dataList == null) {
					dataList = new ArrayList<Post>();
					header2postMap.put(header, dataList);
				}
				dataList.add(post);
			}
			
		}

		this.isInitialized = true;
		return true;
	}
	
	public boolean isInitialized(){
		return this.isInitialized;
	}

	public PostSuggestion getPostSuggestion() {
		return postSuggestion;
	}

	public HashMap<String, ArrayList<Post>> getBusiness2postMap() {
		return business2postMap;
	}

	public void setBusiness2postMap(HashMap<String, ArrayList<Post>> business2postMap) {
		this.business2postMap = business2postMap;
	}

	public static void main(String[] args){
		SortedMap<Integer, String> scoreMap = new TreeMap<Integer, String>();
		scoreMap.put(1, "a");
		scoreMap.put(3, "c");
		scoreMap.put(2, "b");
		scoreMap.put(4, "d");
		System.out.println(scoreMap);
		
	}
}
