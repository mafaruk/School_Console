CREATE TABLE Student (
    studentID int NOT NULL PRIMARY KEY,
    studentName varchar(255) NOT NULL,
	rollNo int NOT NULL,
	classID int not null FOREIGN KEY REFERENCES Classroom(classID)
);

CREATE TABLE Classroom (
    classID int NOT NULL PRIMARY KEY,
    className varchar(255) NOT NULL,
	classTeacherID int not null FOREIGN KEY REFERENCES Teacher(teacherID)
);

CREATE TABLE Teacher (
    teacherID int NOT NULL PRIMARY KEY,
    teacherName varchar(255) NOT NULL,
	subjectID int not null FOREIGN KEY REFERENCES Subject(subjectID)
);

CREATE TABLE Subject (
    subjectID int NOT NULL PRIMARY KEY,
    subjectName varchar(255) NOT NULL,
	teacherID int NOT NULL,
	classID int NOT NULL 
);

ALTER TABLE Subject
ADD FOREIGN KEY (classID) REFERENCES Classroom(classID);

ALTER TABLE Subject
ADD FOREIGN KEY (teacherID) REFERENCES Teacher(teacherID);

CREATE TABLE Management (
	teacherID int NOT NULL FOREIGN KEY  REFERENCES Teacher(teacherID),
	Designation varchar(255) NOT NULL
);

CREATE TABLE NonTeacher (
    NonTeacherID int NOT NULL PRIMARY KEY,
    NonTeacherName varchar(255) NOT NULL,
	Designation varchar(255) NOT NULL
);