package HealthCenterApplication.com.example.HealthCenter.Services;

import HealthCenterApplication.com.example.HealthCenter.dao.DepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class DepartmentServices {
    ActionResult actionResult;

    @Autowired
    private DepartmentDao departmentDao;

    public ActionResult addDepartment(Department department) {
        try {
            departmentDao.save(department);
            actionResult = new ActionResult(0, "Success", department);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult updateDepartment(int id, Department department) {
        try {
            if (departmentDao.findOne(id) != null) {
                department.setId(id);
                departmentDao.save(department);
                actionResult = new ActionResult(0, "Success", department);
            }else{
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult deleteDepartment(int id) {
        try {
            if (departmentDao.findOne(id) != null) {
                departmentDao.delete(id);
                actionResult = new ActionResult(0, "Success", "");
            }else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getDepartments() {
        try {
            List<Department> departmentList = (List<Department>) departmentDao.findAll();
            if (!departmentList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", departmentList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getDepartmentById(int id) {
        try {
            Department department = departmentDao.findOne(id);
            if (department != null) {
                actionResult = new ActionResult(0, "Success", department);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }

    }
}
