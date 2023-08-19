create table m_user (
  user_id bigint AUTO_INCREMENT
  , user_name varchar(256) not null
  , registration_datetime timestamp default current_timestamp not null
  , update_datetime timestamp default current_timestamp not null
  , logical_delete_flag boolean default false not null
  , primary key (user_id)
) ;