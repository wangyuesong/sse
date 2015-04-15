package sse.dao.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import sse.dao.base.GenericDao;
import sse.entity.Teacher;
import sse.entity.User;

@Repository
public class TeacherDaoImpl extends GenericDao<Integer, Teacher>
{

    /*
     * (non-Javadoc)
     * 
     * @see sse.dao.impl.ITeacherDao#findTeachersForPaging()
     */
    public List<Teacher> findTeachersForPaging(int page, int pageSize, String sort, String order)
    {
        return this.findForPaging("select t from Teacher t", new LinkedList<Object>(), page, pageSize, sort, order);
    }

    /*
     * (non-Javadoc)
     * 
     * @see sse.dao.impl.ITeacherDao#findTeachersForCount()
     */
    public long findTeachersForCount()
    {
        return this.findForCount("select t from Teacher t", new LinkedList<Object>());
    }
    
    public int getTeacherIdByAccount(String account)
    {
        String queryStr = "select t from Teacher t where t.account = :account";
        List<Teacher> teachers = this.getEntityManager()
                .createQuery(queryStr, Teacher.class)
                .setParameter("account", account).getResultList();
        if(!CollectionUtils.isEmpty(teachers))
            return teachers.get(0).getId();
        else
            return -1;
    }

}
