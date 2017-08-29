<html>
<head>
<title>noark5-kravspec</title>
<meta charset="utf-8" />
</head>
<body>
<?php
function TestFunction($s_value) {
        $regex = '/^[+\-]?(?:\d+(?:\.\d*)?|\.\d+)$/';
        return preg_match($regex, $s_value);
}
         
$row = 1;
if (($handle = fopen("noark5kravspec.csv", "r")) !== FALSE) {
        while (($data = fgetcsv($handle, 5000, ";")) !== FALSE) {
                $num = count($data);
                /* echo "<p>$num fields in line $row:<br /></p>\n"; */
                $row++;
                /* for ($c=0; $c < $num; $c++) { */
                // echo $c . ": " . $data[$c] . "\t\n";
                $kravnr = rtrim($data[0], "\n");
                $kravnr = rtrim($data[0], " ");
                $ookrav = rtrim($data[1], "\n");
                $type = rtrim($data[2], "\n");
                $merknad = rtrim($data[3], "\n");
                $forklaring = rtrim($data[4], "\n");
                $konsekvens = rtrim($data[5], "\n");
                $konfnivaa = rtrim($data[6], "\n");
                $refkrav = rtrim($data[7], "\n");
                $status = rtrim($data[8], "\n");
                $ansvar = rtrim($data[9], "\n");
                if ($kravnr == "Krav nr.") {
                        echo "<h2>" . $ookrav . "<h2>\n";
                }
                if (TestFunction($kravnr)==0) {
                        if ($kravnr != "Krav nr.") {
                                print "<h3>" . $kravnr . "</h3>\n";
                                print "<h4>" . $ookrav . "</h4>\n";
                        }
                }
                        // echo "INSERT INTO kravspec VALUES ('" . $kravnr . "','" . $ookrav . "','" . $type . "','" . $merknad . "','" . $forklaring . "','" . $konsekvens . "','" . $konfnivaa . "','" . $refkrav . "','" . $status . "','" . $ansvar . "');\n";
        }
        fclose($handle);
}
?>
</body>
</html>
