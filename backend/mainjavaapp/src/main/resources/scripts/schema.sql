--basic one
CREATE TABLE IF NOT EXISTS student (
    studentId UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    studentName TEXT NOT NULL,
    studentAge INT,
    studentSSO TEXT
);
