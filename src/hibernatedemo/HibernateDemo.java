/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatedemo;

import java.util.List;
import javame.model.bean.Department;
import javame.model.bean.Employee;
import javame.util.demo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Kuldeep
 */
public class HibernateDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HibernateDemo empDao=new HibernateDemo();
       
       
 
        Employee emp = new Employee();
        Department dept=new Department();
        dept.setDeptName("security");
        emp.setFirstName("Babu");
        emp.setLastName("Tangewala");
        emp.setSalary(new Long(5250));
        emp.setDept(dept);
        dept.setEmp(emp);
        
        System.out.println(" Employee "+emp);
        System.out.println(" Department  "+dept);
        empDao.insertEmployee(emp);
        
 
        System.out.println("---------------------------");
 
        List<Employee> empList = empDao.getEmployeeList();
        System.out.println("emp size: "+empList.size());
        empList.stream().forEach(System.out::println);
 
        System.out.println("---------------------------");
 
        Employee empObj;
        empObj = empDao.getEmployeeById(emp.getId());
        System.out.println(empObj);
 
        System.out.println("---------------------------");
       //S empDao.deleteEmployee(empObj);
 
        System.out.println("---------------------------");
 
        empList = empDao.getEmployeeList();
        System.out.println("emp size: "+empList.size());
        empList.stream().forEach(System.out::println);
 
        System.out.println("---------------------------");
    }
    
    public List<Employee> getEmployeeList(){
 
        Session session = null;
        List<Employee> empList = null;
        try {
            session = HibernateUtil.getSession();
            String queryStr = "select emp from Employee emp";
            Query query = session.createQuery(queryStr);
            empList = query.list();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return empList;
    }
    
    public Employee getEmployeeById(int empId){
 
        Session session = null;
        Employee emp = null;
        try {
            session = HibernateUtil.getSession();
            String queryStr = "select emp from Employee emp";
            emp = (Employee) session.get(Employee.class, empId);
 
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
        return emp;
    }
 
    public void insertEmployee(Employee emp) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.save(emp);
            System.out.println("inserted employee: "+emp.getFirstName());
            transaction.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
 
    public void deleteEmployee(Employee emp) {
 
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            session.delete(emp);
            transaction.commit();
            System.out.println("deleted employee: "+emp.getFirstName());
        } catch(Exception ex) {
            ex.printStackTrace();
            // handle exception here
            if(transaction != null) transaction.rollback();
        } finally {
            try {if(session != null) session.close();} catch(Exception ex) {}
        }
    }
    
}
