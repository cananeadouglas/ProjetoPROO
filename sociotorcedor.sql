-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 27-Jun-2016 às 22:27
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sociotorcedor`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastrandonosistema`
--

CREATE TABLE `cadastrandonosistema` (
  `idusuario` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `cpf` int(11) NOT NULL,
  `idade` int(11) NOT NULL,
  `telefone` int(11) NOT NULL,
  `email` varchar(40) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `tipo` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cadastrandonosistema`
--

INSERT INTO `cadastrandonosistema` (`idusuario`, `nome`, `cpf`, `idade`, `telefone`, `email`, `sexo`, `senha`, `tipo`) VALUES
(1, 'Douglas', 123, 25, 3322, 'cana@hotmail.com', 'M', '123', 'cliente'),
(2, 'Rocha ', 321, 26, 2233, 'rocha@hotmail.com', 'M', '321', 'cliente'),
(4, 'admin', 1111, 50, 8899, 'admin@admin.com', 'm', 'admin', 'adm'),
(5, 'roberto', 2222, 12, 789456, 'df@dfd.com', 'M', 'asdf', 'cliente'),
(6, 'anonimo', 999, 0, 0, '', '', '', 'anonimo'),
(7, 'maria', 147, 19, 3221, 'maria@hotmail.com', 'm', '147', 'cliente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `eventos`
--

CREATE TABLE `eventos` (
  `idevento` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idjogos` int(11) NOT NULL,
  `valortotal` double NOT NULL,
  `pagamento` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `eventos`
--

INSERT INTO `eventos` (`idevento`, `idusuario`, `idjogos`, `valortotal`, `pagamento`) VALUES
(1, 1, 1, 70, 'sim'),
(2, 2, 2, 80, 'no'),
(9, 6, 3, 90, 'sim'),
(10, 2, 3, 119, 'no'),
(11, 6, 2, 80, 'no');

-- --------------------------------------------------------

--
-- Estrutura da tabela `partidas`
--

CREATE TABLE `partidas` (
  `idjogos` int(11) NOT NULL,
  `jogos` varchar(50) NOT NULL,
  `diajogo` date NOT NULL,
  `valorjogo` double NOT NULL,
  `caravana` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `partidas`
--

INSERT INTO `partidas` (`idjogos`, `jogos`, `diajogo`, `valorjogo`, `caravana`) VALUES
(1, 'csa x crb', '2016-06-26', 70, 30),
(2, 'CRB x Coruripe', '2016-06-29', 80, 25),
(3, 'Corinthians x Flamengo', '2016-06-30', 90, 50);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cadastrandonosistema`
--
ALTER TABLE `cadastrandonosistema`
  ADD PRIMARY KEY (`idusuario`);

--
-- Indexes for table `eventos`
--
ALTER TABLE `eventos`
  ADD PRIMARY KEY (`idevento`);

--
-- Indexes for table `partidas`
--
ALTER TABLE `partidas`
  ADD PRIMARY KEY (`idjogos`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cadastrandonosistema`
--
ALTER TABLE `cadastrandonosistema`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `eventos`
--
ALTER TABLE `eventos`
  MODIFY `idevento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `partidas`
--
ALTER TABLE `partidas`
  MODIFY `idjogos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
