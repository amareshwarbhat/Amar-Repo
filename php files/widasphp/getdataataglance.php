<?php
 
/*
 * Following code will list all the ataglance
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all ataglance from ataglance table
$result = mysql_query("SELECT *FROM ataglance") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // ataglance node
    $response["ataglance"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["icon"] = $row["icon"];
        $product["description"] = $row["description"];        
 
        // push single product into final response array
        array_push($response["ataglance"], $product);
    }
    // success
    $response["success"] = "1";
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no ataglance found
    $response["success"] = "0";
    $response["message"] = "No ataglance found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>
