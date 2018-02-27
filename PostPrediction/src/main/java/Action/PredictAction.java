package Action;

import java.io.IOException;
import java.text.SimpleDateFormat;

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

import Model.Header;
import Model.LineItem;
import Model.Post;
import Service.PredictionService;

@Controller
public class PredictAction {
	@Autowired
	private PredictionService predictionService;
	
	
	@RequestMapping(value="/predict.do",method=RequestMethod.POST)
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
		
		return modelAndView;
	}
	
	public PredictionService getPredictionService() {
		return predictionService;
	}

	public void setPredictionService(PredictionService predictionService) {
		this.predictionService = predictionService;
	}
}
