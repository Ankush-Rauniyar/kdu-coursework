package QuestionTwo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;

public class SentimentAnalyzer {
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords, String[] negOpinionWords) {
        int[] featureOpinions = new int[featureSet.length];

        for(int i = 0 ; i < featureSet.length ; i++){
            String[] featureIndividual = featureSet[i];
            for(int counterFeature = 0 ; counterFeature  < featureIndividual.length ; counterFeature++) {
                boolean containsFeature = review.toLowerCase().contains(featureIndividual[counterFeature].toLowerCase());
                if (!containsFeature) {
                    continue;
                } else {
                    int getReview = getOpinionOnFeature(review.toLowerCase(), featureIndividual[counterFeature].toLowerCase(), posOpinionWords, negOpinionWords);
                    featureOpinions[i] = getReview;
                    break;
                }
            }
        }
        return featureOpinions;
    }
    private static int getOpinionOnFeature(String review, String feature,String[] posOpinionWords, String[] negOpinionWords) {
        int ans = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);
        if(ans == 0){
            ans = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return ans;
    }
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {
        int opinion = 0;
        String pattern = feature + " was ";
        if(review.contains(pattern)){
            for(int counter = 0 ; counter < posOpinionWords.length ; counter++){
                String anotherPattern = pattern + posOpinionWords[counter];
                if(review.contains(anotherPattern)){
                    opinion = 1;
                    return opinion;
                }else{
                    continue;
                }
            }
            for(int counter = 0 ; counter < negOpinionWords.length ; counter++){
                String anotherPattern = pattern + negOpinionWords[counter];
                if(review.contains(anotherPattern)){
                    opinion = -1;
                    return opinion;
                }else{
                    continue;
                }
            }
            return opinion;
        }else{
            return 0;
        }
    }

    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,String[] negOpinionWords) {
        int opinion = 0;
        for(int i = 0 ; i < posOpinionWords.length; i++){
            String pattern = posOpinionWords[i] + " " + feature;
            if(review.contains(pattern)){
                opinion = 1;
                return opinion;
            }else{
                continue;
            }
        }

        for(int i = 0 ; i < negOpinionWords.length; i++){
            String pattern = negOpinionWords[i] + " " + feature;
            if(review.contains(pattern)){
                opinion = -1;
                return opinion;
            }else{
                continue;
            }
        }
        return opinion;
    }
    private static final Logger logger = LoggerFactory.getLogger(SentimentAnalyzer.class);


    public static void main(String[] args) {


        logger.info("initated the program");

        String review = "Haven't bad ice cream been here in years! amazing service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";
        //String review = "Sorry OG, but you just lost some loyal
//        customers. Horrible service, no smile or greeting just attitude. The
//        breadsticks were stale and burnt, appetizer was cold and the food came
//        out before the salad.";


        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };

        String[] posOpinionWords = { "good", "fantastic", "friendly",
                "great", "excellent", "amazing", "awesome",
                "delicious" };

        String[] negOpinionWords = { "slow", "bad", "horrible",
                "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review.toLowerCase(), featureSet,posOpinionWords, negOpinionWords);

        logger.info("ended the program");


        //System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));

        //turned of system.out.println
    }
}