package com.example.myapplication;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "LMS.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the database schema
        db.execSQL("CREATE TABLE IF NOT EXISTS BOOK (\n" +
                "    Book_Id        INTEGER          PRIMARY KEY AUTOINCREMENT\n" +
                "                                NOT NULL,\n" +
                "    Title          VARCHAR (20),\n" +
                "    Publisher_Name VARCHAR (30) \n" +
                ");");

        // Initialize some data
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     1,\n" +
                "                     'To Kill a \n" +
                "Mockingbird',\n" +
                "                     'HarperCollins'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     2,\n" +
                "                     '1984',\n" +
                "                     'Penguin Books'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     3,\n" +
                "                     'Pride and Prejudice',\n" +
                "                     'Penguin Classics'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     4,\n" +
                "                     'The Great Gatsby',\n" +
                "                     'Scribner'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     5,\n" +
                "                     'One Hundred Years of Solitude',\n" +
                "                     'Harper & Row'\n" +
                "                 );");
        db.execSQL("\n" +
                "INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     6,\n" +
                "                     'Animal Farm',\n" +
                "                     'Penguin Books'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     7,\n" +
                "                     'The Catcher in the Rye',\n" +
                "                     'Little, Brown and Company'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     8,\n" +
                "                     'Lord of the Flies',\n" +
                "                     'Faber and Faber'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     9,\n" +
                "                     'Brave New World',\n" +
                "                     'Chatto & Windus'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     10,\n" +
                "                     'The Picture of Dorian Gray',\n" +
                "                     'Ward, Lock and Co.'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     11,\n" +
                "                     'The Alchemist',\n" +
                "                     'HarperCollins'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     12,\n" +
                "                     'The God of Small Things',\n" +
                "                     'Random House India'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     13,\n" +
                "                     'Wuthering Heights',\n" +
                "                     'Thomas Cautley Newby'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     14,\n" +
                "                     'The Hobbit',\n" +
                "                     'Allen & Unwin'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     15,\n" +
                "                     'The Lord of the Rings',\n" +
                "                     'Allen & Unwin'\n" +
                "                 );");
        db.execSQL("\n" +
                "INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     16,\n" +
                "                     'The Hitchhiker''s Guide to the Galaxy',\n" +
                "                     'Pan Books'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     17,\n" +
                "                     'The Diary of a Young Girl',\n" +
                "                     'Bantam Books'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     18,\n" +
                "                     'The Da Vinci Code',\n" +
                "                     'Doubleday'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     19,\n" +
                "                     'The Adventures of Huckleberry Finn',\n" +
                "                     'Penguin Classics'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     20,\n" +
                "                     'The Adventures of Tom Sawyer',\n" +
                "                     'American Publishing Company'\n" +
                "                 );");
        db.execSQL("INSERT INTO BOOK (\n" +
                "                     Book_Id,\n" +
                "                     Title,\n" +
                "                     Publisher_Name\n" +
                "                 )\n" +
                "                 VALUES (\n" +
                "                     21,\n" +
                "                     'A Tale of Two \n" +
                "Cities',\n" +
                "                     'Chapman and Hall'\n" +
                "                 );");
        db.execSQL("CREATE TABLE IF NOT EXISTS BOOK_AUTHORS (\n" +
                "    Book_Id     INT,\n" +
                "    Author_Name VARCHAR (30),\n" +
                "    CONSTRAINT fk_bookCopy FOREIGN KEY (\n" +
                "        Book_Id\n" +
                "    )\n" +
                "    REFERENCES BOOK (Book_Id),\n" +
                "    CONSTRAINT pk_bookCopy PRIMARY KEY (\n" +
                "        Author_Name,\n" +
                "        Book_Id\n" +
                "    )\n" +
                ");");
        db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
                "                             Book_Id,\n" +
                "                             Author_Name\n" +
                "                         )\n" +
                "                         VALUES (\n" +
                "                             1,\n" +
                "                             'Harper Lee'\n" +
                "                         );");
        db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
                "                             Book_Id,\n" +
                "                             Author_Name\n" +
                "                         )\n" +
                "                         VALUES (\n" +
                "                             2,\n" +
                "                             'George Orwell'\n" +
                "                         );");
        db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
                "                             Book_Id,\n" +
                "                             Author_Name\n" +
                "                         )\n" +
                "                         VALUES (\n" +
                "                             3,\n" +
                "                             'Jane Austen'\n" +
                "                         );\n");
        db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
                "                             Book_Id,\n" +
                "                             Author_Name\n" +
                "                         )\n" +
                "                         VALUES (\n" +
                "                             4,\n" +
                "                             'F. Scott \n" +
                "Fitzgerald'\n" +
                "                         );");
        db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
                "                             Book_Id,\n" +
                "                             Author_Name\n" +
                "                         )\n" +
                "                         VALUES (\n" +
                "                             5,\n" +
                "                             'Gabriel Garcia Marquez'\n" +
                "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             6,\n" +
        "                             'George Orwell'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             7,\n" +
        "                             'J.D. Salinger'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             8,\n" +
        "                             'William \n" +
        "Golding'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             9,\n" +
        "                             'Aldous Huxley'\n" +
        "                         );\n");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             10,\n" +
        "                             'Oscar Wilde'\n" +
        "                         );\n");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             11,\n" +
        "                             'Paulo Coelho'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             12,\n" +
        "                             'Arundhati \n" +
        "Roy'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             13,\n" +
        "                             'Emily Bronte'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             14,\n" +
        "                             'J.R.R. \n" +
        "Tolkien'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             15,\n" +
        "                             'J.R.R. \n" +
        "Tolkien'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             16,\n" +
        "                             'Douglas \n" +
        "Adams'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             17,\n" +
        "                             'Anne Frank'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             18,\n" +
        "                             'Dan Brown'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             19,\n" +
        "                             'Mark Twain'\n" +
        "                         );");
