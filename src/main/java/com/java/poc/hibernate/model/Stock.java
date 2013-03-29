package com.java.poc.hibernate.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.OptimisticLockType;

@Entity
@Table(name = "stock", uniqueConstraints = {
		@UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE")})
@org.hibernate.annotations.Entity(dynamicUpdate=true, optimisticLock = OptimisticLockType.ALL)
public class Stock implements Serializable {

	private Integer stockId;
	private String stockCode;
	private String stockName;

	private int version;

	public Stock() {
	}

	public Stock(String stockCode, String stockName) {
		this.setStockCode(stockCode);
		this.setStockName(stockName);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@Version
    @Column(name="version")
	public int getVersion() {
		return version;
	}

	@Generated(GenerationTime.ALWAYS)
	public void setVersion(int version) {
		this.version = version;
	}

}
