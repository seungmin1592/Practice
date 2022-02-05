package com.example.receipt.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
public class Receipt {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String companyname;
    private String title;
    private String price;
    private String contents;
    @CreationTimestamp
    private Timestamp createDate;
    private String companyno;
}
