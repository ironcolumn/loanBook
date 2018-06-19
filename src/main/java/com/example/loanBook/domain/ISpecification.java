package com.example.loanBook.domain;

public interface ISpecification < T > {

    boolean isSatisified ( T entity );

}
