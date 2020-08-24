ALTER TABLE `classfiy_contact`.`file`
MODIFY COLUMN `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '文件id' FIRST,
MODIFY COLUMN `userid` int(0) NOT NULL COMMENT '上传文件者id' AFTER `id`,
MODIFY COLUMN `content` longblob NOT NULL COMMENT '二进制文件' AFTER `userid`,
MODIFY COLUMN `classfiy_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件类别\r\n0 - 租赁合同\r\n1 -  买卖合同\r\n2 - 劳动合同' AFTER `content`,
MODIFY COLUMN `filename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '文件名字' AFTER `classfiy_field`;

ALTER TABLE `classfiy_contact`.`user`
CHANGE COLUMN `username` `user_name` int(0) NOT NULL COMMENT '用户名' AFTER `id`,
MODIFY COLUMN `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户id' FIRST;