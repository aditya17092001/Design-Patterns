    public class Client {
        public static void main(String[] args) {

            /*
            * If we create the object like below it means it is tightly coupled.
            * 
            * To solve this problem we'll create a seperate class and we will get object from the class by passing what type of object we required.
            */
            // Employee employee = new AndroidDeveloper();
            // System.out.println(employee.salary());

            /*
            * Here we'll get an objects from the Factory class.
            */
            
            Employee webDev = EmployeeFactory.getEmployeeObject("WEB DEVELOPER");
            System.out.println(webDev.salary());
            Employee andDev = EmployeeFactory.getEmployeeObject("ANDROID DEVELOPER");
            System.out.println(andDev.salary());
        }   

    }
