package com.example.loanBook.domain;

import java.util.stream.Collectors;

public class MaxLoanSizeSpecification implements ISpecification < Member > {

    @Override
    public boolean isSatisfied ( Member entity ) {

        return entity.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).collect ( Collectors.toList ( ) ).size ( ) < 3;
    }
}
