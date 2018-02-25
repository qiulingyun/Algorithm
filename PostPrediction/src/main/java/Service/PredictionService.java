package Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.ExcelData;
import Model.Header;
import Model.Post;
import Utility.ExcelParser;

@Service
public class PredictionService {

	private ExcelData excel;
	private HashMap<String, ArrayList<Post>> business2postMap;
	private HashMap<Header, ArrayList<Post>> header2postMap;
	private boolean isInitialized;

	public PredictionService() {
		super();
		business2postMap = new HashMap<String, ArrayList<Post>>();
		header2postMap = new HashMap<Header, ArrayList<Post>>();
		isInitialized = false;
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

}
