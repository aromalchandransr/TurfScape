package com.candella.utility;

import java.util.ArrayList;

import java.util.Properties;
import java.util.Scanner;


import com.candella.entity.FeedBack;
import com.candella.entity.Turf;
import com.candella.entity.User;
import com.candella.service.FeedBackServiceImp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class FeedBackUtility {
	public static void main(String[] args) {
		feedBackMenu()	;
	}
	
	public static void feedBackMenu() {
		char selectChoice;
		do {

			Scanner scanner = new Scanner(System.in);

			System.out.println("1.Add Feedback \n2.Display All Feedback\n3.Analysis Feedback");
			int choice = scanner.nextInt();

			if (choice == 1) {
				addFeedback();
			} else if (choice == 2) {
				displayAllFeedback();

			}else if (choice==3) {
				analysisFeedback();
				
			}
			
			  
			System.out.println("do you want continue");
			selectChoice = scanner.next().charAt(0);
			if (selectChoice != 'y' && selectChoice != 'Y') {
		        MainUtility.mainMenu();
		    }
		} while (selectChoice == 'y' || selectChoice == 'Y');

	}

	


	private static void analysisFeedback() {
	    FeedBackServiceImp feedBackService = new FeedBackServiceImp();
	    ArrayList<FeedBack> feedbackList;
	    feedbackList = (ArrayList<FeedBack>) feedBackService.ListAllFeedBack();

	    // Set up Stanford NLP pipeline
	    Properties props = new Properties();
	    props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
	    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);

	    for (FeedBack feedBack : feedbackList) {
	        String feedBackText = feedBack.getFeedBack();

	        // Create an annotation with the text
	        Annotation annotation = new Annotation(feedBackText);
	        pipeline.annotate(annotation);

	        // Get sentiment annotation from the annotation
	        CoreMap sentence = annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0);
	        String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);

	        // Print sentiment corresponding to the feedback text
	        System.out.println("Feedback: " + feedBackText);
	        System.out.println("Sentiment: " + sentiment);
	        System.out.println("-----------------------------------------");
	    }
	}

	
	
	private static void displayAllFeedback() {
		FeedBackServiceImp feedBackService=new FeedBackServiceImp();
		ArrayList<FeedBack>feedbackList;
		feedbackList=(ArrayList<FeedBack>)feedBackService.ListAllFeedBack();
		System.out.println("FedID\tUserID\tTurfID\tFeedback");
		System.out.println("-----------------------------------------");
		for (FeedBack feedBack : feedbackList) {
		    System.out.println(
		        feedBack.getFedId() + "\t" +
		        feedBack.getUser().getUserId() + "\t" +
		        feedBack.getTurf().getTurfId() + "\t" +
		        feedBack.getFeedBack()
		    );
		}
	}

	private static void addFeedback() {
		
		FeedBackServiceImp feedBackService=new FeedBackServiceImp();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Feedback_id : ");
		int feedbackId = scanner.nextInt();
		System.out.println("Enter the User_id : ");
		int userId = scanner.nextInt();
		User user = new User();
		user.setUserId(userId);;
		System.out.println("Enter the Turf Id : ");
		int TurfId = scanner.nextInt();
		Turf turf = new Turf();
		turf.setTurfId(TurfId);
		scanner.nextLine();
		System.out.println("Enter the Feedback : ");
		String Feedback = scanner.nextLine();

		feedBackService.addFeedBack(new FeedBack(feedbackId,user,turf,Feedback));
				
	
	
	
	}
}

