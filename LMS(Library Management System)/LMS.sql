/*Query 1: [5 points]
Add an extra column ‘Late’ to the Book_Loan table. Values will be 0-for non-late retuns, and 1-for late
returns. Then update the ‘Late’ column with '1' for all records that they have a return date later than the
due date and with '0' for those were returned on time*/

ALTER TABLE BOOK_LOANS
ADD Late integer;

Update BOOK_LOANS 
SET Late= CASE
    WHEN Returned_Date > Due_Date  THEN 1
    ELSE 0
END;

/*Query 2: Add an extra column ‘LateFee’ to the Library_Branch table, decide late fee per day for each branch and
update that column*/

ALTER TABLE Library_Branch
ADD LateFee DECIMAL;

Update LIBRARY_BRANCH
SET LateFee = CASE  Branch_id WHEN 1 THEN 1.5
 WHEN 2 THEN 3.25
 WHEN 3 THEN 4.5
 WHEN 4 THEN 5.25
 WHEN 5 THEN 6.5
ELSE 3.5
END;

/*Query 3: Create a view vBookLoanInfo that retrieves all information per book loan. The view should have the
following attributes:
• Card_No,
• Borrower Name
• Date_Out,
• Due_Date,
• Returned_date
• Total Days of book loaned out as 'TotalDays'– you need to change weeks to days
• Book Title
• Number of days later return – if returned before or on due_date place zero
• Branch ID
• Total Late Fee Balance 'LateFeeBalance' – If the book was not retuned late than fee = ‘0*/

CREATE VIEW vBookLoanInfo AS 
Select BR.Card_No, BR.Name as 'Borrower Name', BL.Date_Out,BL.Due_Date, BL.Returned_Date as 'Returned_date',
julianday(BL.Returned_date)-julianday(BL.Date_out) as TotalDays, 
B.Title as 'Book Title', 
CASE  WHEN BL.Late=1 THEN julianday(BL.Returned_Date)-julianday(BL.Due_Date)
WHEN BL.Late=0 THEN 0
END as 'Number of days later return'
 ,LB.Branch_id as 'Branch ID',
CASE  WHEN BL.Late=1 THEN (LB.LateFee*(julianday(BL.Returned_Date)-julianday(BL.Due_Date)))
WHEN BL.Late=0 THEN 0
END  as 'LateFeeBalance'
From BOOK_LOANS as BL JOIN Library_Branch as LB ON LB.Branch_Id = BL.Branch_Id
JOIN BORROWER as BR ON BL.Card_No= BR.Card_No
JOIN Book as B ON BL.Book_Id = B.Book_Id;

Select * from vBookLoanInfo;

------------------------------------TASK 2 Queries--------------------------------------------------------
/*QUERY 1
User checks out a book, add it to Book_Loan, the number of copies needs to be updated in the
Book_Copies table. Show the output of the updated Book_Copies.*/

INSERT INTO BOOK_LOANS (Book_Id, Branch_Id, Card_No, Date_Out, Due_Date) 
VALUES (1, 3, 454545, '2022-01-24', '2022-02-24'); 
 
UPDATE BOOK_COPIES
SET No_Of_Copies = No_Of_Copies - 1
WHERE Book_Id = 1 AND Branch_Id = 3;

SELECT Title, Branch_Name, No_Of_Copies FROM Book
JOIN Book_Copies ON Book.Book_Id = Book_Copies.Book_Id
JOIN Library_Branch ON Book_Copies.Branch_Id = Library_Branch.Branch_Id where BOOK.Title='To Kill a Mockingbird’;

 
---QUERY 2: 
/*Add information about a new Borrower. Do not provide the CardNo in your query. Output the card
number as if you are giving a new library card. Submit your editable SQL query that your code
executes.*/

INSERT INTO BORROWER ( Name, Address, Phone) VALUES (  'Harshita', '178 Elm St, New YORK, NY 32124', '325-500-5579');  
Select Card_No, Name, Address, Phone from Borrower where Name = 'Harshita';

--QUERY3: ADDED A BOOK WITH NEW PUBLISHER INTO BOOK TABLE,5 BRANCHES WITH 5 COPIES?
/*Add a new Book with publisher (use can use a publisher that already exists) and author information to
all 5 branches with 5 copies for each branch. Submit your editable SQL query that your code
executes.*/

Insert into Book (Title, Publisher_Name) values('Book1','Penguin Classics');
Select Book_Id from BOOK where Title=’Unfinished’;

