package com.example.loanBook.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Member {

    private String id;

    private String name;

    private List < Loan > Loans = new ArrayList <> ( );

    public void returnBook ( Book book ) {

        Loan loan = findCurrentLoanFor ( book );
        if ( loan != null ) {
            loan.markAsReturned ( );
            book.setLoanTo ( null );
            System.out.println ( "还书成功！" );
        }
    }

    public boolean canLoan ( Book book ) {

        return book.getLoanTo ( ) == null;
    }

    public Loan loan ( Book book ) {

        Loan loan = null;
        if ( canLoan ( book ) ) {
            loan = LoanFactory.CreateLoan ( book , this );
            System.out.println ( "借阅成功！" );
            getLoans ( ).add ( loan );
            return loan;
        }
        System.out.println ( "该书不可以借阅！" );
        return loan;

    }

    public Loan findCurrentLoanFor ( Book book ) {

        return getLoans ( ).stream ( )
                .filter ( loan -> book.getId ( ).equals ( loan.getBook ( ).getId ( ) ) && loan.hasNotBeenReturned ( ) )
                .collect ( Collectors.toList ( ) )
                .get ( 0 );
    }

    public String getId ( ) {

        return id;
    }

    public void setId ( String id ) {

        this.id = id;
    }

    public String getName ( ) {

        return name;
    }

    public void setName ( String name ) {

        this.name = name;
    }

    public List < Loan > getLoans ( ) {

        return Loans;
    }

    public void setLoans ( List < Loan > loans ) {

        Loans = loans;
    }
}
