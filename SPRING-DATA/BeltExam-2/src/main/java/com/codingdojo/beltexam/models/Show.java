package com.codingdojo.beltexam.models;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(unique=true)
	@Size(min=1, message="Title is required")
	private String title;
	@Size(min=1, message="Network is required")
	private String network;
	
	
	private double average_reviews;
	
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @OneToMany(mappedBy="show", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Rating> ratings;
    
    public Show() {
    }
    public Show(String title, String network) {
    	this.title = title;
    	this.network = network;
    }

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public double getAverage_reviews() {
		return average_reviews;
	}
	public void setAverage_reviews(double average_reviews) {
		this.average_reviews = average_reviews;
		double total = 0.0;
		for (int i = 0; i < this.ratings.size(); i++) {
			total += this.ratings.get(i).getValue();
		}
		double average = total/this.ratings.size();
		this.average_reviews = average;
	}
}
