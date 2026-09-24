-- Удаление таблиц
DROP TABLE IF EXISTS document_type;
DROP TABLE IF EXISTS department;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS employee_department;
DROP TABLE IF EXISTS employee_document;
DROP TABLE IF EXISTS employee;

-- Создание таблиц
-- Таблица департаментов
CREATE TABLE department (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);
-- Таблица позиций
CREATE TABLE position (
    id INTEGER PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);
-- Таблица типов документов
CREATE TABLE document_type (
    id INTEGER PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
);
-- Таблица работников
CREATE TABLE employee (
    id INTEGER PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    birth_date DATE NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    position_id INTEGER NOT NULL REFERENCES position(id) ON DELETE RESTRICT,
    CONSTRAINT chk_employees_birth_date CHECK (birth_date <= CURRENT_DATE)
);
-- Таблица принадлежности работника к департаменту
CREATE TABLE employee_department (
    employee_id INTEGER REFERENCES employee(id) ON DELETE CASCADE,
    department_id INTEGER REFERENCES department(id) ON DELETE RESTRICT,
    PRIMARY KEY (employee_id, department_id)
);
-- Таблица документов работника
CREATE TABLE employee_document (
    id INTEGER PRIMARY KEY,
    employee_id INTEGER NOT NULL REFERENCES employee(id) ON DELETE CASCADE,
    document_type_id INTEGER NOT NULL REFERENCES document_type(id) ON DELETE RESTRICT,
    doc_number VARCHAR(50) NOT NULL,
    issue_date DATE NOT NULL,
    issued_by VARCHAR(255) NOT NULL,
    CONSTRAINT uq_document_type_number UNIQUE (document_type_id, doc_number)
);

-- Создание индексов для более быстрого поиска
CREATE INDEX idx_employees_last_name ON employee(last_name);
CREATE INDEX idx_employees_position_id ON employee(position_id);
CREATE INDEX idx_emp_dep_department_id ON employee_department(department_id);
CREATE INDEX idx_employee_documents_employee ON employee_document(employee_id);
CREATE INDEX idx_employee_documents_issue ON employee_document(issue_date);