db.execSQL("\n" +
        "INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             20,\n" +
        "                             'Mark Twain'\n" +
        "                         );");
db.execSQL("INSERT INTO BOOK_AUTHORS (\n" +
        "                             Book_Id,\n" +
        "                             Author_Name\n" +
        "                         )\n" +
        "                         VALUES (\n" +
        "                             21,\n" +
        "                             'Charles \n" +
        "Dickens'\n" +
        "                         );");
db.execSQL("CREATE TABLE IF NOT EXISTS BOOK_COPIES (\n" +
        "    Book_Id      INTEGER REFERENCES BOOK (Book_Id) MATCH SIMPLE,\n" +
        "    Branch_Id    INTEGER REFERENCES LIBRARY_BRANCH (Branch_Id),\n" +
        "    No_Of_Copies INT,\n" +
        "    CONSTRAINT pk_bookCopy PRIMARY KEY (\n" +
        "        Branch_id,\n" +
        "        Book_Id\n" +
        "    ),\n" +
        "    CONSTRAINT fk_bookCopy FOREIGN KEY (\n" +
        "        Branch_id\n" +
        "    )\n" +
        "    REFERENCES Library_Branch (Branch_Id),\n" +
        "    CONSTRAINT fk_bookCopy FOREIGN KEY (\n" +
        "        Book_Id\n" +
        "    )\n" +
        "    REFERENCES Book (Book_Id) \n" +
        ");");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            1,\n" +
        "                            1,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            2,\n" +
        "                            1,\n" +
        "                            1\n" +
        "                        );\n");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            3,\n" +
        "                            2,\n" +
        "                            1\n" +
        "                        );\n");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            4,\n" +
        "                            3,\n" +
        "                            5\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            5,\n" +
        "                            1,\n" +
        "                            5\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            6,\n" +
        "                            2,\n" +
        "                            3\n" +
        "                        );\n");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            7,\n" +
        "                            2,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            8,\n" +
        "                            3,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            9,\n" +
        "                            1,\n" +
        "                            4\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            10,\n" +
        "                            2,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            11,\n" +
        "                            1,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            12,\n" +
        "                            3,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            13,\n" +
        "                            3,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            14,\n" +
        "                            1,\n" +
        "                            5\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            15,\n" +
        "                            3,\n" +
        "                            2\n" +
        "                        );\n");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            16,\n" +
        "                            2,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("\n" +
        "INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            17,\n" +
        "                            3,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            18,\n" +
        "                            3,\n" +
        "                            3\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            19,\n" +
        "                            1,\n" +
        "                            5\n" +
        "                        );\n");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            20,\n" +
        "                            3,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("INSERT INTO BOOK_COPIES (\n" +
        "                            Book_Id,\n" +
        "                            Branch_Id,\n" +
        "                            No_Of_Copies\n" +
        "                        )\n" +
        "                        VALUES (\n" +
        "                            21,\n" +
        "                            3,\n" +
        "                            2\n" +
        "                        );");
