package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName()
            .replace(".", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        String updatedFileContent = getUpdatedFileContent(vacancies);
        updateFile(updatedFileContent);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath),"UTF-8");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList) {

        Document document = null;
        try {
            document = getDocument();
            Element template = document.getElementsByClass("template").first();
            Element copy = template.clone();
            copy.removeClass("template").removeAttr("style");
            document.select("tr[class='vacancy']").remove();

            Element temp;

            for (Vacancy v : vacancyList) {
                temp = copy.clone();
                Element a = temp.select("a").first();
                a.attr("href", v.getUrl());
                a.text(v.getTitle());
                temp.select("td.city").first().text(v.getCity());
                temp.select("td.companyName").first().text(v.getCompanyName());
                temp.select("td.salary").first().text(v.getSalary());

                template.before(temp);
            }

            return document.toString();
        }
        catch(IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String fileContent) {
        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
