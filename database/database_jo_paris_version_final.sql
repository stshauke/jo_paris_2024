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
INSERT INTO `offre` VALUES (1,'SINGLE Ticket','SINGLE : Pour les aventuriers en solo, les billets individuels sont le choix gagnant !',100.00,1,'2024-12-13'),(2,'DUO Ticket','DUO : Profitez ensemble, vivez des moments inoubliables !',150.00,2,'2024-12-13'),(3,'TRIPLE Ticket','TRIPLE : Trois fois plus de plaisir, trois fois plus de souvenirs !',200.00,3,'2024-12-13'),(4,'FAMILY  Ticket','FAMILY : Ensemble, créons des souvenirs inoubliables !',300.00,4,'2024-12-13');
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
INSERT INTO `panier` VALUES (6,1,1,'2024-12-26 11:17:22','7e0f6db0-10dc-4f5f-bc6d-33596652446c',NULL,NULL,150,1),(5,1,5,'2024-12-24 14:37:41','ac6c8033-1ee7-47b8-8319-aec093c386e9',NULL,NULL,150,1),(7,1,1,'2024-12-26 11:44:45','d8a53778-661f-49af-b3c0-85a730b33286',NULL,NULL,150,1),(8,1,1,'2024-12-26 11:52:32','834d2751-af78-4a84-88c4-3e4a08897fd5',NULL,NULL,150,1),(9,1,1,'2024-12-26 12:25:19','dece4ae0-f5b9-451e-bae8-c26b6b1e140e','87ece59e-315e-4151-b97d-c8e746e4b008_dece4ae0-f5b9-451e-bae8-c26b6b1e140e',NULL,150,1),(10,12,1,'2024-12-27 18:19:03','f8247208-e84d-49cd-bd24-6b28b2ba4cdd','87ece59e-315e-4151-b97d-c8e746e4b008_f8247208-e84d-49cd-bd24-6b28b2ba4cdd',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0qIDATx^\�݊\�0����\��V {�\����Z��-�\�o�Q����2�\�x\�%�\�.�q��\"bM���+�n�x�\�!>�\�u<�6\�\�&6\�L�\�P\�$�:<�;\�BQ\�\�~h��Ц��@_�\�Թ�*�0k\"�|f�*\"zV�����Ƣ����\�ѹBk�\�G\�j	�Ϥ\Zn00\�\�@�\�\��X�֙\�Z��\�!�\�\�#�\�k\�lL\�]\�P��\�2��b�\�T<7\�C�?�Q?l���6b��������\� CZ���E�\�=D��\�PI�,��i\"n)s���@Z؊-uT�C��$)\�j\�[���\�\���/M�e�s~N�R�@�\�\�롋�ӟ��\�\r��y�bl\"��H�~�\�!TH�*T㹃Z�]r	\�j�����6\�\0\0\0\0IEND�B`�',150,1),(11,12,1,'2024-12-30 18:40:31','124ff667-1b9a-495d-a833-63cbef02162c','87ece59e-315e-4151-b97d-c8e746e4b008_124ff667-1b9a-495d-a833-63cbef02162c',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0rIDATx^\�ۊ\�0D\r�-�~\�\�\�2x\�(\�%\�\�\�z\�\"J�l�\�J\��_ѾO|\�CB<\�d�{ιWoQ��yM�.�Ȉ�\�J�62b(Mm�LV�D\�t`\�r\�d`\"�b~\�\�#\�j9R_���|.1GHSE�\�V\�\��\�\�&.��S�&28�+dF�\�\�^ӓd\�x�G\�9\�ZvG\�\�\�=KS+w�A�i\"d�\n��\�*\\D�\���\�\��,�%*�������t�L>�`�7��:D�䡑T.LDY�m\����i\"�M\�T][�\�\\\�fJ�����\�A#\�\� &R�璲���}9]\�DF�#�j�Y�ԭR�\�\�4=\�Ham95G\�\�#$\�|Q�P\'�!\��\r\�0\�\������C�\'!Ei�i\"�\�CB<\�4�\0�?�J}\��d\0\0\0\0IEND�B`�',150,1),(12,12,1,'2024-12-30 18:43:42','ede308ac-65af-4732-bba1-eabb7d4c7272','87ece59e-315e-4151-b97d-c8e746e4b008_ede308ac-65af-4732-bba1-eabb7d4c7272',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0qIDATx^\�[�\� E�\���n\�\�Bb\�q:#:���8mZ|\"�\�M\��+\��\�W\\r	q\�?��\�WD\�ԐX��=�\Z❱�\�kPF����kɴi\�Y%M������\����s���QgNOG磵�\�j��U�W�+1����)A��RIY.�U�Ҿ�\�Q\�YߤF굼��[�\�˺�w�(Q�OC��߹u�,Y؄[�~QE\�0id\�Ū��D�\�lc�m�t�\�\�eI쯔\�\�\�$$\r\�|Is����sg���Xj��Bk׹dX�\�\�0\�\' �$(!��gl�a\rq\�\�z�5Ͷ�<�?ov+/+!$�A)D\�`	k�*C�2Z\�#&�64\�l�\nQG�\�|�*\�\�1}�Ֆ�d�%��\�~t4\�fp��\Z�\\B\\r�|\0\�\�x\�Y\�&&\0\0\0\0IEND�B`�',150,1),(13,12,1,'2024-12-30 18:48:51','9bdab96b-531a-49b5-b2ab-e98f217d6c59','87ece59e-315e-4151-b97d-c8e746e4b008_9bdab96b-531a-49b5-b2ab-e98f217d6c59',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0}IDATx^\�Q�!D�%\�\�B�p\�9�;�\�\�\�&-\r�>�+�����F{_�7�	\�&� ���ܗ\�h}Oj�\�q�\r�\�5dv\�a�9)#�\�1ג0	�[H�CztgRD0��\�\�F(\�5�\���\�G\�ӡ\�VD\�4,/�q�\\2A�?����H�\���X�\�ɥ�&�?!ED�\nVJ\�5��$TU�Wg�ő\�\\\"	L�\�\�\�U��\�=iKh�㓉�.v]\�x;{U*�>I�\�N�o]r�JTWR�e�H\�\��D\�\�Ԉ\�\�aED���,[\�b/\�R����ꗀY+!�϶σ6�\rRB�\��\��\�\�D��j���\�xe4�\�\rg����\�\�	V�%���KG\�%D�?ٔ\Z;r�N��\�n\�XI��gb\�\"\�\�\"X=�2M�e\�/\nrɯ\�&7a\�$�|`m�:\�\�\�\0\0\0\0IEND�B`�',150,1),(14,12,1,'2024-12-30 18:54:11','917d5c74-5147-42a8-bad3-542eaa38be72','87ece59e-315e-4151-b97d-c8e746e4b008_917d5c74-5147-42a8-bad3-542eaa38be72',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0sIDATx^\�I�E!E�%d\���\�I5��U2{\���z�����\�_���`��1\�\�{�Xc梇\�\�~�e�,��O\�>c͏E�\�K�r����\�\�:	pM�G�,��؟�C;u�a�(-Oo\"�\�\�P吣\�Dt:�\�\�1\�U�Z\"e�Q7��.�&r�Ep��\�W\�j�r�Ծ�\�>8\�C\�S�V�����\�RB��.;K�|g���p!�\�\�?Y�´;\�$)^�R|1�D��{V�u�\�]LL\�;�\�dQ3	\�0σ*��l+�\���rjM$�	]��\�A1	]����4#A��D-_)\�i!n:�9\�/~�\�9:��Pi!y�g�\�%�Md�I�4\�&\�.�\�sJ�Qh#Q���\�v�.\�	>G�MD\�%ؽ=(%��L�\��\�A-�\��\�!\�\�\r%I�ϥC\0\0\0\0IEND�B`�',150,1),(15,12,1,'2024-12-30 18:58:32','f922bac3-9067-41e2-9a0e-316949d1b41f','87ece59e-315e-4151-b97d-c8e746e4b008_f922bac3-9067-41e2-9a0e-316949d1b41f',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0oIDATx^\�]�!�^+����\�V\�\���\�}Z\�ʹ�_��)\�\��\�\�s\�e�\\B�\�$\�\�\�}v�\�DC:@z#���d\�<c��Ld$[:C\�b2b��PBG\�\�`N?r}�P�\�~h\��\r��\�Q��HR\�n\�m���`��A\�|�\�a�L)jǢ\r��2 Ef�˹\��,�\n1\".�㚂�\�\�\���ѣ!\ZՁs\�p�\�3z�`\�`o\nY�\nH�`\�I\�\�g\�(���\�A�\�}5�4q�|�\�\�\�d�F�\�5<��0!y�DDzm��K*��IR�R	\nH\\\�\�\��DB�F \��=���b=����\�H,\�E\�\�\n\�נJ��\r��]m�n�\n\�\���Z/ #�\��F�P�GM5���%��_\�Kh��&_j3�^\Z��e\0\0\0\0IEND�B`�',150,1),(16,12,1,'2024-12-30 19:00:30','8d48dd01-8950-47a3-98d3-30b56d392b89','87ece59e-315e-4151-b97d-c8e746e4b008_8d48dd01-8950-47a3-98d3-30b56d392b89',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0vIDATx^\�Qn\�0D�|-$��ĵ�\�\�n�n�U�N����50\�\���\�υ�=\�!�����\�J�\\���)*v\�\�d��\n��#\�c$Ų\�0�\�\�QB���H\Z\'C���/{\�N)jL�C$�6@\\�@)z\�Ջ\�<\�uU�\���@�\\guUg�����\�_��\�R�OE�\�\�!\�A�\n��\�GU�w���V\�ހKW��\�#d�=%\���J�[���\�VY�$���y�\�֑�ɖ\�\'<\�I��M�\�\�ŬA��(�=\�JKxk�nq�#����\'�#Q�S$��ҡV�( 4gު��:B\�FwV־\�k\�\0	>�\��x�x}\�A)�c�C���<E\�8+���\�]F�\�<X�o�\�#TH}=�T\�0#\�W{\�Ch\�&�^|\�k=f\0\0\0\0IEND�B`�',150,1),(17,12,1,'2024-12-30 19:03:06','21753589-e581-4c82-aa19-28fb0eb10ca5','87ece59e-315e-4151-b97d-c8e746e4b008_21753589-e581-4c82-aa19-28fb0eb10ca5',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0vIDATx^\�[�\� E-�-$�n�m!1\�:�)�\�\�\�qӴp*\�k.nl��}\�+�\�C�Aܬ\�\�m�n-5dr͹W\�]�*\�Mc|y\rʈ7G&	�5xQQeQF{�<�ED����\�;yD�l8RG�^D\\>\�\�;�\�\�(\"[+�\�nf�ع\\\"�O\�\�/\\RDV[\ZpsM�{\�r	ˢ�b*�\��U	�\�nt�\�^\�TB�$F$\���u*	ml]#�E��\"��X��9>�\�8�[.4t��\�$si�J\��Ⳇ\�\�h\�r�v\�\��l�ǫϾ�Y�\�Ѫ�7\���z��\�\�\Zj�\�8t�\�e�\�	\�\"����\��RHxCŤ����\�E\�Ah�)����Z\�4\�BBy�\�|�2�$�\�2c\��e\�g\�R\�Ջ�S\�y\� ��\Zy�\�!\�\����k�\0\0\0\0IEND�B`�',150,1),(18,12,1,'2024-12-30 19:08:55','3dba67da-7063-4b55-b158-22b04995f485','87ece59e-315e-4151-b97d-c8e746e4b008_3dba67da-7063-4b55-b158-22b04995f485',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0oIDATx^\�Qj1D\r��AW\�Z�\�\�l\�8I�U\�\�Jk=\�J\�v\��W��\�Or\�c^\�SZ���7\�J\�Т��\�:qwU\�I|�\Z��IZ\�%\�H\�$��E�)\�;>�SG9\�-�\�#\Z�\�\���\�DRF�H�1\�vr��fGwƹ%\\\�D\�B�\��<�Z�Y4!�F�߻:\�X\�K\���h-A�35)r&\�\�Ept�/\�؁Q\�E�^wVS�\�.�5\�~�\��$|$QQ6�M��\�\�P\�\�m��%T4�+����p>\�\�\�\�+(&\�)\�U\n���5�Ƹ\�B$�t\�hڜXKD�m\�;��\�=\�i�\�7EkI�Y��F�D*&>iƥ>\�\�\�\�Ȝ�\�]:rXt���	2�WPJ\�\�C�\�K�\�\�8\�\�!\�\����b	\Z�Z\0\0\0\0IEND�B`�',150,1),(19,12,1,'2024-12-30 19:10:54','2b526fe9-f985-4ab9-8166-1924dcfb6162','87ece59e-315e-4151-b97d-c8e746e4b008_2b526fe9-f985-4ab9-8166-1924dcfb6162',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0qIDATx^\�ۊ\�0E�V�_��@g/ϙ!�\�\�ķZhW��\�h\����\�/{\�C����\�vef�Ԡ�\�\r\�A	����m$,&K\�f�\\\�\�;	p\Zܲ\�\�CE~\�\�#���[���:���\�)�&�xM4�ԍ�e\�,��8I�L����v_��Nܱ\��(\��˖3\r�%/_1�mW(m��%p9�O� \�.\"\�;!�Zj	HE�TH�md��\�V|r�HG�-u�S\����%l*��\��z�\�w�TERδ���\�Ef�=e�\�myu@)P)[D��F�\�~��0\�q\�M�g	���e��\�@\�=\�ˣ�$AE���k�H��\ZNS7f\�[���D\�/�.Rݖ3D\�\'�\�8)�;H)��\"���%�\�C�=\�4�\0ƉjZ;(.�\0\0\0\0IEND�B`�',150,1),(20,12,1,'2024-12-30 19:17:58','509853df-9617-4a13-b795-b4d2fd6b06d3','87ece59e-315e-4151-b97d-c8e746e4b008_509853df-9617-4a13-b795-b4d2fd6b06d3',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0nIDATx^\�Kn�1�-q-K\\�k!�38i�&]vf�\�\�dc<\�_6~;�\�Kh���\��\�=�\�!���87]Ą{S��ش\0E\0\�$4t\�\�I\'z��r\�D(\nڛv\�-�#ܚ�7�\�\�`1a\�DBb\�|DA<�\�Ւ��+�PI\��`�\�m?��&�j��\�2�����\nil\�KEk\�>v\�\�䳢�ĸF�B�`Tt�=\�q:ʊϡ�Z�\�!�),\�Q\�R�x��pբMs(�u\�y\�L,%\�\"�)xg�����$���\"<�� Aa%��P��@�S9����Tb)\�TR����l���*�\�C�t(��z�H�\�(u>\�S\�	\'^��e�O16��E�{L\�A)�B�\�\�g�\�&�\�.��vI5�B,��\��^\�\0\0\0\0IEND�B`�',150,1),(21,12,1,'2024-12-30 19:25:41','3727f49c-4aba-4d00-8e50-f7966e257b8d','87ece59e-315e-4151-b97d-c8e746e4b008_3727f49c-4aba-4d00-8e50-f7966e257b8d',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0}IDATx^\�[�1D�%���\�2Uvϝ\�y|�����\�eE�_!\�^�0��DtGD��\�\��\���\Z�~g\�R>�\��\�Y�L&\�\�\� !4�LQT>�\">\�v�#ŗ&kz\�\0YԹ��n�\�̧\Zi0c!?*\�J�D)\'�\�\�.d�!F\��::\�JPF\�d�u�|�v�\�\�͙%�ﭢ��f��J9ϊ��\�,ъ0\�	�#N}<�G�C�o�6�\�\�yV��,��^\�zV��@�i�g\�\�L�L	S\�S$S�\�C׋���`\�\�<\�\�\�\�av�����#|�\�Z\�\�z(��\�e�K�\�!�I�k�P}m Q_6����\�Lꪸ\�BH\�;�I\�z�)�@�\�;���\�\�WuG�م�+�\'\�%�\�C\�xH7�\0��z�p�h�\0\0\0\0IEND�B`�',150,1),(22,12,6,'2025-01-22 16:04:33','baf8c12a-157a-40f9-ac52-2b2539dd41a9','87ece59e-315e-4151-b97d-c8e746e4b008_baf8c12a-157a-40f9-ac52-2b2539dd41a9',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0pIDATx^\�]�1���\�\��%d�\�\�lz�V\�\"\�0�k��\��X\��\�x\�%�\�.��1\�r�2f.z�/�\�墋\�\�:&�ע�\�4�\0�Ih\�J\�Hef\�E�(�\�~h��Ђ\�\�ܽ�u.Cd����@�;I�\'WL�`ekq>�b�\�8�Z�$QR\ne����\�И;Y�GE�	�F��H\�䣢��c\�\�=@|�\�@\�\�$\�|#ơ�Zb�\�`*^)��.�⍕=*ZK��؊W�ܗ\�k	6\�Ί�\��\�&�\���Ib\�>b+%{[\�\�\�\"\�*�4;�%��T\�SyU\�ϩ\�RBcE�-����\��/!�_�jq>\�\�1�j	\ZiJ\�9H�>���\'\�\"��88\n��*o������B���?\"�%�\�%�\�.�&䤂��F�\�\0\0\0\0IEND�B`�',170,1),(23,12,5,'2025-01-22 16:31:01','e53c455f-6183-4761-afc4-5e91516cdc2f','87ece59e-315e-4151-b97d-c8e746e4b008_e53c455f-6183-4761-afc4-5e91516cdc2f',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0kIDATx^\�QjD1E�lKp\�B�\�\�c��\�i�\���d�G<���\Z\���;�\�&7�n��fc\�9�r�\�!s�?��\�\"9�k`-\�H�t\�LV��\��\�\n!֘Ϝ;����C;\����\�Q�7�D\�n\�*�ˢ� �t3�\�͝%�\�B�t��8�Ȋ�3��\����\�DI�Z!d\�\� r��K��V\�Ӥ\�+-j˥����W2d(\r\�EY\�a�-\�e\�E����P|\\&\�Y�TR~t2�]\�*UUR�\�ͽ�~^sV5�.¹\n����kG�nj��` Q\�>�\063\����z��hU��ĳ\�s�\�W7��ъJP}mm \�L\�TSM�\�\"j\\u�W�m$h}��@A�%\�&t��>\��\��`\�%��\�W�\�M���&�u\"]	A\0\0\0\0IEND�B`�',300,1),(24,12,6,'2025-01-22 16:57:44','f3ab87db-f7dd-49a2-8f50-19def2dce710','87ece59e-315e-4151-b97d-c8e746e4b008_f3ab87db-f7dd-49a2-8f50-19def2dce710',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0jIDATx^\�ۊ\�0E����.�[Bg/{搹=M|�Z]�D��\�_6�\����`��1\��PN��\�	.���\�O�>_N�\�k�6\�L\�Ү������3p���O���sK\�ʷVo\"�\�\�Xk\�\\2k\",M�\�1\�~r�IRRID��RIq\�EK\�Fط3=Jr�d�\�\�\�=b-\�h,	\�9���g�z��\'1�\�\�\"�k^�ĝj���\�\�\�p�D.m,�}V%�씰���MD���*_;��\�D8���53\�\�B��k\�ŗ�%|f\�WDJ\'mD�+b\�\�H��� u=\�\Z=J0G\���%\�B\0�W�Z��(35�\��υ�{��c3�\�输��Y�]$`�M\�]]DW\�T��r{H)���%�\�C�=\�4�\0u\�wz\��EM\0\0\0\0IEND�B`�',150,1),(25,12,6,'2025-01-22 17:33:47','448c1bde-f5b2-451f-8332-3efb0c1780b2','87ece59e-315e-4151-b97d-c8e746e4b008_448c1bde-f5b2-451f-8332-3efb0c1780b2',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0uIDATx^\�[�\�0E\rޖ�[7x[\�9\�LI\��5\�_Ԓ\�:�\�q��쿬|w�\�!\��2J�{\�_\�C\�ֿZ���,2\�u�\�FF�tC\�%��nE{&�:\�\�{\�B\���\�9G�E�\\�\\�@�:o�(l\�z�Y;4,���� �\�\�\��m� S�\�\�W�<qO\nqrW\�$�:v\�#�\�\�*z�pSb@\�\�$�$BA\'�\"DȼR\� ����X\�rS�Y��\�6U\�\�o��$�CL�\�ڽ��	K\�]�\n\�\�m�F	��t]м$h\�o?�\�=���B*z] �PO�bw�\�<b\�ȶ��\��搠!B�\�Ot��\�[�\�T��\�\�\�B�\�ra\�9���h��\Z�\0Y\�\�\�\�!\�$�}\�}t\�1��B�k�s[$�_\�!\�r�|\0[\�⸆�\0\0\0\0IEND�B`�',170,1),(26,12,6,'2025-01-22 17:38:05','55c136b5-f376-4b73-ac17-a5c2db83734d','87ece59e-315e-4151-b97d-c8e746e4b008_55c136b5-f376-4b73-ac17-a5c2db83734d',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0kIDATx^\�Y�\�0D\r���W�ZO=��N\��5���&��\�RQ\��_־�\�!�����֪?\�x\�\�ĳx9.?f�ʱ�\�1�b\�Lr\�\�9\�t\�\�ѷ�8&�(֧�\�\�9��jT��N7�@磵�\�\�4d�\Zwa��H\�R�J.��f�%\�9i�ZY�ΊyH6㭣g�z�c�uu����\�ä�z�S�\�ET�\�쒈.\���\�\�F\��j6�L*\�\�\�z}�$\Z$�T�\�K�I\�}D�\�XC�)�s\�J\��aR[b!��(�mq	\�B�Z}	�\��]�GIQ�`xʢJ5^\�*T�ST\�ԭ��fw\�H�Ipn\�%�5�|v\�\�A\�F�\�g\�s\�h\"��F�\�=���҆>����Β_\�!�r�|\0R\�6{rQ,\0\0\0\0IEND�B`�',170,1),(27,12,6,'2025-01-22 17:40:16','8f2fc20c-d12f-42d5-bcf2-086fbfc9d34c','87ece59e-315e-4151-b97d-c8e746e4b008_8f2fc20c-d12f-42d5-bcf2-086fbfc9d34c',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0sIDATx^\�KjC1E\rږ�[7x[�%\rNڎjͬdb�O\�\�\�\�_\�>/�\�\��њ�9\�\no��\Z2��>?�5dX�\�p{\�Ȱ\�B1�]�^I������s\ra(\����s\�rH�V@H�ys\�G��W��ԶLR\�[\�\�TǢ\�4mq/\"9\"a��\�:w����\�fi�Ȼ���vUR�GEO�z��k�6y�\�Q�Y&G/�C\�R� \nu���w�1�Myn=Jf\�H\�`�ED�;�,\�wW��D}\�7\�ΐ�ɽ�S���qAbY�!E\��u\� �Z��@��	\��\�\'�(I��\�~\�?H��\�F2��.��P�\�2IV��GT\�7E:KF�xc\��h%1$�*�P\"-o^�Ed=B1\�\�#8J�6��ηΒ_\�K�KN�/\�zJʢ�\0\0\0\0IEND�B`�',170,1),(28,12,6,'2025-01-22 17:48:15','177c74e8-2edb-4868-91b9-ee00a41c388c','87ece59e-315e-4151-b97d-c8e746e4b008_177c74e8-2edb-4868-91b9-ee00a41c388c',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0kIDATx^\�]�\�0��V�W7�Z��\�23\��<��J�/P\�UԌ\�\�\'\�q\�!�C�Ab�2�n\�AC#�Z\�[>�HXA\�R�(IX̉��\�\���+	\�ʃ��E�����>\�X\�\���&$��9�ǚ��\�S\'\"\�:�\���H/J�+4$�\'�\�)p��\\T�-�ώ���@�u!\�N\�:\�KV�0�\0���!\�R���ƢZ��3\�\'�\�}s�^RzO~;\�GG[I\�Zf>���\�{	3��\��\�詋\�=]\�\�2h&ur�\�n]JѢM,\�x\�o\�+��\�u#)\��xåJ&�͵px�<=\�RI�1ꏾ;R3	����\r��\�^\����є�J3�!4�8�g\�J��\�\�\�G�\�\�8\�\�!\�\�3��r�<T\�\0\0\0\0IEND�B`�',170,1),(29,12,6,'2025-02-23 17:23:37','a41e30aa-b732-41d8-82c8-888678c652db','87ece59e-315e-4151-b97d-c8e746e4b008_a41e30aa-b732-41d8-82c8-888678c652db',_binary '�PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\�\0\0\0\�\0\0\0\0�#�3\0\0tIDATx^\�Q�!D�%\�\�\�\n��ҳ�=���\�_�EF_\�\�X�\��_\�>\'\�������f�1�!Km�\�}mZ\r��5�Ȥ�\�>\�0%PL\�\�\�\�*	p���5WD��\�v�\�Z\�vj��2\��У\��I\�ш�6��\�%HDtS�\�6+\"s�w=��\�Ǟ�mVd3RP_Di\�p�1n\�%�\��re�\��Q\�\\�С]B�/���,B�\r\�N\�\�\�\�dI��)����DZ�\�\����QD��i(E;w��TrU\�\�Vl^�y\�e�Wd��\�2	��\�8SXs%d�q��.��\�\�+�=nJ\�$AY��/[\�2/�\�P�jY4�|r�߼*�\\\n��dcG�\�	\�t>�\�J%��Gヵ�\0I\0ψa\ry+�\�2\�%�\�CB<$�|�cذ�\0\0\0\0IEND�B`�',170,1);
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
