package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.undo.UndoManager;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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

    public void resetDocument(){
        UndoListener undoListener = view.getUndoListener();
        if(document!=null){
            document.removeUndoableEditListener(undoListener);
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(undoListener);
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader stringReader = new StringReader(text);
        try {
            new HTMLEditorKit().read(stringReader,document,0);
        } catch (Exception e) {
           ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        //должен получать текст из документа со всеми html тегами
        StringWriter stringWriter = new StringWriter();
        try {
            new HTMLEditorKit().write(stringWriter,document,0,document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }
}
