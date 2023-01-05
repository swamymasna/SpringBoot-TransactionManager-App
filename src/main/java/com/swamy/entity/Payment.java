package com.swamy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PAYMENT_TBL")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String paymentType;
	private String cardNumber;
	private Integer expiryYear;
	private Integer expiryMonth;
	private Integer cvv;
	private Integer orderId;

}
