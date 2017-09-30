package no.kdrs.grouse.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="kravspec")
public class Kravspec implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="kravspec_id")
    private int kravspecId;  
	@Column(name="title")
    private String title;
	@Column(name="category")	
	private String category;
	public int getKravspecId() {
		return kravspecId;
	}
	public void setKravspecId(int kravspecId) {
		this.kravspecId = kravspecId;
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
