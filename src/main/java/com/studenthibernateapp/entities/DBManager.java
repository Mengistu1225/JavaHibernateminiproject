package com.studenthibernateapp.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;



public class DBManager {
	public static void main(String[] args) {
		System.out.println("working ....");
		
		Student student=new Student();
		student.setFname("Yrga");
		student.setLname("Yonas");
		student.setAge(30);
		student.setEmail("yrga2022@gmail.com");
		/*
		saveStudent(student);
		List<Student> students=getAllStudents();
		for(Student st:students) {
			System.out.println("id "+st.getId()+"first name:"+st.getFname()
			+"last name: "+st.getLname()+"age: "+st.getAge()+"email"+st.getEmail());
		}
		System.out.println(" successfully done");
		
		}*/
		//deleteStudent(6);
		
		int updatetostudent=4;
		update(updatetostudent,student);
		System.out.println(" done ");
		
		 
		

		
		
	}
// update method for object in the database
	 private static void update(int updatetostudent, Student student) {
	        Session session = getSession();
	        Transaction transaction = session.beginTransaction();
	        Student studentfound = (Student) session.createQuery("from Student where id=:updatetostudent")
	                .setParameter("updatetostudent", updatetostudent).getSingleResult();
	        studentfound.setFname(student.getFname());
	        studentfound.setLname(student.getLname());
	        studentfound.setAge(student.getAge());
	        studentfound.setEmail(student.getEmail());
	        transaction.commit();
	        session.close();
	    }
// delete the objects of database
	private static void deleteStudent(int id) {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from Student where id=:studentId");
		query.setParameter("studentId", id);
		int rows = query.executeUpdate();
		System.out.println("Rows deleted is: " + rows);
		transaction.commit();
		session.close();
	}
//method of save obejects in the database
	static void saveStudent(Student student) {

		Session session = getSession();
		Transaction transaction = session.beginTransaction();
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
// method for retrieve  objects  from database
	static List<Student> getAllStudents() {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		List<Student> student = session.createQuery("FROM Student").list();
		transaction.commit();
		session.close();
		return student;
	}

}
