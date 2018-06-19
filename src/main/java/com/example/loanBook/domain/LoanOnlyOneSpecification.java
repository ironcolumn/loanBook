package com.example.loanBook.domain;

public class LoanOnlyOneSpecification implements ISpecification < Member > {

    @Override
    public boolean isSatisfied ( Member entity ) {

        return entity.getLoans ( ).size ( ) > 1;
    }
}