db.execSQL("CREATE TABLE IF NOT EXISTS BOOK_LOANS (\n" +
        "    Book_Id       INTEGER REFERENCES BOOK (Book_Id) MATCH SIMPLE,\n" +
        "    Branch_Id     INTEGER REFERENCES LIBRARY_BRANCH (Branch_Id) MATCH SIMPLE,\n" +
        "    Card_No       INTEGER REFERENCES BORROWER (Card_No) MATCH SIMPLE,\n" +
        "    Date_Out      DATE,\n" +
        "    Due_Date      DATE,\n" +
        "    Returned_Date DATE,\n" +
        "    CONSTRAINT pk_bookLoan PRIMARY KEY (\n" +
        "        Branch_Id,\n" +
        "        Card_No,\n" +
        "        Book_id\n" +
        "    ),\n" +
        "    CONSTRAINT fk_bookLoans FOREIGN KEY (\n" +
        "        Branch_Id\n" +
        "    )\n" +
        "    REFERENCES Library_Branch (Branch_Id),\n" +
        "    CONSTRAINT fk_bookLoans FOREIGN KEY (\n" +
        "        Book_Id\n" +
        "    )\n" +
        "    REFERENCES Book (Book_Id),\n" +
        "    CONSTRAINT fk_bookLoans FOREIGN KEY (\n" +
        "        Card_No\n" +
        "    )\n" +
        "    REFERENCES Borrower (Card_no) \n" +
        ");");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           1,\n" +
        "                           1,\n" +
        "                           123456,\n" +
        "                           '2022-01-01',\n" +
        "                           '2022-02-01',\n" +
        "                           '2022-02-01'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           2,\n" +
        "                           1,\n" +
        "                           789012,\n" +
        "                           '2022-01-02',\n" +
        "                           '2022-02-02',\n" +
        "                           '2022-02-02'\n" +
        "                       );\n");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           3,\n" +
        "                           2,\n" +
        "                           345678,\n" +
        "                           '2022-01-03',\n" +
        "                           '2022-02-03',\n" +
        "                           '2022-02-03'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           4,\n" +
        "                           3,\n" +
        "                           901234,\n" +
        "                           '2022-01-04',\n" +
        "                           '2022-02-04',\n" +
        "                           '2022-02-04'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           5,\n" +
        "                           1,\n" +
        "                           567890,\n" +
        "                           '2022-01-05',\n" +
        "                           '2022-02-05',\n" +
        "                           '2022-02-09'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           6,\n" +
        "                           2,\n" +
        "                           234567,\n" +
        "                           '2022-01-06',\n" +
        "                           '2022-02-06',\n" +
        "                           '2022-02-10'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           7,\n" +
        "                           2,\n" +
        "                           890123,\n" +
        "                           '2022-01-07',\n" +
        "                           '2022-02-07',\n" +
        "                           '2022-03-08'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           8,\n" +
        "                           3,\n" +
        "                           456789,\n" +
        "                           '2022-01-08',\n" +
        "                           '2022-02-08',\n" +
        "                           '2022-03-10'\n" +
        "                       );\n");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           9,\n" +
        "                           1,\n" +
        "                           111111,\n" +
        "                           '2022-01-09',\n" +
        "                           '2022-02-09',\n" +
        "                           '2022-02-06'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           10,\n" +
        "                           2,\n" +
        "                           222222,\n" +
        "                           '2022-01-10',\n" +
        "                           '2022-02-10',\n" +
        "                           '2022-02-07'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           11,\n" +
        "                           1,\n" +
        "                           333333,\n" +
        "                           '2022-03-01',\n" +
        "                           '2022-03-08',\n" +
        "                           '2022-02-08'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           12,\n" +
        "                           3,\n" +
        "                           444444,\n" +
        "                           '2022-03-03',\n" +
        "                           '2022-03-10',\n" +
        "                           '2022-03-10'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           13,\n" +
        "                           3,\n" +
        "                           555555,\n" +
        "                           '2022-02-03',\n" +
        "                           '2022-03-03',\n" +
        "                           '2022-02-18'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           14,\n" +
        "                           1,\n" +
        "                           565656,\n" +
        "                           '2022-01-14',\n" +
        "                           '2022-02-14',\n" +
        "                           '2022-03-31'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           15,\n" +
        "                           3,\n" +
        "                           676767,\n" +
        "                           '2022-01-15',\n" +
        "                           '2022-02-15',\n" +
        "                           '2022-02-21'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           16,\n" +
        "                           2,\n" +
        "                           787878,\n" +
        "                           '2022-03-05',\n" +
        "                           '2022-03-12',\n" +
        "                           '2022-02-24'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           17,\n" +
        "                           3,\n" +
        "                           989898,\n" +
        "                           '2022-03-23',\n" +
        "                           '2022-03-30',\n" +
        "                           '2022-03-30'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           18,\n" +
        "                           3,\n" +
        "                           121212,\n" +
        "                           '2022-01-18',\n" +
        "                           '2022-02-18',\n" +
        "                           '2022-02-18'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           19,\n" +
        "                           1,\n" +
        "                           232323,\n" +
        "                           '2022-03-24',\n" +
        "                           '2022-03-31',\n" +
        "                           '2022-03-31'\n" +
        "                       );\n");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           20,\n" +
        "                           3,\n" +
        "                           343434,\n" +
        "                           '2022-01-21',\n" +
        "                           '2022-02-21',\n" +
        "                           '2022-02-21'\n" +
        "                       );");
