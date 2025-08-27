/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-18 20:05:02 UTC+08:00
 ****************************************************/
package org.example.extend.pkg5;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Lionel Johnson
 */
public class Car {
    private String name;
    private int age;
    private String color;
    private String engineName;
    private int engineYear;
    
    
    public Car() {
    }
    
    public Car(String name, int age, String color, String engineName, int engineYear) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.engineName = engineName;
        this.engineYear = engineYear;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getEngineName() {
        return engineName;
    }
    
    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
    
    public int getEngineYear() {
        return engineYear;
    }
    
    public void setEngineYear(int engineYear) {
        this.engineYear = engineYear;
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("age", age)
                .append("color", color)
                .toString();
    }
    
    public void showEngine() {
        Engine engine = new Engine(engineName, engineYear);
        engine.show();
    }
    
    static class Engine {
        private String name;
        private int year;
        
        public Engine() {
        }
        
        public Engine(String name, int year) {
            this.name = name;
            this.year = year;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
        
        public int getYear() {
            return year;
        }
        
        public void setYear(int year) {
            this.year = year;
        }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("name", name)
                    .append("year", year)
                    .toString();
        }
        
        public void show() {
            System.out.println("show");
        }
    }
    
    
}
