package cn.ruhubao.website.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BasePojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 123273510955853019L;

	public BasePojo() {
		super();
	}

	public BasePojo(Date created, Date updated) {
		super();
		this.created = created;
		this.updated = updated;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	 @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
	private Date created;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date updated;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
}
