package opi.utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    public String urlPrograms,urlEvaluation, user, admin, expert, employee, password, documentExampleSignature, programName;

    public void getProperties() throws IOException {
        Properties prop = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream == null) {
            throw new FileNotFoundException("Property File '" + propFileName + "' not found in the classpath");
        }
        prop.load(inputStream);
        urlPrograms = prop.getProperty("urlPrograms");
        urlEvaluation = prop.getProperty("urlEvaluation");
        admin = prop.getProperty("admin");
        expert = prop.getProperty("expert");
        employee = prop.getProperty("employee");
        password = prop.getProperty("password");
        user = prop.getProperty("user");
        documentExampleSignature = prop.getProperty("documentExampleSignature");
        programName = prop.getProperty("programName");

        inputStream.close();
    }

    public String getUrlPrograms(){
        return urlPrograms;
    }
    public String getUrlEvaluation(){
        return urlEvaluation;
    }
    public String getAdminUsername(){ return admin; }
    public String getExpertUsername(){
        return expert;
    }
    public String getExampleDocumentSignature(){
        System.out.println("ex: "+documentExampleSignature);
        return documentExampleSignature;
    }
    public String getEmployee(){
        return employee;
    }
    public String getPassword(){
        return password;
    }
    public String getUser(){
        return user;
    }
    public String getProgramName(){
        return programName;
    }
}
