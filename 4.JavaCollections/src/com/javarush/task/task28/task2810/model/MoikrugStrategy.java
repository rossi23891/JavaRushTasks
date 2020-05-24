package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT= "https://moikrug.ru/vacancies?q=java+%s&page=%d";;
    //private static final String URL_FORMAT= "https://moikrug.ru/vacancies?q=java+%s";
    int PAGE_VALUE = 0;

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> Vacancies = new ArrayList<>();
        int pageNum = 0;
        Document doc = null;
        while(true)
        {
            try {
                doc = getDocument(searchString, pageNum);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements vacancies = doc.getElementsByClass("job");
            if (vacancies.size()==0) break;
            for (Element element: vacancies)
            {
                if (element != null)
                {
                    Vacancy vac = new Vacancy();
                    vac.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vac.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vac.setSiteName(URL_FORMAT);
                    vac.setUrl("https://moikrug.ru" + element.select("a[class=job_icon]").attr("href"));
                    String salary = element.getElementsByAttributeValue("class", "salary").text();
                    String city = element.getElementsByAttributeValue("class", "location").text();
                    vac.setSalary(salary.length()==0 ? "" : salary);
                    vac.setCity(city.length()==0 ? "" : city);
                    Vacancies.add(vac);
                }
            }
            pageNum++;
        }
        return Vacancies;
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
