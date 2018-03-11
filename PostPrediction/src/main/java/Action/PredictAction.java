package Action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Case;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import Model.Header;
import Model.LineItem;
import Model.Post;
import Model.Prediction;
import Model.UserInput;
import Service.PredictionService;

@Controller
public class PredictAction {
	@Autowired
	private PredictionService predictionService;
	
	@RequestMapping(path="/test.do", method=RequestMethod.GET) 
	public UserInput testMethod() {
		return new UserInput();
	}
	@RequestMapping(path="/predict.do", method=RequestMethod.POST)
	public String doPredict(UserInput input){
//		ModelAndView modelAndView = new ModelAndView("PredictivePosting");
		if(input == null){
			return null;
		}
		// get user input
		ArrayList<String> businessList = input.getBusiness();
		String period = input.getPeriod();
		if(period == null || period.isEmpty()){
			return null;
		}
		HashMap<String, ArrayList<Post>> business2postMap = predictionService.getBusiness2postMap();
		if(business2postMap == null || business2postMap.isEmpty()){
			return null;
		}
		
		
		ArrayList<Prediction> predictionList = new ArrayList<Prediction>();
		for(int i = 0; i < businessList.size(); i++){
			String business = businessList.get(i);
			
			ArrayList<Post> postList = business2postMap.get(business);
			if(postList == null){
				continue;
			}
			
			for(int j = 0; j < postList.size(); j++){
				Post post = postList.get(i);
				if(post == null){
					continue;
				}
				Header header = post.getHeader();
				ArrayList<LineItem> listItems = post.getLineItems();
				if(header == null || listItems == null){
					continue;
				}
				
				Prediction prediction = new Prediction();
				prediction.setBusiness(business);
				prediction.setCompanyCode(header.getCompanyCode());
				prediction.setFiscalYear(header.getFiscalYear());
				prediction.setJournalEntryType(header.getJournalEntryType());
				prediction.setTransactionCurrency(header.getTransactionCurrency());
				
				Long debit = 0L;
				for(int k = 0; k < listItems.size(); k++){
					LineItem lineItem = listItems.get(k);
					if(lineItem == null){
						continue;
					}
					debit += Long.getLong(lineItem.getDebit());
				}
				prediction.setDebit(String.valueOf(debit));
				predictionList.add(prediction);
			}
		}
		if(predictionList.isEmpty()){
			return null;
//			modelAndView.addObject("prediction", predictionList);
		}
		JSONObject json = new JSONObject();
		json.put("perdiction", predictionList);
		
		return json.toString();

	}
	
	public ModelAndView processPredict(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView modelAndView = new ModelAndView("index");
		if(predictionService == null || predictionService.isInitialized() == false){
			return modelAndView;
		}
		
		String fiscalYear = request.getParameter("fiscalYear");
		String companyCode = request.getParameter("companyCode");
		String journalEntryType = request.getParameter("journalEntryType");
		String transactionCurrency = request.getParameter("transactionCurrency");
		String accountNumber1 = request.getParameter("accountNumber1");
		String debit1 = request.getParameter("debit1");
		String credit1 = request.getParameter("credit1");
		String costCenter1 = request.getParameter("costCenter1");
		String profitCenter1 = request.getParameter("profitCenter1");
		String accountNumber2 = request.getParameter("accountNumber2");
		String debit2 = request.getParameter("debit2");
		String credit2 = request.getParameter("credit2");
		String costCenter2 = request.getParameter("costCenter2");
		String profitCenter2 = request.getParameter("profitCenter2");
		
		Header header = new Header();
		header.setFiscalYear(fiscalYear);
		header.setCompanyCode(companyCode);
		header.setJournalEntryType(journalEntryType);
		header.setTransactionCurrency(transactionCurrency);
		if(!header.checkCompanyCode()){
			return modelAndView;
		}else if(!header.checkFiscalYear()){
			return modelAndView;
		}
		
		LineItem lineItem1 = new LineItem(), lineItem2 = new LineItem();
		lineItem1.setAccountNumber(accountNumber1);
		lineItem1.setDebit(debit1);
		lineItem1.setCredit(credit1);
		lineItem1.setProfitCenter(profitCenter1);
		lineItem1.setCostCenter(costCenter1);
		lineItem1.addPrefixZero();
		if(!lineItem1.checkAccountNumber()){
			return modelAndView;
		}else if(!lineItem1.checkDebit()){
			return modelAndView;
		}else if(!lineItem1.checkCredit()){
			return modelAndView;
		}else if(!lineItem1.checkProfitCenter()){
			return modelAndView;
		}else if(!lineItem1.checkCostCenter()){
			return modelAndView;
		}
		
		lineItem2.setAccountNumber(accountNumber2);
		lineItem2.setDebit(debit2);
		lineItem2.setCredit(credit2);
		lineItem2.setProfitCenter(profitCenter2);
		lineItem2.setCostCenter(costCenter2);
		lineItem2.addPrefixZero();
		if(!lineItem2.checkAccountNumber()){
			return modelAndView;
		}else if(!lineItem2.checkDebit()){
			return modelAndView;
		}else if(!lineItem2.checkCredit()){
			return modelAndView;
		}else if(!lineItem2.checkProfitCenter()){
			return modelAndView;
		}else if(!lineItem2.checkCostCenter()){
			return modelAndView;
		}
		
		Post post = new Post();
		post.setHeader(header);
		post.getLineItems().add(lineItem1);
		post.getLineItems().add(lineItem2);
		
		Post predictPost = predictionService.doPredict(post);
		ArrayList<LineItem> predictLineItems = predictPost.getLineItems();
		for(int i = 0; i < predictLineItems.size(); i++){
			LineItem lineitem = predictLineItems.get(i);
			switch (i) {
			case 0:
				modelAndView.addObject("accountNumber1", lineitem.getAccountNumber());
				modelAndView.addObject("debit1", lineitem.getDebit());
				modelAndView.addObject("credit1", lineitem.getCredit());
				modelAndView.addObject("costCenter1", lineitem.getCostCenter());
				modelAndView.addObject("profitCenter1", lineitem.getProfitCenter());
				break;
			case 1:
				modelAndView.addObject("accountNumber2", lineitem.getAccountNumber());
				modelAndView.addObject("debit2", lineitem.getDebit());
				modelAndView.addObject("credit2", lineitem.getCredit());
				modelAndView.addObject("costCenter2", lineitem.getCostCenter());
				modelAndView.addObject("profitCenter2", lineitem.getProfitCenter());
				break;
			default:
				break;
			}
		}
		
		return modelAndView;
	}
	
	public PredictionService getPredictionService() {
		return predictionService;
	}

	public void setPredictionService(PredictionService predictionService) {
		this.predictionService = predictionService;
	}
}
