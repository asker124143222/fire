-- ----------------------------
-- Table structure for co_company
-- ----------------------------
# DROP TABLE IF EXISTS `co_company`;
CREATE TABLE `co_company`
(
    `id`                   bigint         NOT NULL COMMENT 'ID',
    `name`                 varchar(255)   NOT NULL COMMENT '公司名称',
    `manager_id`           bigint         NOT NULL COMMENT '企业登录账号ID',
    `version`              varchar(255)            DEFAULT NULL COMMENT '当前版本',
    `renewal_date`         datetime                DEFAULT NULL COMMENT '续期时间',
    `expiration_date`      datetime                DEFAULT NULL COMMENT '到期时间',
    `company_area`         varchar(255)            DEFAULT NULL COMMENT '公司地区',
    `company_address`      text COMMENT '公司地址',
    `business_license_id`  varchar(255)            DEFAULT NULL COMMENT '营业执照-图片ID',
    `legal_representative` varchar(255)            DEFAULT NULL COMMENT '法人代表',
    `company_phone`        varchar(255)            DEFAULT NULL COMMENT '公司电话',
    `mailbox`              varchar(255)            DEFAULT NULL COMMENT '邮箱',
    `company_size`         varchar(255)            DEFAULT NULL COMMENT '公司规模',
    `industry`             varchar(255)            DEFAULT NULL COMMENT '所属行业',
    `remarks`              text COMMENT '备注',
    `audit_state`          varchar(255)            DEFAULT NULL COMMENT '审核状态',
    `state`                int                     DEFAULT '1' COMMENT '状态',
    `balance`              decimal(16, 2) NOT NULL DEFAULT 0.00 COMMENT '当前余额',
    `create_time`          datetime                DEFAULT NULL COMMENT '创建时间',
    `update_time`          datetime                DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of co_company
-- ----------------------------
INSERT INTO `co_company`
VALUES (1, 'M78星云', 1122, '12', null, null, null, null, null, '张三', null, null, null, null, null, '0', '1', '0',
        '2018-11-07 13:30:05', null);
INSERT INTO `co_company`
VALUES (1060043412612452352, '人马', 1133, '12', null, null, null, null, null, null, null, null, null, null, null, '0',
        '1', '0', '2018-11-07 13:36:58', null);
INSERT INTO `co_company`
VALUES (1061532681482932224, '金牛', 1144, '12', null, null, null, null, null, null, null, null, null, null, null, '0',
        '1', '0', '2018-11-11 16:14:48', null);
INSERT INTO `co_company`
VALUES (1065494996154650624, '地球', 1166, '12', null, null, null, null, null, null, null, null, null, null, null, '0',
        '1', 0, null, null);
INSERT INTO `co_company`(id, name, manager_id)
VALUES (1065494996154650625, '火星', 1166);

-- ----------------------------
-- Table structure for co_department
-- ----------------------------
# DROP TABLE IF EXISTS `co_department`;
CREATE TABLE `co_department`
(
    `id`          bigint       NOT NULL,
    `company_id`  bigint       NOT NULL COMMENT '企业ID',
    `pid`         bigint      DEFAULT NULL COMMENT '父级部门ID',
    `name`        varchar(255) NOT NULL COMMENT '部门名称',
    `code`        varchar(255) NOT NULL COMMENT '部门编码',
    `manager_id`  bigint      DEFAULT NULL COMMENT '负责人ID',
    `manager`     varchar(40) DEFAULT NULL COMMENT '部门负责人',
    `introduce`   text COMMENT '介绍',
    `create_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime    DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Records of co_department
-- ----------------------------
INSERT INTO `co_department`
VALUES ('1063676045212913664', '1', '0', '研发部', 'DEV-TECHNOLOG', null, '技术部总监', '包含开发部，测试部', '2018-11-17 14:11:45',
        null);
INSERT INTO `co_department`
VALUES ('1063678149528784896', '1', '1063676045212913664', '测试部', 'DEPT-TEST', null, '测试部门领导', '所有测试人员统一划分到测试部',
        '2018-11-17 14:20:07', null);
INSERT INTO `co_department`
VALUES ('1066238836272664576', '1', null, '财务部', 'DEPT-FIN', null, '李四', '包含出纳和会计', '2018-11-24 15:55:22', null);
INSERT INTO `co_department`
VALUES ('1066239766607040512', '1', null, '行政中心', 'DEPT-XZ', null, '张三', '包含人力资源和行政部门', '2018-11-24 15:59:04', null);
INSERT INTO `co_department`
VALUES ('1066239913642561536', '1', '1066239766607040512', '人力资源部', 'DEPT-HR', null, '李四', '人力资源部',
        '2018-11-24 15:59:39', null);
INSERT INTO `co_department`
VALUES ('1066240303092076544', '1', '1066239766607040512', '行政部', 'DEPT-XZ', null, '王五', '行政部', '2018-11-24 16:01:12',
        null);
INSERT INTO `co_department`
VALUES ('1066240656856453120', '1', '1063676045212913664', '开发部', 'DEPT-DEV', null, '研发', '全部java开发人员',
        '2018-11-24 16:02:37', null);


-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
# DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`                 bigint       NOT NULL COMMENT 'ID',
    `mobile`             varchar(40)  NOT NULL COMMENT '手机号码',
    `username`           varchar(255) NOT NULL COMMENT '用户名称',
    `password`           varchar(255) DEFAULT NULL COMMENT '密码',
    `enable_state`       int(2)       DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
    `create_time`        datetime     DEFAULT NULL COMMENT '创建时间',
    `department_id`      bigint       DEFAULT NULL COMMENT '部门ID',
    `time_of_entry`      datetime     DEFAULT NULL COMMENT '入职时间',
    `form_of_employment` int(1)       DEFAULT NULL COMMENT '聘用形式',
    `work_number`        varchar(20)  DEFAULT NULL COMMENT '工号',
    `form_of_management` varchar(8)   DEFAULT NULL COMMENT '管理形式',
    `working_city`       varchar(16)  DEFAULT NULL COMMENT '工作城市',
    `correction_time`    datetime     DEFAULT NULL COMMENT '转正时间',
    `in_service_status`  int(1)       DEFAULT NULL COMMENT '在职状态 1.在职  2.离职',
    `company_id`         bigint       DEFAULT NULL COMMENT '企业ID',
    `company_name`       varchar(40)  DEFAULT NULL,
    `department_name`    varchar(40)  DEFAULT NULL,
    `level`              varchar(40)  DEFAULT NULL COMMENT '用户级别：saasAdmin，coAdmin，user',
    `staff_photo`        text comment '照片地址',
    `update_time`        datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user`
VALUES ('1063705482939731968', '13800000001', 'cgx', '88012a09484c94fcec9e65b2377c44b9', null, '2018-11-17 16:08:44',
        null, '2018-11-01 08:00:00', '1', '', null, null, '2018-11-01 00:00:00', null, null, null, null, 'saasAdmin',
        null, null);
INSERT INTO `sys_user`
VALUES ('1063705989926227968', '13800000002', 'aj123', 'c8b7722b1139bb9b346409e503302e82', '1', '2018-11-17 16:10:45',
        '1066241293639880704', '2018-11-02 08:00:00', '1', '9002', null, null, '2018-11-30 00:00:00', null, '1', '光之国',
        'test1', 'coAdmin', 'http://pkbivgfrm.bkt.clouddn.com/1063705989926227968?t=1545788007343', null);
INSERT INTO `sys_user`
VALUES ('1066370498633486336', '13800000003', 'zbz', '14af10ffa3798486632a79cbbf469376', '1', null,
        '1063678149528784896', '2018-11-04 08:00:00', '1', '111', null, null, '2018-11-20 00:00:00', null, '1', '光之国',
        '测试部', 'user', 'http://pkbivgfrm.bkt.clouddn.com/1066370498633486336?t=1545812322518', null);
INSERT INTO `sys_user`
VALUES ('1071632760222810112', '13800000004', 'll', '456134d471010ecba14c6f89cac349ff', '1', null,
        '1063678149528784896', '2018-12-02 08:00:00', '1', '1111', null, null, '2018-12-31 00:00:00', null, '1', '光之国',
        '测试部', 'user', null, null);
INSERT INTO `sys_user`
VALUES ('1074238801330704384', '13400000001', 'a01', '80069fc2872ce3cf269053f4a84b2f0d', '1', '2018-12-16 17:44:22',
        '1066240656856453120', '2018-01-01 00:00:00', '1', '1001', null, null, null, '1', '1', '光之国', '开发部', null, null,
        null);
INSERT INTO `sys_user`
VALUES ('1074238801402007552', '13400000002', 'a02', 'a4f6437f96466ff2ad41dc8c46317e7f', '1', '2018-12-16 17:44:23',
        '1066240656856453120', '2018-01-01 00:00:00', '1', '1002', null, null, null, '1', '1', '光之国', '开发部', null, null,
        null);
INSERT INTO `sys_user`
VALUES ('1075383133106425856', '13500000001', 'test001', 'aa824c0d32d9725482e58a7503a20521', '1', null,
        '1066240656856453120', '2018-01-01 00:00:00', '1', '2001', null, null, null, '1', '1', '光之国', '开发部', 'user',
        null, null);
INSERT INTO `sys_user`
VALUES ('1075383135371350016', '13500000002', 'test002', 'becc21ed8df7975fc845c6c70f46c2dd', '1', null,
        '1066240656856453120', '2018-01-01 00:00:00', '1', '2002', null, null, null, '1', '1', '光之国', '开发部', 'user',
        null, null);
INSERT INTO `sys_user`
VALUES ('1075383135459430400', '13500000003', 'test003', '7321b9c9cfaa938abc7408147fc29441', '1', null,
        '1066240656856453120', '2018-01-01 00:00:00', '1', '2003', null, null, null, '1', '1', '光之国', '开发部', 'user',
        null, null);

-- ----------------------------
-- Table structure for pe_role
-- ----------------------------
# DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`          bigint NOT NULL COMMENT '主键ID',
    `name`        varchar(40)  DEFAULT NULL COMMENT '权限名称',
    `description` varchar(255) DEFAULT NULL COMMENT '说明',
    `company_id`  bigint       DEFAULT NULL COMMENT '企业id',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_k3beff7qglfn58qsf2yvbg41i` (`name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role`
VALUES ('1062944989845262336', '人事经理', '负责整合人事部门', '1');
INSERT INTO `sys_role`
VALUES ('1064098829009293312', '系统管理员', '管理整合平台，可以操作企业所有功能', '1');
INSERT INTO `sys_role`
VALUES ('1064098935443951616', '人事专员', '只能操作员工菜单', '1');
INSERT INTO `sys_role`
VALUES ('1064099035536822272', '薪资专员', '绩效管理', '1');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
# DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`
(
    `id`          bigint NOT NULL COMMENT '主键',
    `description` text COMMENT '权限描述',
    `name`        varchar(255) DEFAULT NULL COMMENT '权限名称',
    `type`        tinyint(4)   DEFAULT NULL COMMENT '权限类型 1为菜单 2为功能 3为API',
    `pid`         bigint       DEFAULT 0 COMMENT '父节点',
    `code`        varchar(20)  DEFAULT NULL,
    `en_visible`  int(1)       DEFAULT NULL COMMENT '企业可见性 0：不可见，1：可见',
    `create_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `sys_permission`
VALUES ('1', '3', 'SAAS企业管理', '1', '0', 'saas-clients', '0', null, null);
INSERT INTO `sys_permission`
VALUES ('1063313020819738624', '查看部门的按钮', '查看部门', '2', '1', 'point-dept', '0', null, null);
INSERT INTO `sys_permission`
VALUES ('1063315016368918528', '用户管理菜单', '员工管理', '1', '0', 'employees', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063315194329042944', '用户删除按钮', '用户删除按钮', '2', '1063315016368918528', 'point-user-delete', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063322760811515904', '删除api', '删除用户api', '3', '1063315194329042944', 'API-USER-DELETE', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063327833876729856', '组织架构菜单', '组织架构', '1', '0', 'departments', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063328114689576960', '公司设置菜单', '公司设置', '1', '0', 'settings', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063328310592933888', '用户添加按钮', '用户添加按钮', '2', '1063315016368918528', 'POINT-USER-ADD', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1063328532492587008', '用户修改按钮', '用户修改按钮', '2', '1063315016368918528', 'POINT-USER-UPDATE', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1064104257952813056', null, '权限管理', '1', '0', 'permissions', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1064553683007705088', 'test', 'test', '1', '0', 'test', '1', null, null);
INSERT INTO `sys_permission`
VALUES ('1067396481381625856', '啊啊啊', '啊啊啊', '1', '0', '啊啊啊', '1', null, null);


# DROP TABLE IF EXISTS `sys_permission_api`;
CREATE TABLE `sys_permission_api`
(
    `id`         bigint NOT NULL COMMENT '主键ID',
    `api_level`  varchar(2)   DEFAULT NULL COMMENT '权限等级，1为通用接口权限，2为需校验接口权限',
    `api_method` varchar(255) DEFAULT NULL COMMENT '请求类型',
    `api_url`    varchar(255) DEFAULT NULL COMMENT '链接',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `sys_permission_api`
VALUES ('1063322760811515904', '1', 'delete', '/sys/user/delete');

# DROP TABLE IF EXISTS `sys_permission_menu`;
CREATE TABLE `sys_permission_menu`
(
    `id`         bigint NOT NULL COMMENT '主键ID',
    `menu_icon`  varchar(20) DEFAULT NULL COMMENT '权限代码',
    `menu_order` varchar(40) DEFAULT NULL COMMENT '序号',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `sys_permission_menu`
VALUES ('1', 'abc5', '14');
INSERT INTO `sys_permission_menu`
VALUES ('1063315016368918528', 'menu-user', '1');
INSERT INTO `sys_permission_menu`
VALUES ('1063327833876729856', '2', '2');
INSERT INTO `sys_permission_menu`
VALUES ('1063328114689576960', '3', '3');
INSERT INTO `sys_permission_menu`
VALUES ('1064104257952813056', null, null);
INSERT INTO `sys_permission_menu`
VALUES ('1064553683007705088', '1', '1');
INSERT INTO `sys_permission_menu`
VALUES ('1067396481381625856', '1', '1');
INSERT INTO `sys_permission_menu`
VALUES ('2', 'def', '2');


# DROP TABLE IF EXISTS `sys_permission_point`;
CREATE TABLE `sys_permission_point`
(
    `id`           bigint NOT NULL COMMENT '主键ID',
    `point_class`  varchar(20) DEFAULT NULL COMMENT '按钮类型',
    `point_icon`   varchar(20) DEFAULT NULL COMMENT '按钮icon',
    `point_status` int(11)     DEFAULT NULL COMMENT '状态',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `sys_permission_point` VALUES ('1063313020819738624', 'dept', 'dept', '1');
INSERT INTO `sys_permission_point` VALUES ('1063315194329042944', 'point-user-delete', 'point-user-delete', '1');
INSERT INTO `sys_permission_point` VALUES ('1063328310592933888', 'POINT-USER-ADD', 'POINT-USER-ADD', '1');
INSERT INTO `sys_permission_point` VALUES ('1063328532492587008', 'POINT-USER-UPDATE', 'POINT-USER-UPDATE', '1');