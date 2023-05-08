//Salesforce Apex Class
public with sharing class StudentEditController {
    
    //Apex method to update student record
    @AuraEnabled
    public static void updateStudent(Student__c student){
        //Validate student name
        if(String.isBlank(student.Name)) {
            throw new AuraHandledException('Student name cannot be blank.');
        }
        
        //Validate student ID
        if(String.isBlank(student.Student_ID__c)) {
            throw new AuraHandledException('Student ID cannot be blank.');
        }
        
        //Validate student grade
        if(student.Grade__c == null) {
            throw new AuraHandledException('Student grade must be provided.');
        }
        
        //Update student record
        try {
            update student;
        }
        catch(Exception e) {
            throw new AuraHandledException('An error occurred while trying to update the student record.');
        }
    }
}