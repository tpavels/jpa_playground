INSERT INTO Item (ID, ITM_NAME, AUCTION_TYPE, BUYNOW_PRICE, INIT_PRICE, VERIFIED)
VALUES (1111, 'item_1', 'HIGHEST', 4000, 30, 'Y');
INSERT INTO Item (ID, ITM_NAME, AUCTION_TYPE, BUYNOW_PRICE, INIT_PRICE, VERIFIED)
VALUES (2222, 'item_2', 'FIXED', 3000, 50, 'N');

INSERT INTO Bid (id, amount) VALUES (1111, 1010);
INSERT INTO Bid (id, amount) VALUES (2222, 2020);

INSERT INTO Users (id, street, city, zip_code, country, b_street, b_city, b_zip_code, b_country  )
VALUES (1111, 'street a', 'city a', 'zip a', 'country a', 'street B', 'city B', 'zip B', 'country B');