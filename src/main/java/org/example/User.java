package org.example;

import java.io.File;

public class User {
    //Class atributes
    protected String username;
    protected String password;
    protected File file = null;

    //Constructors
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Method to create a file or a directory, maybe i will modify this for the CMD
    public File setFile(String path) {
        return file = new File(path);
    }

    //Method to create a directory
    public void mkDir(String path) {
        File dir = setFile(path); //It gets the directory created
        if(!dir.exists()) { //Validates that the directory's name doesn't exist
            //if not it create the dir, else just Show the error message
            if(dir.mkdirs()) System.out.println("Directory created at: "+dir.getAbsolutePath());
            else System.out.println("Error!");
        }
    }

    //Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //toString Method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User {\nUsername: ").append(this.username);
        sb.append(", \nPassword: ").append(this.password);
        sb.append("\n}");
        return sb.toString();
    }
}
