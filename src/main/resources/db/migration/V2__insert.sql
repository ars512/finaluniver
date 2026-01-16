INSERT INTO t_group(name)
VALUES ('CS-101'), ('FN-102'),('WW-103');

INSERT INTO t_subject(code,name)
VALUES
    ('MATH', 'Mathematics'),
    ('PHYS', 'Physics'),
    ('DB', 'Databases');

INSERT INTO t_student(name,age,group_id,email,password,role)
VALUES
    ('Dan',20,1,'dan@gmail.com','123','ROLE_USER'),
    ('Den',21,2,'den@gmail.com','123','ROLE_USER'),
    ('Bob',19,3,'bob@gmail.com','123','ROLE_USER');

INSERT INTO t_student_subjects(student_id,subject_id)
VALUES
    (1,1),
    (1,2),
    (2,3),
    (3,3);

INSERT INTO t_permission (name) VALUES ('ROLE_USER');
INSERT INTO t_permission (name) VALUES ('ROLE_ADMIN');