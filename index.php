<html>
<head>
<title>noark5-kravspec</title>
<meta charset="utf-8" />
</head>
<body>
<h1>noark5-kravspec</h1>
<?php
function sqlite_open($location,$mode)
{
    $handle = new SQLite3($location);
    return $handle;
}
function sqlite_query($dbhandle,$query)
{
    $array['dbhandle'] = $dbhandle;
    $array['query'] = $query;
    $result = $dbhandle->query($query);
    return $result;
}
function sqlite_fetch_array(&$result,$type)
{
    #Get Columns
    $i = 0;
    while ($result->columnName($i))
    {
        $columns[ ] = $result->columnName($i);
        $i++;
    }
   
    $resx = $result->fetchArray(SQLITE3_ASSOC);
    return $resx;
}
if (!isset($_GET['query'])!=0) {
  print "<form method='GET' action='/grouse'><input type='text' name='query' value='SELECT * FROM kravspec;' size='80' /><input type='submit' value='Submit SQL query' /></form>\n";
} else {
  if ($_GET['query']=="") {
    $query = "SELECT * FROM kravspec;";
  } else {
    $query = $_GET['query'];
  }
  print "<form method='GET' action='/grouse'><input type='text' name='query' value='" . $query . "' size='80' /><input type='submit' value='Submit SQL query' /></form>\n";
  $db=sqlite_open("/home/oka/grouse/grouse/noark5kravspec.db",0644,$sqliteerror);
  $result=sqlite_query($db,$_GET['query']);
  print "<table border='1'>";
  while ($entry = sqlite_fetch_array($result, SQLITE3_ASSOC)) {
    print "<tr><td>" . $entry['kravnr'] . "</td><td>" . $entry['ookrav'] . "</td><td>" . $entry['kravtype'] . "</td><td>" . $entry['merknad'] . "</td><td>" . $entry['forklaring'] . "</td><td>" . $entry['konsekvens'] . "</td><td>" . $entry['konfnivaa'] . "</td><td>" . $entry['refkrav'] . "</td><td>" . $entry['status'] . "</td><td>" . $entry['ansvar'] . "</td></tr>\n"; 
  }
}
if (!isset($_GET['kravtype'])==0) {
$db=sqlite_open("/home/oka/grouse/grouse/noark5kravspec.db",0644,$sqliteerror);
   $result=sqlite_query($db,"SELECT * FROM kravspec WHERE kravtype = '" . $_GET['kravtype'] . "';");
   print "<form method='GET' action='/grouse'>Kravtype:&nbsp;<select name='kravtype'><option value='B'>B</option><option value='O'>O</option><option value='V'>V</option><br /><input type='submit' value='Generere kravspec' /></select></form>\n";
   print "<table>";
   while ($entry = sqlite_fetch_array($result, SQLITE3_ASSOC)) {
   	 print "<tr><td>" . $entry['kravnr'] . "</td><td>" . $entry['ookrav'] . "</td><td>" . $entry['kravtype'] . "</td><td>" . $entry['merknad'] . "</td><td>" . $entry['forklaring'] . "</td><td>" . $entry['konsekvens'] . "</td><td>" . $entry['konfnivaa'] . "</td><td>" . $entry['refkrav'] . "</td><td>" . $entry['status'] . "</td><td>" . $entry['ansvar'] . "</td></tr>\n"; 
  }
  print "</table>\n";
} else {
  print "<form method='GET' action='/grouse'>Kravtype:&nbsp;<select name='kravtype'><option value='B'>B</option><option value='O'>O</option><option value='V'>V</option><br /><input type='submit' value='Generere kravspec' /></select></form>\n";
}
?>
</body>
</html>
