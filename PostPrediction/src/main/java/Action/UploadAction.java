package Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import Model.ExcelData;
import Model.Post;
import Model.TreeNode;
import Service.PredictionService;
import Utility.ExcelParser;
import Utility.TreeHelper;

@Controller
public class UploadAction {

	@Autowired
	private PredictionService predictionService;
	
//	@Override
//	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@RequestMapping(value="/upload.do",method=RequestMethod.POST)
	public String processUpload(@RequestParam("excel") MultipartFile file,HttpSession session) throws IOException{
		if(file.getSize() == 0 || !file.getOriginalFilename().endsWith("xlsx")){
			return "error";
		}
		
		predictionService.initByUpload(file.getInputStream());
		
		
		return "success";
	}

	public PredictionService getPredictionService() {
		return predictionService;
	}

	public void setPredictionService(PredictionService predictionService) {
		this.predictionService = predictionService;
	}

	
}
