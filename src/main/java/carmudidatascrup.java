import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Shafayat on 1/30/2017.
 */
public class carmudidatascrup {


    public static void main(String[] args)
    {
        for (int i = 1; i <=382 ; i++) {
            try {
                Document documents = Jsoup.connect("https://www.carmudi.com.bd/cars/?sort=suggested&page="+i).get();
                Elements element =documents.select(".item-title");
                for (Element cars:element) {
                    String link=cars.select("a").attr("href");

                    Document doc= Jsoup.connect("https://www.carmudi.com.bd"+link).get();
                    Elements ele= doc.select(".row.payload");
                    for (Element target :ele
                         ) {
                        String model=target.select(".small-12 .clearfix .column .title-bar").text();
                        String price=target.select(".small-12.large-8 .clearfix .column .type-xl").text();
                        System.out.println(model+" "+price);

                    }


                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
