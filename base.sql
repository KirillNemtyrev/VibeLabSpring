CREATE TABLE IF NOT EXISTS `fines` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cop` varchar(255) DEFAULT NULL,
  `court` bit(1) NOT NULL,
  `date_deadline` datetime DEFAULT NULL,
  `date_of_payment` datetime DEFAULT NULL,
  `date_protocol` datetime DEFAULT NULL,
  `intruder` varchar(255) DEFAULT NULL,
  `number_car` varchar(255) DEFAULT NULL,
  `paid` bit(1) NOT NULL,
  `total` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;