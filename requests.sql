SELECT id, name, price, videomemory, coolingtype, manufacture, qty FROM cards ORDER BY 3;

UPDATE cards SET qty = qty-1 WHERE id =1
RETURNING id, name, qty
;

INSERT INTO cards(name, price, videomemory, coolingtype, manufacture, qty) VALUES ('ASUS ROG STRIX RTX3060 O12G GAMING', 224990, 12, 'Triple Axial-Tech Fans', 'ASUS ROG STRIX', 6)
RETURNING name, price, videomemory, coolingtype, manufacture, qty
;

DELETE FROM cards WHERE id = 6;

