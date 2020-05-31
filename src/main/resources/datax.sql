
insert into public.categories ("ID", "NAME", "PARENT_ID", "CREATED_DATE") VALUES (1, 'Gıda', null, NOW());
insert into public.categories ("ID", "NAME", "PARENT_ID", "CREATED_DATE") VALUES (2, 'Mobilya', null, NOW());
insert into public.categories ("ID", "NAME", "PARENT_ID", "CREATED_DATE") VALUES (3, 'Unlu Mamuller', 1, NOW());
insert into public.categories ("ID", "NAME", "PARENT_ID", "CREATED_DATE") VALUES (4, 'Ekmek', 3, NOW());

insert into public.stores ("ID","NAME", "CREATED_DATE", "AVERAGE_RATE")
VALUES (1, 'DOĞAL MUTFAK', NOW(), 0);
insert into public.stores ("ID","NAME", "CREATED_DATE", "AVERAGE_RATE")
VALUES (2, 'KOX ATOLYECILIK', NOW(), 0);



insert into public.carts ("ID") VALUES (1);

insert into public.customers("ID", "CART_ID") values (1,1);
insert into public.sellers("ID", "STORE_ID") values (1, 1);
insert into public.sellers("ID","STORE_ID") values (2, 2);

insert into public.users("ID", "NAME", "SURNAME", "PASSWORD", "EMAIL", "PHONE", "USER_ROLE", "LOCKED", "ENABLED", "CUSTOMER_ID")
values
(1, 'Halit', 'Gürpınar', '$2a$10$wILigt.xGaU6uwpjxqhqp.8tpft5Gw3f1hlb4RshpQ4CxJFR.fye.', 'test1@user.com', '5459409574', 'USER', FALSE, TRUE,1);

insert into public.users("ID", "NAME", "SURNAME", "PASSWORD", "EMAIL", "PHONE", "USER_ROLE", "LOCKED", "ENABLED", "SELLER_ID")
values
(2, 'Nazife', 'Gürpınar', '$2a$10$wILigt.xGaU6uwpjxqhqp.8tpft5Gw3f1hlb4RshpQ4CxJFR.fye.', 'test2@seller.com', '55555555', 'SELLER', FALSE, TRUE,1);

insert into public.users("ID", "NAME", "SURNAME", "PASSWORD", "EMAIL", "PHONE", "USER_ROLE", "LOCKED", "ENABLED", "SELLER_ID")
values
(3, 'Köksal', 'Karlıdağ', '$2a$10$wILigt.xGaU6uwpjxqhqp.8tpft5Gw3f1hlb4RshpQ4CxJFR.fye.', 'test3@seller.com', '44444444', 'SELLER', FALSE, TRUE, 2);


insert into PUBLIC.PRODUCTS ("ID","INFORMATION","LEAD_TIME","NAME","PRICE","STORE_ID","CREATED_DATE", "AVERAGE_RATE", "LAST_MODIFIED_DATE")
VALUES(1,'ekşi ekmek',3,'ekmek',9,1,NOW(), 0, nulL);
insert into PUBLIC.PRODUCTS ("ID","INFORMATION","LEAD_TIME","NAME","PRICE","STORE_ID","CREATED_DATE", "AVERAGE_RATE", "LAST_MODIFIED_DATE")
VALUES(2,'El yapımı ahşap zigon sehpa',4,'Zigon Sehpa',150,2,NOW(), 0,nulL);

insert into public.PRODUCT_CATEGORIES ("PRODUCT_ID", "CATEGORY_ID") VALUES (1, 4);
insert into public.PRODUCT_CATEGORIES ("PRODUCT_ID", "CATEGORY_ID") VALUES (2, 2);




insert into public.orders("ID", "TOTAL_PRICE", "CUSTOMER_ID","CREATED_DATE") values (1, 0, 1,NOW());
insert into public.order_products ("ORDER_ID", "PRODUCT_ID") VALUES (1,1);
insert into public.cart_products ("CART_ID", "PRODUCT_ID") VALUES (1,1);
insert into public.cart_products ("CART_ID", "PRODUCT_ID") VALUES (1,2);

insert into public.comments("ID", "CONTENT", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (1, 'Gayet güzel', 1, null, 1, NOW());

insert into public.comments("ID", "CONTENT", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (2, 'Sağlam ürün', 2, null, 1, NOW());

insert into public.comments("ID", "CONTENT", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (3, 'Güvenilir mağaza', null, 1, 1, NOW());

insert into public.comments("ID", "CONTENT", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (4, 'Güzel bir mağaza', null, 2, 1, NOW());

insert into public.ratings("ID", "RATE", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (1,9, 1, null, 1, NOW());

insert into public.ratings("ID", "RATE", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (2,8, 2, null, 1, NOW());

insert into public.ratings("ID", "RATE", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (3, 7, null, 1, 1, NOW());

insert into public.ratings("ID", "RATE", "PRODUCT_ID", "STORE_ID", "CUSTOMER_ID","CREATED_DATE") VALUES (4, 8, null, 2, 1, NOW());