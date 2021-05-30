package com.Faktury;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Invoice {

    private int invoiceNumber;
    private String issuedBy;
    private LocalDate issueDate;
    protected LocalDate payDate;
    private String customerName;
    private Map<Product,Integer> products;
    private InvoiceType type = null;

    public Invoice() {
        this.issueDate = LocalDate.now();
        calculatePayDate(this.issueDate);
        this.products = new HashMap<>();
    }

    public abstract void calculatePayDate(LocalDate issueDate);

    public Double calculateTaxedValue(Double taxRate){
        final Double[] invoiceValue = {0.0};
        products.forEach((product,count) -> {
            invoiceValue[0] += product.getPrice()*count * taxRate;
        });

        return invoiceValue[0];
    }

    public abstract Double calculateTaxedValue();

    public Double calculateInvoiceValue(){
        final Double[] invoiceValue = {0.0};
        products.forEach((product, count) -> {
            invoiceValue[0] += product.getPrice()*count;
        });

        return invoiceValue[0];
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public InvoiceType getType() {
        return type;
    }

    void setType(InvoiceType type) {
        this.type = type;
    }
}
