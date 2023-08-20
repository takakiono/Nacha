SET CHARSET UTF8;
CREATE DATABASE IF NOT EXISTS sample_database DEFAULT CHARACTER SET utf8;
-- 初期データの投入
insert into m_group(group_name) values('nacha');

insert into m_user(user_name, group_id) values('小野 鷹希', 1);
insert into m_user(user_name, group_id) values('夏目 奈苗', 1);

insert into m_category(category_name) values('固定費');
insert into m_category(category_name) values('生活費');
insert into m_category(category_name) values('自由費');