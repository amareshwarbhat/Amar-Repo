<?php
 
/*
 * Following code will list all the hometable
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_connect.php';
 
// connecting to db
$db = new DB_CONNECT();
 
// get all hometable from hometable table
$result = mysql_query("SELECT *FROM hometable") or die(mysql_error());
 
// check for empty result
if (mysql_num_rows($result) > 0) {
    // looping through all results
    // hometable node
    $response["hometable"] = array();
 
    while ($row = mysql_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["icon"] = $row["icon"];
        $product["title"] = $row["title"];
        $product["description"] = $row["description"];
        
 
        // push single product into final response array
        array_push($response["hometable"], $product);
    }
    // success
    $response["success"] = "1";
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no hometable found
    $response["success"] = "0";
    $response["message"] = "No hometable found";
 
    // echo no users JSON
    echo json_encode($response);
}
?>
