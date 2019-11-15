package library.common;

import library.BookItem;

import java.util.List;
import java.util.Random;

public class Common {
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max || min <= 0) {
            throw new IllegalArgumentException("Must be in range 1 and greater");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String setCommaAsDelimiter(List<BookItem> itemList) {
        StringBuffer sb = new StringBuffer();
        for (BookItem item : itemList){
            sb.append(item.getTitle()).append(", ");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        return sb.toString();
    }
}
