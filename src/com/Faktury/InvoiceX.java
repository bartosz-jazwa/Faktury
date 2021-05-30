package com.Faktury;

import java.time.LocalDate;

public class InvoiceX extends Invoice{

    {
        this.setType(InvoiceType.X);
    }

    public void calculatePayDate(LocalDate issueDate){
        super.payDate =  issueDate.plusDays(14);
    }

    public Double calculateTaxedValue(){
        return super.calculateTaxedValue(1.07);
    }
}
