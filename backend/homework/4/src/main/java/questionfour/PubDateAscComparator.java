package questionfour;

import java.util.Comparator;

public class PubDateAscComparator implements Comparator<Book>{
    public int compare(Book o1,Book o2){
        int result = Integer.compare(o1.getYear(), o2.getYear());
        if(result == 0){
            return o1.compareTo(o2);
        }
        return result;
    }
}