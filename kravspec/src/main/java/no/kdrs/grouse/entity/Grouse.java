package no.kdrs.grouse.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="grouse")
public class Grouse implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="grouse_id")
    private int grouseId;  
	@Column(name="title")
    private String title;
	@Column(name="category")	
	private String category;
	public int getGrouseId() {
		return grouseId;
	}
	public void setGrouseId(int grouseId) {
		this.grouseId = grouseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
} 
