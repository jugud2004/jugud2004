package com.communication.stock.classify;

import java.io.Serializable;

public class ClassifyVO implements Serializable{
	private int classify;
	private String classifyName;
	
	public ClassifyVO() {}

	public ClassifyVO(int classify, String classifyName) {
		super();
		this.classify = classify;
		this.classifyName = classifyName;
	}

	public int getClassify() {
		return classify;
	}

	public void setClassify(int classify) {
		this.classify = classify;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classify;
		result = prime * result + ((classifyName == null) ? 0 : classifyName.hashCode());
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
		ClassifyVO other = (ClassifyVO) obj;
		if (classify != other.classify)
			return false;
		if (classifyName == null) {
			if (other.classifyName != null)
				return false;
		} else if (!classifyName.equals(other.classifyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassifyVO [classify=" + classify + ", classifyName=" + classifyName + "]";
	}
	
	
}
