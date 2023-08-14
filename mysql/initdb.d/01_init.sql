SET CHARSET UTF8;
CREATE DATABASE IF NOT EXISTS sample_database DEFAULT CHARACTER SET utf8;

-- グループユーザ連結
create table c_group_user (
  connection_id bigint auto_increment not null comment '連結ID'
  , group_id bigint not null comment 'グループID'
  , user_id bigint not null comment 'ユーザーID'
  , registration_datetime timestamp default CURRENT_TIMESTAMP not null comment '登録日時'
  , update_datetime timestamp default CURRENT_TIMESTAMP not null comment '更新日時'
  , logical_delete_flag tinyint(1) default 0 not null comment '論理削除フラグ'
  , constraint c_group_user_PKC primary key (connection_id)
) comment 'グループユーザ連結' ;