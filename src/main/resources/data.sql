INSERT INTO Course (name_course,type_course,name_teacher,number_students,number_lessons) VALUES ('Spring MVC','Tech','Kevin',10,1);
INSERT INTO Course (name_course,type_course,name_teacher,number_students,number_lessons) VALUES ('Spring JPA','Tech','Humberto',20,2);
INSERT INTO Course (name_course,type_course,name_teacher,number_students,number_lessons) VALUES ('Spring H2','Tech','Luis',30,3);
INSERT INTO Course (name_course,type_course,name_teacher,number_students,number_lessons) VALUES ('Spring WEB','Tech','Josue',40,4);
INSERT INTO Course (name_course,type_course,name_teacher,number_students,number_lessons) VALUES ('Spring Thymeleaf','Tech','Misael',50,5);



INSERT INTO Student (name) VALUES ('daniel bracamontes');
INSERT INTO Student (name) VALUES ('test');


INSERT INTO course_enrroll (id_student,id_course) VALUES (1,1);
INSERT INTO course_enrroll (id_student,id_course) VALUES (1,2);
INSERT INTO course_enrroll (id_student,id_course) VALUES (1,3);


INSERT INTO course_enrroll (id_student,id_course) VALUES (2,1);