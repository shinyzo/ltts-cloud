CREATE TABLE `ltts_server_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `server_name` varchar(50) DEFAULT NULL COMMENT 'server名称',
  `server_ip` varchar(20) DEFAULT NULL COMMENT 'server ip',
  `client_ip` varchar(20) DEFAULT NULL COMMENT '客户端ip',
  `requset_uri` varchar(100) DEFAULT NULL COMMENT '请求uri',
  `method_type` varchar(10) DEFAULT NULL COMMENT '请求方法',
  `user_agent` varchar(200) DEFAULT NULL COMMENT '浏览器类型',
  `class_name` varchar(400) NOT NULL COMMENT '类名',
  `method_name` varchar(80) DEFAULT NULL COMMENT '方法名称',
  `log_name` varchar(100) DEFAULT NULL COMMENT '日志标题',
  `log_type` char(1) DEFAULT NULL COMMENT '日志类型（0：正常，9：错误）',
  `request_data` varchar(500) DEFAULT NULL COMMENT '请求参数',
  `response_code` tinyint(3) DEFAULT NULL COMMENT '响应码',
  `error_msg` varchar(500) DEFAULT NULL COMMENT '错误消息',
  `response_data` varchar(500) DEFAULT NULL COMMENT '返回数据',
  `cost_time` bigint(12) DEFAULT NULL COMMENT '执行耗时（毫秒）',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `timestamp` timestamp COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='服务端日志';