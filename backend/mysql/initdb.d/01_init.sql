SET CHARSET UTF8;
CREATE DATABASE IF NOT EXISTS sample_database DEFAULT CHARACTER SET utf8;
-- nacha_dbの作成
create table m_group (
  group_id bigint AUTO_INCREMENT comment 'グループID'
  , group_name varchar(256)
  , registration_datetime timestamp default current_timestamp not null comment '登録日時'
  , update_datetime timestamp default current_timestamp not null comment '更新日時'
  , logical_delete_flag boolean default false not null comment '論理削除フラグ'
  , constraint m_group_PKC primary key (group_id)
) comment 'グループマスタ';

create table m_user (
  user_id bigint AUTO_INCREMENT comment 'ユーザID'
  , user_name varchar(256) not null comment 'ユーザ名'
  , registration_datetime timestamp default current_timestamp not null comment '登録日時'
  , update_datetime timestamp default current_timestamp not null comment '更新日時'
  , logical_delete_flag boolean default false not null comment '論理削除フラグ'
  , constraint m_user_PKC primary key (user_id)
) comment 'ユーザマスタ';

create table c_group_user (
  group_user_id bigint AUTO_INCREMENT comment 'グループ-ユーザ連結ID'
  , group_id bigint not null comment 'グループID'
  , user_id bigint not null comment 'ユーザID'
  , registration_datetime timestamp default current_timestamp not null comment '登録日時'
  , update_datetime timestamp default current_timestamp not null comment '更新日時'
  , logical_delete_flag boolean default false not null comment '論理削除フラグ'
  , constraint m_user_PKC primary key (group_user_id)
) comment 'グループ-ユーザ連結';

create table m_category (
  category_id bigint AUTO_INCREMENT comment 'カテゴリID'
  , category_name varchar(256) not null comment 'カテゴリ名'
  , registration_datetime timestamp default current_timestamp not null comment '登録日時'
  , update_datetime timestamp default current_timestamp not null comment '更新日時'
  , logical_delete_flag boolean default false not null comment '論理削除フラグ'
  , constraint m_category_PKC primary key (category_id)
) comment 'カテゴリマスタ';

create table m_account (
  account_id bigint AUTO_INCREMENT comment '家計簿ID'
  , group_id bigint not null comment 'グループID'
  , category_id bigint not null comment 'カテゴリID'
  , note varchar(256) not null comment '備考'
  , amount bigint not null comment '金額'
  , datatime timestamp not null comment '日時'
  , registration_datetime timestamp default current_timestamp not null comment '登録日時'
  , update_datetime timestamp default current_timestamp not null comment '更新日時'
  , logical_delete_flag boolean default false not null comment '論理削除フラグ'
  , constraint m_account_PKC primary key (account_id)
) comment '家計簿マスタ';

alter table c_group_user
  add constraint c_group_user_FK1 foreign key (group_id) references m_group(group_id);

alter table c_group_user
  add constraint c_group_user_FK2 foreign key (user_id) references m_user(user_id);

alter table m_account
  add constraint m_accout_FK1 foreign key (category_id) references m_category(category_id);

alter table m_account
  add constraint m_account_FK1 foreign key (group_id) references m_group(group_id);