package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    private View view;
    //model
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View currentView = new View();
        Controller controller = new Controller(currentView);
        currentView.setController(controller);
        currentView.init();
        controller.init();
    }

    public void init(){

    }

    public void exit(){
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }
}
