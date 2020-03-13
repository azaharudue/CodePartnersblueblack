-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 27, 2020 at 11:17 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fp`
--

-- --------------------------------------------------------

--
-- Table structure for table `donating`
--

CREATE TABLE `donating` (
  `id` int(11) NOT NULL,
  `email` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `iban` varchar(38) NOT NULL,
  `amountToDonate` double NOT NULL,
  `pid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donating`
--

INSERT INTO `donating` (`id`, `email`, `name`, `iban`, `amountToDonate`, `pid`) VALUES
(1, 'alex@uni-due.de', 'Alex', 'DE100000000000000', 2000, 129),
(2, 'mamun@uni-due.de', 'Mamun', 'DE10000000848484', 4000, 126);

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

CREATE TABLE `project` (
  `id` int(100) NOT NULL,
  `emailPS` varchar(255) COLLATE utf8_bin NOT NULL,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `iban` varchar(255) COLLATE utf8_bin NOT NULL,
  `pName` varchar(255) COLLATE utf8_bin NOT NULL,
  `pDescription` varchar(255) COLLATE utf8_bin NOT NULL,
  `pStatus` enum('OPEN','SUCCESSFUL','FAILED') COLLATE utf8_bin NOT NULL,
  `fundingLimit` int(11) NOT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `nameOfRewardPerAmount` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id`, `emailPS`, `name`, `iban`, `pName`, `pDescription`, `pStatus`, `fundingLimit`, `endDate`, `nameOfRewardPerAmount`) VALUES
(122, 'xyz@abc.de', 'myName', 'DE123456789', 'Project Name', 'Some Description', 'FAILED', 20000, '2020-01-30 23:00:00', NULL),
(123, 'sdfgerwgthz', 'ewfgretb', 'rebebtet', 'rebree', 'vberfbvhgsdtfwetzdfwetzdfwe', 'OPEN', 4484848, '2020-01-27 23:00:00', NULL),
(124, 'aerstzu', 'aertzjk,', 'reghjrth5485451', 'ergreh', 'ahiuf7iezhigufkenrg,nro gh', 'OPEN', 15185484, '2020-01-29 23:00:00', NULL),
(125, 'sdghrztruziu', 'dsfsdkuhsduihsu', 'ssd59589562265', 'sdfsdfsdzhf', 'shfsdzgfzusgdf', 'OPEN', 515848458, '2020-01-30 23:00:00', NULL),
(126, 'ewterjtuz', '45w36u576', 'w4wer48488rer', 'reterzeh', 'thtrgutr78gzer', 'OPEN', 4546845, '2020-01-26 23:00:00', NULL),
(127, 'aasdf', 'asdfg', 'asdfg', 'asdfg', 'asdf', 'SUCCESSFUL', 1474, '2020-01-27 23:00:00', NULL),
(128, 'ertrhzuz', 'efshg', 'sf56595', 'dsfsdg', 'arhrzj', 'OPEN', 48484, '2020-01-27 23:00:00', NULL),
(129, 'abc@web.de', 'Dummy1', 'De1234567890', 'Dummy-collection', 'some description', 'OPEN', 12000, '2020-01-27 23:00:00', 'Pizza:10'),
(130, 'alex@uni-due.de', 'Alex', 'DE100000000000000', 'Collect Money For Party', 'here goes some description ', 'OPEN', 123456, '2020-01-23 23:00:00', NULL),
(131, 'dfghj', 'ghj', 'ds48541515', 'abc', 'drtfzguhkjhbn ddfgtzgu', 'OPEN', 40000000, '2020-01-30 23:00:00', 'A:100;B:200'),
(132, 'dfghj', 'dsfgh', 're15484545', 'eggt', 'trhwtttnzn', 'OPEN', 100, '2020-01-27 23:00:00', 'C20'),
(133, 'abc@xyz.de', 'MyName', 'MY123456789', 'DummyProject', 'Some informal description', 'OPEN', 1000, '2020-01-27 23:00:00', 'BS:400');

-- --------------------------------------------------------

--
-- Table structure for table `rewardlist`
--

CREATE TABLE `rewardlist` (
  `nameOfReward` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `perAmount` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `donating`
--
ALTER TABLE `donating`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pid` (`pid`);

--
-- Indexes for table `project`
--
ALTER TABLE `project`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rewardlist`
--
ALTER TABLE `rewardlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `donating`
--
ALTER TABLE `donating`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `project`
--
ALTER TABLE `project`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=134;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donating`
--
ALTER TABLE `donating`
  ADD CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `project` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `rewardlist`
--
ALTER TABLE `rewardlist`
  ADD CONSTRAINT `rewardlist_ibfk_1` FOREIGN KEY (`id`) REFERENCES `project` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
