package com.jadm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BBOOK_ENVIOTDA")
public class BbookEnvioTda {
	
	@Id
    @Column(name="idd" ,columnDefinition = "varchar2(100)")
    private String id;

    @Column(name="org_lvl_number_s" ,columnDefinition = "number(12)")
    private long orgLvlNumber;
    
    @Column(name="org_name_full" ,columnDefinition = "varchar2(100)")
    protected String orgNameFull;
    
    @Column(name="inactive" ,columnDefinition = "varchar2(10)")
    protected String inactive;
    
    @Column(name="is_warehouse" ,columnDefinition = "varchar2(10)")
    protected String isWarehouse;

    @Column(name="tran_type" ,columnDefinition = "varchar2(1)")
    protected String tranType;

	public BbookEnvioTda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BbookEnvioTda(String id, long orgLvlNumber, String orgNameFull, String inactive, String isWarehouse,
			String tranType) {
		super();
		this.id = id;
		this.orgLvlNumber = orgLvlNumber;
		this.orgNameFull = orgNameFull;
		this.inactive = inactive;
		this.isWarehouse = isWarehouse;
		this.tranType = tranType;
	}

	@Override
	public String toString() {
		return "BbookEnvioTda [id=" + id + ", orgLvlNumber=" + orgLvlNumber + ", orgNameFull=" + orgNameFull
				+ ", inactive=" + inactive + ", isWarehouse=" + isWarehouse + ", tranType=" + tranType + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getOrgLvlNumber() {
		return orgLvlNumber;
	}

	public void setOrgLvlNumber(long orgLvlNumber) {
		this.orgLvlNumber = orgLvlNumber;
	}

	public String getOrgNameFull() {
		return orgNameFull;
	}

	public void setOrgNameFull(String orgNameFull) {
		this.orgNameFull = orgNameFull;
	}

	public String getInactive() {
		return inactive;
	}

	public void setInactive(String inactive) {
		this.inactive = inactive;
	}

	public String getIsWarehouse() {
		return isWarehouse;
	}

	public void setIsWarehouse(String isWarehouse) {
		this.isWarehouse = isWarehouse;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

    
}
