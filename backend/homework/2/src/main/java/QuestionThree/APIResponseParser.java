package QuestionThree;

public class APIResponseParser {
    public static Book parse(String response){
        Book book = new Book();

        String endRule = "<";

        String startRule = "<title>";
        String title = parse(response, startRule, endRule);

        String startRulePublication ="<original_publication_year type=\"integer\">";
        String publication = parse(response,startRulePublication,endRule);

        String[] startRuleName = {"<author>","<name>"};
        String name = parse(response,startRuleName,endRule);

        String startRuleAvergae = "<average_rating>";
        String average = parse(response,startRuleAvergae,endRule);

        String startRuleRatings = "<ratings_count type=\"integer\">";
        String ratings = parse(response,startRulePublication,endRule);

        String startRuleImg = "<image_url>";
        String img = parse(response,startRuleImg,endRule);



        book.setTitle(title);
        book.setAuthor(name);
        book.setAverageRating(Double.parseDouble(average));
        book.setRatings(Integer.parseInt(ratings));
        book.setPublicationYear(Integer.parseInt(publication));
        book.setImageUrl(img);

        return book;
    }

    public static String parse(String response,String[] startRule,String endRule){
        String ans;
        int startIndex = response.indexOf(startRule[0] + startRule[0].length());
        for(int counter = 1; counter < startRule.length ; counter++){
            startIndex = response.indexOf(startRule[counter],startIndex);
        }
        startIndex = startIndex + startRule[startRule.length - 1].length();
        int endIndex = response.indexOf(endRule,startIndex);
        return response.substring(startIndex,endIndex);

    }

    public static String parse(String response,String startRule,String endRule){
        int startIndex = response.indexOf(startRule) + startRule.length();
        int endIndex = response.indexOf(endRule,startIndex);
        return response.substring(startIndex,endIndex);
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";
        Book book = APIResponseParser.parse(response);
        book.getTitle();
        book.getAuthor();
        book.getPublicationYear();
        book.getAverageRating();
        book.getRatings();
        book.getImageUrl();

    }
}
