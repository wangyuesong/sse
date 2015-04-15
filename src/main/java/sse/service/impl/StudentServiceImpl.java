package sse.service.impl;

import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sse.dao.impl.TeacherDaoImpl;
import sse.dao.impl.WillDaoImpl;
import sse.entity.Teacher;
import sse.pageModel.DataGrid;
import sse.pageModel.WillModel;

@Service
public class StudentServiceImpl {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private TeacherDaoImpl teacherDaoImpl;

    @Autowired
    private WillDaoImpl willDaoImpl;

    public DataGrid<Teacher> findTeachersForPaging(int pageSize, int page, String sort, String order)
    {
        DataGrid<Teacher> dg = new DataGrid<>();
        dg.setRows(teacherDaoImpl.findTeachersForPaging(pageSize, page, sort, order));
        dg.setTotal(teacherDaoImpl.findTeachersForCount());
        return dg;
    }

    public HashMap<String, String> findPreviousWills(int studentId)
    {
        return willDaoImpl.findPreviousSelectionByStudentId(studentId);
    }

    public void updateSelection(WillModel model, int studentId)
    {
        willDaoImpl.updateSelection(model, studentId);
    }

}
