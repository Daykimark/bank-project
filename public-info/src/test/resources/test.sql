insert into branch (id, address, phone_number, city, start_of_work, end_of_work)
values (2, 'test', 890945496578, 'test', '12:00:00', '14:00:00');
insert into atm (id, address, start_of_work, end_of_work, all_hours, branch_id)
values (2, 'test', '12:00:00', '14:00:00', true, 2);
insert into branch (id, address, phone_number, city, start_of_work, end_of_work)
values (3, 'test', 85054649895, 'test', '12:00:00', '14:00:00');
insert into atm (id, address, start_of_work, end_of_work, all_hours, branch_id)
values (3, 'test', '12:00:00', '14:00:00', true, 3);
insert into atm (id, address, start_of_work, end_of_work, all_hours, branch_id)
values (4, 'test', '12:00:00', '14:00:00', true, 3);
insert into branch (id, address, phone_number, city, start_of_work, end_of_work)
values (4, 'test', 855564656, 'test', '12:00:00', '14:00:00');
insert into atm (id, address, start_of_work, end_of_work, all_hours, branch_id)
values (5, 'test', '12:00:00', '14:00:00', true, 4);


insert into bank_details (id, bik, inn, kpp, cor_account, city, joint_stock_company, name)
values (2, 11111, 22222, 33333, 4444444, 'sochi', 'vtb', 'test');
insert into bank_details (id, bik, inn, kpp, cor_account, city, joint_stock_company, name)
values (3, 131231, 1231313, 1231411, 4155151, 'sochi', 'vtb', 'test');
insert into bank_details (id, bik, inn, kpp, cor_account, city, joint_stock_company, name)
values (4, 5634634, 12313, 123133, 123131, 'sochi', 'vtb', 'test');
insert into bank_details (id, bik, inn, kpp, cor_account, city, joint_stock_company, name)
values (5, 3133131, 525252, 1312314, 1231445, 'sochi', 'vtb', 'test');


insert into certificate (id, photo, bank_details_id)
values (2, '\xDEADBEEF', 2);
insert into certificate (id, photo, bank_details_id)
values (3, '\xDEADBEEF', 2);
insert into certificate (id, photo, bank_details_id)
values (4, '\xDEADBEEF', 2);

insert into license (id, photo, bank_details_id)
values (2, '\xDEADBEEF', 2);
insert into license (id, photo, bank_details_id)
values (3, '\xDEADBEEF', 2);
insert into license (id, photo, bank_details_id)
values (4, '\xDEADBEEF', 2);
