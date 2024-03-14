package com.sopra.BookStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.sopra.repository.BookStoreRepository;



public class App 
{
    public static void main( String[] args )
    {
    	
    	
    	 AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext();
         
         app.scan("com.sopra.repository");
         
         app.refresh();
         
    
        BookStoreRepository bsr=app.getBean(BookStoreRepository.class);
        
         
         
//         
//         bsr.store(new Inventory(101,"The Chronicals Of Narnia", "Adventure",30,1000.00));
//         bsr.store(new Inventory(102,"Harry Potter", "Fiction",50,1200.00));
//         bsr.store(new Inventory(103,"Game of Thrones", "Action",70,1500.00));
//         bsr.store(new Inventory(104,"Divergent", "Science Fiction",20,900.00));
//         bsr.store(new Inventory(105,"Outlander", "Drama",30,1100.00));
         
        
//         System.out.println(bsr.getAll());
       
    	List<Inventory> lst=new ArrayList<>();
    	
    	Inventory in=new Inventory();
    	in.setBookId(101);
    	in.setGenre("Adventure");
    	in.setName("The Chronicles of Narnia");
    	in.setPrice(1200);
    	in.setQuantity(30);
    	
    	Inventory in1=new Inventory();
    	in1.setBookId(102);
    	in1.setGenre("Fiction");
    	in1.setName("Harry Potter");
    	in1.setPrice(1500);
    	in1.setQuantity(50);
    	
    	Inventory in2=new Inventory();
    	in2.setBookId(103);
    	in2.setGenre("Action");
    	in2.setName("Game of thrones");
    	in2.setPrice(1000);
    	in2.setQuantity(20);
//    	
//    	Inventory in3=new Inventory();
//    	in3.setBookId(104);
//    	in3.setGenre("Science Fiction");
//    	in3.setName("Divergent");
//    	in3.setPrice(900);
//    	in3.setQuantity(40);
//    	
    	Inventory in4=new Inventory();
    	in4.setBookId(105);
    	in4.setGenre("Drama");
    	in4.setName("Outlander");
    	in4.setPrice(1500);
    	in4.setQuantity(30);
    	
    	
    	
    	lst.add(in);
    	lst.add(in1);
    	lst.add(in2);
//    	lst.add(in3);
    	lst.add(in4);
    	
    	//storing
    	bsr.store(lst);
    	
    	Scanner sc;
    	Scanner sc1;
    	int did;
    	
    	try {
			//selecting
			System.out.println("Enter the id to be displayed");
			sc = new Scanner(System.in);
			int id = sc.nextInt();
			System.out.println("details for car id" + id + "are: \n" + bsr.get(id));
			//deleting
			System.out.println("Enter the id to be deleted");
			sc1 = new Scanner(System.in);
			did = sc1.nextInt();
			
			Inventory i = bsr.get(did);
			bsr.delete(i);
			
			System.out.println("details for car id"+did+"are deleted");
			//getall
			System.out.println("All details are: \n" + bsr.getAll());
		} finally {
			// TODO: handle finally clause
			
	         app.close();
	         
		}
		
    	
    	
    	
    	
    	sc.close();
    	sc1.close();
         
         
    }
}
