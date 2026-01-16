CREATE TABLE t_group(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE t_subject(
    id SERIAL PRIMARY KEY,
    code VARCHAR(255),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE t_student(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    group_id INT,
    email VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255),
    CONSTRAINT fk_student_group
                       FOREIGN KEY (group_id) REFERENCES t_group(id)
);

CREATE TABLE t_student_subjects(
    student_id INT NOT NULL,
    subject_id INT NOT NULL,
    PRIMARY KEY(student_id,subject_id),
    CONSTRAINT fk_subject_student_student
                                    FOREIGN KEY (student_id) REFERENCES t_student(id),
    CONSTRAINT fk_subject_student_subject
                                    FOREIGN KEY (subject_id) REFERENCES t_subject(id)
);
CREATE TABLE t_permission(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
CREATE TABLE t_student_permissions(
    student_id INT NOT NULL,
    permission_id INT NOT NULL,
    PRIMARY KEY (student_id,permission_id),
    CONSTRAINT fk_student_permission_student
                                   FOREIGN KEY (student_id) REFERENCES t_student(id),
    CONSTRAINT fk_student_permission_permission
                                   FOREIGN KEY (permission_id) REFERENCES t_permission(id)
)
