/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-27 22:11:18 UTC+08:00
 *****************************************************/

create database sky_takeout charset utf8mb4 collate utf8mb4_general_ci;

create table sky_tb_employee
(
    id         integer unsigned primary key auto_increment,
    username   varchar(32)      not null unique comment '用户名',
    password   varchar(128)     not null comment '密码',
    name       varchar(32)      not null comment '姓名',
    gender     tinyint(1)       not null comment '性别 0 女 1 男',
    phone      varchar(11)      not null comment '手机号',
    id_number  varchar(18)      not null comment '身份证号',
    forbidden  boolean          not null default false comment '禁用状态',
    created_by integer unsigned not null comment '创建人',
    updated_by integer unsigned not null comment '修改人',
    created_at datetime         not null comment '创建时间',
    updated_at datetime         not null comment '修改时间',
    deleted    boolean          not null default false comment '数据状态'
) comment '员工表';

drop table sky_tb_employee;

insert into sky_tb_employee (username, password, name, gender, phone, id_number, forbidden, created_by, updated_by, created_at, updated_at, deleted)
values ('admin', 'e10adc3949ba59abbe56e057f20f883e', '管理员', 1, '13800138000', '110101199003074512', false, 0, 0, now(), now(), false);
