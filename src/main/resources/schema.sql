CREATE TABLE owners (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    dateOfBirth TEXT NOT NULL,
    drivingLicence TEXT NOT NULL
);

CREATE TABLE autos (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    model TEXT NOT NULL,
    vin TEXT NOT NULL,
    regNumber TEXT NOT NULL,
    ownerId INTEGER NOT NULL REFERENCES owners
);

CREATE TABLE offenses (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    regNumber TEXT NOT NULL,
    article TEXT NOT NULL,
    amountFine INTEGER NOT NULL CHECK (amountFine >= 0),
    urlPhoto TEXT,
    paid BOOLEAN
);