db.execSQL("INSERT INTO BOOK_LOANS (\n" +
        "                           Book_Id,\n" +
        "                           Branch_Id,\n" +
        "                           Card_No,\n" +
        "                           Date_Out,\n" +
        "                           Due_Date,\n" +
        "                           Returned_Date\n" +
        "                       )\n" +
        "                       VALUES (\n" +
        "                           21,\n" +
        "                           3,\n" +
        "                           454545,\n" +
        "                           '2022-01-24',\n" +
        "                           '2022-02-24',\n" +
        "                           '2022-02-24'\n" +
        "                       );");
db.execSQL("CREATE TABLE IF NOT EXISTS BORROWER (\n" +
        "    Card_No INTEGER      PRIMARY KEY AUTOINCREMENT\n" +
        "                         NOT NULL,\n" +
        "    Name    VARCHAR (50),\n" +
        "    Address VARCHAR (50),\n" +
        "    Phone   INT\n" +
        ");");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         111111,\n" +
        "                         'Alex Kim',\n" +
        "                         '983 Sine St, Arizona, AR 70451',\n" +
        "                         '678-784-5563'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         121212,\n" +
        "                         'Chloe Park',\n" +
        "                         '345 Shark St, Arizona, AR 72213',\n" +
        "                         '755-905-5572'\n" +
        "                     );");
db.execSQL("\n" +
        "INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         123456,\n" +
        "                         'John Smith',\n" +
        "                         '456 Oak St, Arizona, AR 70010',\n" +
        "                         '205-555-5555'\n" +
        "                     );\n");
db.execSQL("\n" +
        "INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         222222,\n" +
        "                         'Rachel Lee',\n" +
        "                         '999 Apple Ave, Arizona, AR 70671',\n" +
        "                         '231-875-5564'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         232323,\n" +
        "                         'William Chen',\n" +
        "                         '890 Sting St, New York, NY 10459',\n" +
        "                         '406-755-5580'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         234567,\n" +
        "                         'Emily Lee',\n" +
        "                         '389 Oaklay St, Arizona, AR 70986',\n" +
        "                         '231-678-5560'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         333333,\n" +
        "                         'William Johnson',\n" +
        "                         '705 Paster St, New Jersey 32002',\n" +
        "                         '235-525-5567'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         343434,\n" +
        "                         'Olivia Johnson',\n" +
        "                         '345 Pine St, New Jersey, NJ 32095',\n" +
        "                         '662-554-5575'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         345678,\n" +
        "                         'Bob \n" +
        "Johnson',\n" +
        "                         '12 Elm St, Arizona, AR 70345 ',\n" +
        "                         '545-234-5557'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         444444,\n" +
        "                         'Ethan Martinez',\n" +
        "                         '466 Deeplm St, New York, NY 10321',\n" +
        "                         '555-555-5569'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         454545,\n" +
        "                         'Dylan \n" +
        "Kim',\n" +
        "                         '567 Cowboy way St, New Jersey, NJ 32984',\n" +
        "                         '435-254-5578'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         456789,\n" +
        "                         'Laura \n" +
        "Chen',\n" +
        "                         '345 Mapman Ave, Arizona, AR 70776',\n" +
        "                         '565-985-9962'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         555555,\n" +
        "                         'Grace \n" +
        "Hernandez',\n" +
        "                         '315 Babes St, Arizona, AR 70862 ',\n" +
        "                         '455-567-5587'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         565656,\n" +
        "                         'Sophia Park',\n" +
        "                         '678 Dolphin St, New York, NY 10062',\n" +
        "                         '675-455-5568'\n" +
        "                     );\n");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         567890,\n" +
        "                         'Tom Lee',\n" +
        "                         '678  S Oak St, New York, NY 10045',\n" +
        "                         '209-525-5559'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         676767,\n" +
        "                         'Olivia Lee',\n" +
        "                         '345 Spine St, New York, NY 10092',\n" +
        "                         '435-878-5569'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         787878,\n" +
        "                         'Noah Thompson',\n" +
        "                         '189 GreenOak Ave, New Jersey, NJ 32453',\n" +
        "                         '245-555-5571'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         789012,\n" +
        "                         'Jane Doe',\n" +
        "                         '789 Maple Ave, New Jersey, NJ 32542',\n" +
        "                         '555-235-5556'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         890123,\n" +
        "                         'Michael Park',\n" +
        "                         '123 Pinewood St, New Jersey, NJ 32954',\n" +
        "                         '655-890-2161'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         901234,\n" +
        "                         'Sarah Kim',\n" +
        "                         '345 Pine St, New York, NY 10065',\n" +
        "                         '515-325-2158'\n" +
        "                     );");
