CREATE TABLE teams (
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL ,
    budget DECIMAL(15,2),
    commission_rate DECIMAL (4,2),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);