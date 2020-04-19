package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT= "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    int PAGE_VALUE = 0;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> listVacancy = new ArrayList<>();
        Document document = null;
        int pageNumber = 0;
            try {
                document = getDocument(searchString, pageNumber);
                String key = "data-qa";
                while (true){
                    Elements elements = document.getElementsByAttributeValue(key, "vacancy-serp__vacancy");
                    if (elements.size() == 0) {
                        PAGE_VALUE = 0;
                        break;
                    }
                    for (Element element : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setTitle(element.getElementsByAttributeValueContaining(key, "vacancy-serp__vacancy-title").text().trim());
                        vacancy.setCity(element.getElementsByAttributeValueContaining(key, "vacancy-serp__vacancy-address").text().trim());
                        vacancy.setCompanyName(element.getElementsByAttributeValueContaining(key, "vacancy-serp__vacancy-employer").text().trim());
                        vacancy.setUrl(element.getElementsByAttributeValueContaining(key, "vacancy-serp__vacancy-title").attr("href").trim());
                        vacancy.setSalary(element.getElementsByAttributeValueContaining(key, "vacancy-serp__vacancy-compensation").text().trim());
                        vacancy.setSiteName(URL_FORMAT);
                        listVacancy.add(vacancy);
                    }
                    ++PAGE_VALUE;
                    document = getDocument(searchString, PAGE_VALUE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return listVacancy;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        Document doc = null;
        String html="";
        try {
            html = String.format(URL_FORMAT, searchString, page);
            doc = Jsoup.connect(html).userAgent("Chromium/81.0.4044.113")
                    .referrer("https://grc.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2").get();
            //System.out.println(doc.html());
            return doc;
        } catch (IOException e){
        }
        return doc;
    }
}
