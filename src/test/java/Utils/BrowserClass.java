package Utils;

import PageObject.PageObjectManager;

import java.io.IOException;

public class BrowserClass {
    public String productName;

    public TestBaseClass testBaseClass;

public PageObjectManager PageObjectManager;
public Genericutils genericutils;

    public BrowserClass() throws IOException {
        testBaseClass = new TestBaseClass();
        PageObjectManager = new PageObjectManager(testBaseClass.BrowserManger());
        genericutils = new Genericutils(testBaseClass.BrowserManger());
    }



}
