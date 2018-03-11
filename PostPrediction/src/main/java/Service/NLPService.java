package Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.ognl.Token;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.CharTermAttributeImpl;

import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ie.util.RelationTriple;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.naturalli.NaturalLogicAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class NLPService {
	// lucene
	private Analyzer analyzerStanderd = new StandardAnalyzer();

	public NLPService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analyzer getAnalyzerStanderd() {
		return analyzerStanderd;
	}

	public void setAnalyzerStanderd(Analyzer analyzerStanderd) {
		this.analyzerStanderd = analyzerStanderd;
	}

	public void runAllStanfordNLPAnnotators(String text) {
		// creates a StanfordCoreNLP object, with POS tagging, lemmatization,
		// NER, parsing, and coreference resolution
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,depparse,natlog,openie");
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

		// create an empty Annotation just with the given text
		Annotation document = new Annotation(text);

		// run all Annotators on this text
		pipeline.annotate(document);

		parserOutput(document);
	}

	public void parserOutput(Annotation document) {
		// these are all the sentences in this document
		// a CoreMap is essentially a Map that uses class objects as keys and
		// has values with custom types
		List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

		for (CoreMap sentence : sentences) {
			// traversing the words in the current sentence
			// a CoreLabel is a CoreMap with additional token-specific methods
			// for (CoreLabel token :
			// sentence.get(CoreAnnotations.TokensAnnotation.class)) {
			// // this is the text of the token
			// String word = token.get(CoreAnnotations.TextAnnotation.class);
			// // this is the POS tag of the token
			// String pos =
			// token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
			// // this is the NER label of the token
			// String ne =
			// token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
			// }

			// this is the parse tree of the current sentence
//			Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
//			System.out.println("Óï·¨Ê÷£º");
//			System.out.println(tree.toString());
//
//			// this is the Stanford dependency graph of the current sentence
//			SemanticGraph dependencies = sentence
//					.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
//			System.out.println("ÒÀ´æ¾ä·¨£º");
//			System.out.println(dependencies.toString());

			Collection<RelationTriple> triples = sentence.get(NaturalLogicAnnotations.RelationTriplesAnnotation.class);
			// Print the triples
			for (RelationTriple triple : triples) {
				System.out.println(triple.confidence + "\t" + triple.subjectLemmaGloss() + "\t"
						+ triple.relationLemmaGloss() + "\t" + triple.objectLemmaGloss());
			}
		}

		// This is the coreference link graph
		// Each chain stores a set of mentions that link to each other,
		// along with a method for getting the most representative mention
		// Both sentence and token offsets start at 1!
		Map<Integer, CorefChain> graph = document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
	}

	public static void main(String[] args) throws IOException {
		String text = "We kindly ask you to transfer 30% amount to company code 1010 and 70% amount to company code 1710 on 08.03.2018";
		NLPService nlpService = new NLPService();
		Analyzer analyzer = nlpService.getAnalyzerStanderd();
		TokenStream tokenStream = analyzer.tokenStream("content", text);
		tokenStream.reset();
		CharTermAttribute term = tokenStream.addAttribute(CharTermAttribute.class);
		while (tokenStream.incrementToken()) {
			System.out.print("[" + term.toString() + "]");
		}

		nlpService.runAllStanfordNLPAnnotators(text);
	}

}
