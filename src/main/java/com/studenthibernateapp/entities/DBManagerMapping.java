package com.studenthibernateapp.entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBManagerMapping {

	public static void main(String[] args) {
		//onetoonesave();
		//onetomanysave();
		manytomanysave();

	}

	private static void manytomanysave() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student student1=new Student();
		student1.setFname("tesema");
		student1.setLname("girmay");
		student1.setAge(30);
		student1.setEmail("tesema2022@gmail.com");
		
		Student student2=new Student();
		student2.setFname("alganesh");
		student2.setLname("girmay");
		student2.setAge(30);
		student2.setEmail("alganesh2022@gmail.com");
		
		Student student3=new Student();
		student3.setFname("freweyni");
		student3.setLname("girmay");
		student3.setAge(30);
		student3.setEmail("freweyni2022@gmail.com");
		
		Project project1 =new Project();
		project1.setTitle("hotel managment system");
		Project project2 =new Project();
		project2.setTitle("human resource management system");
		
		student1.getProjects().add(project1);
		project1.getStudents().add(student1);
		
		student1.getProjects().add(project2);
		project2.getStudents().add(student1);
		
		student2.getProjects().add(project2);
		project2.getStudents().add(student2);
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.save(project1);
		session.save(project2);
		
		transaction.commit();
		session.close();
		
		
		
	}

	private static void onetomanysave() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Student student=new Student();
		student.setFname("eyoba");
		student.setLname("girmay");
		student.setAge(30);
		student.setEmail("girmay2022@gmail.com");
		Department department=new Department();
		department.setName("computer science");
		student.setDepartment(department);
		session.save(department);
		session.save(student);
		
		transaction.commit();
		session.close();
		
		
	}

	private static void onetoonesave() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Address address=new Address();
		address.setCity("Addis Abeba");
		address.setSubcity("mesqlegna");
		Student student=new Student();
		student.setFname("Tesfamaryam");
		student.setLname("hagos");
		student.setAge(30);
		student.setEmail("tesfamariam2022@gmail.com");
		student.setAddrress(address);
		session.save(address);
		session.save(student);
		
		transaction.commit();
		session.close();
		
		
	}
	static Session getSession() {
		Configuration cnfg = new Configuration();
		cnfg.configure("hibernate.cfg.xml");
		Session session = cnfg.buildSessionFactory().openSession();
		return session;
	}
	

}
