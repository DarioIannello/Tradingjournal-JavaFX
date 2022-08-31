-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 15. Jun 2022 um 20:21
-- Server-Version: 10.4.11-MariaDB
-- PHP-Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `tradingjournal`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `buysell`
--

CREATE TABLE `buysell` (
  `id_BuySell` int(11) NOT NULL,
  `tradeKind` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `buysell`
--

INSERT INTO `buysell` (`id_BuySell`, `tradeKind`) VALUES
(1, 'BUY'),
(2, 'SELL');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `strategy`
--

CREATE TABLE `strategy` (
  `id_Strategy` int(11) NOT NULL,
  `strategy` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `strategy`
--

INSERT INTO `strategy` (`id_Strategy`, `strategy`) VALUES
(1, 'TBX'),
(2, 'Harmonics'),
(3, 'Pricetrap'),
(4, 'ECC-11'),
(5, 'Steady'),
(6, 'Colors');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `trade`
--

CREATE TABLE `trade` (
  `id_Trade` int(11) NOT NULL,
  `pair` text DEFAULT NULL,
  `id_BuySell` int(11) NOT NULL,
  `dateOfTrade` text DEFAULT NULL,
  `timeOfTrade` text DEFAULT NULL,
  `id_WBEL` int(11) NOT NULL,
  `id_Strategy` int(11) NOT NULL,
  `profit` text DEFAULT NULL,
  `reasonF` text DEFAULT NULL,
  `reasonA` text DEFAULT NULL,
  `other` text DEFAULT NULL,
  `learn` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `trade`
--

INSERT INTO `trade` (`id_Trade`, `pair`, `id_BuySell`, `dateOfTrade`, `timeOfTrade`, `id_WBEL`, `id_Strategy`, `profit`, `reasonF`, `reasonA`, `other`, `learn`) VALUES
(1, 'GBPCHF', 2, '30/05/2022', '17:49', 1, 1, '+ 1%', '5 Punkte Trade', 'Erster selbstanalysierter Trade', '', 'Mehr Selbstvertrauen, Wirtschaftskalender vorher anschauen'),
(2, 'AUDNZD', 1, '31/05/2022', '08:54', 2, 1, '+ 0.1%', '4 Punkte Trade', 'Euro News', 'Sehr unsicher während Trade offen', 'Nicht so oft auf laufenden Trade achten, Mehr Vertrauen'),
(3, 'AUDUSD', 2, '31/05/2022', '10:33', 1, 1, '+ 1.5%', 'Resistance oben abgeprallt und 4 Punkte Trade', 'Kein Pfeil nach unten', 'Sicheres Gefühl', 'Es ist kein Pfeil nötig wenn der Rest passt'),
(4, 'EURAUD', 2, '31/05/2022', '20:55', 1, 1, '+ 1.3%', 'Resistance oben', 'Keine Punktebewertung gemacht', '', 'Ein Trade mit TBX kann auch ohne Punktebewertung gehen aber man muss auf den Abpraller warten'),
(5, 'EURCHF', 1, '15/06/2022', '20:22', 1, 1, '- 0.9%', 'Resistance oben, gut Punkte', '', 'Trade mit Lukas Live verfolgt', 'Immer nach allen Resistance/Supports ausschau halten & SL nicht zu schnell runterziehen und bei - wieder auf Ausgangswert setzen'),
(6, 'AUDJPY', 2, '02/06/2022', '07:58', 2, 1, '- 0.1%', 'Reistance', '', '', ''),
(7, 'AUDJPY', 1, '15/06/2022', '08:00', 1, 1, '- 1.1%', 'Resistance', '', '', ''),
(8, 'GBPJPY', 1, '02/06/2022', '09:19', 3, 1, '- 1.1%', 'Support', '', '', ''),
(9, 'CADCHF', 1, '02/06/2022', '09:53', 1, 1, '+ 1%', 'Nach News stark gedropped --> Wiederaufbau', 'Keine Analyse', '1. Trade mit 15 PIP SL anstatt 10', 'Auch ohne Analyse möglich aber lieber nicht'),
(10, 'EURJPY', 1, '06/06/2022', '21:15', 1, 1, '+ 0.3%', '5 Punkte Trade', '', '', 'SL auf 5 PIPS versuchen, Nicht so viel mit SL spielen nach BE'),
(11, 'GBPUSD', 1, '06/06/2022', '22:20', 3, 1, '- 0.9%', '3 Punkte Trade', 'Gegen Wolke', '1. Trade mit 5 PIP', 'Immer Wolke beachten und nicht gegen Traden'),
(12, 'AUDJPY', 1, '07/06/2022', '19:40', 3, 1, '- 1%', '', '', '', ''),
(13, 'EURAUD', 2, '07/06/2022', '19:50', 3, 1, '- 1%', '', '', '', ''),
(14, 'GBPJPY', 2, '07/06/2022', '20:05', 3, 1, '- 1.2%', '', '', '', ''),
(15, 'EURAUD', 2, '08/06/2022', '21:46', 1, 1, '+ 0.6%', '', '', '', ''),
(16, 'EURCAD', 2, '08/06/2022', '22:22', 3, 1, '- 1%', '', '', '', ''),
(17, 'EURJPY', 2, '09/06/2022', '11:04', 1, 1, '+ 1.1%', '', '', '', ''),
(18, 'AUDCHF', 1, '09/06/2022', '11:11', 3, 1, '- 1%', '', '', '', ''),
(19, 'CADCHF', 1, '09/06/2022', '11:34', 3, 1, '- 1%', '', '', '', ''),
(20, 'USDCAD', 1, '09/06/2022', '19:57', 1, 1, '+ 1%', '', '', '', ''),
(21, 'AUDJPY', 2, '10/06/2022', '19:45', 2, 3, '+ 0.1 %', '3 Punkte Trade', 'Keine Confirmation', '', 'Auf Confirmation warten');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `wbel`
--

CREATE TABLE `wbel` (
  `id_WBEL` int(11) NOT NULL,
  `finish` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `wbel`
--

INSERT INTO `wbel` (`id_WBEL`, `finish`) VALUES
(1, 'WIN'),
(2, 'BE'),
(3, 'LOSS');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `buysell`
--
ALTER TABLE `buysell`
  ADD PRIMARY KEY (`id_BuySell`);

--
-- Indizes für die Tabelle `strategy`
--
ALTER TABLE `strategy`
  ADD PRIMARY KEY (`id_Strategy`);

--
-- Indizes für die Tabelle `trade`
--
ALTER TABLE `trade`
  ADD PRIMARY KEY (`id_Trade`),
  ADD KEY `id_BuySell` (`id_BuySell`),
  ADD KEY `id_Strategy` (`id_Strategy`),
  ADD KEY `id_WBEL` (`id_WBEL`);

--
-- Indizes für die Tabelle `wbel`
--
ALTER TABLE `wbel`
  ADD PRIMARY KEY (`id_WBEL`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `buysell`
--
ALTER TABLE `buysell`
  MODIFY `id_BuySell` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `strategy`
--
ALTER TABLE `strategy`
  MODIFY `id_Strategy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT für Tabelle `trade`
--
ALTER TABLE `trade`
  MODIFY `id_Trade` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT für Tabelle `wbel`
--
ALTER TABLE `wbel`
  MODIFY `id_WBEL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `trade`
--
ALTER TABLE `trade`
  ADD CONSTRAINT `trade_ibfk_1` FOREIGN KEY (`id_BuySell`) REFERENCES `buysell` (`id_BuySell`),
  ADD CONSTRAINT `trade_ibfk_2` FOREIGN KEY (`id_Strategy`) REFERENCES `strategy` (`id_Strategy`),
  ADD CONSTRAINT `trade_ibfk_3` FOREIGN KEY (`id_WBEL`) REFERENCES `wbel` (`id_WBEL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
