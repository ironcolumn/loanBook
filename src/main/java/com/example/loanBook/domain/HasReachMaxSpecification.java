package com.example.loanBook.domain;

public class HasReachMaxSpecification implements ISpecification < Member > {

    @Override
    public boolean isSatisfied ( Member entity ) {

        return entity.getLoans ( ).size ( ) > 3;
    }
}
