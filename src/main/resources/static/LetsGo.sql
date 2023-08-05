-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 05, 2023 at 08:48 PM
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
  `driver_status` varchar(255) DEFAULT 'Inactive',
  `trips_driven` int(11) DEFAULT 0,
  `times_rated` int(11) DEFAULT 0,
  `driver_safety_score` float DEFAULT 0,
  `driver_safety_rating` float DEFAULT 0,
  `driver_responsibility_rating` float DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`driver_id`, `user_id`, `is_active`, `driver_status`, `trips_driven`, `times_rated`, `driver_safety_score`, `driver_safety_rating`, `driver_responsibility_rating`, `created_at`, `updated_at`) VALUES
(2, 2, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-25 01:44:44'),
(3, 3, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-29 02:56:11'),
(4, 4, 1, 'Active', 4, 2, 1.5, 0.5, 0, '2023-07-24 20:57:39', '2023-07-24 21:00:39'),
(5, 5, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(6, 6, 1, 'Active', 1, 1, 5, 2, 2, '2023-07-22 22:30:02', '2023-07-24 21:05:02'),
(7, 7, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(8, 8, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(9, 9, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(10, 10, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(11, 11, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(12, 12, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(13, 13, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(14, 14, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(19, 15, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-29 17:37:44', '2023-07-29 17:37:51'),
(21, 17, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-04 07:37:08', '2023-08-04 07:37:08'),
(22, 18, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-04 07:39:20', '2023-08-04 07:39:20'),
(23, 19, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-04 22:00:31', '2023-08-04 22:00:31'),
(24, 20, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-05 04:28:38', '2023-08-05 04:28:38'),
(25, 21, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:29:43', '2023-08-05 05:05:40'),
(26, 22, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:30:34', '2023-08-05 04:30:45'),
(27, 23, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-05 05:06:19', '2023-08-05 05:15:43'),
(28, 24, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 05:29:02', '2023-08-05 05:29:16');

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
-- Table structure for table `driver_trip_transaction`
--

CREATE TABLE `driver_trip_transaction` (
  `driver_trip_transaction_id` int(11) NOT NULL,
  `trip_id` int(11) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `driver_trip_transaction_status` varchar(255) DEFAULT '''Planned''',
  `driver_safety_score` float DEFAULT 0,
  `passengers` int(11) DEFAULT 1,
  `passengers_max` int(11) DEFAULT 2,
  `base_rate_duration` decimal(8,2) DEFAULT 1.00,
  `duration_estimated` float DEFAULT 0,
  `duration_actual` float DEFAULT 0,
  `duration_subtotal` decimal(8,2) DEFAULT 0.00,
  `base_rate_distance` decimal(8,2) DEFAULT 1.00,
  `distance_estimated` float DEFAULT 0,
  `distance_actual` float DEFAULT 0,
  `distance_subtotal` decimal(8,2) DEFAULT 0.00,
  `base_rate_multiplier` decimal(8,2) DEFAULT 1.00,
  `base_rate_subtotal` decimal(8,2) DEFAULT 0.00,
  `multi_passenger_multiplier` decimal(8,2) DEFAULT 0.00,
  `multi_passenger_bonus` decimal(8,2) DEFAULT 1.00,
  `multi_passenger_multiplier_max` decimal(8,2) DEFAULT 0.30,
  `multi_passenger_bonus_max` decimal(8,2) DEFAULT 0.00,
  `pre_trip_quote` decimal(8,2) DEFAULT 0.00,
  `pre_trip_quote_max` decimal(8,2) DEFAULT 0.00,
  `tip_amount` decimal(8,2) DEFAULT 0.00,
  `trip_total` decimal(8,2) DEFAULT 0.00,
  `final_total` decimal(8,2) DEFAULT 0.00,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `driver_trip_transaction`
--

INSERT INTO `driver_trip_transaction` (`driver_trip_transaction_id`, `trip_id`, `route_id`, `driver_id`, `vehicle_id`, `first_name`, `last_name`, `full_name`, `driver_trip_transaction_status`, `driver_safety_score`, `passengers`, `passengers_max`, `base_rate_duration`, `duration_estimated`, `duration_actual`, `duration_subtotal`, `base_rate_distance`, `distance_estimated`, `distance_actual`, `distance_subtotal`, `base_rate_multiplier`, `base_rate_subtotal`, `multi_passenger_multiplier`, `multi_passenger_bonus`, `multi_passenger_multiplier_max`, `multi_passenger_bonus_max`, `pre_trip_quote`, `pre_trip_quote_max`, `tip_amount`, `trip_total`, `final_total`, `created_at`, `updated_at`) VALUES
(1, 22, NULL, 2, NULL, 'A', 'B', 'A B', 'Requested', 0, 2, 2, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.10, 2.21, 0.10, 2.21, 24.26, 24.26, 0.00, 0.00, 0.00, '2023-08-02 19:04:00', '2023-08-02 19:04:00'),
(2, 10, NULL, 4, NULL, NULL, NULL, NULL, 'Planned', 0, 1, 5, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 27.56, 0.00, 0.00, 0.00, '2023-08-02 19:48:25', '2023-08-02 19:48:25'),
(3, 19, NULL, 2, NULL, NULL, NULL, NULL, 'Planned', 0, 2, 2, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.10, 2.21, 0.10, 2.21, 24.26, 24.26, 0.00, 0.00, 0.00, '2023-08-02 20:27:32', '2023-08-02 20:27:32'),
(4, 24, NULL, 6, NULL, NULL, NULL, NULL, 'Planned', 0, 1, 2, 0.50, 31, 31, 15.50, 0.50, 17.3, 17.3, 8.65, 1.00, 24.15, 0.00, 0.00, 0.10, 2.41, 24.15, 26.56, 0.00, 0.00, 0.00, '2023-08-02 20:27:36', '2023-08-02 20:27:36'),
(5, 13, NULL, 6, NULL, NULL, NULL, NULL, 'Planned', 0, 2, 2, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.10, 2.21, 0.10, 2.21, 24.26, 24.26, 0.00, 0.00, 0.00, '2023-08-02 20:27:39', '2023-08-02 20:27:39'),
(6, 20, NULL, 3, NULL, NULL, NULL, NULL, 'Planned', 0, 1, 5, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 27.56, 0.00, 0.00, 0.00, '2023-08-02 20:27:43', '2023-08-02 20:27:43'),
(7, 23, NULL, 3, NULL, NULL, NULL, NULL, 'Planned', 0, 1, 5, 0.50, 31, 31, 15.50, 0.50, 17.3, 17.3, 8.65, 1.00, 24.15, 0.00, 0.00, 0.25, 6.04, 24.15, 30.19, 0.00, 0.00, 0.00, '2023-08-02 20:27:47', '2023-08-02 20:27:47'),
(8, 17, NULL, NULL, NULL, NULL, NULL, NULL, 'Cancelled', 0, 0, 6, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 28.67, 0.00, 0.00, 0.00, '2023-08-02 20:28:18', '2023-08-02 20:28:18'),
(9, 12, NULL, NULL, NULL, NULL, NULL, NULL, 'Requested', 0, 0, 6, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 28.67, 0.00, 0.00, 0.00, '2023-08-02 20:28:22', '2023-08-02 20:28:22'),
(10, 29, NULL, NULL, NULL, NULL, NULL, NULL, 'Completed', 0, 0, 6, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 28.67, 0.00, 0.00, 0.00, '2023-08-02 20:28:26', '2023-08-02 20:28:26'),
(11, 31, NULL, NULL, NULL, NULL, NULL, NULL, 'Planned', 0, 0, 6, 0.50, 31, 31, 15.50, 0.50, 17.3, 17.3, 8.65, 1.00, 24.15, 0.00, 0.00, 0.30, 7.24, 24.15, 31.39, 0.00, 0.00, 0.00, '2023-08-02 20:28:29', '2023-08-02 20:28:29'),
(12, 27, NULL, 3, NULL, NULL, NULL, NULL, 'Requested', 0, 2, 5, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.10, 2.21, 0.25, 5.51, 24.26, 27.56, 0.00, 0.00, 0.00, '2023-08-02 20:28:36', '2023-08-02 20:28:36'),
(13, 30, NULL, 4, NULL, NULL, NULL, NULL, 'Requested', 0, 0, 5, 0.50, 31, 31, 15.50, 0.50, 17.3, 17.3, 8.65, 1.00, 24.15, 0.00, 0.00, 0.25, 6.04, 24.15, 30.19, 0.00, 0.00, 0.00, '2023-08-02 20:28:40', '2023-08-02 20:28:40'),
(14, 21, NULL, NULL, NULL, NULL, NULL, NULL, 'Planned', 0, 0, 6, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 28.67, 0.00, 0.00, 0.00, '2023-08-02 20:28:44', '2023-08-02 20:28:44'),
(15, 32, NULL, NULL, NULL, NULL, NULL, NULL, 'Requested', 0, 0, 6, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 28.67, 0.00, 0.00, 0.00, '2023-08-02 20:28:47', '2023-08-02 20:28:47'),
(16, 28, NULL, 3, NULL, NULL, NULL, NULL, 'Planned', 0, 0, 5, 0.50, 28, 28, 14.00, 0.50, 16.1, 16.1, 8.05, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 27.56, 0.00, 0.00, 0.00, '2023-08-02 20:28:51', '2023-08-02 20:28:51');

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
  `user_id` int(11) DEFAULT NULL,
  `is_active` tinyint(1) DEFAULT 0,
  `rider_status` varchar(255) DEFAULT '''Inactive''',
  `trips_taken` int(11) DEFAULT 0,
  `times_rated` int(11) DEFAULT 0,
  `rider_safety_score` float DEFAULT 0,
  `rider_safety_rating` float DEFAULT 0,
  `rider_responsibility_rating` float DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rider`
--

INSERT INTO `rider` (`rider_id`, `user_id`, `is_active`, `rider_status`, `trips_taken`, `times_rated`, `rider_safety_score`, `rider_safety_rating`, `rider_responsibility_rating`, `created_at`, `updated_at`) VALUES
(2, 2, 1, 'Active', 7, 4, 4, 1.75, 1.25, '2023-07-22 22:30:02', '2023-07-22 22:32:03'),
(3, 3, 1, 'Active', 4, 3, 5, 2, 2, '2023-07-22 22:30:02', '2023-07-24 20:20:21'),
(4, 4, 1, 'Banned', 10, 5, 1.8, 0.6, 0.2, '2023-07-22 22:30:02', '2023-07-22 22:32:53'),
(5, 5, 0, 'Inactive', 2, 2, 3.5, 2, 0.5, '2023-07-22 22:30:02', '2023-07-22 22:36:50'),
(6, 6, 1, 'Active', 15, 10, 2.9, 1.3, 0.6, '2023-07-22 22:30:02', '2023-07-22 22:33:52'),
(7, 7, 1, 'Active', 2, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:34:03'),
(8, 8, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-08-01 00:29:24'),
(9, 9, 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-08-01 00:29:38'),
(10, 10, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(11, 11, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(12, 12, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(13, 13, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(14, 14, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(16, 15, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-29 17:37:44', '2023-07-29 17:37:44'),
(18, 17, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-04 07:37:08', '2023-08-04 07:37:08'),
(19, 18, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-04 07:39:20', '2023-08-04 07:39:20'),
(20, 19, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-04 22:00:31', '2023-08-04 22:01:16'),
(21, 20, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:28:38', '2023-08-05 04:28:57'),
(22, 21, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-05 04:29:43', '2023-08-05 05:05:33'),
(23, 22, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:30:34', '2023-08-05 04:30:40'),
(24, 23, 0, 'Inactive', 0, 0, 0, 0, 0, '2023-08-05 05:06:19', '2023-08-05 05:15:38'),
(25, 24, 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 05:29:02', '2023-08-05 05:29:10');

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
-- Table structure for table `rider_trip_transaction`
--

CREATE TABLE `rider_trip_transaction` (
  `rider_trip_transaction_id` int(11) NOT NULL,
  `rider_id` int(11) DEFAULT NULL,
  `trip_id` int(11) DEFAULT NULL,
  `route_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `rider_trip_transaction_status` varchar(255) DEFAULT '''Planned''',
  `rider_safety_score` float DEFAULT 0,
  `passengers` int(11) DEFAULT 1,
  `passengers_max` int(11) DEFAULT 2,
  `base_rate_distance` decimal(8,2) DEFAULT 1.00,
  `distance_estimated` float DEFAULT 0,
  `distance_actual` float DEFAULT 0,
  `distance_subtotal` decimal(8,2) DEFAULT 0.00,
  `base_rate_duration` decimal(8,2) DEFAULT 1.00,
  `duration_estimated` float DEFAULT 0,
  `duration_actual` float DEFAULT 0,
  `duration_subtotal` decimal(8,2) DEFAULT 0.00,
  `base_rate_multiplier` decimal(8,2) DEFAULT 1.00,
  `base_rate_subtotal` decimal(8,2) DEFAULT 0.00,
  `multi_passenger_multiplier` decimal(8,2) DEFAULT 1.00,
  `multi_passenger_discount` decimal(8,2) DEFAULT 1.00,
  `multi_passenger_multiplier_max` decimal(8,2) DEFAULT 1.30,
  `multi_passenger_discount_max` decimal(8,2) DEFAULT 0.00,
  `pre_trip_quote` decimal(8,2) DEFAULT 0.00,
  `pre_trip_quote_max` decimal(8,2) DEFAULT 0.00,
  `trip_total` decimal(8,2) DEFAULT 0.00,
  `tip_amount` decimal(8,2) DEFAULT 0.00,
  `final_total` decimal(8,2) DEFAULT 0.00,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rider_trip_transaction`
--

INSERT INTO `rider_trip_transaction` (`rider_trip_transaction_id`, `rider_id`, `trip_id`, `route_id`, `driver_id`, `first_name`, `last_name`, `full_name`, `rider_trip_transaction_status`, `rider_safety_score`, `passengers`, `passengers_max`, `base_rate_distance`, `distance_estimated`, `distance_actual`, `distance_subtotal`, `base_rate_duration`, `duration_estimated`, `duration_actual`, `duration_subtotal`, `base_rate_multiplier`, `base_rate_subtotal`, `multi_passenger_multiplier`, `multi_passenger_discount`, `multi_passenger_multiplier_max`, `multi_passenger_discount_max`, `pre_trip_quote`, `pre_trip_quote_max`, `trip_total`, `tip_amount`, `final_total`, `created_at`, `updated_at`) VALUES
(22, 3, 22, NULL, NULL, 'C', 'D', 'C D', 'Requested', 5, 0, 6, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 15.44, 0.00, 0.00, 0.00, '2023-08-04 04:43:35', '2023-08-04 04:43:35'),
(23, 6, 22, NULL, NULL, 'I', 'J', 'I J', 'Requested', 2.9, 1, 6, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 15.44, 0.00, 0.00, 0.00, '2023-08-04 04:43:39', '2023-08-04 04:43:39'),
(24, 2, 10, NULL, 4, 'A', 'B', 'A B', 'Planned', 4, 0, 5, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 16.54, 0.00, 0.00, 0.00, '2023-08-04 04:43:52', '2023-08-04 04:43:52'),
(25, 6, 19, NULL, 2, 'I', 'J', 'I J', 'Planned', 2.9, 0, 2, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.10, 2.21, 22.05, 19.85, 0.00, 0.00, 0.00, '2023-08-04 04:44:17', '2023-08-04 04:44:17'),
(26, 8, 19, NULL, 2, 'M', 'N', 'M N', 'Planned', 0, 1, 2, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.10, 2.21, 22.05, 19.85, 0.00, 0.00, 0.00, '2023-08-04 04:44:21', '2023-08-04 04:44:21'),
(27, 3, 24, NULL, 6, 'C', 'D', 'C D', 'Planned', 5, 0, 2, 0.50, 17.3, 17.3, 8.65, 0.50, 31, 31, 15.50, 1.00, 24.15, 0.00, 0.00, 0.10, 2.41, 24.15, 21.73, 0.00, 0.00, 0.00, '2023-08-04 04:44:34', '2023-08-04 04:44:34'),
(28, 9, 13, NULL, 6, 'O', 'P', 'O P', 'Planned', 0, 1, 2, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.10, 2.21, 22.05, 19.85, 0.00, 0.00, 0.00, '2023-08-04 04:44:57', '2023-08-04 04:44:57'),
(29, 8, 13, NULL, 6, 'M', 'N', 'M N', 'Planned', 0, 1, 2, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.10, 2.21, 22.05, 19.85, 0.00, 0.00, 0.00, '2023-08-04 04:45:26', '2023-08-04 04:45:26'),
(30, 2, 20, NULL, 3, 'A', 'B', 'A B', 'Planned', 4, 0, 5, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 16.54, 0.00, 0.00, 0.00, '2023-08-04 04:45:35', '2023-08-04 04:45:35'),
(32, 2, 27, NULL, 3, 'A', 'B', 'A B', 'Requested', 4, 0, 5, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 16.54, 0.00, 0.00, 0.00, '2023-08-04 04:58:07', '2023-08-04 04:58:07'),
(33, 6, 27, NULL, 3, 'I', 'J', 'I J', 'Requested', 2.9, 1, 5, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.25, 5.51, 22.05, 16.54, 0.00, 0.00, 0.00, '2023-08-04 04:58:09', '2023-08-04 04:58:09'),
(36, 20, 29, NULL, NULL, 'Rider', '1', 'Rider 1', 'Completed', 0, 0, 6, 0.50, 16.1, 16.1, 8.05, 0.50, 28, 28, 14.00, 1.00, 22.05, 0.00, 0.00, 0.30, 6.62, 22.05, 15.44, 0.00, 0.00, 0.00, '2023-08-04 23:57:45', '2023-08-04 23:57:45'),
(37, 20, 31, NULL, NULL, 'Rider', '1', 'Rider 1', 'Planned', 0, 0, 6, 0.50, 17.3, 17.3, 8.65, 0.50, 31, 31, 15.50, 1.00, 24.15, 0.00, 0.00, 0.30, 7.24, 24.15, 16.90, 0.00, 0.00, 0.00, '2023-08-04 23:57:51', '2023-08-04 23:57:51');

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
  `route_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `trip_status` varchar(255) DEFAULT 'Planned',
  `passengers_max` int(11) DEFAULT 2,
  `passengers` int(11) DEFAULT 0,
  `seats_left` int(11) DEFAULT 0,
  `departure_time` datetime DEFAULT NULL,
  `arrival_time` datetime DEFAULT NULL,
  `trip_image_source` varchar(255) DEFAULT '',
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp(),
  `trip_distance_actual` float DEFAULT NULL,
  `trip_distance_estimated` float DEFAULT NULL,
  `trip_duration_actual` float DEFAULT NULL,
  `trip_duration_estimated` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `trip`
--

INSERT INTO `trip` (`trip_id`, `route_id`, `vehicle_id`, `driver_id`, `trip_status`, `passengers_max`, `passengers`, `seats_left`, `departure_time`, `arrival_time`, `trip_image_source`, `created_at`, `updated_at`, `trip_distance_actual`, `trip_distance_estimated`, `trip_duration_actual`, `trip_duration_estimated`) VALUES
(10, 1, 16, 4, 'Planned', 5, 1, 4, '2023-07-26 12:00:00', '2023-07-26 12:28:00', 'route1.png', '2023-08-02 19:48:15', '2023-08-02 19:48:15', 16.1, 16.1, 28, 28),
(12, 1, NULL, NULL, 'Requested', 2, 0, 2, '2023-07-27 23:10:00', '2023-07-27 23:38:00', 'route1.png', '2023-08-02 20:28:22', '2023-08-02 20:28:22', 16.1, 16.1, 28, 28),
(13, 1, 15, 6, 'Planned', 2, 2, 0, '2023-07-26 12:35:00', '2023-07-26 13:03:00', 'route1.png', '2023-08-02 21:02:40', '2023-08-02 21:02:40', 16.1, 16.1, 28, 28),
(17, 1, NULL, NULL, 'Cancelled', 2, 0, 2, '2023-07-27 22:15:00', '2023-07-27 22:43:00', 'route1.png', '2023-08-02 20:28:18', '2023-08-02 20:28:18', 16.1, 16.1, 28, 28),
(19, 1, 14, 2, 'Planned', 2, 2, 0, '2023-07-26 12:00:00', '2023-07-26 12:28:00', 'route1.png', '2023-08-02 20:27:32', '2023-08-02 20:27:32', 16.1, 16.1, 28, 28),
(20, 1, 17, 3, 'Planned', 5, 1, 4, '2023-07-26 23:00:00', '2023-07-26 23:28:00', 'route1.png', '2023-08-02 20:27:43', '2023-08-02 20:27:43', 16.1, 16.1, 28, 28),
(21, 1, NULL, NULL, 'Planned', 2, 0, 2, '2023-07-31 12:30:00', '2023-07-31 12:58:00', 'route1.png', '2023-08-02 20:28:44', '2023-08-02 20:28:44', 16.1, 16.1, 28, 28),
(22, 1, 14, 2, 'Requested', 2, 2, 0, '2023-07-21 12:00:00', '2023-07-21 12:28:00', 'route1.png', '2023-08-05 07:12:45', '2023-08-05 07:12:45', 16.1, 16.1, 28, 28),
(23, 2, 17, 3, 'Planned', 5, 0, 5, '2023-07-27 12:00:00', '2023-07-27 12:31:00', 'route2.png', '2023-08-02 20:28:12', '2023-08-02 20:28:12', 17.3, 17.3, 31, 31),
(24, 2, 15, 6, 'Planned', 2, 1, 1, '2023-07-26 12:00:00', '2023-07-26 12:31:00', 'route2.png', '2023-08-02 20:27:36', '2023-08-02 20:27:36', 17.3, 17.3, 31, 31),
(27, 1, 17, 3, 'Requested', 5, 2, 3, '2023-07-29 00:49:00', '2023-07-29 01:17:00', 'route1.png', '2023-08-02 20:28:36', '2023-08-02 20:28:36', 16.1, 16.1, 28, 28),
(28, 1, 17, 3, 'Planned', 5, 0, 5, '2023-08-09 00:55:00', '2023-08-09 01:23:00', 'route1.png', '2023-08-02 20:28:51', '2023-08-02 20:28:51', 16.1, 16.1, 28, 28),
(29, 1, NULL, NULL, 'Completed', 2, 1, 1, '2023-07-27 23:30:00', '2023-07-27 23:58:00', 'route1.png', '2023-08-02 20:28:26', '2023-08-02 20:28:26', 16.1, 16.1, 28, 28),
(30, 2, 16, 4, 'Requested', 5, 0, 5, '2023-07-29 01:55:00', '2023-07-29 02:26:00', 'route2.png', '2023-08-02 20:28:40', '2023-08-02 20:28:40', 17.3, 17.3, 31, 31),
(31, 2, NULL, NULL, 'Planned', 2, 1, 1, '2023-07-28 01:58:00', '2023-07-28 02:29:00', 'route2.png', '2023-08-02 20:28:29', '2023-08-02 20:28:29', 17.3, 17.3, 31, 31),
(32, 1, NULL, NULL, 'Requested', 2, 0, 2, '2023-08-08 14:13:00', '2023-08-08 14:41:00', 'route1.png', '2023-08-02 20:28:47', '2023-08-02 20:28:47', 16.1, 16.1, 28, 28);

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
(54, 22, 3, 'C D'),
(55, 22, 6, 'I J'),
(56, 10, 2, 'A B'),
(57, 19, 6, 'I J'),
(58, 19, 8, 'M N'),
(59, 24, 3, 'C D'),
(60, 13, 9, 'O P'),
(61, 13, 8, 'M N'),
(62, 20, 2, 'A B'),
(64, 27, 2, 'A B'),
(65, 27, 6, 'I J'),
(68, 29, 20, 'Rider 1'),
(69, 31, 20, 'Rider 1');

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
  `first_name` varchar(255) DEFAULT '''''',
  `last_name` varchar(255) DEFAULT '''''',
  `email` varchar(255) DEFAULT '''''',
  `password` varchar(255) DEFAULT '''''',
  `username` varchar(255) DEFAULT '''''',
  `is_active` tinyint(1) DEFAULT 0,
  `user_status` varchar(255) DEFAULT '''inactive''',
  `is_admin` tinyint(1) DEFAULT 0,
  `times_rated` int(11) DEFAULT 0,
  `overall_safety_score` float DEFAULT 0,
  `overall_responsibility_rating` float DEFAULT 0,
  `overall_safety_rating` float DEFAULT 0,
  `created_at` timestamp NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `first_name`, `last_name`, `email`, `password`, `username`, `is_active`, `user_status`, `is_admin`, `times_rated`, `overall_safety_score`, `overall_responsibility_rating`, `overall_safety_rating`, `created_at`, `updated_at`) VALUES
(2, 'A', 'B', 'ab@gmail.com', 'ab', 'ab', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-24 21:57:03'),
(3, 'C', 'D', 'cd@gmail.com', 'cd', 'cd', 1, 'Active', 1, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-08-05 00:59:14'),
(4, 'E', 'F', 'ef@gmail.com', 'ef', 'ef', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:32:34'),
(5, 'G', 'H', 'gh@gmail.com', 'gh', 'gh', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:33:17'),
(6, 'I', 'J', 'ij@gmail.com', 'ij', 'ij', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:33:39'),
(7, 'K', 'L', 'kl@gmail.com', 'kl', 'kl', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:33:59'),
(8, 'M', 'N', 'mn@gmail.com', 'mn', 'mn', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(9, 'O', 'P', 'op@gmail.com', 'op', 'op', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(10, 'Q', 'R', 'qr@gmail.com', 'qr', 'qr', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(11, 'S', 'T', 'st@gmail.com', 'st', 'st', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(12, 'U', 'V', 'uv@gmail.com', 'uv', 'uv', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(13, 'W', 'X', 'wx@gmail.com', 'wx', 'wx', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(14, 'Y', 'Z', 'yz@gmail.com', 'yz', 'yz', 0, 'Inactive', 0, 0, 0, 0, 0, '2023-07-22 22:30:02', '2023-07-22 22:30:02'),
(15, 'A', 'A', 'aa@gmail.com', 'aa', 'aa', 1, 'Active', 0, 0, 0, 0, 0, '2023-07-29 17:37:44', '2023-07-29 17:37:44'),
(17, 'J', 'M', 'jm@gmail.com', 'jm', 'jm', 0, 'Active', 0, 0, 0, 0, 0, '2023-08-04 07:37:08', '2023-08-04 07:37:08'),
(18, 'Jacob', 'McCallum', 'jm@gmail.com', 'jcm', 'jcm', 0, 'Active', 1, 0, 0, 0, 0, '2023-08-04 07:39:20', '2023-08-05 00:57:26'),
(19, 'Rider', '1', 'rider1@gmail.com', 'rider1', 'rider1', 1, 'Active', 0, 0, 0, 0, 0, '2023-08-04 22:00:31', '2023-08-05 00:16:53'),
(20, 'Test', 'Rider', 'testrider@gmail.com', 'testrider', 'testrider', 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:28:38', '2023-08-05 04:31:10'),
(21, 'Test', 'Driver', 'testdriver@gmail.com', 'testdriver', 'testdriver', 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:29:43', '2023-08-05 04:31:04'),
(22, 'Test', 'RiderDriver', 'testriderdriver@gmail.com', 'testriderdriver', 'testriderdriver@gmail.com', 1, 'Active', 0, 0, 0, 0, 0, '2023-08-05 04:30:34', '2023-08-05 04:30:57'),
(23, 'Test', 'Admin', 'testadmin@gmail.com', 'testadmin', 'testadmin', 1, 'Active', 1, 0, 0, 0, 0, '2023-08-05 05:06:19', '2023-08-05 05:07:14'),
(24, 'Test', 'RiderDriverAdmin', 'testriderdriveradmin@gmail.com', 'testriderdriveradmin', 'testriderdriveradmin', 1, 'Active', 1, 0, 0, 0, 0, '2023-08-05 05:29:02', '2023-08-05 05:29:02');

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
(6, 3, 'Inactive', 0, 2022, 'Volkswagen', 'Golf', 'Black', '#121212', 5, 3, '2023-08-02 06:44:02', '2023-08-02 06:44:02'),
(7, 3, 'Inactive', 0, 2020, 'Toyota', 'Camry', 'Red', '#e93a3a', 5, 3, '2023-08-02 06:43:54', '2023-08-02 06:43:54'),
(8, 3, 'Inactive', 0, 2015, 'Honda', 'Civic', 'Blue', '#729ff8', 5, 3, '2023-08-02 06:43:39', '2023-08-02 06:43:39'),
(9, 19, 'Active', 1, 2020, 'Ford', 'Focus', 'Purple', '#7322ec', 5, 2, '2023-08-01 05:10:26', '2023-08-01 05:10:26'),
(13, 2, 'Active', 0, 2022, 'Chevy', 'Bolt', 'Gray', '#bdbdbc', 5, 2, '2023-08-01 05:32:13', '2023-08-01 05:32:13'),
(14, 2, 'Active', 1, 2022, 'Chevy', 'Volt', 'Silver', '#e6e6e1', 5, 2, '2023-08-01 05:31:38', '2023-08-01 05:31:38'),
(15, 6, 'Active', 1, 2015, 'VW', 'Beetle', 'Green', '#47ff54', 5, 2, '2023-08-02 06:38:53', '2023-08-02 06:38:53'),
(16, 4, 'Active', 1, 2020, 'Honda', 'Pilot', 'Blue', '#00bfff', 7, 5, '2023-08-02 06:42:08', '2023-08-02 06:42:08'),
(17, 3, 'Active', 1, 2020, 'Hyundai', 'Palisade', 'Gray', '#5e5e5e', 7, 5, '2023-08-02 06:43:12', '2023-08-02 06:43:12');

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
-- Indexes for table `driver_trip_transaction`
--
ALTER TABLE `driver_trip_transaction`
  ADD PRIMARY KEY (`driver_trip_transaction_id`),
  ADD KEY `FKdy4jlhxvrul4yio1bqiy25p0a` (`trip_id`);

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
-- Indexes for table `rider_trip_transaction`
--
ALTER TABLE `rider_trip_transaction`
  ADD PRIMARY KEY (`rider_trip_transaction_id`),
  ADD KEY `FKfewcdjmbrn958i5notlr744qd` (`trip_id`);

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
  MODIFY `driver_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `driver_rating`
--
ALTER TABLE `driver_rating`
  MODIFY `driver_rating_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `driver_trip_transaction`
--
ALTER TABLE `driver_trip_transaction`
  MODIFY `driver_trip_transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `payment_method`
--
ALTER TABLE `payment_method`
  MODIFY `payment_method_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rider`
--
ALTER TABLE `rider`
  MODIFY `rider_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `rider_rating`
--
ALTER TABLE `rider_rating`
  MODIFY `rider_rating_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rider_trip_transaction`
--
ALTER TABLE `rider_trip_transaction`
  MODIFY `rider_trip_transaction_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `route_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `trip`
--
ALTER TABLE `trip`
  MODIFY `trip_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `trip_rider`
--
ALTER TABLE `trip_rider`
  MODIFY `trip_rider_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `trip_transaction`
--
ALTER TABLE `trip_transaction`
  MODIFY `trip_transaction_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `vehicle`
--
ALTER TABLE `vehicle`
  MODIFY `vehicle_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
-- Constraints for table `driver_trip_transaction`
--
ALTER TABLE `driver_trip_transaction`
  ADD CONSTRAINT `FKdy4jlhxvrul4yio1bqiy25p0a` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

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
-- Constraints for table `rider_trip_transaction`
--
ALTER TABLE `rider_trip_transaction`
  ADD CONSTRAINT `FKfewcdjmbrn958i5notlr744qd` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`);

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
