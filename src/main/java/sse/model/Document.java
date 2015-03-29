package sse.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;

/**
 * The persistent class for the document database table.
 * 
 */
@Entity
@Table(name = "document")
@NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false, length = 45)
	private String status;

	@Column(nullable = false, length = 2000)
	private String url;

	// bi-directional many-to-one association to Documenttype
	@ManyToOne
	@JoinColumn(name = "DOCUMENTTYPE_ID", nullable = false)
	private Documenttype documenttype;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "CREATE_TIME")
	private Timestamp createTime;

	@Column(name = "LAST_MODIFIED_BY")
	private int lastModifiedBy;

	@Column(name = "UPDATE_TIME")
	private Timestamp updateTime;

	public Document() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Documenttype getDocumenttype() {
		return documenttype;
	}

	public void setDocumenttype(Documenttype documenttype) {
		this.documenttype = documenttype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	

}