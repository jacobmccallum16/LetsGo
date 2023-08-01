-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 01, 2023 at 08:19 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `LetsGo`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `driver_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT 0,
  `driver_status` varchar(255) DEFAULT '''inactive''',
  `trips_driven` int(11) DEFAULT 0,
  `times_rated` int(11) DEFAULT 0,
  `driver_safety_rating` float DEFAULT 0,
  `driver_responsibility_rating` float DEFAULT 0,
  `driver_safety_score` float DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driver_id`, `user_id`, `is_active`, `driver_status`, `trips_driven`, `times_rated`, `driver_safety_rating`, `driver_responsibility_rating`, `driver_safety_score`, `created_at`, `updated_at`) VALUES
(2, 2, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-25 01:44:44'),
(3, 3, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-29 02:56:11'),
(4, 4, 1, 'Active', 4, 2, 0.5, 0, 1.5, '2023-07-24 20:57:39', '2023-07-24 21:00:39'),
(5, 5, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(6, 6, 1, 'Active', 1, 1, 2, 2, 5, '2023-07-22 22:30:02', '2023-07-24 21:05:02'),
(7, 7, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(8, 8, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(9, 9, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(10, 10, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(11, 11, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(12, 12, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(13, 13, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(14, 14, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(19, 15, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-29 17:37:44', '2023-07-29 17:37:51');

-- --------------------------------------------------------

--
-- Table structure for table `driver_rating`
--

CREATE TABLE `driver_rating` (
  `driver_rating_id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT '',
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `driver_responsibility_rating` int(11) DEFAULT 0,
  `driver_safety_rating` int(11) DEFAULT 0,
  `driver_safety_score` int(11) DEFAULT 1,
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `rated_by_user_id` int(11) DEFAULT NULL,
  `rated_driver_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `payment_method`
--

CREATE TABLE `payment_method` (
  `payment_method_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `is_valid` tinyint(1) DEFAULT 0,
  `payment_detail` varchar(255) DEFAULT '',
  `payment_method_status` varchar(255) DEFAULT 'inactive',
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rider`
--

CREATE TABLE `rider` (
  `rider_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `is_active` tinyint(1) DEFAULT 0,
  `rider_responsibility_rating` float DEFAULT 0,
  `rider_safety_rating` float DEFAULT 0,
  `rider_safety_score` float DEFAULT 0,
  `rider_status` varchar(255) DEFAULT 'inactive',
  `times_rated` int(11) DEFAULT 0,
  `trips_taken` int(11) DEFAULT 0,
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rider`
--

INSERT INTO `rider` (`rider_id`, `created_at`, `is_active`, `rider_responsibility_rating`, `rider_safety_rating`, `rider_safety_score`, `rider_status`, `times_rated`, `trips_taken`, `updated_at`, `user_id`) VALUES
(2, '2023-07-22 22:30:02', 1, 1.25, 1.75, 4, 'Active', 4, 7, '2023-07-22 22:32:03', 2),
(3, '2023-07-22 22:30:02', 1, 2, 2, 5, 'Active', 3, 4, '2023-07-24 20:20:21', 3),
(4, '2023-07-22 22:30:02', 1, 0.2, 0.6, 1.8, 'Banned', 5, 10, '2023-07-22 22:32:53', 4),
(5, '2023-07-22 22:30:02', 0, 0.5, 2, 3.5, 'Inactive', 2, 2, '2023-07-22 22:36:50', 5),
(6, '2023-07-22 22:30:02', 1, 0.6, 1.3, 2.9, 'Active', 10, 15, '2023-07-22 22:33:52', 6),
(7, '2023-07-22 22:30:02', 1, 0, 0, 0, 'Active', 0, 2, '2023-07-22 22:34:03', 7),
(8, '2023-07-22 22:30:02', 1, 0, 0, 0, 'Active', 0, 0, '2023-08-01 00:29:24', 8),
(9, '2023-07-22 22:30:02', 1, 0, 0, 0, 'Active', 0, 0, '2023-08-01 00:29:38', 9),
(10, '2023-07-22 22:30:02', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-22 22:30:02', 10),
(11, '2023-07-22 22:30:02', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-22 22:30:02', 11),
(12, '2023-07-22 22:30:02', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-22 22:30:02', 12),
(13, '2023-07-22 22:30:02', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-22 22:30:02', 13),
(14, '2023-07-22 22:30:02', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-22 22:30:02', 14),
(15, '2023-07-25 01:26:18', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-25 01:26:18', NULL),
(16, '2023-07-29 17:37:44', 0, 0, 0, 0, 'Inactive', 0, 0, '2023-07-29 17:37:44', 15);

-- --------------------------------------------------------

--
-- Table structure for table `rider_rating`
--

CREATE TABLE `rider_rating` (
  `rider_rating_id` int(11) NOT NULL,
  `comments` varchar(255) DEFAULT '',
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `rated_by_driver` tinyint(1) DEFAULT 0,
  `rider_responsibility_rating` int(11) DEFAULT 0,
  `rider_safety_rating` int(11) DEFAULT 0,
  `rider_safety_score` int(11) DEFAULT 1,
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `rated_by_user_id` int(11) DEFAULT NULL,
  `rated_rider_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `location_end` varchar(255) DEFAULT '',
  `location_start` varchar(255) DEFAULT '',
  `route_distance` float DEFAULT 0,
  `route_duration` float DEFAULT 0,
  `route_image_source` varchar(255) DEFAULT '',
  `route_status` varchar(255) DEFAULT 'inactive',
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_id`, `created_at`, `location_end`, `location_start`, `route_distance`, `route_duration`, `route_image_source`, `route_status`, `updated_at`) VALUES
(1, '2023-07-28 08:33:35', 'Douglas College - New West', 'Douglas College - Coquitlam', 16.1, 28, 'route1.png', 'Active', '2023-07-28 08:33:35'),
(2, '2023-07-22 20:44:48', 'Douglas College - Coquitlam', 'Douglas College - New West', 17.3, 31, 'route2.png', 'Inactive', '2023-07-22 20:44:48');

-- --------------------------------------------------------

--
-- Table structure for table `trip`
--

CREATE TABLE `trip` (
  `trip_id` int(11) NOT NULL,
  `arrival_time` time DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `date` date DEFAULT NULL,
  `departure_time` time DEFAULT NULL,
  `seats_available` int(11) DEFAULT 0,
  `seats_used` int(11) DEFAULT 0,
  `trip_image_source` varchar(255) DEFAULT '',
  `trip_status` varchar(255) DEFAULT 'planned',
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `route_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`trip_id`, `arrival_time`, `created_at`, `date`, `departure_time`, `seats_available`, `seats_used`, `trip_image_source`, `trip_status`, `updated_at`, `route_id`, `driver_id`, `vehicle_id`) VALUES
(10, '12:28:00', '2023-07-31 21:55:47', '2023-07-26', '12:00:00', 0, 0, '', 'Planned', '2023-07-31 21:55:47', 1, 4, NULL),
(12, '23:38:00', '2023-07-25 06:07:50', '2023-07-27', '23:10:00', 0, 0, '', 'Requested', '2023-07-25 06:07:50', 1, NULL, NULL),
(13, '12:58:00', '2023-07-25 06:13:22', '2023-07-26', '12:30:00', 0, 0, '', 'Planned', '2023-07-25 06:13:22', 1, NULL, NULL),
(17, '22:43:00', '2023-07-25 06:24:45', '2023-07-27', '22:15:00', 0, 0, '', 'Planned', '2023-07-25 06:24:45', 1, NULL, NULL),
(19, '12:28:00', '2023-07-31 21:55:54', '2023-07-26', '12:00:00', 0, 0, '', 'Planned', '2023-07-31 21:55:54', 1, 2, NULL),
(20, '23:28:00', '2023-07-29 07:30:56', '2023-07-26', '23:00:00', 0, 0, '', 'Planned', '2023-07-29 07:30:56', 1, 3, NULL),
(21, '12:58:00', '2023-07-29 02:55:43', '2023-07-31', '12:30:00', 0, 0, '', 'Planned', '2023-07-29 02:55:43', 1, NULL, NULL),
(22, '12:28:00', '2023-07-29 07:30:42', '2023-07-21', '12:00:00', 0, 0, '', 'Requested', '2023-07-29 07:30:42', 1, 2, NULL),
(23, '12:31:00', '2023-07-25 07:10:52', '2023-07-27', '12:00:00', 0, 0, '', 'Planned', '2023-07-25 07:10:52', 2, NULL, NULL),
(24, '12:31:00', '2023-07-29 07:30:51', '2023-07-26', '12:00:00', 0, 0, '', 'Planned', '2023-07-29 07:30:51', 2, 6, NULL),
(27, '01:17:00', '2023-07-29 05:37:32', '2023-07-29', '00:49:00', 0, 0, '', 'Requested', '2023-07-29 05:37:32', 1, 3, NULL),
(28, '01:23:00', '2023-07-29 06:33:30', '2023-08-09', '00:55:00', 0, 0, '', 'Planned', '2023-07-29 06:33:30', 1, 3, NULL),
(29, '23:58:00', '2023-07-28 08:18:58', '2023-07-27', '23:30:00', 0, 0, '', 'Completed', '2023-07-28 08:18:58', 1, NULL, NULL),
(30, '02:26:00', '2023-07-29 17:33:14', '2023-07-29', '01:55:00', 0, 0, '', 'Requested', '2023-07-29 17:33:14', 2, 4, NULL),
(31, '02:29:00', '2023-07-28 08:58:36', '2023-07-28', '01:58:00', 0, 0, '', 'Planned', '2023-07-28 08:58:36', 2, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `trip_rider`
--

CREATE TABLE `trip_rider` (
  `trip_rider_id` int(11) NOT NULL,
  `trip_id` int(11) DEFAULT NULL,
  `rider_id` int(11) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trip_rider`
--

INSERT INTO `trip_rider` (`trip_rider_id`, `trip_id`, `rider_id`, `full_name`) VALUES
(2, 20, 2, 'A B'),
(4, 22, 3, 'C D'),
(8, 19, 6, 'I J'),
(14, 19, 8, 'M N'),
(17, 22, 6, 'I J'),
(18, 10, 2, 'A B');

-- --------------------------------------------------------

--
-- Table structure for table `trip_transaction`
--

CREATE TABLE `trip_transaction` (
  `trip_transaction_id` int(11) NOT NULL,
  `base_rate` decimal(8,2) DEFAULT 2.00,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `distance_fee` decimal(8,2) DEFAULT 0.00,
  `duration_fee` decimal(8,2) DEFAULT 0.00,
  `final_price` decimal(8,2) DEFAULT 0.00,
  `is_driver` tinyint(1) DEFAULT 0,
  `multipassenger_adjustment` decimal(8,2) DEFAULT 1.00,
  `multipassenger_discount` decimal(8,2) DEFAULT 0.00,
  `subtotal` decimal(8,2) DEFAULT 0.00,
  `surge_percent` decimal(8,2) DEFAULT 1.00,
  `tax_amount` decimal(8,2) DEFAULT 0.00,
  `tax_rate` decimal(8,2) DEFAULT 1.12,
  `tip_amount` decimal(8,2) DEFAULT 0.00,
  `total` decimal(8,2) DEFAULT 0.00,
  `trip_distance` float DEFAULT 0,
  `trip_duration` float DEFAULT 0,
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `payment_method_id` int(11) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `email` varchar(255) DEFAULT '',
  `first_name` varchar(255) DEFAULT '',
  `is_active` tinyint(1) DEFAULT 0,
  `is_admin` tinyint(1) DEFAULT 0,
  `last_name` varchar(255) DEFAULT '',
  `overall_responsibility_rating` float DEFAULT 0,
  `overall_safety_rating` float DEFAULT 0,
  `overall_safety_score` float DEFAULT 0,
  `password` varchar(255) DEFAULT '',
  `times_rated` int(11) DEFAULT 0,
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `user_status` varchar(255) DEFAULT 'inactive',
  `username` varchar(255) DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `created_at`, `email`, `first_name`, `is_active`, `is_admin`, `last_name`, `overall_responsibility_rating`, `overall_safety_rating`, `overall_safety_score`, `password`, `times_rated`, `updated_at`, `user_status`, `username`) VALUES
(2, '2023-07-22 22:30:02', 'ab@gmail.com', 'A', 0, 0, 'B', 0, 0, 0, 'ab', 0, '2023-07-24 21:57:03', 'Active', 'ab'),
(3, '2023-07-22 22:30:02', 'cd@gmail.com', 'C', 1, 0, 'D', 0, 0, 0, 'cd', 0, '2023-07-25 05:02:29', 'Active', 'cd'),
(4, '2023-07-22 22:30:02', 'ef@gmail.com', 'E', 1, 0, 'F', 0, 0, 0, 'ef', 0, '2023-07-22 22:32:34', 'Active', 'ef'),
(5, '2023-07-22 22:30:02', 'gh@gmail.com', 'G', 1, 0, 'H', 0, 0, 0, 'gh', 0, '2023-07-22 22:33:17', 'Active', 'gh'),
(6, '2023-07-22 22:30:02', 'ij@gmail.com', 'I', 1, 0, 'J', 0, 0, 0, 'ij', 0, '2023-07-22 22:33:39', 'Active', 'ij'),
(7, '2023-07-22 22:30:02', 'kl@gmail.com', 'K', 1, 0, 'L', 0, 0, 0, 'kl', 0, '2023-07-22 22:33:59', 'Active', 'kl'),
(8, '2023-07-22 22:30:02', 'mn@gmail.com', 'M', 0, 0, 'N', 0, 0, 0, 'mn', 0, '2023-07-22 22:30:02', 'Inactive', 'mn'),
(9, '2023-07-22 22:30:02', 'op@gmail.com', 'O', 0, 0, 'P', 0, 0, 0, 'op', 0, '2023-07-22 22:30:02', 'Inactive', 'op'),
(10, '2023-07-22 22:30:02', 'qr@gmail.com', 'Q', 0, 0, 'R', 0, 0, 0, 'qr', 0, '2023-07-22 22:30:02', 'Inactive', 'qr'),
(11, '2023-07-22 22:30:02', 'st@gmail.com', 'S', 0, 0, 'T', 0, 0, 0, 'st', 0, '2023-07-22 22:30:02', 'Inactive', 'st'),
(12, '2023-07-22 22:30:02', 'uv@gmail.com', 'U', 0, 0, 'V', 0, 0, 0, 'uv', 0, '2023-07-22 22:30:02', 'Inactive', 'uv'),
(13, '2023-07-22 22:30:02', 'wx@gmail.com', 'W', 0, 0, 'X', 0, 0, 0, 'wx', 0, '2023-07-22 22:30:02', 'Inactive', 'wx'),
(14, '2023-07-22 22:30:02', 'yz@gmail.com', 'Y', 0, 0, 'Z', 0, 0, 0, 'yz', 0, '2023-07-22 22:30:02', 'Inactive', 'yz'),
(15, '2023-07-29 17:37:44', 'aa@gmail.com', 'A', 0, 0, 'A', 0, 0, 0, 'aa', 0, '2023-07-29 17:37:44', 'active', 'aa');

-- --------------------------------------------------------

--
-- Table structure for table `user_route`
--

CREATE TABLE `user_route` (
  `user_id` int(11) NOT NULL,
  `route_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user_trip`
--

CREATE TABLE `user_trip` (
  `user_id` int(11) NOT NULL,
  `trip_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE `vehicle` (
  `vehicle_id` int(11) NOT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `vehicle_status` varchar(255) DEFAULT '''Inactive''',
  `primary_vehicle` tinyint(1) DEFAULT 0,
  `year` int(11) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `color_hex_code` varchar(255) DEFAULT '999999',
  `seats_total` int(11) DEFAULT 0,
  `seats_available` int(11) DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`vehicle_id`, `driver_id`, `vehicle_status`, `primary_vehicle`, `year`, `make`, `model`, `color`, `color_hex_code`, `seats_total`, `seats_available`, `created_at`, `updated_at`) VALUES
(6, 3, 'Inactive', 0, 2022, 'Volkswagen', 'Golf', 'Black', '#121212', 5, 2, '2023-08-01 05:08:34', '2023-08-01 05:08:34'),
(7, 3, 'Inactive', 0, 2020, 'Toyota', 'Camry', 'Red', '#e93a3a', 5, 2, '2023-08-01 04:35:03', '2023-08-01 04:35:03'),
(8, 3, 'Inactive', 0, 2015, 'Honda', 'Civic', 'Blue', '#729ff8', 5, 2, '2023-08-01 04:35:20', '2023-08-01 04:35:20'),
(9, 19, 'Active', 0, 2020, 'Ford', 'Focus', 'Purple', '#7322ec', 5, 2, '2023-08-01 05:10:26', '2023-08-01 05:10:26'),
(13, 2, 'Active', 0, 2022, 'Chevy', 'Bolt', 'Gray', '#bdbdbc', 5, 2, '2023-08-01 05:32:13', '2023-08-01 05:32:13'),
(14, 2, 'Active', 1, 2022, 'Chevy', 'Volt', 'Silver', '#e6e6e1', 5, 2, '2023-08-01 05:31:38', '2023-08-01 05:31:38');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`driver_id`),
  ADD UNIQUE KEY `UK_g3oju5uudgl1cct873m6f2bfy` (`user_id`);

--
-- Indexes for table `driver_rating`
--
ALTER TABLE `driver_rating`
  ADD PRIMARY KEY (`driver_rating_id`),
  ADD KEY `FKehmg8k2yll3hpj3xw3jlk773g` (`rated_by_user_id`),
  ADD KEY `FKebtsy6wq7w321mwne1y2dvmvh` (`rated_driver_id`),
  ADD KEY `FKmcvk090lkrkbdjqd2auxb0fb9` (`trip_id`);

--
-- Indexes for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD PRIMARY KEY (`payment_method_id`),
  ADD KEY `FK9qgi86n91j5kxnymanelaa1ag` (`user_id`);

--
-- Indexes for table `rider`
--
ALTER TABLE `rider`
  ADD PRIMARY KEY (`rider_id`),
  ADD UNIQUE KEY `UK_tou6imtc4gdyru9biscat4rvg` (`user_id`);

--
-- Indexes for table `rider_rating`
--
ALTER TABLE `rider_rating`
  ADD PRIMARY KEY (`rider_rating_id`),
  ADD KEY `FK7tyae0obyl02me7pdl3k8p074` (`rated_by_user_id`),
  ADD KEY `FKektnq3mebjm329m8rb353x7yy` (`rated_rider_id`),
  ADD KEY `FKckjc26kh7i3yqjnkk80y9cjio` (`trip_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `trip`
--
ALTER TABLE `trip`
  ADD PRIMARY KEY (`trip_id`),
  ADD KEY `FKeva4adpyk6glllffnw5ypj20j` (`route_id`),
  ADD KEY `FKpuhkx68hnwy4by2b0onybv5x1` (`driver_id`),
  ADD KEY `FKrji8htecrp06ao6s7nfubswnr` (`vehicle_id`);

--
-- Indexes for table `trip_rider`
--
ALTER TABLE `trip_rider`
  ADD PRIMARY KEY (`trip_rider_id`);

--
-- Indexes for table `trip_transaction`
--
ALTER TABLE `trip_transaction`
  ADD PRIMARY KEY (`trip_transaction_id`),
  ADD KEY `FKf7pq1slnpy2mcjbcrio80900f` (`payment_method_id`),
  ADD KEY `FK1m1i2ec938fk6pdkpmfmelvnx` (`route_id`),
  ADD KEY `FK6ech88e57mvsp5v2f4r1ljebw` (`trip_id`),
  ADD KEY `FKnflss0ox1w25xyriiul0ymrt7` (`user_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_route`
--
ALTER TABLE `user_route`
  ADD PRIMARY KEY (`user_id`,`route_id`),
  ADD KEY `FKb4iue46yjto7b5hcge3kak3iu` (`route_id`);

--
-- Indexes for table `user_trip`
--
ALTER TABLE `user_trip`
  ADD PRIMARY KEY (`user_id`,`trip_id`),
  ADD KEY `FKh2rnctmi0t9t8clnbi64x68yo` (`trip_id`);

--
-- Indexes for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD PRIMARY KEY (`vehicle_id`),
  ADD KEY `FKdpor9ohov2f3optwe7twe49tt` (`driver_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `driver`
--
ALTER TABLE `driver`
  MODIFY `driver_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `driver_rating`
--
ALTER TABLE `driver_rating`
  MODIFY `driver_rating_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `payment_method_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rider`
--
ALTER TABLE `rider`
  MODIFY `rider_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `rider_rating`
--
ALTER TABLE `rider_rating`
  MODIFY `rider_rating_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `trip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `trip_rider`
--
ALTER TABLE `trip_rider`
  MODIFY `trip_rider_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `trip_transaction`
--
ALTER TABLE `trip_transaction`
  MODIFY `trip_transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicle_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `FKkux9gqt7e9mh4rd4oo4i5ov0f` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `driver_rating`
--
ALTER TABLE `driver_rating`
  ADD CONSTRAINT `FKebtsy6wq7w321mwne1y2dvmvh` FOREIGN KEY (`rated_driver_id`) REFERENCES `driver` (`driver_id`),
  ADD CONSTRAINT `FKehmg8k2yll3hpj3xw3jlk773g` FOREIGN KEY (`rated_by_user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKmcvk090lkrkbdjqd2auxb0fb9` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

--
-- Constraints for table `payment_method`
--
ALTER TABLE `payment_method`
  ADD CONSTRAINT `FK9qgi86n91j5kxnymanelaa1ag` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `rider`
--
ALTER TABLE `rider`
  ADD CONSTRAINT `FK1r3koghordb7ngou3f7n262hg` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `rider_rating`
--
ALTER TABLE `rider_rating`
  ADD CONSTRAINT `FK7tyae0obyl02me7pdl3k8p074` FOREIGN KEY (`rated_by_user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKckjc26kh7i3yqjnkk80y9cjio` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`),
  ADD CONSTRAINT `FKektnq3mebjm329m8rb353x7yy` FOREIGN KEY (`rated_rider_id`) REFERENCES `rider` (`rider_id`);

--
-- Constraints for table `trip`
--
ALTER TABLE `trip`
  ADD CONSTRAINT `FKeva4adpyk6glllffnw5ypj20j` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
  ADD CONSTRAINT `FKpuhkx68hnwy4by2b0onybv5x1` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`),
  ADD CONSTRAINT `FKrji8htecrp06ao6s7nfubswnr` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`vehicle_id`);

--
-- Constraints for table `trip_transaction`
--
ALTER TABLE `trip_transaction`
  ADD CONSTRAINT `FK1m1i2ec938fk6pdkpmfmelvnx` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
  ADD CONSTRAINT `FK6ech88e57mvsp5v2f4r1ljebw` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`),
  ADD CONSTRAINT `FKf7pq1slnpy2mcjbcrio80900f` FOREIGN KEY (`payment_method_id`) REFERENCES `payment_method` (`payment_method_id`),
  ADD CONSTRAINT `FKnflss0ox1w25xyriiul0ymrt7` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_route`
--
ALTER TABLE `user_route`
  ADD CONSTRAINT `FKb4iue46yjto7b5hcge3kak3iu` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`),
  ADD CONSTRAINT `FKo697kascom9v6nhdwvdcib3q4` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_trip`
--
ALTER TABLE `user_trip`
  ADD CONSTRAINT `FK97hmjkqd2hgg1lmd4vctnsxob` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKh2rnctmi0t9t8clnbi64x68yo` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

--
-- Constraints for table `vehicle`
--
ALTER TABLE `vehicle`
  ADD CONSTRAINT `FKdpor9ohov2f3optwe7twe49tt` FOREIGN KEY (`driver_id`) REFERENCES `driver` (`driver_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
