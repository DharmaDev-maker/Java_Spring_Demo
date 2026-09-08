package com.mon7926;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    { 
        /*
        BeanFactory is older version and lazy loading compared to ApplicationContext----------------
        loads the Spring context from the XML configuration file

       BeanFactory fact = new ClassPathXmlApplicationContext("context.xml");
       Student s = (Student) fact.getBean("student1");  
       This returns object of type Student
       this is traditional way of setting properties after getting the bean from Spring container
       s.setAge(20);
       s.setName("sidhu");
        
       System.out.println("Student Name: " + s.getName());
       System.out.println("Student Age: " + s.getAge());
    //  refer to T1}  this will not work cuz this is a inner bean not a standalone bean for this the parent bean is student1
    //  Address a = (Address) fact.getBean("address1");
       System.out.println("Student Address: " + s.getAddress().getCity() + ", " + s.getAddress().getState());
    */

    /*ApplicationCOntext which extends the BeanFactory and provides additional 
    features like eager loading, event propagation, and @autowiring------
    */   
   /*Student s =  context.getBean("studentWithHobbies", Student.class); //internally it is typcasted object -> student
   Student s2 =  context.getBean("studentWithAttributes", Student.class); //internally it is typcasted object -> student
   System.out.println("Student Hobbies: " + s.getHobbies());
   System.out.println("Student Attributes: " + s2.getAttributes());
   Address tempAddress = context.getBean("address1", Address.class);
   Address permaAddress = context.getBean("address1", Address.class);
   
   System.out.println("Temp Address: " + tempAddress);
   System.out.println("Perma Address: " + permaAddress);
   */
  
    /*lets check the autowired injection for Address in Student*/
    /*ApplicationContext context = new ClassPathXmlApplicationContext("context8926_new_config.xml");
    Student s = context.getBean("", Student.class); //internally it is typcasted object -> student
    System.out.println("Student Name: " + s.getName());
    System.out.println("Student Age: " + s.getAge());
    System.out.println(s.getAddress()); 
    */
   /*when 2 beans exsist for address temp and perma, Spring will inject the primary one , 
     if we set primary="true" else it gets confused or throws an exception. 
     This is the exception:  No qualifying bean of type 'com.mon7926.Address' 
       available: expected single matching bean but found 2: tempAddress,permaAddress
        this reason we will use Annotation called @Qualifier to specify which bean to inject.
*/
  //  testing the placeholder injection for student properties
  ApplicationContext context = new ClassPathXmlApplicationContext("context8926_new_config.xml");
    Student s = context.getBean("student", Student.class); //internally it is typcasted object -> student
    System.out.println("Student Name: " + s.getName());
    System.out.println("Student Age: " + s.getAge());
    System.out.println(s.getAddress());

     
     

    
   
    
    }
}
