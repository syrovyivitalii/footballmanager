CREATE TABLE transfers (
    id UUID PRIMARY KEY,
    player_id UUID NOT NULL,
    from_team_id UUID NOT NULL,
    to_team_id UUID NOT NULL,
    transfer_price DECIMAL(15,2) NOT NULL,
    commission DECIMAL(15,2) NOT NULL,
    total_fee DECIMAL(15,2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);