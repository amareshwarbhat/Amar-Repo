<?php
 
/*
 * Following code will list all the contacttable
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all contacttable from contacttable table
$result = mysql_query("SELECT *FROM contacttable") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // contacttable node
    $response["contacttable"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["title"] = $row["title"];
        $product["description"] = $row["description"];        
 
        // push single product into final response array
        array_push($response["contacttable"], $product);
    }
    // success
    $response["success"] = "1";
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no contacttable found
    $response["success"] = "0";
    $response["message"] = "No contacttable found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>