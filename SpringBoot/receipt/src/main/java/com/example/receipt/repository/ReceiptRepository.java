package com.example.receipt.repository;

import com.example.receipt.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
    Receipt findByCompanyno(String companyno);

    Receipt findByCompanynoAndCompanyname(String companyno, String companyname);
}