db.execSQL("INSERT INTO BORROWER (\n" +
        "                         Card_No,\n" +
        "                         Name,\n" +
        "                         Address,\n" +
        "                         Phone\n" +
        "                     )\n" +
        "                     VALUES (\n" +
        "                         989898,\n" +
        "                         'Olivia \n" +
        "Smith',\n" +
        "                         '178 Elm St, New Jersey, NJ 32124',\n" +
        "                         '325-500-5579'\n" +
        "                     );");

        db.execSQL("CREATE TABLE IF NOT EXISTS LIBRARY_BRANCH (\n" +
                "    Branch_Id      INT          PRIMARY KEY,\n" +
                "    Branch_Name    VARCHAR (20),\n" +
                "    Branch_Address VARCHAR (50),\n" +
                "    LateFee        DECIMAL\n" +
                ");");

        db.execSQL("INSERT INTO LIBRARY_BRANCH (\n" +
                "                               Branch_Id,\n" +
                "                               Branch_Name,\n" +
                "                               Branch_Address,\n" +
                "                               LateFee\n" +
                "                           )\n" +
                "                           VALUES (\n" +
                "                               1,\n" +
                "                               'Main Branch',\n" +
                "                               '123 Main St, New York, NY 10003',\n" +
                "                               1.5\n" +
                "                           );");
        db.execSQL("INSERT INTO LIBRARY_BRANCH (\n" +
                "                               Branch_Id,\n" +
                "                               Branch_Name,\n" +
                "                               Branch_Address,\n" +
                "                               LateFee\n" +
                "                           )\n" +
                "                           VALUES (\n" +
                "                               2,\n" +
                "                               'West Branch',\n" +
                "                               '456 West St, Arizona, AR 70622',\n" +
                "                               3\n" +
                "                           );\n");

        db.execSQL("INSERT INTO LIBRARY_BRANCH (\n" +
                "                               Branch_Id,\n" +
                "                               Branch_Name,\n" +
                "                               Branch_Address,\n" +
                "                               LateFee\n" +
                "                           )\n" +
                "                           VALUES (\n" +
                "                               3,\n" +
                "                               'East Branch',\n" +
                "                               '789 East St, New Jersy, NY 32032',\n" +
                "                               2\n" +
                "                           );");
        db.execSQL("INSERT INTO LIBRARY_BRANCH (\n" +
                "                               Branch_Id,\n" +
                "                               Branch_Name,\n" +
                "                               Branch_Address,\n" +
                "                               LateFee\n" +
                "                           )\n" +
                "                           VALUES (\n" +
                "                               4,\n" +
                "                               'North Branch 456 NW',\n" +
                "                               'Irving, TX 76100',\n" +
                "                               2\n" +
                "                           );");
        db.execSQL("INSERT INTO LIBRARY_BRANCH (\n" +
                "                               Branch_Id,\n" +
                "                               Branch_Name,\n" +
                "                               Branch_Address,\n" +
                "                               LateFee\n" +
                "                           )\n" +
                "                           VALUES (\n" +
                "                               5,\n" +
                "                               'UTA Branch 123 Cooper St',\n" +
                "                               'Arlington TX 76101',\n" +
                "                               2\n" +
                "                           );");
