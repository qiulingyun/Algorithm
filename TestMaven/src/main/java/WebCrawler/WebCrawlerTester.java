package WebCrawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawlerTester {

	private static final int QUESTION_NUM = 2;
	private static final int ANSWER_NUM = 3;
	
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		//获取编辑推荐页
        Document document=Jsoup.connect("https://www.zhihu.com/")
                //模拟火狐浏览器
//                .userAgent("Mozilla/4.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)")
                .get();
        
        Element root = document.getElementById("root");
        Elements main = root.select("div").select("main").select("div")
        					.select("div.ContentLayout-mainColumn").select("div").select("div:nth-child(2)");
        for(int i = 1; i <= QUESTION_NUM; i++){
        	String divName = "div:nth-child(" + i + ")";
        	Elements url=main.select(divName).select("div").select("div.ContentItem.AnswerItem")
                             .select("h2").select("div").select("a");
        	
        	for(Element question:url){
                //输出href后的值，即主页上每个关注问题的链接
                String URL=question.attr("abs:href");
                URL = URL.replaceAll("/answer/.*", "");
                //下载问题链接指向的页面
                Document document2=Jsoup.connect(URL).get();
                //问题
                Elements title=document2.select("#root").select("div").select("main").select("div")
                		.select("div:nth-child(11)").select("div.QuestionHeader").select("div.QuestionHeader-content")
                		.select("div.QuestionHeader-main").select("h1");
                //问题描述
//                Elements detail=document2.select("#root").select("div").select("main").select("div")
//                		.select("div:nth-child(11)").select("div.QuestionHeader").select("div.QuestionHeader-content")
//                		.select("div.QuestionHeader-main").select("div:nth-child(4)").select("div").select("div").select("div")
//                		.select("span").select("p:nth-child(1)");
                //回答
//                Elements answerBest=document2.select("#root").select("div").select("main").select("div").select("div.Question-main").select("div.Question-mainColumn")
//                		.select("div.Card.AnswerCard").select("div").select("div")
//                		.select("div.RichContent.RichContent--unescapable").select("div.RichContent-inner").select("span");
                
                System.out.println("\n"+"链接："+URL
                        +"\n"+"标题："+title.text());
//                        +"\n"+"问题描述："+detail.text()
//                        +"\n"+"置顶回答："+answerBest.text());
                Elements answers=document2.select("#QuestionAnswers-answers").select("div").select("div");
                int j = 1;
                ArrayList<String> answerList = new ArrayList<String>();
                String lastAnswer = null;
                for(Element answer:answers){
                	Elements answerContent = answer.select("div").select("div.RichContent.RichContent--unescapable").select("div.RichContent-inner").select("span");
                	String ans = answerContent.text();
                	if(ans == null || ans.isEmpty()){
                		continue;
                	}
                	if(lastAnswer == null || !lastAnswer.equals(ans)){
                		if(j > ANSWER_NUM){
                			break;
                		}
                		answerList.add(ans);
                		lastAnswer = ans;
                		j++;
                	}
//                	System.out.println( "回答"+(j)+": "+ answerContent.text() );
                	
                }
                for(String ansStr:answerList){
                	System.out.println( "回答: "+ ansStr );
                }
                
//                for(int j = 1; j <= ANSWER_NUM; j++){
//                	String answerDiv = "div:nth-child(" + j + ")";
//                	Elements answerOther=document2.select("#QuestionAnswers-answers").select("div").select("div")
//                    		             .select("div:nth-child(2)").select("div").select(answerDiv).select("div")
//                    		             .select("div.RichContent.RichContent--unescapable").select("div.RichContent-inner").select("span");
//                	System.out.println( "回答"+(j)+": "+ answerOther.text() );
//                    
//                }
                               
                
            } 
        }
        
          
	}

}
