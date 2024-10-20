-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 04, 2024 at 12:31 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_bansos001`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_anggota`
--

CREATE TABLE `tbl_anggota` (
  `kta` varchar(6) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `alamat` text DEFAULT NULL,
  `no_telp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_anggota`
--

INSERT INTO `tbl_anggota` (`kta`, `nama`, `alamat`, `no_telp`) VALUES
('198001', 'Muklis Anwar', 'Cipayung', '081232311223'),
('198002', 'Zulhi Faisal', 'Cipayung', '089876452732'),
('198003', 'Ahmad Solehudin', 'Cipayung', '081223227766'),
('198004', 'Muhammad Nur Yislam', 'Cipayung', '081234276574'),
('198005', 'Zaenal A', 'Cipayung', '08122121391'),
('198006', 'Akmal Ibrahim', 'Cipayung', '081121923811'),
('198007', 'Mushoffa', 'Cipayung', '081213132233'),
('198008', 'Eko W', 'Cipayung', '085313132131'),
('198009', 'Fadil Ahmad', 'Cipayung', '081231339921'),
('198010', 'Arfanul Khusna', 'Cipayung', '082412313312');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobot`
--

CREATE TABLE `tbl_bobot` (
  `kta` varchar(6) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `id_subkriteria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_bobot`
--

INSERT INTO `tbl_bobot` (`kta`, `id_kriteria`, `id_subkriteria`) VALUES
('K10001', 3, 6),
('K10001', 4, 12),
('K10002', 3, 8),
('K10002', 1, 1),
('K10002', 4, 13),
('K10003', 1, 2),
('K10003', 3, 8),
('K10003', 4, 15),
('K10004', 1, 1),
('K10004', 3, 8),
('K10004', 4, 14),
('K10001', 1, 3),
('K10001', 2, 17),
('K10001', 5, 22),
('K10002', 2, 17),
('K10002', 5, 22),
('K10003', 2, 17),
('K10003', 5, 22),
('K10004', 2, 17),
('K10004', 5, 22),
('P1001', 1, 1),
('P1001', 2, 19),
('P1001', 4, 13),
('P1002', 1, 4),
('P1002', 2, 20),
('P1002', 3, 8),
('P1002', 4, 12),
('P1003', 1, 3),
('P1003', 2, 20),
('P1003', 3, 10),
('P1003', 4, 12),
('P1004', 1, 1),
('P1004', 2, 18),
('P1004', 3, 10),
('P1004', 4, 13),
('P1001', 3, 8),
('KR001', 2, 19),
('KR001', 3, 9),
('KR001', 4, 13),
('KR002', 1, 2),
('KR002', 2, 19),
('KR002', 3, 8),
('KR002', 4, 15),
('KR003', 1, 4),
('KR003', 3, 10),
('KR003', 2, 20),
('KR003', 4, 14),
('KR004', 1, 2),
('KR004', 2, 18),
('KR004', 3, 6),
('KR004', 4, 13),
('KR001', 1, 2),
('DT001', 1, 2),
('DT001', 2, 19),
('DT001', 3, 8),
('DT001', 4, 15),
('DT002', 1, 1),
('DT002', 2, 17),
('DT002', 3, 6),
('DT002', 4, 13),
('DT003', 1, 3),
('DT003', 2, 18),
('DT003', 3, 9),
('DT003', 4, 15),
('DT004', 1, 5),
('DT004', 2, 17),
('DT004', 3, 6),
('DT004', 4, 14),
('198001', 1, 1),
('198001', 2, 18),
('198001', 3, 9),
('198001', 4, 12),
('198002', 1, 1),
('198002', 2, 19),
('198002', 3, 11),
('198002', 4, 12),
('198003', 1, 4),
('198003', 2, 21),
('198003', 3, 8),
('198003', 4, 12),
('198004', 1, 3),
('198004', 2, 19),
('198004', 3, 9),
('198004', 4, 14),
('198005', 1, 1),
('198005', 2, 19),
('198005', 3, 10),
('198005', 4, 13),
('198006', 1, 1),
('198006', 2, 18),
('198006', 3, 8),
('198006', 4, 14),
('198007', 1, 1),
('198007', 3, 8),
('198007', 2, 20),
('198007', 4, 16),
('198008', 1, 3),
('198008', 2, 21),
('198008', 3, 9),
('198008', 4, 13),
('198009', 1, 3),
('198009', 2, 19),
('198009', 3, 8),
('198009', 4, 12),
('198010', 1, 1),
('198010', 2, 19),
('198010', 3, 10),
('198010', 4, 12);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobotkriteria`
--

CREATE TABLE `tbl_bobotkriteria` (
  `id_kriteria1` int(11) NOT NULL,
  `id_kriteria2` int(11) NOT NULL,
  `bobot_kriteria` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_bobotkriteria`
--

INSERT INTO `tbl_bobotkriteria` (`id_kriteria1`, `id_kriteria2`, `bobot_kriteria`) VALUES
(1, 1, 1),
(2, 1, 3),
(1, 2, 0.3333333333333333),
(2, 2, 1),
(3, 1, 3),
(1, 3, 0.3333333333333333),
(3, 2, 5),
(2, 3, 0.2),
(3, 3, 1),
(4, 1, 3),
(1, 4, 0.3333333333333333),
(4, 2, 3),
(2, 4, 0.3333333333333333),
(4, 3, 3),
(3, 4, 0.3333333333333333),
(4, 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobotsubkriteria`
--

CREATE TABLE `tbl_bobotsubkriteria` (
  `id_subkriteria1` int(11) NOT NULL,
  `id_subkriteria2` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `bobot_subkriteria` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_bobotsubkriteria`
--

INSERT INTO `tbl_bobotsubkriteria` (`id_subkriteria1`, `id_subkriteria2`, `id_kriteria`, `bobot_subkriteria`) VALUES
(1, 1, 1, 1),
(1, 2, 1, 3),
(2, 1, 1, 0.3333333333333333),
(1, 3, 1, 3),
(3, 1, 1, 0.3333333333333333),
(2, 2, 1, 1),
(2, 3, 1, 3),
(3, 2, 1, 0.3333333333333333),
(1, 4, 1, 5),
(4, 1, 1, 0.2),
(2, 4, 1, 5),
(4, 2, 1, 0.2),
(3, 3, 1, 1),
(3, 4, 1, 3),
(4, 3, 1, 0.3333333333333333),
(4, 4, 1, 1),
(6, 6, 3, 1),
(6, 8, 3, 3),
(8, 6, 3, 0.3333333333333333),
(6, 9, 3, 5),
(9, 6, 3, 0.2),
(6, 10, 3, 7),
(10, 6, 3, 0.14285714285714285),
(6, 11, 3, 9),
(11, 6, 3, 0.1111111111111111),
(8, 8, 3, 1),
(8, 9, 3, 3),
(9, 8, 3, 0.3333333333333333),
(8, 10, 3, 5),
(10, 8, 3, 0.2),
(8, 11, 3, 7),
(11, 8, 3, 0.14285714285714285),
(9, 9, 3, 1),
(9, 10, 3, 3),
(10, 9, 3, 0.3333333333333333),
(9, 11, 3, 5),
(11, 9, 3, 0.2),
(10, 10, 3, 1),
(10, 11, 3, 3),
(11, 10, 3, 0.3333333333333333),
(11, 11, 3, 1),
(12, 12, 4, 1),
(12, 13, 4, 3),
(13, 12, 4, 0.3333333333333333),
(12, 14, 4, 5),
(14, 12, 4, 0.2),
(12, 15, 4, 7),
(15, 12, 4, 0.14285714285714285),
(12, 16, 4, 7),
(16, 12, 4, 0.14285714285714285),
(13, 13, 4, 1),
(13, 14, 4, 3),
(14, 13, 4, 0.3333333333333333),
(13, 15, 4, 5),
(15, 13, 4, 0.2),
(13, 16, 4, 5),
(16, 13, 4, 0.2),
(14, 14, 4, 1),
(14, 15, 4, 3),
(15, 14, 4, 0.3333333333333333),
(14, 16, 4, 5),
(16, 14, 4, 0.2),
(15, 15, 4, 1),
(15, 16, 4, 3),
(16, 15, 4, 0.3333333333333333),
(16, 16, 4, 1),
(17, 17, 2, 1),
(17, 20, 2, 3),
(20, 17, 2, 0.3333333333333333),
(17, 21, 2, 3),
(21, 17, 2, 0.3333333333333333),
(18, 17, 2, 3),
(17, 18, 2, 0.3333333333333333),
(18, 18, 2, 1),
(18, 19, 2, 3),
(19, 18, 2, 0.3333333333333333),
(19, 20, 2, 3),
(20, 19, 2, 0.3333333333333333),
(18, 21, 2, 3),
(21, 18, 2, 0.3333333333333333),
(19, 17, 2, 3),
(17, 19, 2, 0.3333333333333333),
(19, 21, 2, 3),
(21, 19, 2, 0.3333333333333333),
(20, 18, 2, 3),
(18, 20, 2, 0.3333333333333333),
(20, 20, 2, 1),
(20, 21, 2, 3),
(21, 20, 2, 0.3333333333333333);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_hasil`
--

CREATE TABLE `tbl_hasil` (
  `kta` varchar(6) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_hasil`
--

INSERT INTO `tbl_hasil` (`kta`, `nilai`) VALUES
('198001', 0.30106071715922095),
('198002', 0.25230871698567753),
('198003', 0.285672859661415),
('198004', 0.18816551653353628),
('198005', 0.2077694526527501),
('198006', 0.2463992313206676),
('198007', 0.17879203123186876),
('198008', 0.18632797539155876),
('198009', 0.32842272726695027),
('198010', 0.27049081541105646),
('DT001', 0.20563466113179543),
('DT002', 0.3234916699012634),
('DT003', 0.1530139835591008),
('DT004', 0.27191457273027586),
('K10001', 0.37077718031986867),
('K10002', 0.2689453746251267),
('K10003', 0.19344281890857715),
('K10004', 0.23420738909744931),
('KR001', 0.2327263171864779),
('KR002', 0.20563466113179543),
('KR003', 0.13922943162627305),
('KR004', 0.33007047491004493),
('P1001', 0.2811372168483449),
('P1002', 0.31005654410785155),
('P1003', 0.24286312084813713),
('P1004', 0.2077694526527501);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kriteria`
--

CREATE TABLE `tbl_kriteria` (
  `id_kriteria` int(11) NOT NULL,
  `nama_kriteria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`id_kriteria`, `nama_kriteria`) VALUES
(1, 'Usia'),
(2, 'Pekerjaan'),
(3, 'Jumlah Tanggungan'),
(4, 'Penghasilan');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nilaibobotkriteria`
--

CREATE TABLE `tbl_nilaibobotkriteria` (
  `id_kriteria` int(11) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_nilaibobotkriteria`
--

INSERT INTO `tbl_nilaibobotkriteria` (`id_kriteria`, `nilai`) VALUES
(1, 0.07731958762886597),
(2, 0.17525773195876287),
(3, 0.36082474226804123),
(4, 0.3865979381443299);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nilaibobotsubkriteria`
--

CREATE TABLE `tbl_nilaibobotsubkriteria` (
  `id_subkriteria` int(11) NOT NULL,
  `id_kriteria` int(11) NOT NULL,
  `nilai` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_nilaibobotsubkriteria`
--

INSERT INTO `tbl_nilaibobotsubkriteria` (`id_subkriteria`, `id_kriteria`, `nilai`) VALUES
(1, 1, 0.35390199637023595),
(2, 1, 0.28130671506352084),
(3, 1, 0.15426497277676948),
(4, 1, 0.07441016333938294),
(5, 1, 0.13611615245009073),
(17, 2, 0.19999999999999998),
(18, 2, 0.2695652173913043),
(19, 2, 0.26956521739130435),
(20, 2, 0.19999999999999998),
(21, 2, 0.06086956521739129),
(6, 3, 0.43607065728999395),
(8, 3, 0.28489949609612936),
(9, 3, 0.16628827731325102),
(10, 3, 0.08156597818262364),
(11, 3, 0.031175591118002107),
(12, 4, 0.43055803173471213),
(13, 4, 0.2683187733998931),
(14, 4, 0.17846318416830098),
(15, 4, 0.08753788554109469),
(16, 4, 0.035122125155999294);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_subkriteria`
--

CREATE TABLE `tbl_subkriteria` (
  `id_subkriteria` int(11) NOT NULL,
  `nama_subkriteria` varchar(15) NOT NULL,
  `id_kriteria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_subkriteria`
--

INSERT INTO `tbl_subkriteria` (`id_subkriteria`, `nama_subkriteria`, `id_kriteria`) VALUES
(1, 'Sangat Baik', 1),
(2, 'Baik', 1),
(3, 'Cukup', 1),
(4, 'Kurang', 1),
(5, 'Sangat Kurang', 1),
(6, 'Sangat Baik', 3),
(8, 'Baik', 3),
(9, 'Cukup', 3),
(10, 'Kurang', 3),
(11, 'Sangat Kurang', 3),
(12, 'Sangat Baik', 4),
(13, 'Baik', 4),
(14, 'Cukup', 4),
(15, 'Kurang', 4),
(16, 'Sangat Kurang', 4),
(17, 'Sangat Baik', 2),
(18, 'Baik', 2),
(19, 'Cukup', 2),
(20, 'Kurang', 2),
(21, 'Sangat Kurang', 2),
(27, 'Sangat Baik', 6),
(28, 'Baik', 6),
(29, 'Cukup', 6),
(30, 'Kurang', 6),
(31, 'Sangat Kurang', 6);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_values`
--

CREATE TABLE `tbl_values` (
  `max_eigen_value` double NOT NULL,
  `inconsistency_index` double NOT NULL,
  `random_inconsistency` double NOT NULL,
  `inconsistency_ratio` double NOT NULL,
  `flag` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `tbl_values`
--

INSERT INTO `tbl_values` (`max_eigen_value`, `inconsistency_index`, `random_inconsistency`, `inconsistency_ratio`, `flag`, `id`) VALUES
(4.4955782519391425, 0.16519275064638084, 0.9, 0.18354750071820092, 1, 0),
(5.549356589826642, 0.13733914745666054, 1.12, 0.12262423880058976, 2, 1),
(6.507657786185153, 0.37691444654628814, 1.12, 0.3365307558449001, 2, 2),
(5.237475251487309, 0.05936881287182727, 1.12, 0.053007868635560056, 2, 3),
(5.3281218034055975, 0.08203045085139937, 1.12, 0.07324147397446372, 2, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_anggota`
--
ALTER TABLE `tbl_anggota`
  ADD PRIMARY KEY (`kta`);

--
-- Indexes for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  ADD PRIMARY KEY (`id_kriteria`);

--
-- Indexes for table `tbl_subkriteria`
--
ALTER TABLE `tbl_subkriteria`
  ADD PRIMARY KEY (`id_subkriteria`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
  MODIFY `id_kriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `tbl_subkriteria`
--
ALTER TABLE `tbl_subkriteria`
  MODIFY `id_subkriteria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
