
-- Inheritance patterns
-- Table for Admin
CREATE TABLE admin (
    id serial primary key ,
    username varchar(20) DEFAULT NULL,
    password varchar(20) DEFAULT NULL,
    name varchar(20) DEFAULT NULL,
    telephone varchar(20) DEFAULT NULL
);

-- Table for Customer
CREATE TABLE Customer (
    id serial primary key ,
    username varchar(20) DEFAULT NULL,
    password varchar(20) DEFAULT NULL,
    name varchar(20) DEFAULT NULL,
    telephone varchar(20) DEFAULT NULL
);

-- Table for Planner
CREATE TABLE Planner (
    id serial primary key ,
    username varchar(20) DEFAULT NULL,
    password varchar(20) DEFAULT NULL,
    name varchar(20) DEFAULT NULL,
    telephone varchar(20) DEFAULT NULL
);

-- Embedded value pattern for “location” and sections
-- Table for venue
CREATE TABLE venue (
    id SERIAL PRIMARY KEY,
    name varchar(20) DEFAULT NULL,
    sectionSta int,  -- Embedded value
    sectionMos int,  -- Embedded value
    sectionSea int,  -- Embedded value
    sectionVip int,  -- Embedded value
    sectionOth int   -- Embedded value
);

-- Embedded value pattern for start/end time
-- Table for event
CREATE TABLE Event (
    Event_ID        SERIAL PRIMARY KEY,
    Planner_ID      int,
    Venue_ID        int,
    Start_Time timestamp DEFAULT current_timestamp, -- Embedded value
    End_Time timestamp DEFAULT current_timestamp, -- Embedded value
    FOREIGN KEY (Planner_ID) REFERENCES Planner(id),
    FOREIGN KEY (Venue_ID) REFERENCES Venue(Venue_ID)
);

-- Association table mapping pattern
-- An event can be managed by multiple Event Planners
CREATE TABLE EVENT_PLANNER_ASSOCIATION (
    Event_ID      int,
    Planner_ID    int,
    PRIMARY KEY (Event_ID, Planner_ID),
    FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID),
    FOREIGN KEY (Planner_ID) REFERENCES Planner(id)
);

-- Association table mapping pattern
-- An event can have multiple sections and different price
CREATE TABLE EVENT_PRICING (
    Event_ID int REFERENCES Event(Event_ID),
    Section_Type varchar(50), -- This could be 'Standing', 'Mosh', 'Seated' or 'VIP'
    Price decimal(10, 2),
    PRIMARY KEY (Event_ID, Section_Type)
);

-- Table for order
CREATE TABLE Customer_Order (
    Order_ID        SERIAL PRIMARY KEY,
    Customer_ID     int,
    Date            timestamp,
    Timestamp       timestamp DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Customer_ID) REFERENCES customer(id)
);

-- Table for tickets
CREATE TABLE TICKET (
    Ticket_ID       SERIAL PRIMARY KEY,
    Event_ID        int,
    Section_Type    varchar(50),
    Seat_ID         varchar(50),
    FOREIGN KEY (Event_ID) REFERENCES Event(Event_ID)
);

-- Association table mapping pattern
-- An oder can have many tickets
CREATE TABLE ORDER_DETAILS (
    Order_ID        int,
    Ticket_ID       int,
    FOREIGN KEY (Order_ID) REFERENCES Customer_Order(Order_ID),
    FOREIGN KEY (Ticket_ID) REFERENCES TICKET(Ticket_ID),
    PRIMARY KEY (Order_ID, Ticket_ID)
);





