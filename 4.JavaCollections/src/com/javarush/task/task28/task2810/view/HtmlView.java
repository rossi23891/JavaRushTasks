package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView  implements View{
    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName()
            .replace(".","/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        String updatedFileContent = getUpdatedFileContent(vacancies);
        updateFile(updatedFileContent);
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancyList){
        return null;
    }

    private void updateFile(String fileContent){
        try (FileWriter fileWriter = new FileWriter(new File(filePath))) {
            fileWriter.write(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
