package com.semurr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "blog")
public class Blog {

	@Id
	@GeneratedValue	
	@Column(name = "blog_id", unique = true, nullable = false)
	private int		blog_id;
	
	@Column(name = "title", nullable = false)
	private String	title;
	
	@Column(name = "subject", nullable = false)
	private String	subject;	
	
	@OneToOne
	@JoinColumn(name = "author")	
	private UserAccount	author;
	
	@Column(name = "time")	
	private Date	time;

	/**
	 * @return the blog_id
	 */
	public int getBlog_id() {
		return blog_id;
	}

	/**
	 * @param blog_id
	 *            the blog_id to set
	 */
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the author
	 */
	public UserAccount getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(UserAccount author) {
		this.author = author;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
}
