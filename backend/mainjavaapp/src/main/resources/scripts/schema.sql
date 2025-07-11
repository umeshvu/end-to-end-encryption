--basic one
CREATE TABLE IF NOT EXISTS student (
    student_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    student_name TEXT NOT NULL,
    student_age INT,
    student_sso TEXT
);
