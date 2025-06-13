-- Insert sample hotels
INSERT INTO hotel (id, name, city, rating, price_per_night) VALUES 
(1, 'The Ritz Paris', 'Paris', 4.9, 350.00),
(2, 'Hotel California', 'Los Angeles', 4.5, 220.00),
(3, 'Taj Palace', 'New Delhi', 4.7, 180.00),
(4, 'Marina Bay Sands', 'Singapore', 4.8, 400.00);

-- Insert inventory for The Ritz Paris
INSERT INTO inventory (id, hotel_id, date, available_rooms) VALUES 
(1, 1, '2025-06-10', 5),
(2, 1, '2025-06-11', 3),
(3, 1, '2025-06-12', 0);

-- Insert inventory for Hotel California
INSERT INTO inventory (id, hotel_id, date, available_rooms) VALUES 
(4, 2, '2025-06-10', 2),
(5, 2, '2025-06-11', 1);

-- Insert inventory for Taj Palace
INSERT INTO inventory (id, hotel_id, date, available_rooms) VALUES 
(6, 3, '2025-06-10', 10),
(7, 3, '2025-06-11', 8);

-- Insert inventory for Marina Bay Sands
INSERT INTO inventory (id, hotel_id, date, available_rooms) VALUES 
(8, 4, '2025-06-10', 0),
(9, 4, '2025-06-11', 4);

-- Insert rooms for inventory The Ritz Paris - date: 2025-06-10
INSERT INTO room (room_id, id, room_type, price_per_night, available_rooms, allowed_guests) VALUES
(101, 1, 'REGULAR', 1300.0, 5, 2),
(102, 1, 'DELUXE', 1800.0, 3, 4),
(103, 1, 'SUITE', 2500.0, 0, 2);

-- Insert rooms for inventory Hotel California
INSERT INTO room (room_id, id, room_type, price_per_night, available_rooms, allowed_guests) VALUES
(201, 4, 'REGULAR', 1300.0, 5, 2),
(202, 4, 'DELUXE', 1800.0, 3, 3),
(203, 4, 'SUITE', 2500.0, 0, 4);

-- Insert rooms for inventory Marina Bay Sands
INSERT INTO room (room_id, id, room_type, price_per_night, available_rooms, allowed_guests) VALUES
(301, 8, 'REGULAR', 1300.0, 5, 2),
(302, 8, 'DELUXE', 1800.0, 3, 4),
(303, 8, 'SUITE', 2500.0, 0, 4);

-- Insert rooms for inventory Taj Palace
INSERT INTO room (room_id, id, room_type, price_per_night, available_rooms, allowed_guests) VALUES
(401, 6, 'REGULAR', 1300.0, 5, 2),
(402, 6, 'DELUXE', 1800.0, 3, 2),
(403, 7, 'SUITE', 2500.0, 0, 2);