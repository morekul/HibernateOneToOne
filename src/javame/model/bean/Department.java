/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javame.model.bean;

/**
 *
 * @author Kuldeep
 */
public class Department {
    
    private int depId;
    private String deptName;
    private Employee emp;

    public Department() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Department(int depId, String deptName) {
        this.depId = depId;
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Department{" + "depId=" + depId + ", deptName=" + deptName + '}';
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    
    
}
