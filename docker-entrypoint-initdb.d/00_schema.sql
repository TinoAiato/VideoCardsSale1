CREATE TABLE cards
(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price INT NOT NULL CHECK (price >= 0),
    videoMemory INT NOT NULL CHECK (videoMemory>=0),
    coolingType TEXT NOT NULL,
    manufacture TEXT NOT NULL,
    qty INT NOT NULL CHECK (qty >=0) DEFAULT 0,
    removed BOOLEAN NOT NULL DEFAULT FALSE,
    created timestamptz NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE games
(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE cards_game_stats
(
    id BIGSERIAL PRIMARY KEY,
    card_id BIGINT NOT NULL REFERENCES cards,
    game_id INT NOT NULL REFERENCES games,
    fps INT NOT NULL CHECK (fps >=0) DEFAULT 0,
    rtx BOOLEAN NOT NULL DEFAULT FALSE
);