# 测试代码
```java
    public void test ( ) {

        Book book1 = new Book ( );
        book1.setId ( "1" );
        book1.setISBN ( "ISBN1" );
        book1.setTitle ( "第1本书" );

        Book book2 = new Book ( );
        book2.setId ( "2" );
        book2.setISBN ( "ISBN2" );
        book2.setTitle ( "第2本书" );

        Book book3 = new Book ( );
        book3.setId ( "3" );
        book3.setISBN ( "ISBN3" );
        book3.setTitle ( "第3本书" );
        Book book4 = new Book ( );
        book4.setId ( "4" );
        book4.setISBN ( "ISBN4" );
        book4.setTitle ( "第4本书" );
        System.out.println ( "存进了四本书" );

        Member testMember = new Member ( );
        System.out.println ( "新建测试member" );
        ISpecification hasReachMax = new MaxLoanSizeSpecification ( );
        testMember.getSpecifications ( ).add ( hasReachMax );
        System.out.println ( "添加规则：最多借三本" );

        testMember.loan ( book1 );
        testMember.loan ( book2 );
        testMember.loan ( book3 );
        testMember.loan ( book4 );

        System.out.println ( "借阅记录" );
        System.out.println ( "--------------" );
        testMember.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).forEach ( loan -> {
            System.out.println ( loan.getBook ( ).getTitle ( ) );
        } );
        System.out.println ( "--------------" );

        System.out.println ( "===========================================================" );
        testMember.returnBook ( book1 );
        testMember.returnBook ( book2 );
        testMember.returnBook ( book3 );
        testMember.getSpecifications ( ).add ( new LoanOnlyOneSpecification ( ) );

        System.out.println ( "添加规则：只能借一本" );
        testMember.loan ( book1 );
        testMember.loan ( book2 );
        System.out.println ( "借阅记录" );
        System.out.println ( "--------------" );
        testMember.getLoans ( ).stream ( ).filter ( loan -> loan.hasNotBeenReturned ( ) ).forEach ( loan -> {
            System.out.println ( loan.getBook ( ).getTitle ( ) );
        } );
        System.out.println ( "--------------" );
    }

}

```
# 测试结果
![image](src/testResult1.png)
