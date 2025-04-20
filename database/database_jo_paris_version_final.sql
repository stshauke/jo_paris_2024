-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: localhost    Database: jo_paris_2024_db
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billet`
--

DROP TABLE IF EXISTS `billet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billet` (
  `id_billet` bigint NOT NULL AUTO_INCREMENT,
  `id_offre` int NOT NULL,
  `type_billet` varchar(50) NOT NULL,
  `prix_billet` decimal(10,2) NOT NULL,
  `stock` int DEFAULT '0',
  `offre_id` bigint DEFAULT NULL,
  `offre_id_offre` bigint DEFAULT NULL,
  PRIMARY KEY (`id_billet`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billet`
--

LOCK TABLES `billet` WRITE;
/*!40000 ALTER TABLE `billet` DISABLE KEYS */;
INSERT INTO `billet` VALUES (1,1,'VIP',150.00,150,NULL,NULL),(2,2,'Standard',150.00,150,NULL,NULL),(3,3,'Economique',200.00,100,NULL,NULL),(4,1,'Premium',120.00,10,NULL,NULL),(5,4,'Backstage',300.00,400,NULL,NULL),(6,2,'Early Bird',170.00,23,NULL,NULL);
/*!40000 ALTER TABLE `billet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offre` (
  `id_offre` bigint NOT NULL AUTO_INCREMENT,
  `nom_offre` varchar(255) DEFAULT NULL,
  `description_offre` varchar(255) DEFAULT NULL,
  `prix_offre` decimal(38,2) DEFAULT NULL,
  `nombre_personnes` bigint DEFAULT NULL,
  `date_fin_offre` date DEFAULT NULL,
  PRIMARY KEY (`id_offre`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre`
--

LOCK TABLES `offre` WRITE;
/*!40000 ALTER TABLE `offre` DISABLE KEYS */;
INSERT INTO `offre` VALUES (1,'SINGLE Ticket','SINGLE : Pour les aventuriers en solo, les billets individuels sont le choix gagnant !',100.00,1,'2024-12-13'),(2,'DUO Ticket','DUO : Profitez ensemble, vivez des moments inoubliables !',150.00,2,'2024-12-13'),(3,'TRIPLE Ticket','TRIPLE : Trois fois plus de plaisir, trois fois plus de souvenirs !',200.00,3,'2024-12-13'),(4,'FAMILY  Ticket','FAMILY : Ensemble, crÃ©ons des souvenirs inoubliables !',300.00,4,'2024-12-13');
/*!40000 ALTER TABLE `offre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `panier`
--

DROP TABLE IF EXISTS `panier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `panier` (
  `id_panier` int NOT NULL AUTO_INCREMENT,
  `id_visiteur` int DEFAULT NULL,
  `id_billet` int DEFAULT NULL,
  `date_ajout` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `identifiant_billet` varchar(255) DEFAULT NULL,
  `cle_unique` varchar(255) DEFAULT NULL,
  `qr_code_image` mediumblob,
  `prix` double DEFAULT NULL,
  `quantite` int DEFAULT NULL,
  PRIMARY KEY (`id_panier`),
  KEY `FK9mtv4yfq1jf2hrrhkih1kft1e` (`id_billet`),
  KEY `FKegjvrij28x2vmn5km0jm32r9v` (`id_visiteur`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `panier`
--

LOCK TABLES `panier` WRITE;
/*!40000 ALTER TABLE `panier` DISABLE KEYS */;
INSERT INTO `panier` VALUES (6,1,1,'2024-12-26 11:17:22','7e0f6db0-10dc-4f5f-bc6d-33596652446c',NULL,NULL,150,1),(5,1,5,'2024-12-24 14:37:41','ac6c8033-1ee7-47b8-8319-aec093c386e9',NULL,NULL,150,1),(7,1,1,'2024-12-26 11:44:45','d8a53778-661f-49af-b3c0-85a730b33286',NULL,NULL,150,1),(8,1,1,'2024-12-26 11:52:32','834d2751-af78-4a84-88c4-3e4a08897fd5',NULL,NULL,150,1),(9,1,1,'2024-12-26 12:25:19','dece4ae0-f5b9-451e-bae8-c26b6b1e140e','87ece59e-315e-4151-b97d-c8e746e4b008_dece4ae0-f5b9-451e-bae8-c26b6b1e140e',NULL,150,1),(10,12,1,'2024-12-27 18:19:03','f8247208-e84d-49cd-bd24-6b28b2ba4cdd','87ece59e-315e-4151-b97d-c8e746e4b008_f8247208-e84d-49cd-bd24-6b28b2ba4cdd',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0qIDATx^\í–ÝŠ\Ä0……¼–\à«¾V {Ž\é™ý¹Z½‹-\Æo Q¶²þ2ù\îx\Û%—\Ð.ùq‘±\"bM•‘‹+ýn±xð\ì!>ö\Úu<‹6\â\Ã&6\ÐL¦\áP\ë$„:<½;\æBQ\Ä\Ë~h§ŽÐ¦’Š@_Ž\âÔ¹Š*«0k\"Á|f*\"zV®”¬¹ýÆ¢¡‹­‹\àÑ¹BkÁ\íG\åj	ŸÏ¤\Zn00\Ò\×@¦\Ú\äXôÖ™\ÑZ²ˆ\ê!µ\è\ã#£\Åk\ÖlL\Å]\ìPœ‚\Æ2ô©b±\à©T<7\ÓC ?¬Q?l€»±6bœ”óüœ‰µ„\Â CZŠ¤‰Eÿ\Ì=Dûù\åPIò±¸,§üi\"n)s„¬@ZØŠ-uTðC£•$)\æj\ä[–£‡\Ð\áôò/M‘e›s~N¤R’@¨\ã”\çë¡‹¤ÓŸ ‹\à\r ybl\"„œHœ~¹\ì!THð*Tã¹ƒZò«]r	\í’jò€„šó6\ã\0\0\0\0IEND®B`‚',150,1),(11,12,1,'2024-12-30 18:40:31','124ff667-1b9a-495d-a833-63cbef02162c','87ece59e-315e-4151-b97d-c8e746e4b008_124ff667-1b9a-495d-a833-63cbef02162c',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0rIDATx^\í—ÛŠ\Ã0D\rú-ƒ~\Ý\à\ß2x\ç(\Ý%\Ý\Ë\Óz\Þ\"Jûl\ÆJ\Úö_Ñ¾O|\ÅCB<\äd´{Î¹WoQ™›yM§.¸Èˆ‚\ÚJ¼62b(MmÀLV®D\Ñt`\×r\Åd`\"˜b~\Æ\ïœ#\Äj9R_µº‰|.1GHSEš\ÈV\Ý\Êó\è·\Ê&.”¬Sœ&28º+dFò\Ý\ã^Ó“d\ãx±G\ã¬9\áZvG\Ò\Þ\ß=KS+wöAºi\"dú\n¥¼\Ô*\\D‚\Êô¬\Î\Úý,œ%*™¶Á…Ÿ÷Žt”L>‡`ý7­:DŒä¡‘T.LDY•m\áÁ‰¦i\"”M\ÓT][š\È\\\ÉfJ™šˆü‘\âA#\Ï\Ë &R–ç’²¾}9]\ÃDF£#ñj¢YýÔ­R™\Ê\ï4=\îHam95G\é\ê#$\Ó|Q£P\'’!\Çý\r\å0\æ\åø¬¡‡”Cø\'!Ei´i\"¿\ÆCB<\ä4ù\0˜?‰J}\Ìýd\0\0\0\0IEND®B`‚',150,1),(12,12,1,'2024-12-30 18:43:42','ede308ac-65af-4732-bba1-eabb7d4c7272','87ece59e-315e-4151-b97d-c8e746e4b008_ede308ac-65af-4732-bba1-eabb7d4c7272',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0qIDATx^\í–[Ž\Ã E‘\Ø’·n\É\ÛBb\îq:#:¯Á8mZ|\"›\ËM\Úú+\Ú÷\ÄW\\r	q\É?ˆ·\ÖWD\äŸÔX™Ÿ=Ÿ\Zâ±›\àkPF¼ûƒ‚kÉ´i\á£Y%M¡«©Š¢ˆ\Ïø¡s„˜ªQgNOGç£µ¡\Æjù†UýW+1¼ˆ¨‹)AøšRIY.²U§Ò¾­\ÜQ\âYß¤Fêµ¼º€[Š\ÝËº½wô(Q¾OCŒ®ß¹uô,YØ„[ú~QE\æ0id\êÅª±…Dú\ëlc…mŽt–\È\ÅeIì¯”\ã\Þ\ë£$$\r\Ê|Is¾³„ûsgŠŒ‰XjˆœBk×¹dX¼\Í\í0\É\' ‰$(!‹›glœa\rq\Ù\Äz¬5Í¶ˆ<´?ov+/+!$¤A)D\Ù`	kˆ*Có2Z\ë»#&Ž64\êlù\nQGŸ\È|‚*\â–\Ì1}ôÕ–šd÷%ª¯\ã~t4\Þfp–ü\Z—\\B\\rš|\0\É\àx\âY\É&&\0\0\0\0IEND®B`‚',150,1),(13,12,1,'2024-12-30 18:48:51','9bdab96b-531a-49b5-b2ab-e98f217d6c59','87ece59e-315e-4151-b97d-c8e746e4b008_9bdab96b-531a-49b5-b2ab-e98f217d6c59',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0}IDATx^\í–QŠ!D¯%\ä\êB®p\ë9³;ö\Ì\î\×&-\r>¡+±’¶­¿F{_ø7¹	\ã&ÿ ³µ¾Ü—\Çh}Ojˆ\ëq–\r¼\ç5dv\æaý9)#³\Ï1×’0	˜[H€CztgRD0…\ï\äF(\Æ5‡\í¯‘‰\ÏG\ãÓ¡\ãVD\Ö4,/Œqœ\\2Aƒ?ø¢ÀªH´\íõõXž\ÇÉ¥’&¯?!ED\nVJ\Æ5£©$TU¦WgƒÅ‘\Ñ\\\"	L•\É\Ù\éU„º\Ý=iKh‡ã“‰Ž.v]\áx;{U*‰>I©\ÎNo]rJTWR¡e”H\Ë\Ëñ¹D\ß\äÔˆ\Õ\ÙaED•ÿ,[\Ôb/\ÚR‰ü±˜ê—€Y+!ŠÏ¶Ïƒ6¾\rRB‚\îÀ\Ïý\ê\ÑD²©j‹›ƒ\Øxe4—\à\rg…ûƒ¶\ì­\Ä	V•%³›¯KG\Ê%D©?Ù”\Z;rN¸œ\×n\ìXIˆ”gb\Æ\"\Ü\Ý\"X=¤2M·e\Ô/\nrÉ¯\ã&7a\Ü$›|`mŠ:\è\è\ã§\0\0\0\0IEND®B`‚',150,1),(14,12,1,'2024-12-30 18:54:11','917d5c74-5147-42a8-bad3-542eaa38be72','87ece59e-315e-4151-b97d-c8e746e4b008_917d5c74-5147-42a8-bad3-542eaa38be72',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0sIDATx^\í–IŠE!E·%d\ë·°\îI5ø«U2{\áñùz¦¹‰Žó—\ï_ö‡`ùñ1\æ\Ù{ŸXcæ¢‡\ì\Ã~¬e¢,ºˆO\Ö>cÍEñ\éKûr¥—„…\í\Ã:	pMŸG»,š¢ØŸöC;u‹a®(-Oo\"Ž\Î\×På£\ÙDt:’\ß\à1\ÖU¹Z\"eQ7Š¦.¶&rEp°³\íW\åj‰rºÔ¾ô\ï>8\ÒC\ÔSŠVÁ†ª÷š\ëRB€Š.;K|g´”¨p!½\Ç\Ì?YÁÂ´;\Ì$)^ôR|1ñDŠ·{V•u°\Â]LL\×;£\ÅdQ3	\å0Ïƒ*¶l+\îô±rjM$»	]—ú\íA1	]³¤“4#A‘øD-_)\ïi!n:9\Î/~ô\Ì9:’ñPi!y£g¼\Ú%±MdóI„4\Õ&\î.‚\ÔsJQh#Q€Á³\Ûv‚.\âŒ	>GŒMD\Ý%Ø½=(%©L©\Ôþ\âA-ù\Õò\ì!\Õ\ä\r%I—Ï¥C\0\0\0\0IEND®B`‚',150,1),(15,12,1,'2024-12-30 18:58:32','f922bac3-9067-41e2-9a0e-316949d1b41f','87ece59e-315e-4151-b97d-c8e746e4b008_f922bac3-9067-41e2-9a0e-316949d1b41f',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0oIDATx^\í–]Š!„^+«¼–\àV\Å\ÞÁ™\Ý}Z\ëÍ´­_ƒù)\ã\Øü\Ë\ìs\áe—\\B»\ä$\Í\Ú\ì}v¾\ÔDC:@z#®¹†d\ã<cŽöLd$[:C\ìb2bÀ³PBG\Í\Ú`N?r}ŽPý\Û~h\ç¡\r‹Œ\áQ»‹HR\çn\îm‡…ˆ`ŠA\Â|«\Üa’L)jÇ¢\r·¤2 Ef”Ë¹\Õô,\n1\".¾ãš‚”\Ä\é\ËöžÑ£!\ZÕs\Üp’\ß3z`\ç`o\nY¡\nH²`\ìI\å‚\íg\á(©Œ²\áA…\è}5•4q|º\ëž\Ñ\ãdµF‹\Ê5<¿Á0!yŠDDzmK*»‡IR½R	\nH\\\é\ì\çþDBF \Þ¼=¢±b=ù„ð\ÂH,\á²E\Û\Ë\n\Ò× J‚¹\rÁÁ]m‚n\n\É\àÿ­Z/ #Œ\×»F¨PòGM5¤øµ%ü‘_\í’Kh—œ&_j3„^\Z¬‚e\0\0\0\0IEND®B`‚',150,1),(16,12,1,'2024-12-30 19:00:30','8d48dd01-8950-47a3-98d3-30b56d392b89','87ece59e-315e-4151-b97d-c8e746e4b008_8d48dd01-8950-47a3-98d3-30b56d392b89',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0vIDATx^\í–Qn\Ä0D‘|-$®ŽÄµ\Ò\ÜnnûUøN¤µŸ¥50\à\Èõ—\ÉÏ…—=\ä!´‡üƒ¸\ÈJ‹\\œ‘À)*v\å\âdŠø\n—…#\â„c$Å²\Æ0Á\Ì\ÞQB¨ª–H\Z\'C„¢ˆ/{\ÓN)jLžC$Ÿ6@\\@)z\ÄÕ‹\è<\ÍuUò\Üòð´•@…\\guUg®—¸¨\Ã_ü¨\åRŠOE«\Ð\Ø!\â»A…\n”\èGUwõ¦V\ÂÞ€KW…©\Ý#d÷=%\ÅŽ´J™[¼–°\ãVY­$ª´¨y¨\åÖ‘šÉ–\Ò\'<\ËIŠM\î²Â†\ÈÅ¬AŠˆ(ý=\ßJKxk¼nq€#¢½„ÿ\'«#QüS$˜²Ò¡V§( 4gÞªÁƒ:B\êFwVÖ¾\Ôk\ë\0	>½\×µx„x}\ÙA)¨c‘Cñý¤<E\ã³8+¸Ÿ¤\Ñ]F“\Þ<X«o±\î#TH}=”T\ê0#\äW{\ÈCh\é&õ^|\Þk=f\0\0\0\0IEND®B`‚',150,1),(17,12,1,'2024-12-30 19:03:06','21753589-e581-4c82-aa19-28fb0eb10ca5','87ece59e-315e-4151-b97d-c8e746e4b008_21753589-e581-4c82-aa19-28fb0eb10ca5',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0vIDATx^\í–[Ž\Ã E-±-$¶n‰m!1\ç:)™\Ç\×\ØqÓ´p*\ák.nlÿö}\â+ò\ÅCþAÜ¬\í\émõn-5drÍ¹W\Ó]ƒ*\âMc|y\rÊˆ7G&	“5xQQeQF{‹<¦ED¦˜Ÿñ\Ã;yD±l8RG¬^D\\>\ï\Ö;…\í\Ä(\"[+‡\ÈnfýØ¹\\\"¯O\Ç\îœ/\\RDV[\ZpsMû{\çr	Ë¢b*‘\íúU	‰\Ånt¶\í^\ëTBÀ$F$\çø¬u*	ml]#‹E«¨\"¨´X½½9>•\ì8¼[.4tžµ\Î$si¬J\Òùâ³†\È\âh\ÜrŠv\î\íøl‚Ç«Ï¾ŽY¹\æÑª®7\Ï’‰z¬ð\Ü\ê\Zjú\Ð8t‚\Çe\Ç	\Ð\"— š\Æñœ°RHxCÅ¤ª¼Š\æ’E\ãAhŸ)™ ’ŠZ\è4\ÑBByŠ\Ô|€2¢$ô\å2c\á±e\Ñg\ÏR\ÉÕ‹¸S\Ñy\Ë —ü\Zyˆ\â!\Ù\ä‚—™k™\0\0\0\0IEND®B`‚',150,1),(18,12,1,'2024-12-30 19:08:55','3dba67da-7063-4b55-b158-22b04995f485','87ece59e-315e-4151-b97d-c8e746e4b008_3dba67da-7063-4b55-b158-22b04995f485',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0oIDATx^\í–Qj1D\r¾–AW\èZ‚\í\Ìl\Ú8IûU\é\ÏJk=\ÃJ\ã‰v\ÇõWŒ÷\ÄOr\ãc^\áSZôÀ7\âJ\àÐ¢‹ø\ä:qwU\ÒI|ú\Z†šIZ\Ú%\ØH\×$ŸÁE¡)\â;>¼SG9\Ì-©\é#\Zˆ\Ó\ç´º\ÖDRFŒHÀ1\Övrµ„fGwÆ¹%\\\ÒD\äB…\Òþ<¹Z¢Y4!¦F…ß»:\ÈX\ÇK\Òõ¢h-Aƒ35)r&\í\ØEpt¸/\ÒØQ\ÑE’^wVS¢\Û.¢5\ç~ú\Ü­$|$QQ6œM„\ç‘\ÆP\Â\ÉmŽ¯%T4¨+®­‰p>\Ø\Ý\ä²\Ø+(&\Ò)\ãU\n´šœ5¸Æ¸\ÒB$¦t\åhÚœXKDm\Þ;žŠ\Ö=\Ñi¹\Þ7EkI°Y»øFûD*&>iÆ¥>\Ç\ã\í¡‹\àÈœ¯\Ý]:rXt…›¡	2»WPJ\è\çCŠ\ÆKµ\ä\×8\ä\Æ!\Õ\äõƒ€b	\ZZ\0\0\0\0IEND®B`‚',150,1),(19,12,1,'2024-12-30 19:10:54','2b526fe9-f985-4ab9-8166-1924dcfb6162','87ece59e-315e-4151-b97d-c8e746e4b008_2b526fe9-f985-4ab9-8166-1924dcfb6162',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0qIDATx^\í–ÛŠ\Å0EþVÀ_ü­@g/Ï™!\Ë\ÓÄ·ZhW¡‰\îh\Æõ—\ïŽ/{\ÈC°‡üƒ\Ävef½Ô ‡\ä…\r\ç•A	«± ½m$,&K\Ìf²\\\×\Ã;	p\ZÜ²\Ö\ÜCE~\Ú\íœ#˜ô®[ý½‰:Ÿº´\Ô)ó&²xM4¯Ô¹e\î,‘…8I“Lø°ƒ v_¦ˆNÜ±\åô(\áÿË–3\r•%/_1þmW(m÷ˆ%p9¥OŸ \Ç.\"\í•;!ùZj	HE¢THŽmd \ÚV|r«HG‰-uŠS\Ööˆž%l*ú’\æÁz·\Êw–TERÎ´¥²¤\ßEf•=e­\Úmyu@)P)[D·‹Fô\Ç~¤…0\ê¸q\è²M‰g	¦ŽŽe©–\Ú@\Þ=\ÊË£‰$AEŠ”Àk¯H‡‰\ZNS7f\ã[¬©D\Ê/.RÝ–3D\ì\'”\Ã8)ôŽ—;H)„»\"š·œ%¿\ÚC‚=\ä4ù\0Æ‰jZ;(.•\0\0\0\0IEND®B`‚',150,1),(20,12,1,'2024-12-30 19:17:58','509853df-9617-4a13-b795-b4d2fd6b06d3','87ece59e-315e-4151-b97d-c8e746e4b008_509853df-9617-4a13-b795-b4d2fd6b06d3',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0nIDATx^\í•Knƒ1„-q-K\\‰k!¹38i&]vfñ\Ç\æ‹dc<\Ö_6~;¾\í’Kh—üƒ\Ø²\Ü=¹\é!¾¶Ÿ87]Ä„{S›òØ´\0E\0\Í$4t\Ù\ÚI\'z¦ðr\ÓD(\nÚ›v\ê-#Üš§7£\Î\ç`1a\ÚDBb\â|DA<\ÎÕ’Œ‡+›PI\áµõ`¿\Òm?«&j¢˜\Ê2¥¯ƒðö\nil\ÛKEk\É>v\Ï\Üä³¢¥Ä¸FºB­`Tt‘=\Äq:ÊŠÏ¡øZ‚\á€!®),\×Q\ëRòx”pÕ¢Ms(„u\Ìy\çL,%\Ô\"¼)xgóšš†ü˜$¦žŸ\"<¼¿ Aa%ñ…P¼@ŠS9•œ³öTb)\ÙTRñÂŒ›ˆñl†¡¬*ÿ\ÒCt(»úzH¥\Ä(u>\ê’S\Ã	\'^ú´e†O16‘µE{L\ïA)¡Bø\Ö\âgñ¹\Õ&ò\Ñ.¹„vI5ùB,‚\Ãø^\Ã\0\0\0\0IEND®B`‚',150,1),(21,12,1,'2024-12-30 19:25:41','3727f49c-4aba-4d00-8e50-f7966e257b8d','87ece59e-315e-4151-b97d-c8e746e4b008_3727f49c-4aba-4d00-8e50-f7966e257b8d',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0}IDATx^\í•[Š1D·%¸õ€\Û2UvÏ\Üy|þµ÷\è¨eEö_!\ß^ñ‡0ò²DtGDš‰\Ö\Ã‰\Íõ\Z›~g\ÈR>§\î¥÷\ÃYºL&\é\é»\à !4ôLQT>Š\">\ã‡vú#Å—&kz\Ç\0YÔ¹‰˜nˆ\ÞÌ§\Zi0c!?*\ÚJ‚D)\'·\Í\Ì.d¸!F\áò::\×JPF\Åd¡uÁ|½v\à\ËÍ™%¼ï­¢­„f”¬J9ÏŠ¶’\ä,ÑŠ0\Æ	«#N}<‰G‘Cñ½o§6”\Ò\äyV´“,®‚^\îzV´™@…iüg\ç¾\ßL¼L	S\ÅS$S½\ÂC×‹·´’`\ï\Ø<\Ö\Ú\ç\Úav¨§¯²ñ#|¿\ÓZ\é\æz(±—\Åe¾K’\ã!‚I¯k«P}m Q_6¹žŽ\ÔLêª¸\ÍBH\ç;†I\æz)‚@†\É;¶™ò²\Å\èWuG‚Ù…+·\'\è%¿\ÆC\ÂxH7ù\0“–zþpðh»\0\0\0\0IEND®B`‚',150,1),(22,12,6,'2025-01-22 16:04:33','baf8c12a-157a-40f9-ac52-2b2539dd41a9','87ece59e-315e-4151-b97d-c8e746e4b008_baf8c12a-157a-40f9-ac52-2b2539dd41a9',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0pIDATx^\í–]Š1„¹–\à\Õ¯%d«\Ì\ìlzžV\ß\"\Í0ñkˆš\ÒôX\Ùø\îx\Û%—\Ð.ù±1\ær÷2f.zˆ/ú\éå¢‹\Ø\ä:&ž×¢\Ø4Š\0šIh\èJ\ØHef\ÎE¡(ü\Ó~h§ŽÐ‚\å\ÑÜ½‰u.Cd‚Á´‰@¡;I˜\'WL•`ekq>ˆb»\í8¹ZŠ$QR\ne™¦¯\ØÐ˜;Y‘GE«	¶F–œH\èä£¢µ›c\ê\Ñ=@|§\Ú@\à\ä$\Ò|#Æ¡øZbü\ì`*^)˜’.¥â•=*ZKŒ²ØŠWžÜ—\âk	6\åÎŠ–\Êó\Ó&‚\Û­•Ib\Ä>b+%{[\ß\È\ë\"\è*–4;ø%‚T\ÑSyU\àÏ©\ÄRBcE÷-‹»½‰\ÐÁ/!•_ùjq>\á\ë1‘j	\ZiJ\æ9Hû> Áô\'\è\"þš88\n¥‡*oò ÷Œ ”¤B¿¨¨?\"¨%¿\Ú%—\Ð.©&ä¤‚º™F\ï\0\0\0\0IEND®B`‚',170,1),(23,12,5,'2025-01-22 16:31:01','e53c455f-6183-4761-afc4-5e91516cdc2f','87ece59e-315e-4151-b97d-c8e746e4b008_e53c455f-6183-4761-afc4-5e91516cdc2f',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0kIDATx^\í•QjD1E…lKp\ëB¶\È\Üc§\×iû\Õø÷d˜G<¨¹\Z\Û™½;¾\ì&7Ánò’fc\Ï9÷rµ\è!s—?Áµ\è\"9žk`-\ÚHŽt\ÐLV¬˜\é\è\n!Ö˜Ïœ;¢˜ŸöC;\ç¶”£\ÜQ§7‘D\çn\î*¬Ë¢ ’t3ó\ËÍ%›\ËB‚t–º8šÈŠ3”§\Üùº¹\ÃDIŠZ!d\à\ë rÁžK¥ýV\ÑÓ¤\î+-jË¥¢‡‰úW2d(\r\æEY\Òa-\Åe\ÛE¤ù¨±P|\\&\ÒY’TR~t2™]\Ä*UUR¢\×Í½š~^sV5.Â¹\n‚±§ÿkG‰nj¢Ž` Q\Û>¢\063\Öù¶‘z¨hU÷¢Ä³\ÓsŽ\åW7ºŠÑŠJP}mm \ÊL\êTSMò\î\"j\\u±Wžm$h}”¿@Añ¼¹%\Æ&t¿>\Ëò¡\Æø`\Ë%‚³\äW»\ÉM°›œ&Àu\"]	A\0\0\0\0IEND®B`‚',300,1),(24,12,6,'2025-01-22 16:57:44','f3ab87db-f7dd-49a2-8f50-19def2dce710','87ece59e-315e-4151-b97d-c8e746e4b008_f3ab87db-f7dd-49a2-8f50-19def2dce710',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0jIDATx^\í–ÛŠ\Å0Eù­€¿.ø[Bg/{æ¹=M|«Z]…D³µ\×_6¾\Þö‡`ùñ1\æõPN‰«\â	.§‹ø\ÄO­>_Nñ\ék˜6\ÐL\ÒÒ®‚¸´…™3pš¢ˆOû¡sK\åÊ·Vo\"Ž\Î\×Xk\Ì\\2k\",Mª\à1\Ö~r‡IRRID‡–RIq\ËEK\éFØ·3=Jr¦d‘\æ¦\Í\è=b-\Äh,	\Ð9½½¢g‰z–‰\'1ú\ä\ë\"‹k^ˆÄj¡¢¦\è¬\â\î½p”D.m,³}V%¯ì”°’¥°MD¥ù*_;¹¥\ÒD8´ ª53\è\äB³®k\êÅ—œ%|f\ÕWDJ\'mD+b\Ü\íH™üž u=\î\Z=J0G\éõ•%\éB\0¥W´Z¬‡(35±\èõÏ…ö{ˆ¯c3ª\éè¾“ õYñ]$`šM\Õ]]DW\ÐTŒ¤r{H)þöœ%¿\ÚC‚=\ä4ù\0u\çwz\×ùEM\0\0\0\0IEND®B`‚',150,1),(25,12,6,'2025-01-22 17:33:47','448c1bde-f5b2-451f-8332-3efb0c1780b2','87ece59e-315e-4151-b97d-c8e746e4b008_448c1bde-f5b2-451f-8332-3efb0c1780b2',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0uIDATx^\í–[Š\Ã0E\rÞ–Á[7x[\Ï9\ÊLI\çñ5\Ö_Ô’\Ö:…\èq¥´ì¿¬|w¼\ì!\Ñò2J©{\Î_\âC\æÖ¿Zõ«‡,2\êuÀ\ëFF­tC\É%«¯nE{&¶:\ê\Æ{\åœB\Åü²\Ú9G´EŽ\\½\\–@†:o¼(l\Ãz¡Y;4,¥½÷ô Á\Ê\à\Îôm… Sˆ\Ó\ÛW<qO\nqrW\×$‚:v\ì#ú\×\Þ*z–pSb@\ë¤\Ë$ó»$BA\'‰\"DÈ¼R\Í ºû¨«X\ØrSüY‚¯\Ù6U\È\î»o¤£$öCLÿ\èÚ½¢‡	K\Ü]¤\n\í\ÜmŽF	·¥t]Ð¼$Â’h\îo?‘\Ê=¶³„B*z] …PO bw\Ï<b\ËÈ¶ú§\Ëòæ !B“\î¦OtŠ‰\ê[\ÇT™¾\É\Õ\áB’\Îra\ç9¹ª‘h ‰\Zþ\0Y\Ä\í\ç¾\Ø!\Æ$²}\Â}t\Ä1‡„B¦küs[$‘_\í!\Ñrš|\0[\í–â¸†¡\0\0\0\0IEND®B`‚',170,1),(26,12,6,'2025-01-22 17:38:05','55c136b5-f376-4b73-ac17-a5c2db83734d','87ece59e-315e-4151-b97d-c8e746e4b008_55c136b5-f376-4b73-ac17-a5c2db83734d',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0kIDATx^\í–YŠ\Ä0D\r¾–ÁWøZO=…™N\Ïò5®¿ˆ&´ô\ÖRQ\Òö_Ö¾¾\ì!Áò­õ½Öª?\åx\È\ÚÄ³x9.?fÀÊ±‘\è1šb\ËLr\æ\Ü9\Út\à\èÑ·¢8&‚(Ö§ý\Ð\Î9‚¥jT¥³N7‘@ç£µ¡\Æ\Ù4d®\Zwa¸‰H\êRúJ.¥¹f—%\Ù9iªZYõÎŠyH6Â‚ã­£g‰z©c¥uu–›¦‰\ÐÃ¤“zŒS«\ÂET¦\áì’ˆ.\í¦ø³\ä\ÒF\ç™j6öL*\Ñ\Ô\Þz}”$\Z$¨T˜\ÜKñ‡I\ç}D‹\çXCô)s\ÙJ\åžÁaR[b!‘‚(ƒmq	\ÄB˜Z}	±\Íû]‰GIQ²`xÊ¢J5^\â*TóST\éÔ­²øfw\ßH‡Ipn\í%²5¢|v\ë\ÅA\ÌF´\Æg\ís\Äh\"À‰F’\è=ƒ£¤Ò†>ƒ¤ö·Î’_\í!Árš|\0R\ë6{rQ,\0\0\0\0IEND®B`‚',170,1),(27,12,6,'2025-01-22 17:40:16','8f2fc20c-d12f-42d5-bcf2-086fbfc9d34c','87ece59e-315e-4151-b97d-c8e746e4b008_8f2fc20c-d12f-42d5-bcf2-086fbfc9d34c',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0sIDATx^\í–KjC1E\rÚ–À[7x[÷%\rNÚŽjÍ¬dbO\ß\ë\×\Ö_\Ö>/»\ä\ì’Ñš­9\ç\no–‡\Z2þð>?þ5dXž\çp{\ÊÈ°\áB1‰]´^I€®ž™¼™s\ra(\æ·ý˜s\å¸rHžV@H±ys\ÍG¸¬W‘¾Ô¶LR\æ[\ç\ÎTÇ¢\Ó4mq/\"9\"a”÷\Ø:w”Œ®‚\æfi±È»ˆ„óvURøGEO’z½‘k˜6y¯\èQ¢Y&G/ªC\èR¤ \nu¯Š¨wŽ1…Myn=Jf\ÞH\Ñ`¢EDˆ;–,\ÉwW¾£D}\Ë7\ç½Î‘É½”S¯®‘qAbY !E\äñu\Â ¦Z”‘@¿‘	\ãö\Ø\'ñ(Iª½\Õ~\É?H¸„\èF2²õ.¯¾Pò\Ñ2IV³¨GT\Ø7E:KFŠxc\äh%1$‚*òP\"-o^„Ed=B1\à\Ý#8J˜6˜ŠÎ·Î’_\í’K°KN“/\ÚzJÊ¢‡\0\0\0\0IEND®B`‚',170,1),(28,12,6,'2025-01-22 17:48:15','177c74e8-2edb-4868-91b9-ee00a41c388c','87ece59e-315e-4151-b97d-c8e746e4b008_177c74e8-2edb-4868-91b9-ee00a41c388c',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0kIDATx^\í–]Š\Ä0ƒ¾VÀW7øZ®\ä23\éþ<­õJ›/P\ÛUÔŒ\ë¯\ß\'\Þq\È!ŒCþAb»2¬n\êAC#óZ\Î[>¨HXA\äR™(IXÌ‰¹“\å\ËÁ†+	\á´ÊƒõªE‘¯ø¡>\ÂX\Ã\Ã…¾&$¨ó9˜Çš‘·\äS\'\"\Â:³\ä•ˆHî—…/J‘+4$¦\'€\Ý)p™†\\Tý-ÏŽ¶’ @°u!\ÃN\Þ:\ÚKVµ0¹\0¤ú«!\ØR¨ž„Æ¢Z©3\Â\'„\â}s¤^RzO~;\âGG[I\ÕZf>œ—\â{	3€•\Ãú\àè©‹\È=]\å\Û2h&urÀ\Ån]JÑ¢M,\Úx\Êo\è+…‚\Íu#)\Ê¡xÃ¥J&€Íµpx˜<=\ÔRIþ1ê¾;R3	¾—À˜\r¨\Ú^\Í£ÿÑ”öJ3¹!4²8»g\ÐJ¨\ä\Ñ\ÍG½\ä\×8\ä\Æ!\Ý\ä3£rð<T\Î\0\0\0\0IEND®B`‚',170,1),(29,12,6,'2025-02-23 17:23:37','a41e30aa-b732-41d8-82c8-888678c652db','87ece59e-315e-4151-b97d-c8e746e4b008_a41e30aa-b732-41d8-82c8-888678c652db',_binary '‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\È\0\0\0\È\0\0\0\0…#“3\0\0tIDATx^\í–QŠ!D¯%\ä\ê‚\×\n¸õÒ³ƒ=»ûµ\É_§EF_\Ã\ÄX–\Ýö_\Ñ>\'\Þñ‡ù™­õ½f1¨!Km­\í}mZ\r™ý5öÈ¤’\Ì>\Ç0%PL\Ü\Ü\Ö\Í*	pô³¯5WD±¾\ã‡vò\áZ\ãvjúŠ2\ÑùÐ£\Â…I\ÝÑˆ¶6Ž\Ë%HDtS§\Õ6+\"s˜w=¶‘\âžÇž¦mVd3RP_Di\Ëp¾1n\Í%Ž\Þ÷re¡\åúQ\Ñ\\²Ð¡]BÁ/ªˆ”,B«\r\ÔN\Å\ç\É\ÜdI¨°)•£¢©DZ—\ë\éô’žQD†±i(E;wœ…TrU\Ô\éVl^‘y\Çe¡Wd±÷\Ü2	³ú\ë8SXs%d±qšŒ.”\Ø\Ã+¸=nJ\Ì$AY­¤/[\â…2/¥\ÜPñjY4Œ|r­ß¼*—\\\n¡¬dcG­\Ó	\ët>»\ÑJ%‘“GãƒµŠ\0I\0Ïˆa\ry+µ\ß2\È%¿\ÆCB<$›|¡cØ°\0\0\0\0IEND®B`‚',170,1);
/*!40000 ALTER TABLE `panier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stade`
--

DROP TABLE IF EXISTS `stade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stade` (
  `id_stade` bigint NOT NULL AUTO_INCREMENT,
  `adresse_stade` varchar(255) DEFAULT NULL,
  `nom_stade` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_stade`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stade`
--

LOCK TABLES `stade` WRITE;
/*!40000 ALTER TABLE `stade` DISABLE KEYS */;
INSERT INTO `stade` VALUES (1,'Paris','Stade'),(2,'Saint-Denis','Stade de France'),(3,'Paris','Parc de Prince'),(4,'Kinshasa','Stade de Martyrs'),(9,'klkkklkl','kjkjkjj');
/*!40000 ALTER TABLE `stade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visiteur` (
  `id_visiteur` bigint NOT NULL AUTO_INCREMENT,
  `email_visiteur` varchar(255) DEFAULT NULL,
  `nom_visiteur` varchar(255) DEFAULT NULL,
  `prenom_visiteur` varchar(255) DEFAULT NULL,
  `password_visiteur` varchar(255) DEFAULT NULL,
  `solde_visiteur` decimal(38,2) DEFAULT NULL,
  `cle_visiteur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_visiteur`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visiteur`
--

LOCK TABLES `visiteur` WRITE;
/*!40000 ALTER TABLE `visiteur` DISABLE KEYS */;
INSERT INTO `visiteur` VALUES (12,'tshaukemulumba@yahoo.com','TSHAUKE MULUMBA ','Salomon','$2a$10$SOb8p3h3ITJjof5bxvy88uvpy/N.GsaEtZ0.tHF/B5EgA7asJuN86',400.00,'87ece59e-315e-4151-b97d-c8e746e4b008'),(13,'tshaukemulumbua@yahoo.com','Network ABCabc123@','Scrapy','$2a$10$lhcP2xuCyy8hDQugLTWKquhTXAFPnDWtMehA1ZHeYjmqB7K6j0cRi',400.00,'8ab1f945-9774-4e77-9ae7-6624d644274d'),(14,'scrapyjoyce1@yahoo.com','Network','Scrapy','$2a$10$pND/tGsptms7gkuqcdgj2ekNyIHq6QHTyXVjA7PGOzRgSGDh.HUB2',500.00,'75dba739-2ad9-401c-b6b2-68efb014b49d'),(15,'scrapyjoyce2@yahoo.com','Network Admin123@','Scrapy','$2a$10$SOb8p3h3ITJjof5bxvy88uvpy/N.GsaEtZ0.tHF/B5EgA7asJuN86',500.00,'24b2d400-7774-43b8-acfe-3dabdee7b6cd'),(16,'scrapyjoyce3@yahoo.com','Network','Scrapy','$2a$10$3GVucGJJl89ZYZ5jfFy.mOsUEmsAPUcRwHrEoAqrEifjMfeLcwQ4y',500.00,'cc3bfa70-9113-458e-8ed7-928f014a4d12'),(17,'hajjriadh@gmail.com','HAJJI','Riadh','$2a$10$61Qm5Oclz2dADf0pSStcceGr5liQubYOY2uGUIE.jOKFPRp31rnNu',600.00,'bf441ba6-8005-4de6-afad-6a8356badea1');
/*!40000 ALTER TABLE `visiteur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-20 15:52:04
