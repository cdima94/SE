CREATE DATABASE `se` /*!40100 DEFAULT CHARACTER SET utf8 */
CREATE TABLE `fitness` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `min_age` int(11) NOT NULL,
  `max_age` int(11) NOT NULL,
  `min_weight` int(11) NOT NULL,
  `max_weight` int(11) NOT NULL,
  `min_height` int(11) NOT NULL,
  `max_height` int(11) NOT NULL,
  `style` enum('ACTIVE','PASSIVE') NOT NULL,
  `biceps` int(11) NOT NULL,
  `triceps` int(11) NOT NULL,
  `forearm` int(11) NOT NULL,
  `shoulder` int(11) NOT NULL,
  `chest` int(11) NOT NULL,
  `back` int(11) NOT NULL,
  `abdomen` int(11) NOT NULL,
  `feet` int(11) NOT NULL,
  `legs` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8
