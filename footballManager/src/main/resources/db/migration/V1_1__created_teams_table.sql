CREATE TABLE teams (
    id UUID PRIMARY KEY,
    name varchar NOT NULL ,
    budget decimal(15,2),
    commission_rate DECIMAL (4,2),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);