-- ----------------------------
-- Table structure for co_company
-- ----------------------------
# DROP TABLE IF EXISTS `co_company`;
CREATE TABLE `co_company` (
  `id` bigint NOT NULL COMMENT 'ID',
  `name` varchar(255) NOT NULL COMMENT '公司名称',
  `manager_id` bigint NOT NULL COMMENT '企业登录账号ID',
  `version` varchar(255) DEFAULT NULL COMMENT '当前版本',
  `renewal_date` datetime DEFAULT NULL COMMENT '续期时间',
  `expiration_date` datetime DEFAULT NULL COMMENT '到期时间',
  `company_area` varchar(255) DEFAULT NULL COMMENT '公司地区',
  `company_address` text COMMENT '公司地址',
  `business_license_id` varchar(255) DEFAULT NULL COMMENT '营业执照-图片ID',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法人代表',
  `company_phone` varchar(255) DEFAULT NULL COMMENT '公司电话',
  `mailbox` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `company_size` varchar(255) DEFAULT NULL COMMENT '公司规模',
  `industry` varchar(255) DEFAULT NULL COMMENT '所属行业',
  `remarks` text COMMENT '备注',
  `audit_state` varchar(255) DEFAULT NULL COMMENT '审核状态',
  `state` int DEFAULT '1' COMMENT '状态',
  `balance` decimal(16,2) NOT NULL DEFAULT 0.00 COMMENT '当前余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of co_company
-- ----------------------------
INSERT INTO `co_company` VALUES (1, 'M78星云', 1122, '12', null, null, null, null, null, '张三', null, null, null, null, null, '0', '1', '0', '2018-11-07 13:30:05',null);
INSERT INTO `co_company` VALUES (1060043412612452352, '人马', 1133, '12', null, null, null, null, null, null, null, null, null, null, null, '0', '1', '0', '2018-11-07 13:36:58',null);
INSERT INTO `co_company` VALUES (1061532681482932224, '金牛', 1144, '12', null, null, null, null, null, null, null, null, null, null, null, '0', '1', '0', '2018-11-11 16:14:48',null);
INSERT INTO `co_company` VALUES (1065494996154650624, '地球', 1166, '12', null, null, null, null, null, null, null, null, null, null, null, '0', '1', 0, null,null);
INSERT INTO `co_company`(id,name,manager_id) VALUES (1065494996154650625,'火星', 1166);