INSERT INTO BOOK_AUTHORS (Book_Id, Author_Name) 
VALUES (25,’Bhanuja’);

INSERT INTO BOOK_COPIES (Book_Id, Branch_Id, No_Of_Copies) 
SELECT 25,Branch_Id, 5 as No_Of_Copies  FROM LIBRARY_BRANCH ;

SELECT BOOK.Title, BOOK_COPIES.No_Of_Copies, LIBRARY_BRANCH.Branch_Name 
FROM BOOK, BOOK_COPIES, LIBRARY_BRANCH WHERE BOOK.Book_Id = BOOK_COPIES.Book_Id  AND LIBRARY_BRANCH.Branch_Id = BOOK_COPIES.Branch_Id 
AND BOOK.Book_Id = 25;


--QUERY 4 : Given a book title list the number of copies loaned out per branch. 
SELECT BOOK.Title, LIBRARY_BRANCH.Branch_Name,COUNT(BOOK_LOANS.Book_Id) 
FROM BOOK 
INNER JOIN BOOK_LOANS ON BOOK_LOANS.Book_Id = BOOK.Book_Id 
INNER JOIN LIBRARY_BRANCH ON LIBRARY_BRANCH.Branch_Id = BOOK_LOANS.Branch_Id 
WHERE BOOK.Title = 'To Kill a Mockingbird' GROUP BY BOOK_LOANS.Branch_Id;

--QUERY 5:
/*Given any due date range list the Book_Loans that were returned late and how many days they were
late. Submit your editable SQL queries that your code executes. */
SELECT Book_Id, Branch_Id, Card_No,
julianday(Returned_Date)-julianday(Due_Date) as DaysLate
from Book_Loans  
where Returned_Date>'2022-02-01'  and Returned_Date<'2022-03-30' and Returned_Date>Due_Date;

--QUERY 6a:
/*List for every borrower the ID, name, and if there is any lateFee balance. The user has the
right to search either by a borrower ID, name, part of the name, or to run the query with no
filters/criteria. The amount needs to be in US dollars. For borrowers with zero (0) or NULL
balance, you need to return zero dollars ($0.00). Make sure that your query returns
meaningful attribute names. In the case that the user decides not to provide any filters, order
the results based on the balance amount. Make sure that you return all records. Submit your
editable SQL query that your code executes.*/


CREATE VIEW borrowerLateFeeFiltered AS
SELECT Borrower.Card_No AS ID, Borrower.Name,
CASE WHEN COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) <= 0 THEN '$0.00' 
ELSE '$' || CAST(FORMAT(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) AS TEXT) 
END AS LateFee 
FROM BORROWER JOIN Book_Loans ON Borrower.Card_No = Book_Loans.Card_No JOIN Library_Branch ON Library_Branch.Branch_Id = BOOK_LOANS.Branch_Id 
GROUP BY Borrower.Card_No, Borrower.Name ORDER BY LateFee DESC;

SELECT * FROM borrowerLateFeeFiltered WHERE ID=121212 AND Name LIKE '%Chloe%';

----QUERY 6b:
/*List book information in the view. The user has the right either to search by the book id,
books title, part of book title, or to run the query with no filters/criteria. The late fee amount
needs to be in US dollars. The late fee price amount needs to have two decimals as well as the
dollar ‘$’ sign. For books that they do not have any late fee amount, you need to substitute
the NULL value with a ‘Non-Applicable’ text. Make sure that your query returns meaningful
attribute names. In the case that the user decides not to provide any filters, order the results
based on the highest late fee remaining. Submit your editable SQL query that your code
executes.*/

CREATE VIEW IF NOT EXISTS books_view AS 
SELECT Book.Book_Id AS book_id, Book.Title AS book_title, 
CASE WHEN SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee < 0 THEN 'Non-Applicable' 
ELSE '$' || CAST(COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 2) AS TEXT) 
END AS late_fee FROM BOOK LEFT JOIN Book_Loans ON Book.Book_Id = Book_Loans.Book_Id LEFT JOIN Library_Branch 
ON Library_Branch.Branch_Id = Book_Loans.Branch_Id GROUP BY Book.Book_Id, Book.Title ORDER BY late_fee DESC;

SELECT * FROM books_view
WHERE book_id= 21 AND book_title LIKE '1984' ORDER BY late_fee DESC;








