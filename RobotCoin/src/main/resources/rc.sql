-- phpMyAdmin SQL Dump
-- version 4.7.6
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: 2018-06-03 19:33:52
-- 服务器版本： 10.2.11-MariaDB
-- PHP Version: 5.6.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rc`
--
CREATE DATABASE IF NOT EXISTS `rc` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `rc`;

-- --------------------------------------------------------

--
-- 表的结构 `rc_account`
--

DROP TABLE IF EXISTS `rc_account`;
CREATE TABLE `rc_account` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '账户名称',
  `institution` tinyint(4) NOT NULL DEFAULT 0 COMMENT '机构类型 	机构',
  `apikey` varchar(40) NOT NULL DEFAULT '' COMMENT 'Access Key',
  `secretkey` varchar(40) NOT NULL DEFAULT '' COMMENT 'Secret Key',
  `user` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='账号表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_code`
--

DROP TABLE IF EXISTS `rc_code`;
CREATE TABLE `rc_code` (
  `id` smallint(5) UNSIGNED NOT NULL,
  `fcodeid` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '父ID',
  `field` varchar(20) NOT NULL DEFAULT '' COMMENT '对照字段',
  `fieldname` varchar(20) NOT NULL DEFAULT '' COMMENT '对照字段名称',
  `code` varchar(20) NOT NULL DEFAULT '' COMMENT '代码',
  `codedesc` varchar(100) NOT NULL DEFAULT '' COMMENT '代码描述（中文）',
  `enabled` tinyint(4) NOT NULL DEFAULT 0 COMMENT '(0:禁用;1:启用)',
  `seq` tinyint(4) NOT NULL DEFAULT 0 COMMENT '排序 0-1-2……'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典信息表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_condition`
--

DROP TABLE IF EXISTS `rc_condition`;
CREATE TABLE `rc_condition` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `strategy` mediumint(9) NOT NULL DEFAULT 0 COMMENT '策略ID',
  `dealtype` tinyint(4) NOT NULL DEFAULT 0 COMMENT '交易类型	0-买入 1-卖出',
  `type` varchar(40) NOT NULL DEFAULT '' COMMENT '参数类型	行情、技术指标、持仓指标、日历指标、自定义',
  `unit` varchar(8) NOT NULL DEFAULT '' COMMENT '单位	如：% 、万……',
  `comparison` varchar(8) NOT NULL COMMENT '默认比较符	如：大于，小于……',
  `value` int(11) NOT NULL DEFAULT 0 COMMENT '默认值'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='策略条件表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_conditionparam`
--

DROP TABLE IF EXISTS `rc_conditionparam`;
CREATE TABLE `rc_conditionparam` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `unit` varchar(8) NOT NULL DEFAULT '' COMMENT '单位',
  `value` int(11) NOT NULL DEFAULT 0 COMMENT '参数值',
  `paramname` varchar(40) NOT NULL DEFAULT '' COMMENT '参数名称',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `conditionid` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '策略条件表id',
  `strategy` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '策略id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='策略条件参数表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_currency`
--

DROP TABLE IF EXISTS `rc_currency`;
CREATE TABLE `rc_currency` (
  `id` int(10) UNSIGNED NOT NULL,
  `symbol` varchar(40) NOT NULL DEFAULT '' COMMENT '币对',
  `mintradesize` int(11) NOT NULL DEFAULT 0 COMMENT '最小交易单位',
  `quoteincrement` int(11) NOT NULL DEFAULT 0 COMMENT '下单精度'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货币表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_deallog`
--

DROP TABLE IF EXISTS `rc_deallog`;
CREATE TABLE `rc_deallog` (
  `id` int(10) UNSIGNED NOT NULL,
  `tid` int(11) NOT NULL DEFAULT 0 COMMENT '交易生成的id',
  `robot` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '机器人名称ID',
  `strategy` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '策略ID',
  `exchange` tinyint(4) NOT NULL DEFAULT 0 COMMENT '交易所',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '交易类型	0buy-买入 1sell-卖出',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '交易价格',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '交易数量',
  `account` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '账号',
  `user` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='交易日志表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_entrust`
--

DROP TABLE IF EXISTS `rc_entrust`;
CREATE TABLE `rc_entrust` (
  `id` int(10) UNSIGNED NOT NULL,
  `type` varchar(40) NOT NULL DEFAULT '' COMMENT '委托类型',
  `enprice` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '委托价格 ',
  `encount` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '委托总量',
  `ensum` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '委托金额',
  `dealprice` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '成交均价',
  `dealcount` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '成交数量',
  `direction` varchar(40) NOT NULL DEFAULT '' COMMENT '方向',
  `coin` varchar(40) NOT NULL DEFAULT '' COMMENT '币对',
  `state` tinyint(4) NOT NULL DEFAULT 0 COMMENT '委托状态',
  `user` smallint(5) UNSIGNED NOT NULL DEFAULT 0 COMMENT '添加用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='委托表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_funds`
--

DROP TABLE IF EXISTS `rc_funds`;
CREATE TABLE `rc_funds` (
  `id` int(10) UNSIGNED NOT NULL,
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '余额类型	0-free（账户可用余额） 1-freezed（账户冻结余额）',
  `product` mediumint(9) NOT NULL DEFAULT 0 COMMENT '币对id',
  `balance` int(11) NOT NULL DEFAULT 0 COMMENT '余额',
  `user` mediumint(9) NOT NULL DEFAULT 0 COMMENT '用户',
  `account` mediumint(9) NOT NULL DEFAULT 0 COMMENT '账户'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='余额表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_menu`
--

DROP TABLE IF EXISTS `rc_menu`;
CREATE TABLE `rc_menu` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `name` varchar(8) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `url` varchar(40) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `pid` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级菜单ID',
  `type` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单等级 1-一级 2-二级',
  `role` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户角色 0-普通 1-管理员 '
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_msg`
--

DROP TABLE IF EXISTS `rc_msg`;
CREATE TABLE `rc_msg` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `user` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户',
  `content` text DEFAULT NULL COMMENT '消息内容',
  `isread` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否阅读	0-未读  1-已读',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型	1-系统 2-普通',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='消息表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_order`
--

DROP TABLE IF EXISTS `rc_order`;
CREATE TABLE `rc_order` (
  `id` int(10) UNSIGNED NOT NULL,
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '单个购买价格',
  `avgprice` int(11) NOT NULL DEFAULT 0 COMMENT '购买数量',
  `dealamount` int(11) NOT NULL DEFAULT 0 COMMENT '交易金额',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '订单金额',
  `state` tinyint(4) NOT NULL DEFAULT 0 COMMENT '交易类型	-1-已取消，0-未成交，1-部分成交，2-已成交，3-撤销处理中',
  `symbol` varchar(10) NOT NULL DEFAULT '' COMMENT '标记',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '订单类型	0Buy-买，1sell-卖',
  `account` mediumint(9) NOT NULL DEFAULT 0 COMMENT '账号',
  `user` mediumint(9) NOT NULL DEFAULT 0 COMMENT '用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_period`
--

DROP TABLE IF EXISTS `rc_period`;
CREATE TABLE `rc_period` (
  `id` int(10) UNSIGNED NOT NULL,
  `value` int(11) NOT NULL COMMENT '周几值',
  `unit` tinyint(4) NOT NULL COMMENT '周期单位	0-分钟 1-小时 2-日 3-周 4-月'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='周期表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_robot`
--

DROP TABLE IF EXISTS `rc_robot`;
CREATE TABLE `rc_robot` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '名称',
  `account` mediumint(9) NOT NULL DEFAULT 0 COMMENT '账号',
  `strategy` mediumint(9) NOT NULL DEFAULT 0 COMMENT '策略',
  `currency` varchar(40) NOT NULL DEFAULT '' COMMENT '货币',
  `cash` int(11) NOT NULL DEFAULT 0 COMMENT '现金',
  `state` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态	0-未启用，1-启用',
  `user` mediumint(8) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机器人表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_strategy`
--

DROP TABLE IF EXISTS `rc_strategy`;
CREATE TABLE `rc_strategy` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '名称',
  `lperiod` int(11) NOT NULL DEFAULT 0 COMMENT '轮询周期',
  `currency` int(11) NOT NULL DEFAULT 0 COMMENT '币对id',
  `period` int(11) NOT NULL DEFAULT 0 COMMENT 'K线周期',
  `tprice` int(11) NOT NULL DEFAULT 0 COMMENT '成交价格',
  `exchange` tinyint(4) NOT NULL DEFAULT 0 COMMENT '交易所',
  `initialfunds` int(11) NOT NULL DEFAULT 0 COMMENT '起始资金',
  `tstarttime` time NOT NULL DEFAULT '00:00:00' COMMENT '开始交易时间',
  `tendtime` time NOT NULL DEFAULT '00:00:00' COMMENT '开始结束时间',
  `mtposition` int(11) NOT NULL DEFAULT 0 COMMENT '单次最大买卖仓位',
  `account` mediumint(9) NOT NULL DEFAULT 0 COMMENT '账号',
  `user` mediumint(9) NOT NULL DEFAULT 0 COMMENT '用户',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='策略表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_ticker`
--

DROP TABLE IF EXISTS `rc_ticker`;
CREATE TABLE `rc_ticker` (
  `id` int(10) UNSIGNED NOT NULL,
  `buy` int(11) NOT NULL COMMENT '买价',
  `high` int(11) NOT NULL COMMENT '最高价格',
  `last` int(11) NOT NULL COMMENT '最新价格',
  `low` int(11) NOT NULL COMMENT '最低价格',
  `sell` int(11) NOT NULL COMMENT '卖价',
  `vol` int(11) NOT NULL COMMENT '成交量'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='货币行情表';

-- --------------------------------------------------------

--
-- 表的结构 `rc_user`
--

DROP TABLE IF EXISTS `rc_user`;
CREATE TABLE `rc_user` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(40) NOT NULL DEFAULT '' COMMENT '用户姓名',
  `role` tinyint(3) UNSIGNED NOT NULL DEFAULT 0 COMMENT '人员类型 	0-普通 1-管理员  ',
  `account` varchar(15) NOT NULL DEFAULT '' COMMENT '登陆手机	手机号',
  `password` char(32) NOT NULL DEFAULT '' COMMENT '密码',
  `nick` varchar(40) NOT NULL DEFAULT '' COMMENT '昵称',
  `sex` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别	0-未知 1-男 2-女 ',
  `idnum` varchar(32) NOT NULL DEFAULT '' COMMENT '身份证',
  `birthday` date NOT NULL DEFAULT '0000-00-00' COMMENT '出生日期',
  `phone` varchar(20) NOT NULL DEFAULT '' COMMENT '电话',
  `wechat` varchar(32) NOT NULL DEFAULT '' COMMENT '微信',
  `qq` varchar(32) NOT NULL DEFAULT '' COMMENT 'QQ',
  `email` varchar(128) NOT NULL DEFAULT '' COMMENT '电子邮箱',
  `address` varchar(128) NOT NULL DEFAULT '' COMMENT '地址',
  `headportrait` varchar(128) NOT NULL DEFAULT '' COMMENT '头像',
  `time` timestamp NOT NULL DEFAULT current_timestamp() COMMENT '添加时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `rc_account`
--
ALTER TABLE `rc_account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_code`
--
ALTER TABLE `rc_code`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_condition`
--
ALTER TABLE `rc_condition`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_conditionparam`
--
ALTER TABLE `rc_conditionparam`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_currency`
--
ALTER TABLE `rc_currency`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_deallog`
--
ALTER TABLE `rc_deallog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_entrust`
--
ALTER TABLE `rc_entrust`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_funds`
--
ALTER TABLE `rc_funds`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_menu`
--
ALTER TABLE `rc_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_msg`
--
ALTER TABLE `rc_msg`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_order`
--
ALTER TABLE `rc_order`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_period`
--
ALTER TABLE `rc_period`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_robot`
--
ALTER TABLE `rc_robot`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_strategy`
--
ALTER TABLE `rc_strategy`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_ticker`
--
ALTER TABLE `rc_ticker`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rc_user`
--
ALTER TABLE `rc_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `account` (`account`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `rc_account`
--
ALTER TABLE `rc_account`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_code`
--
ALTER TABLE `rc_code`
  MODIFY `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_condition`
--
ALTER TABLE `rc_condition`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_conditionparam`
--
ALTER TABLE `rc_conditionparam`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_currency`
--
ALTER TABLE `rc_currency`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_deallog`
--
ALTER TABLE `rc_deallog`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_entrust`
--
ALTER TABLE `rc_entrust`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_funds`
--
ALTER TABLE `rc_funds`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_menu`
--
ALTER TABLE `rc_menu`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_msg`
--
ALTER TABLE `rc_msg`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_order`
--
ALTER TABLE `rc_order`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_period`
--
ALTER TABLE `rc_period`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_robot`
--
ALTER TABLE `rc_robot`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_strategy`
--
ALTER TABLE `rc_strategy`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_ticker`
--
ALTER TABLE `rc_ticker`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- 使用表AUTO_INCREMENT `rc_user`
--
ALTER TABLE `rc_user`
  MODIFY `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
