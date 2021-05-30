package com.Faktury;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {


    }
//zadanie 1 a.
    public static Double calculateIncome(List<Invoice> invoiceList, LocalDate incomeDate){

        final Double[] calculatedIncome = {0.0};
        invoiceList.stream()
                .filter(invoice -> invoice.getPayDate().isBefore(incomeDate))
                .forEach(invoice -> {
                    calculatedIncome[0] += invoice.calculateInvoiceValue();
                });
        return calculatedIncome[0];
    }
//zadanie 1 b.
    public static Invoice highestValueInvoice(List<Invoice> invoiceList, InvoiceType type){
        Optional<Invoice> highestInvoiceOptional = invoiceList.stream()
                .filter(invoice -> invoice.getType().equals(type))
                .max(Comparator.comparingDouble(Invoice::calculateInvoiceValue));

        Invoice highestInvoice = new InvoiceX();
        if (type.equals(InvoiceType.Y)){
            highestInvoice = new InvoiceY();
        }
        return highestInvoiceOptional.orElse(highestInvoice);
    }
//zadanie 1 c.
    public static Double calculateValueOfAll(List<Invoice> invoiceList){
        final Double[] totalValue = {0.0};
        invoiceList.forEach(invoice -> {

            totalValue[0] +=invoice.calculateTaxedValue();

        });
        return totalValue[0];
    }

}
