package com.Faktury;

import java.time.LocalDate;

public class InvoiceY extends Invoice {

    {
        this.setType(InvoiceType.Y);
    }
    public void calculatePayDate(LocalDate issueDate){
        int monthLength = issueDate.getMonth().length(issueDate.isLeapYear());
        super.payDate = issueDate.withDayOfMonth(monthLength);
    }

    public Double calculateTaxedValue(){
        return super.calculateTaxedValue(1.18);
    }
}
