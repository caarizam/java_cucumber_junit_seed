package org.aut.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReaderHelper {
    private Properties properties;
    private InputStream input;
    private String fileName = "application.properties";

    public PropertiesReaderHelper(){
        properties = new Properties();
        input = null;
    }

    public String getProperty(String propertyName){

        String value = "";

        try{
            input = PropertiesReaderHelper.class.getClassLoader().getResourceAsStream(this.fileName);
            properties.load(input);
            value = properties.getProperty(propertyName);

            return value;

        }catch(IOException iex){
            iex.printStackTrace();

        }finally {
            if(input != null){
                try{
                    input.close();
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return "";
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
