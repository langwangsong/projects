package cn.itcast.crm.domain;
/**
 * 课程类别的实体
 * @author Mr_lang
 *
 */
public class CourseType {
	private Integer tid;
	private String tname;
	private String tdesc;
	private Integer tnum;
	private Double tprice;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	public Integer getTnum() {
		return tnum;
	}
	public void setTnum(Integer tnum) {
		this.tnum = tnum;
	}
	public Double getTprice() {
		return tprice;
	}
	public void setTprice(Double tprice) {
		this.tprice = tprice;
	}
	
}
