SET CHARSET UTF8;
CREATE DATABASE IF NOT EXISTS sample_database DEFAULT CHARACTER SET utf8;
-- 初期データの投入
insert into m_group(group_name) values('nacha');

insert into m_user(user_name) values('小野 鷹希');
insert into m_user(user_name) values('夏目 奈苗');

insert into c_group_user(group_id, user_id) values(1,1);
insert into c_group_user(group_id, user_id) values(1,2);

insert into m_category(category_name) values('固定費');
insert into m_category(category_name) values('生活費');
insert into m_category(category_name) values('自由費');