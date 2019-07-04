package cn.ruhubao.website.pojo;

import java.io.Serializable;
import java.util.Date;

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

	private Date created;

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
