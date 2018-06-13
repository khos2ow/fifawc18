CREATE TABLE `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(36) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `iso2` varchar(2) DEFAULT NULL,
  `iso3` varchar(3) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Afghanistan", "AF", "AFG", "afghanistan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Aland Islands", "AX", "ALA", "aland_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Albania", "AL", "ALB", "albania");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Algeria", "DZ", "DZA", "algeria");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "American Samoa", "AS", "ASM", "american_samoa");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Andorra", "AD", "AND", "andorra");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Angola", "AO", "AGO", "angola");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Anguilla", "AI", "AIA", "anguilla");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Antarctica", "AQ", "ATA", "antarctica");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Antigua and Barbuda", "AG", "ATG", "antigua_and_barbuda");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Argentina", "AR", "ARG", "argentina");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Armenia", "AM", "ARM", "armenia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Aruba", "AW", "ABW", "aruba");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Australia", "AU", "AUS", "australia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Austria", "AT", "AUT", "austria");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Azerbaijan", "AZ", "AZE", "azerbaijan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bahamas", "BS", "BHS", "bahamas");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bahrain", "BH", "BHR", "bahrain");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bangladesh", "BD", "BGD", "bangladesh");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Barbados", "BB", "BRB", "barbados");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Belarus", "BY", "BLR", "belarus");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Belgium", "BE", "BEL", "belgium");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Belize", "BZ", "BLZ", "belize");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Benin", "BJ", "BEN", "benin");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bermuda", "BM", "BMU", "bermuda");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bhutan", "BT", "BTN", "bhutan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bolivia", "BO", "BOL", "bolivia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bosnia and Herzegovina", "BA", "BIH", "bosnia_and_herzegovina");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Botswana", "BW", "BWA", "botswana");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bouvet Island", "BV", "BVT", "bouvet_island");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Brazil", "BR", "BRA", "brazil");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "British Indian Ocean Territory", "IO", "IOT", "british_indian_ocean_territory");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Brunei Darussalam", "BN", "BRN", "brunei");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Bulgaria", "BG", "BGR", "bulgaria");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Burkina Faso", "BF", "BFA", "burkina_faso");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Burundi", "BI", "BDI", "burundi");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cambodia", "KH", "KHM", "cambodia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cameroon", "CM", "CMR", "cameroon");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Canada", "CA", "CAN", "canada");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cape Verde", "CV", "CPV", "cape_verde");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cayman Islands", "KY", "CYM", "cayman_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Central African Republic", "CF", "CAF", "central_african_republic");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Chad", "TD", "TCD", "chad");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Chile", "CL", "CHL", "chile");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "China", "CN", "CHN", "china");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Christmas Island", "CX", "CXR", "christmas_island");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cocos (Keeling) Islands", "CC", "CCK", "cocos_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Colombia", "CO", "COL", "colombia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Comoros", "KM", "COM", "comoros");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Congo", "CG", "COG", "republic_of_the_congo");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cook Islands", "CK", "COK", "cook_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Costa Rica", "CR", "CRI", "costa_rica");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Côte d'Ivoire", "CI", "CIV", "cote_d_Ivoire");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Croatia", "HR", "HRV", "croatia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cuba", "CU", "CUB", "cuba");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Cyprus", "CY", "CYP", "cyprus");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Czech Republic", "CZ", "CZE", "czech_republic");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Denmark", "DK", "DNK", "denmark");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Djibouti", "DJ", "DJI", "djibouti");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Dominica", "DM", "DMA", "dominica");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Dominican Republic", "DO", "DOM", "dominican_republic");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Ecuador", "EC", "ECU", "ecuador");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Egypt", "EG", "EGY", "egypt");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "El Salvador", "SV", "SLV", "el_salvador");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "England", "EN", "ENG", "england");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Equatorial Guinea", "GQ", "GNQ", "equatorial_guinea");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Eritrea", "ER", "ERI", "eritrea");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Estonia", "EE", "EST", "estonia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Ethiopia", "ET", "ETH", "ethiopia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Falkland Islands (Malvinas)", "FK", "FLK", "falkland_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Faroe Islands", "FO", "FRO", "faroe_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Fiji", "FJ", "FJI", "fiji");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Finland", "FI", "FIN", "finland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "France", "FR", "FRA", "france");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "French Guiana", "GF", "GUF", "french_guiana");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "French Polynesia", "PF", "PYF", "french_polynesia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "French Southern Territories", "TF", "ATF", "french_southern_territories");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Gabon", "GA", "GAB", "gabon");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Gambia", "GM", "GMB", "gambia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Georgia", "GE", "GEO", "georgia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Germany", "DE", "DEU", "germany");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Ghana", "GH", "GHA", "ghana");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Gibraltar", "GI", "GIB", "gibraltar");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Greece", "GR", "GRC", "greece");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Greenland", "GL", "GRL", "greenland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Grenada", "GD", "GRD", "grenada");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guadeloupe", "GP", "GLP", "guadeloupe");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guam", "GU", "GUM", "guam");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guatemala", "GT", "GTM", "guatemala");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guernsey", "GG", "GGY", "guernsey");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guinea", "GN", "GIN", "guinea");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guinea-Bissau", "GW", "GNB", "guinea_bissau");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Guyana", "GY", "GUY", "guyana");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Haiti", "HT", "HTI", "haiti");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Heard and Mcdonald Islands", "HM", "HMD", "heard_island_and_mcdonald_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Honduras", "HN", "HND", "honduras");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Hong Kong, SAR China", "HK", "HKG", "hong_kong");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Hungary", "HU", "HUN", "hungary");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Iceland", "IS", "ISL", "iceland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "India", "IN", "IND", "india");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Indonesia", "ID", "IDN", "indonesia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Iran", "IR", "IRN", "iran");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Iraq", "IQ", "IRQ", "iraq");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Ireland", "IE", "IRL", "ireland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Isle of Man", "IM", "IMN", "isle_of_man");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Israel", "IL", "ISR", "israel");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Italy", "IT", "ITA", "italy");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Jamaica", "JM", "JAM", "jamaica");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Japan", "JP", "JPN", "japan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Jersey", "JE", "JEY", "jersey");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Jordan", "JO", "JOR", "jordan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Kazakhstan", "KZ", "KAZ", "kazakhstan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Kenya", "KE", "KEN", "kenya");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Kiribati", "KI", "KIR", "kiribati");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Korea (North)", "KP", "PRK", "korea_north");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Korea (South)", "KR", "KOR", "korea_south");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Kuwait", "KW", "KWT", "kuwait");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Kyrgyzstan", "KG", "KGZ", "kyrgyzstan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Lao PDR", "LA", "LAO", "laos");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Latvia", "LV", "LVA", "latvia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Lebanon", "LB", "LBN", "lebanon");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Lesotho", "LS", "LSO", "lesotho");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Liberia", "LR", "LBR", "liberia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Libya", "LY", "LBY", "libya");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Liechtenstein", "LI", "LIE", "liechtenstein");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Lithuania", "LT", "LTU", "lithuania");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Luxembourg", "LU", "LUX", "luxembourg");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Macao, SAR China", "MO", "MAC", "macao");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Macedonia, Republic of", "MK", "MKD", "macedonia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Madagascar", "MG", "MDG", "madagascar");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Malawi", "MW", "MWI", "malawi");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Malaysia", "MY", "MYS", "malaysia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Maldives", "MV", "MDV", "maldives");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mali", "ML", "MLI", "mali");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Malta", "MT", "MLT", "malta");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Marshall Islands", "MH", "MHL", "marshall_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Martinique", "MQ", "MTQ", "martinique");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mauritania", "MR", "MRT", "mauritania");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mauritius", "MU", "MUS", "mauritius");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mayotte", "YT", "MYT", "mayotte");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mexico", "MX", "MEX", "mexico");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Micronesia, Federated States of", "FM", "FSM", "micronesia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Moldova", "MD", "MDA", "moldova");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Monaco", "MC", "MCO", "monaco");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mongolia", "MN", "MNG", "mongolia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Montenegro", "ME", "MNE", "montenegro");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Montserrat", "MS", "MSR", "montserrat");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Morocco", "MA", "MAR", "morocco");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Mozambique", "MZ", "MOZ", "mozambique");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Myanmar", "MM", "MMR", "myanmar");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Namibia", "NA", "NAM", "namibia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Nauru", "NR", "NRU", "nauru");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Nepal", "NP", "NPL", "nepal");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Netherlands", "NL", "NLD", "netherlands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "New Caledonia", "NC", "NCL", "new_caledonia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "New Zealand", "NZ", "NZL", "new_zealand");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Nicaragua", "NI", "NIC", "nicaragua");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Niger", "NE", "NER", "niger");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Nigeria", "NG", "NGA", "nigeria");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Niue", "NU", "NIU", "niue");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Norfolk Island", "NF", "NFK", "norfolk_island");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Northern Mariana Islands", "MP", "MNP", "northern_mariana_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Norway", "NO", "NOR", "norway");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Oman", "OM", "OMN", "oman");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Pakistan", "PK", "PAK", "pakistan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Palau", "PW", "PLW", "palau");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Palestinian Territory", "PS", "PSE", "palestinian_territory");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Panama", "PA", "PAN", "panama");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Papua New Guinea", "PG", "PNG", "papua_new_guinea");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Paraguay", "PY", "PRY", "paraguay");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Peru", "PE", "PER", "peru");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Philippines", "PH", "PHL", "philippines");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Pitcairn", "PN", "PCN", "pitcairn_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Poland", "PL", "POL", "poland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Portugal", "PT", "PRT", "portugal");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Puerto Rico", "PR", "PRI", "puerto_rico");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Qatar", "QA", "QAT", "qatar");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Réunion", "RE", "REU", "reunion");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Romania", "RO", "ROU", "romania");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Russian Federation", "RU", "RUS", "russia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Rwanda", "RW", "RWA", "rwanda");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint-Barthélemy", "BL", "BLM", "saint_barthelemy");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint Helena", "SH", "SHN", "saint_helena");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint Kitts and Nevis", "KN", "KNA", "saint_kitts_and_nevis");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint Lucia", "LC", "LCA", "saint_lucia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint-Martin (French part)", "MF", "MAF", "saint_martin");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint Pierre and Miquelon", "PM", "SPM", "saint_pierre_and_miquelon");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saint Vincent and Grenadines", "VC", "VCT", "saint_vincent_and_the_grenadines");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Samoa", "WS", "WSM", "samoa");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "San Marino", "SM", "SMR", "san_marino");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Sao Tome and Principe", "ST", "STP", "sao_tome_and_principe");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Saudi Arabia", "SA", "SAU", "saudi_arabia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Scotland", "SC", "SCT", "scotland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Senegal", "SN", "SEN", "senegal");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Serbia", "RS", "SRB", "serbia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Seychelles", "SC", "SYC", "seychelles");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Sierra Leone", "SL", "SLE", "sierra_leone");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Singapore", "SG", "SGP", "singapore");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Slovakia", "SK", "SVK", "slovakia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Slovenia", "SI", "SVN", "slovenia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Solomon Islands", "SB", "SLB", "solomon_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Somalia", "SO", "SOM", "somalia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "South Africa", "ZA", "ZAF", "south_africa");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "South Georgia and the South Sandwich Islands", "GS", "SGS", "south_georgia_and_the_south_sandwich_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "South Sudan", "SS", "SSD", "south_sudan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Spain", "ES", "ESP", "spain");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Sri Lanka", "LK", "LKA", "sri_lanka");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Sudan", "SD", "SDN", "sudan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Suriname", "SR", "SUR", "suriname");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Svalbard and Jan Mayen Islands", "SJ", "SJM", "svalbard_and_jan_mayen");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Swaziland", "SZ", "SWZ", "swaziland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Sweden", "SE", "SWE", "sweden");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Switzerland", "CH", "CHE", "switzerland");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Syrian Arab Republic (Syria)", "SY", "SYR", "syria");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Taiwan, Republic of China", "TW", "TWN", "");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tajikistan", "TJ", "TJK", "tajikistan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tanzania, United Republic of", "TZ", "TZA", "tanzania");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Thailand", "TH", "THA", "thailand");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Togo", "TG", "TGO", "togo");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tokelau", "TK", "TKL", "tokelau");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tonga", "TO", "TON", "tonga");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Trinidad and Tobago", "TT", "TTO", "trinidad_and_tobago");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tunisia", "TN", "TUN", "tunisia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Turkey", "TR", "TUR", "turkey");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Turkmenistan", "TM", "TKM", "turkmenistan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Turks and Caicos Islands", "TC", "TCA", "turks_and_caicos_islands");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Tuvalu", "TV", "TUV", "tuvalu");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Uganda", "UG", "UGA", "uganda");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Ukraine", "UA", "UKR", "ukraine");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "United Arab Emirates", "AE", "ARE", "united_arab_emirates");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "United Kingdom", "GB", "GBR", "united_kingdom");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "United States of America", "US", "USA", "united_states_of_america");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Uruguay", "UY", "URY", "uruguay");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Uzbekistan", "UZ", "UZB", "uzbekistan");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Vanuatu", "VU", "VUT", "vanuatu");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Venezuela (Bolivarian Republic)", "VE", "VEN", "venezuela");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Viet Nam", "VN", "VNM", "vietnam");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Virgin Islands, US", "VI", "VIR", "virgin_islands_us");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Wales", "WS", "WLS", "wales");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Wallis and Futuna Islands", "WF", "WLF", "wallis_and_futuna");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Western Sahara", "EH", "ESH", "western_sahara");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Yemen", "YE", "YEM", "yemen");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Zambia", "ZM", "ZMB", "zambia");
INSERT IGNORE INTO country(uuid, name, iso2, iso3, flag) VALUES(UUID(), "Zimbabwe", "ZW", "ZWE", "zimbabwe");
