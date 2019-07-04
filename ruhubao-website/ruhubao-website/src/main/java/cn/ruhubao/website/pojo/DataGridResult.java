package cn.ruhubao.website.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class DataGridResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5034057491744606993L;

	private Long total;
	
	private List<?> rows;


	public DataGridResult(List<?> rows) {
		super();
		this.rows = rows;
	}

	public DataGridResult(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	
}
