package com.changepond.executors.db.message;

public class ResponseFile {
  private int id; 
  private String url;
  private String status;
  
/**
 * 
 */
public ResponseFile() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param id
 * @param url
 * @param status
 */
public ResponseFile(int id, String url, String status) {
	super();
	this.id = id;
	this.url = url;
	this.status = status;
}
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the url
 */
public String getUrl() {
	return url;
}
/**
 * @param url the url to set
 */
public void setUrl(String url) {
	this.url = url;
}
/**
 * @return the status
 */
public String getStatus() {
	return status;
}
/**
 * @param status the status to set
 */
public void setStatus(String status) {
	this.status = status;
}
 
}
