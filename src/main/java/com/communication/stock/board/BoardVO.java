package com.communication.stock.board;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO implements Serializable{
	private int seq;
	private String title;
	private int classify;
	private String content;
	private Date postDate;
	private int viewCount;
	private String writer;
	private MultipartFile uploadFile;
	private String filename;
	////////////////////////////////////////////////////////
	
	
	
	

	////////////////////////////////////////////////////////
	public BoardVO() {}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getClassify() {
		return classify;
	}
	public void setClassify(int classify) {
		this.classify = classify;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostDate() {
		return postDate;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classify;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((postDate == null) ? 0 : postDate.hashCode());
		result = prime * result + seq;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((uploadFile == null) ? 0 : uploadFile.hashCode());
		result = prime * result + viewCount;
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		if (classify != other.classify)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (postDate == null) {
			if (other.postDate != null)
				return false;
		} else if (!postDate.equals(other.postDate))
			return false;
		if (seq != other.seq)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (uploadFile == null) {
			if (other.uploadFile != null)
				return false;
		} else if (!uploadFile.equals(other.uploadFile))
			return false;
		if (viewCount != other.viewCount)
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", classify=" + classify + ", content=" + content
				+ ", postDate=" + postDate + ", viewCount=" + viewCount + ", writer=" + writer + ", uploadFile="
				+ uploadFile + "]";
	}
	public BoardVO(int seq, String title, int classify, String content, Date postDate, int viewCount, String writer, MultipartFile uploadFile) {
		this.seq = seq;
		this.title = title;
		this.classify = classify;
		this.content = content;
		this.postDate = postDate;
		this.viewCount = viewCount;
		this.writer = writer;
		this.uploadFile = uploadFile;
	}
	
	
	
	
	
	
}