db.execSQL("CREATE TABLE IF NOT EXISTS PUBLISHER (\n" +
        "    Publisher_Name VARCHAR (50) PRIMARY KEY,\n" +
        "    Phone          TEXT (20),\n" +
        "    Address        VARCHAR (10) \n" +
        ");");
db.execSQL("INSERT INTO PUBLISHER (\n" +
        "                          Publisher_Name,\n" +
        "                          Phone,\n" +
        "                          Address\n" +
        "                      )\n" +
        "                      VALUES (\n" +
        "                          'HarperCollins',\n" +
        "                          '212-207-7000',\n" +
        "                          '195 Broadway, New York, NY 10007'\n" +
        "                      );");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Penguin Books', '212-366-3000', '475 Hudson St, New York, NY 10014'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Penguin \n" +
        "Classics', '212-366-2000', '123 Main St, California, CA 01383'); ");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Scribner', '212-\n" +
        "207-7474', '19 Broadway, New York, NY 10007'); ");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Harper & Row', '212-207-7000', '1195 Border street, Montana, MT 59007'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Little, Brown and Company', '212-764-2000', '111 Huddle St, New Jersey, NJ 32014'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Faber and Faber', '201-797-3800', '463 south centre street, Arizona, AR 71653'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Chatto & Windus', '442-727-3800', 'Bloomsbury House, 7477 Great Russell St, Arizona, AR 72965'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Ward, Lock and Co.', '647-242-3434', '456 Maple Ave, Texas, TX 76013 '); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Random House India', '291-225-6634', '423 baywatch centre street, Alabama, AL - 30513'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Thomas Cautley Newby', '243-353-2352', '890 Elmwood Dr, Floride, FL 98238'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Allen & Unwin', '212-782-9001', '22 New Wharf Rd, Arizona, AR 70654'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Pan Books', '313-243-5353', '567 Pine Tree Rd, Colorado, CO 87348'); \n");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Doubleday', \n" +
        "'212-782-9000', '789 Division St, Minnesota, MN 55344'); ");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('American \n" +
        "Publishing Company', '682-243-3524', '7652 Northgate way lane, Georgia, GA - 30054'); ");
db.execSQL("INSERT INTO PUBLISHER (Publisher_Name, Phone, Address) VALUES ('Chapman and Hall', '833-342-2343', '789 Oak St, Texas, TX 76010'); \n");

db.execSQL("CREATE VIEW borrowerLateFeeFiltered AS\n" +
               "SELECT Borrower.Card_No AS ID, Borrower.Name, \n" +
               "       CASE \n" +
               "            WHEN COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) <= 0 THEN '$0.00' \n" +
               "            ELSE '$' || CAST(COALESCE(SUM(julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 0) AS TEXT) \n" +
               "       END AS LateFee \n" +
               "FROM BORROWER \n" +
               "JOIN Book_Loans ON Borrower.Card_No = Book_Loans.Card_No \n" +
               "JOIN Library_Branch ON Library_Branch.Branch_Id = BOOK_LOANS.Branch_Id \n" +
               "GROUP BY Borrower.Card_No, Borrower.Name \n" +
               "ORDER BY LateFee DESC;\n");

       db.execSQL("CREATE VIEW IF NOT EXISTS books_view AS " +
               "SELECT Book.Book_Id AS book_id, Book.Title AS book_title, " +
               "CASE " +
               "  WHEN (julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee < 0 THEN 'Non-Applicable' " +
               "  ELSE '$' || CAST(COALESCE((julianday(Book_Loans.Returned_Date) - julianday(Book_Loans.Due_Date)) * Library_Branch.LateFee, 2) AS TEXT) " +
               "END AS late_fee " +
               "FROM Book " +
               "LEFT JOIN Book_Loans ON Book.Book_Id = Book_Loans.Book_Id " +
               "LEFT JOIN Library_Branch ON Library_Branch.Branch_Id = Book_Loans.Branch_Id " +
               "GROUP BY Book.Book_Id, Book.Title " +
               "ORDER BY late_fee DESC;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP VIEW IF EXISTS borrowerLateFeeFiltered");
        db.execSQL("DROP VIEW IF EXISTS books_view");
        onCreate(db);
        // Handle database schema changes
    }


}
