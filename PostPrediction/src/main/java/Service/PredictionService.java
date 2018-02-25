package Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Model.ExcelData;
import Model.Post;
import Utility.ExcelParser;

@Service
public class PredictionService {
	
	private ExcelData excel;
	private HashMap<String, ArrayList<Post>> cocd2postMap;
	
	
	public PredictionService() {
		super();
		cocd2postMap = new HashMap<String, ArrayList<Post>>();
	}



	public boolean initByUpload(InputStream is){
		excel = ExcelParser.parseXlsx(is);
		if(excel != null){
			ArrayList<Post> postList = excel.getPostList();
			if(postList != null){
				for(int i = 0; i < postList.size(); i++){
					Post post = postList.get(i);
					if(post == null){
						continue;
					}
					String cocd = post.getHeader().getCompanyCode();
					ArrayList<Post> dataList = cocd2postMap.get(cocd);
					if(dataList == null){
						dataList = new ArrayList<Post>();
						cocd2postMap.put(cocd, dataList);
					}
					dataList.add(post);
					
				}
			}
		}
		return true;
	}
	
	
}
