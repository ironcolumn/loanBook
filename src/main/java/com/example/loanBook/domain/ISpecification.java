package com.example.loanBook.domain;

public interface ISpecification < T > {

    boolean isSatisfied ( T entity );

}
