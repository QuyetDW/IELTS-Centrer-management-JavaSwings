CREATE DATABASE QLHocVien;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hoc_vien
-- ----------------------------
DROP TABLE IF EXISTS `hoc_vien`;
CREATE TABLE `hoc_vien` (
  `ma_hoc_vien` int(11) NOT NULL AUTO_INCREMENT,
  `ho_ten` varchar(255) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` bit(1) NOT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_hoc_vien`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for khoa_hoc
-- ----------------------------
DROP TABLE IF EXISTS `khoa_hoc`;
CREATE TABLE `khoa_hoc` (
  `ma_khoa_hoc` int(11) NOT NULL AUTO_INCREMENT,
  `ten_khoa_hoc` varchar(255) DEFAULT NULL,
  `mo_ta` varchar(255) DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_khoa_hoc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lop_hoc
-- ----------------------------
DROP TABLE IF EXISTS `lop_hoc`;
CREATE TABLE `lop_hoc` (
  `ma_lop_hoc` int(11) NOT NULL AUTO_INCREMENT,
  `ma_khoa_hoc` int(11) DEFAULT NULL,
  `ma_hoc_vien` int(11) DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `tinh_trang` bit(1) NOT NULL,
  PRIMARY KEY (`ma_lop_hoc`),
  KEY `FK_nsk96k2rdocji4oakgsv51nuq` (`ma_hoc_vien`),
  KEY `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` (`ma_khoa_hoc`),
  CONSTRAINT `FK_nsk96k2rdocji4oakgsv51nuq` FOREIGN KEY (`ma_hoc_vien`) REFERENCES `hoc_vien` (`ma_hoc_vien`),
  CONSTRAINT `FK_pvhxvf4oy1n5bp8tvn8a6tcnu` FOREIGN KEY (`ma_khoa_hoc`) REFERENCES `khoa_hoc` (`ma_khoa_hoc`)
)ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tai_khoan
-- ----------------------------
DROP TABLE IF EXISTS `tai_khoan`;
CREATE TABLE `tai_khoan` (
  `ma_tai_khoan` int(11) NOT NULL AUTO_INCREMENT,
  `ten_dang_nhap` varchar(255) DEFAULT NULL,
  `mat_khau` varchar(255) DEFAULT NULL,
  `tinh_trang` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ma_tai_khoan`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;