package sse.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author yuesongwang
 *
 */
@Entity
@DiscriminatorValue("Teacher")
public class Teacher extends User {
    /**
	 * 
	 */
    private static final long serialVersionUID = 400018318739519613L;

    // bi-directional many-to-one association to User
    @OneToMany(mappedBy = "teacher")
    private List<Student> students;

    @Column(length = 45)
    private String title;

    private int capacity;

    @Column(length = 45)
    private String degree;

    @OneToMany(mappedBy = "teacher")
    List<DocumentComment> documentComments;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Teacher() {

    }

    /**
     * @param id
     * @param account
     * @param name
     * @param password
     * @param capacity
     */
    public Teacher(int id, String account, String name, String password, int capacity)
    {
        this.setId(id);
        this.setAccount(account);
        this.setName(name);
        this.setPassword(password);
        this.setCapacity(capacity);
    }

}
