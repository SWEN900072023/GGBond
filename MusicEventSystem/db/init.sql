
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

-- Table for event
CREATE TABLE event (
    id        SERIAL PRIMARY KEY,
    name varchar(20) DEFAULT NULL,
    venue_id        int,
    date varchar(20) DEFAULT NULL,
    staP int,
    mosP int,
    seaP int,
    vipP int,
    othP int,
    version int DEFAULT 0,
    FOREIGN KEY (venue_id) REFERENCES venue(id)
);

-- Association table mapping pattern
-- An event can be managed by multiple Event Planners
CREATE TABLE EVENT_PLANNER_ASSOCIATION (
    event_id      int,
    planner_id    int,
    PRIMARY KEY (event_id, planner_id),
    FOREIGN KEY (event_id) REFERENCES event(id) on update cascade  on delete  cascade,
    FOREIGN KEY (planner_id) REFERENCES planner(id) on update cascade  on delete  cascade
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
CREATE TABLE customerorder (
    id        SERIAL PRIMARY KEY,
    customer_id int,
    ticket_id int,
    event_id int,
    event_name varchar(20) DEFAULT NULL,
    section varchar(20) DEFAULT NULL,
    unitprice int,
    num int,
    Timestamp timestamp DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES event(id) on update cascade  on delete  cascade,
    FOREIGN KEY (customer_id) REFERENCES customer(id) on update cascade  on delete  cascade
);

-- Table for tickets
CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    event_id int,
    event_name varchar(20) DEFAULT NULL,
    venue_id int,
    venue_name varchar(20) DEFAULT NULL,
    san int,
    sbn int,
    scn int,
    sdn int,
    sen int,
    sap int,
    sbp int,
    scp int,
    sdp int,
    sep int,
    FOREIGN KEY (event_id) REFERENCES event(id)  on update cascade  on delete  cascade
);

-- Not use yet
-- Association table mapping pattern
-- An oder can have many tickets
CREATE TABLE ORDER_DETAILS (
    Order_ID        int,
    Ticket_ID       int,
    FOREIGN KEY (Order_ID) REFERENCES Customer_Order(Order_ID),
    FOREIGN KEY (Ticket_ID) REFERENCES TICKET(Ticket_ID),
    PRIMARY KEY (Order_ID, Ticket_ID)
);





