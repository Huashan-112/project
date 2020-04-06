package service;

import dao.DepartmentDAO;
import entity.Department;

public class DepartmentService {
    DepartmentDAO departmentDAO = new DepartmentDAO();

    public String getName(int id){
        Department department = departmentDAO.get(id);
        return department.getName();
    }
}
