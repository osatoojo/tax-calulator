INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (1, 1, 9951, 0.1, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (2, 9951, 40526, 0.12, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (3, 40526, 86376, 0.22, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (4, 86376, 164926, 0.24, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (5, 164926, 209426, 0.32, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (6, 209426, 523601, 0.35, 'S',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (7, 523601, 0, 0.37, 'S',2022 );

INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (8, 1, 19901, 0.1, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (9, 19901, 81051, 0.12, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (10, 81051, 172751, 0.22, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (11, 172751, 329851, 0.24, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (12, 329851, 418851, 0.32, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (13, 418851, 628301, 0.35, 'MFJ',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (14, 628301, 0, 0.37, 'MFJ',2022 );

INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (15, 1, 9876, 0.1, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (16, 9876, 41126, 0.12, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (17, 41126, 85526, 0.22, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (18, 85526, 163301, 0.24, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (19, 163301, 207351, 0.32, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (20, 207351, 311025, 0.35, 'MFS',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (21, 311025, 0, 0.37, 'MFS',2022 );

INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (22, 1, 14201, 0.1, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (23, 14201, 54201, 0.12, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (24, 54201, 86351, 0.22, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (25, 86351, 164901, 0.24, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (26, 164901, 209401, 0.32, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (27, 209401, 523601, 0.35, 'HOH',2022 );
INSERT INTO tax (id, min_amount,max_amount,rate,filling_status,year) VALUES (28, 523601, 0, 0.37, 'HOH',2022 );


INSERT INTO user (id, first_name,last_name) VALUES (1, 'Kobe','Bryant');

INSERT INTO salary (id, amount,additional_amount,year,user_id,tax_id) VALUES (1, 100000,20000, 2022, 1, 4);